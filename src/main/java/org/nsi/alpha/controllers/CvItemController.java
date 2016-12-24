package org.nsi.alpha.controllers;

import org.nsi.alpha.models.CvItem;
import org.nsi.alpha.models.viewModels.CvItemViewModel;
import org.nsi.alpha.services.CvItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
public class CvItemController {

    @Autowired
    CvItemService cvItemService;

    @RequestMapping(value = "cv_item/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {

        try {
            CvItem cvItem = cvItemService.findById(id);
            CvItemViewModel cvItemViewModel = new CvItemViewModel(cvItem);
            return new ResponseEntity(cvItemViewModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/new_cv_item", method = RequestMethod.GET)
    public String newCvItem(){

        return "new_cv_item";
    }

    @RequestMapping(value = "/create_cv_item", method = RequestMethod.GET)
    public @ResponseBody Map createCvItem(
            @RequestParam(value = "name", required = false, defaultValue = "no_name") String name,
            @RequestParam(value = "description", required = false, defaultValue = "desc") String description){

        Map model = new HashMap<>();

        CvItem cvItem = new CvItem();
        cvItem.setName(name);
        cvItem.setDescription(description);
        cvItem.setInsertDate(new Date()); //Stavka unesena upravo u ovom trenutku

        //Po defaultu ide 1 koji ce predstavljati status PENDING (preostali statusi su APPROVED i DECLINED)
        cvItem.setStatusId(1);

        //TODO: Za ovaj cvId ce se postaviti vrijednost ID-a ulogovanog profesora (vjerovatno neka veza profa-cv)
        cvItem.setCvId(1);

        //TODO: Kada budemo imali drvo za odabir kriterija, dodati i ovo kao parametar kontrolera
        cvItem.setCriteriaId(1);

        //TODO: Definisati sta raditi sa ovim
        //cvItem.setCvItemId();
        cvItem.setId(3L);
        model.put("savedCvItem", cvItemService.save(cvItem));

        return model;
    }


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Map getAll() {
        Map model = new HashMap<>();

        CvItem cvItem = new CvItem();
        cvItem.setId(1L);
        cvItem.setName("Ilvaana");
        cvItem.setDescription("test");
        Date d = new Date();
        cvItem.setStartDate(d);
        cvItem.setEndDate(d);
        cvItem.setInsertDate(d);
        cvItem.setLastUpdateDate(d);
        cvItem.setCvId(1);
        cvItem.setStatusId(1);
        cvItem.setCvItemId(1);
        cvItem.setCriteriaId(1);

        cvItemService.save(cvItem);

        model.put("cvItems", cvItemService.findAll());
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveCv(@RequestBody CvItem cvItemSaveRequest) {

        try {
            CvItem savedCvItem = cvItemService.save(cvItemSaveRequest);
            CvItemViewModel cvItemViewModel = new CvItemViewModel(savedCvItem);
            return new ResponseEntity(cvItemViewModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            CvItem deletedCv = cvItemService.findById(id);
            CvItemViewModel cvItemViewModel = new CvItemViewModel(deletedCv);
            cvItemService.remove(id);
            return new ResponseEntity(cvItemViewModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
