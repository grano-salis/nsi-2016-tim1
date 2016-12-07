package org.nsi.alpha.controllers;

import org.nsi.alpha.models.Criteria;
import org.nsi.alpha.models.viewModels.CriteriaViewModel;
import org.nsi.alpha.services.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ekusundzija on 17/11/16.
 */
@RestController
@RequestMapping(value = "/criteria")
public class CriteriaController {

    @Autowired
    CriteriaService criteriaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map getById(@PathVariable Long id) {
        Map model = new HashMap<>();

        model.put("criteria", criteriaService.findById(id));
        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Map getAll() {
        Map model = new HashMap<>();

        Criteria criteria = new Criteria();
        criteria.setName("Ilvana");
        criteria.setId(1L);
        criteria.setLastUpdateDate(new Date());
        criteria.setDescription("Ilvana");
        criteria.setInsertDate(new Date());
        criteria.setPoints(1);
        criteria.setCriteriaId(1);

        criteriaService.save(criteria);

        model.put("criteria", criteriaService.findAll());
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveCv(@RequestBody Criteria criteriaSaveItemRequest) {

        try {
            Criteria savedCriteria = criteriaService.save(criteriaSaveItemRequest);
            CriteriaViewModel criteriaViewModel = new CriteriaViewModel(savedCriteria);
            return new ResponseEntity(criteriaViewModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    //ima constraint na criteria, pa se ne mogu item-i brisat
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            Criteria deletedCriteria = criteriaService.findById(id);
            CriteriaViewModel criteriaViewModel = new CriteriaViewModel(deletedCriteria);
            criteriaService.remove(id);
            return new ResponseEntity(criteriaViewModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
