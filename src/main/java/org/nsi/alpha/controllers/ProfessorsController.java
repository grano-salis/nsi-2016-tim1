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
    public Map getById(@PathVariable Long id){
        Map model = new HashMap<>();

        model.put("professor", professorsService.findById(id));
        /*Professor professor = new Professor();
        professor.setId(id);
        professor.setLastName("Prezime");
        professor.setFirstName("Ime");
        professor.setAddress("Adresa");
        professor.setBirthDate(new Date());
        professor.setCurrentCategory(1);
        professor.setNotes("notes");
        professor.setNumberOfBooks(20);
        professor.setYearsOfExperience(5);
        professor.setNumberOfPublications(20);
        professor.setPhoto("urlSlike");

        model.put("professor", Collections.singletonList(professor));
*/
        return model;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll(){
        Map model = new HashMap<>();

        model.put("professor", professorsService.findAll());
/*        Professor professor1 = new Professor();
        professor1.setId(1L);
        professor1.setLastName("Prezime");
        professor1.setFirstName("Ime");
        professor1.setAddress("Adresa");
        professor1.setBirthDate(new Date());
        professor1.setCurrentCategory(1);
        professor1.setNotes("notes");
        professor1.setNumberOfBooks(20);
        professor1.setYearsOfExperience(5);
        professor1.setNumberOfPublications(20);
        professor1.setPhoto("urlSlike");

        Professor professor2 = new Professor();
        professor2.setId(100L);
        professor2.setLastName("Prezime");
        professor2.setFirstName("Ime");
        professor2.setAddress("Adresa");
        professor2.setBirthDate(new Date());
        professor2.setCurrentCategory(1);
        professor2.setNotes("notes");
        professor2.setNumberOfBooks(20);
        professor2.setYearsOfExperience(5);
        professor2.setNumberOfPublications(20);
        professor2.setPhoto("urlSlike");

        model.put("professors1", Arrays.asList(professor1, professor2));

        model.put("professors", professorsService.findAll());
*/
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Map saveProfessor(){
        Map model = new HashMap<>();

        Professor professor2 = new Professor();
        professor2.setId(2L);
        professor2.setLastName("SURNAME");
        professor2.setFirstName("NAME");
        professor2.setAddress("Adresa");
        professor2.setBirthDate(new Date());
        professor2.setCurrentCategory(1);
        professor2.setNotes("notes");
        professor2.setNumberOfBooks(20);
        professor2.setYearsOfExperience(5);
        professor2.setNumberOfPublications(20);
        professor2.setPhoto("urlSlike");

        professorsService.save(professor2);

        return model;
    }
}
