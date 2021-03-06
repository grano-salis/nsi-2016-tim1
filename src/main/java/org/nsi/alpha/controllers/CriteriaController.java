package org.nsi.alpha.controllers;

import org.nsi.alpha.models.Criteria;
import org.nsi.alpha.models.viewModels.CriteriaViewModel;
import org.nsi.alpha.repositories.CrieteriaRepository;
import org.nsi.alpha.services.CriteriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Controller
@RequestMapping(value = "/criteria")
public class CriteriaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CriteriaController.class);

    @Autowired
    CriteriaService criteriaService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCriteriaView(Model model){
        return "criteria";
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public @ResponseBody Map getAll() {
        Map model = new HashMap<>();
        model.put("criteria", criteriaService.findAll());
        LOGGER.info(String.format("Action called - successfully pulled all criteria."));
        return model;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map getById(@PathVariable Long id) {
        Map model = new HashMap<>();
        LOGGER.info(String.format("Action called - successfully pulled criteria with id %s.", id));
        model.put("criteria", criteriaService.findById(id));
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Model saveCriteria(@RequestParam(value="criteriaId") Integer criteriaId,
                                          @RequestParam(value="name") String name,
                                          @RequestParam(value="description") String description,
                                          @RequestParam(value="points") Integer points,
                                          @RequestParam(value = "level") Integer level,Model model) {
        Criteria criteria = new Criteria();
        criteria.setId(criteriaService.count() + 1);// napraviti na bazi inkrementalno
        criteria.setLastUpdateDate(new Date());
        criteria.setPoints(points);
        criteria.setDescription(description);
        criteria.setName(name);
        criteria.setCriteriaId(criteriaId);
        criteria.setInsertDate(new Date());
        criteria.setCriteriaLevel(level);
        criteriaService.save(criteria);
        LOGGER.info(String.format("Action called - saved new criteria with id %s.", criteriaId));
        return model;
    }

    //ima constraint na criteria, pa se ne mogu item-i brisat
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            Criteria deletedCriteria = criteriaService.findById(id);
            CriteriaViewModel criteriaViewModel = new CriteriaViewModel(deletedCriteria);
            criteriaService.remove(id);
            LOGGER.info(String.format("Action called - deleted new criteria with id %s.", id));
            return new ResponseEntity(criteriaViewModel, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(String.format("Action failed - failed to delete criteria with id %s.", id));
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
