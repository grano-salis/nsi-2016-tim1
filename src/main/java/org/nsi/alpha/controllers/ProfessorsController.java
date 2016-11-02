package org.nsi.alpha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.nsi.alpha.services.ProfessorsService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by edenasevic on 11/2/16.
 */

@RestController
@RequestMapping(value = "/professors")
public class ProfessorsController {

    @Autowired
    ProfessorsService professorsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map getById(@PathVariable Long id){
        Map model = new HashMap<>();

        model.put("professor", professorsService.findById(id));

        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll(){
        Map model = new HashMap<>();

        model.put("professors", professorsService.findAll());

        return model;
    }
}
