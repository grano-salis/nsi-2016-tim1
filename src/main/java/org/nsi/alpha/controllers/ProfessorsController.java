package org.nsi.alpha.controllers;

import org.nsi.alpha.models.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.nsi.alpha.services.ProfessorsService;

import java.util.*;

/**
 * Created by edenasevic on 11/2/16.
 */

@Controller
@RequestMapping(value = "/professors")
public class ProfessorsController {

    @Autowired
    ProfessorsService professorsService;


    @RequestMapping(method = RequestMethod.GET)
    public String getProfessorsView(Model model){
        return "professors";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map getById(@PathVariable Long id) {
        Map model = new HashMap<>();
        model.put("professor", professorsService.findById(id));
        return model;
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public @ResponseBody Map getAll() {
        Map model = new HashMap<>();
        model.put("professors", professorsService.findAll());
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Map saveProfessor(Professor professorSaveRequest) {
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
