package org.nsi.alpha.controllers;

import org.nsi.alpha.models.Criteria;
import org.nsi.alpha.services.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public Map getById(@PathVariable Long id){
        Map model = new HashMap<>();

        model.put("criteria", criteriaService.findById(id));
        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll(){
        Map model = new HashMap<>();

        model.put("criteria", criteriaService.findAll());
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map saveCriteria(Criteria criteriaSaveRequest){
        Map model = new HashMap<>();
        //todo fixme in a way that this part works without hardcoded values
        Criteria criteriaToSave = new Criteria();
        criteriaToSave.setId(3L);
        criteriaToSave.setDescription(criteriaSaveRequest.getDescription());
        criteriaToSave.setName(criteriaSaveRequest.getName());
        criteriaToSave.setId(criteriaSaveRequest.getId());
        criteriaToSave.setCriteriaId(criteriaSaveRequest.getCriteriaId());
        criteriaToSave.setInsertDate(criteriaSaveRequest.getInsertDate());
        criteriaToSave.setLastUpdateDate(criteriaSaveRequest.getLastUpdateDate());
        criteriaToSave.setPoints(criteriaSaveRequest.getPoints());

        criteriaService.save(criteriaToSave);

        return model;
    }
}
