package org.nsi.alpha.controllers;

import org.nsi.alpha.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.nsi.alpha.services.ProfessorsService;

import java.util.*;

/**
 * Created by edenasevic on 11/2/16.
 */

@RestController
@RequestMapping(value = "/professors")
public class ProfessorsController {

    @Autowired
    ProfessorsService professorsService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map getById(@PathVariable Long id) {
        Map model = new HashMap<>();

        model.put("professor", professorsService.findById(id));
        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll() {
        Map model = new HashMap<>();

        model.put("professor", professorsService.findAll());
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map saveProfessor(Professor professorSaveRequest) {
        Map model = new HashMap<>();
        //todo fixme in a way that this part works without hardcoded values
        Professor professorToSave = new Professor();
        professorToSave.setId(3L);
        professorToSave.setLastName(professorSaveRequest.getLastName());
        professorToSave.setFirstName(professorSaveRequest.getFirstName());
        professorToSave.setAddress(professorSaveRequest.getAddress());
        professorToSave.setBirthDate(professorSaveRequest.getBirthDate());
        professorToSave.setCurrentCategory(professorSaveRequest.getCurrentCategory());
        professorToSave.setNotes(professorSaveRequest.getNotes());
        professorToSave.setNumberOfBooks(professorSaveRequest.getNumberOfBooks());
        professorToSave.setYearsOfExperience(professorSaveRequest.getYearsOfExperience());
        professorToSave.setNumberOfPublications(professorSaveRequest.getNumberOfPublications());
        professorToSave.setPhoto(professorSaveRequest.getPhoto());

        professorsService.save(professorToSave);

        return model;
    }
}
