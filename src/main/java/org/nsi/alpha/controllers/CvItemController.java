package org.nsi.alpha.controllers;

import org.apache.commons.net.ftp.*;
import org.nsi.alpha.models.CvItem;
import org.nsi.alpha.models.viewModels.CvItemViewModel;
import org.nsi.alpha.services.CvItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
public class CvItemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CvItemController.class);

    @Autowired
    CvItemService cvItemService;

    String CURRENTLY_UPLOADED_FILENAME = "";

    @RequestMapping(value = "cv_item/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {

        try {
            CvItem cvItem = cvItemService.findById(id);
            CvItemViewModel cvItemViewModel = new CvItemViewModel(cvItem);
            LOGGER.info(String.format("Action called - successfully pulled cv item with id %s.", id));
            return new ResponseEntity(cvItemViewModel, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Action failed - cv item with id %s could not be pulled.", id));
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/new_cv_item", method = RequestMethod.GET)
    public String newCvItem(){

        return "new_cv_item";
    }

    @RequestMapping(value = "/create_cv_item", method = RequestMethod.POST)
    public @ResponseBody Map createCvItem(
           @RequestParam(value = "name", required = false, defaultValue = "no_name") String name,
           @RequestParam(value = "description", required = false, defaultValue = "desc") String description,
           @RequestParam(value = "criteriaId", required = false, defaultValue = "0") Integer criteriaId){

        Map model = new HashMap<>();
        if(CURRENTLY_UPLOADED_FILENAME == null){
            CURRENTLY_UPLOADED_FILENAME = "";
        }

        CvItem cvItem = new CvItem();
        cvItem.setName(name);
        cvItem.setDescription(description);
        cvItem.setStatusId(1);

        cvItem.setInsertDate(new Date());

        //TODO:
        // Za ovaj cvId ce se postaviti vrijednost ID-a
        // ulogovanog profesora (vjerovatno neka veza profa-cv)
        cvItem.setCvId(1);
        cvItem.setCriteriaId(criteriaId);

        CvItem savedCvItem = new CvItem();

        try{
            savedCvItem = cvItemService.save(cvItem);
            savedCvItem.setAttachmentLink(
                    savedCvItem.getId() + "_" + CURRENTLY_UPLOADED_FILENAME);
            savedCvItem = cvItemService.save(savedCvItem);

            model.put("savedCvItem", savedCvItem);
            model.put("success", true);
            LOGGER.info(String.format("Action called - saved new cv item with id %s.", savedCvItem.getId()));
        } catch(Exception e){
            e.printStackTrace();
            model.put("exception", e);
            LOGGER.error(String.format("Action failed - new cv item with id %s saving failed.", savedCvItem.getId()));
            return model;
        }

        return model;
    }

    @RequestMapping(value = "/upload_cv_item_attachment", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Map fileUpload(@RequestParam("file") MultipartFile mpFile, HttpServletResponse response) {

        Map model = new HashMap<>();

        boolean uploadSucceded = false;

        try {
            uploadSucceded = uploadFile(mpFile.getInputStream(), mpFile.getOriginalFilename());
            CURRENTLY_UPLOADED_FILENAME = mpFile.getOriginalFilename();
            LOGGER.info(String.format("Action called - file uploaded: %s.", mpFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(String.format("Action failed - file upload failed: %s.", mpFile.getOriginalFilename()));
        }

        model.put("uploadSuccess", uploadSucceded);

        return model;
    }

    @RequestMapping(value = "/download_cv_item_attachment", method = RequestMethod.GET)
    @ResponseBody
    public void fileDownload(@RequestParam("fileName") String fileName,
                            HttpServletResponse response){
        try{
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
            downloadFile(bufferedOutputStream, fileName);
            bufferedOutputStream.close();
            LOGGER.info(String.format("Action called - file download: %s.", fileName));
        } catch(Exception e) {
            LOGGER.error(String.format("Action failed - file download failed: %s.", fileName));
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Map getAll() {
        Map model = new HashMap<>();
        model.put("cvItems", cvItemService.findAll());
        return model;
    }

    @RequestMapping(value = "/cvItem/save", method = RequestMethod.POST)
    public ResponseEntity saveCv(@RequestBody CvItem cvItemSaveRequest) {

        try {
            CvItem savedCvItem = cvItemService.save(cvItemSaveRequest);
            CvItemViewModel cvItemViewModel = new CvItemViewModel(savedCvItem);
            LOGGER.info(String.format("Action called - updated cv item with id %s.", savedCvItem.getId()));
            return new ResponseEntity(cvItemViewModel, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Action failed - new cv item with id %s saving failed.", cvItemSaveRequest.getId()));
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            CvItem deletedCv = cvItemService.findById(id);
            CvItemViewModel cvItemViewModel = new CvItemViewModel(deletedCv);
            cvItemService.remove(id);
            LOGGER.info(String.format("Action called - deleted cv item with id %s.", deletedCv.getId()));
            return new ResponseEntity(cvItemViewModel, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Action failed - deleting cv item with id %s failed.", id));
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/clear_saved_file", method = RequestMethod.GET)
    public void clearSavedFile(){
        CURRENTLY_UPLOADED_FILENAME = "";
    }

    public FTPClient connectToFTPClient() throws IOException {
        String serverAddress = "host4.bakop.com";

        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(10000);
        ftpClient.setControlKeepAliveTimeout(30);
        ftpClient.connect(serverAddress);
        if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            ftpClient.disconnect();
            LOGGER.error(String.format("Action failed - failed to connect to server: %s.", serverAddress));
            throw new FTPConnectionClosedException("Failed to connect to server: " + serverAddress);
        } else {
            LOGGER.info(String.format("Action called - connected to server: %s.", serverAddress));
            ftpClient.login("emirmire", "nsimire");
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(null);

            return ftpClient;
        }
    }

    public boolean downloadFile(BufferedOutputStream bufferedOutputStream, String fileName){
        boolean result = false;

        FTPClient ftpClient = new FTPClient();

        try{
            ftpClient = connectToFTPClient();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            result = ftpClient.retrieveFile(fileName, bufferedOutputStream);

            ftpClient.logout();

            return result;
        } catch (Exception e ){
            LOGGER.error("Error downloading the file!");
            System.out.println("Error downloading the file!");
        } finally {
            disconnect(ftpClient);
        }

        return result;
    }

    public boolean uploadFile(InputStream inputStream, String fileName){
        boolean result = false;

        FTPClient ftpClient = new FTPClient();

        try{
            ftpClient = connectToFTPClient();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            result = ftpClient.storeFile(fileName, inputStream);
            ftpClient.storeFileStream("");
            inputStream.close();

            ftpClient.logout();

            return result;
        } catch (Exception e ){
            LOGGER.error("Error downloading the file!");
            System.out.println("Error downloading the file!");
        } finally {
            disconnect(ftpClient);
        }

        return result;
    }

    public void disconnect(FTPClient ftpClient) {
        if (!ftpClient.isConnected()) {
            return;
        }
        try {
            ftpClient.disconnect();
        } catch (Exception e) {
            LOGGER.error("Error disconnecting FTP!");
            System.out.println("Error disconnecting FTP!");
        }
    }
}
