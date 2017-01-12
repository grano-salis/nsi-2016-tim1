package org.nsi.alpha.controllers;

import org.nsi.alpha.models.Cv;
import org.nsi.alpha.models.CvItem;
import org.nsi.alpha.models.CvItemWrapper;
import org.nsi.alpha.models.Status;
import org.nsi.alpha.models.viewModels.StatusViewModel;
import org.nsi.alpha.services.CvItemService;
import org.nsi.alpha.services.CvService;
import org.nsi.alpha.services.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ekusundzija on 17/11/16.
 */
@Controller
@RequestMapping(value = "/status")
public class StatusController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StatusController.class);

    @Autowired
    StatusService statusService;

    @Autowired
    CvService cvService;

    @RequestMapping(method = RequestMethod.GET)
    public String getStatusView(Model model){
        return "status";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map getById(@PathVariable Long id) {
        Map model = new HashMap<>();
        LOGGER.info(String.format("Action called - successfully pulled status with id %s.", id));
        model.put("status", statusService.findById(id));
        return model;
    }

    @RequestMapping(value ="/all", method = RequestMethod.GET)
    public @ResponseBody Map getAll() {
        Map model = new HashMap<>();
        LOGGER.info(String.format("Action called - successfully pulled statuses."));
        model.put("status", statusService.findAll());
        return model;
    }

    @RequestMapping(value ="/bystatus", method = RequestMethod.GET)
    public @ResponseBody Map getByStatus(@RequestParam("status") String status) {
        Map model = new HashMap<>();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        List<CvItem> cvItemArrayList = statusService.findItemsByStatus(status);

        if(!username.equals("admin")){
            Cv userCv = cvService.findByUsername(username);
            List<CvItem> filteredByUser = cvItemArrayList
                    .stream()
                    .filter(cvItem -> Objects.equals(cvItem.getCvId(), userCv.getId()))
                    .collect(Collectors.toList());
            Collections.sort(cvItemArrayList, (cvItem1, cvItem2) -> cvItem2.getInsertDate().compareTo(cvItem1.getInsertDate()));
            String name = userCv.getName() + " " + userCv.getSurname();
            List<CvItemWrapper> cvItemWrappers =
                    filteredByUser
                            .stream()
                            .map(cvItem -> new CvItemWrapper(cvItem, name))
                            .collect(Collectors.toList());
            model.put("status", cvItemWrappers);
            model.put("userRole", "role_prof");
            return model;
        }


        Collections.sort(cvItemArrayList, (cvItem1, cvItem2) -> cvItem2.getInsertDate().compareTo(cvItem1.getInsertDate()));

        List<CvItemWrapper> cvWrapperArrayList = new ArrayList<CvItemWrapper>();

        for (CvItem tempCvItem : cvItemArrayList) {
            Cv tempCv = cvService.findById(tempCvItem.getCvId().longValue());
            String tempProfName = tempCv.getName() + " " + tempCv.getSurname();
            cvWrapperArrayList.add(new CvItemWrapper(tempCvItem, tempProfName));
        }

        model.put("status", cvWrapperArrayList);


        return model;


    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveCv(@RequestBody Status statusSaveRequest) {

        try {
            Status savedStatus = statusService.save(statusSaveRequest);
            StatusViewModel statusViewModel = new StatusViewModel(savedStatus);
            LOGGER.info(String.format("Action called - successfully saved status with id %s.", statusViewModel.getId()));
            return new ResponseEntity(statusViewModel, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Action failed - successfully saved status with id %s.", statusSaveRequest.getId()));
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
