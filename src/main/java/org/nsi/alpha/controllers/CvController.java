package org.nsi.alpha.controllers;

import org.nsi.alpha.models.Cv;
import org.nsi.alpha.models.viewModels.CvViewModel;
import org.nsi.alpha.services.CvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/cv")
public class CvController {

    @Autowired
    CvService cvService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable Long id) {

        try {
            Cv cv = cvService.findById(id);
            CvViewModel cvViewModel = new CvViewModel(cv);
            return new ResponseEntity(cvViewModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map getAll() {
        Map model = new HashMap<>();

        Cv cv = new Cv();
        cv.setName("Ilvana");
        cv.setSurname("Brankovic");
        cv.setAddress("Address");
        cv.setEmail("ibrankovic1@etf.unsa.ba");
        cv.setPhoto("slika");
        cv.setFax(11);
        cv.setTelephone(111);
        Date d = new Date();
        cv.setDateOfBirth(d);
        cv.setId(3L);
        cvService.save(cv);

        model.put("cvs", cvService.findAll());
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveCv(@RequestBody Cv cvSaveRequest) {

        try {
            Cv savedCv = cvService.save(cvSaveRequest);
            CvViewModel cvViewModel = new CvViewModel(savedCv);
            return new ResponseEntity(cvViewModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        try {
            Cv deletedCv = cvService.findById(id);
            CvViewModel cvViewModel = new CvViewModel(deletedCv);
            cvService.remove(id);
            return new ResponseEntity(cvViewModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
