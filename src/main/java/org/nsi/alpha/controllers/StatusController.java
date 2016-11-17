package org.nsi.alpha.controllers;

import org.nsi.alpha.models.Status;
import org.nsi.alpha.services.StatusService;
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
@RequestMapping(value = "/status")
public class StatusController {


    @Autowired
    StatusService statusService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map getById(@PathVariable Long id){
        Map model = new HashMap<>();

        model.put("status", statusService.findById(id));
        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll(){
        Map model = new HashMap<>();

        model.put("status", statusService.findAll());
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map saveStatus(Status statusSaveRequest){
        Map model = new HashMap<>();
        //todo fixme in a way that this part works without hardcoded values
        Status statusToSave = new Status();
        statusToSave.setId(3L);
        statusToSave.setValue(statusSaveRequest.getValue());

        statusService.save(statusToSave);

        return model;
    }
}
