package org.nsi.alpha.controllers;

import org.nsi.alpha.models.Status;
import org.nsi.alpha.models.viewModels.StatusViewModel;
import org.nsi.alpha.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ekusundzija on 17/11/16.
 */
@Controller
@RequestMapping(value = "/status")
public class StatusController {


    @Autowired
    StatusService statusService;

    @RequestMapping(method = RequestMethod.GET)
    public String getStatusView(Model model){
        return "status";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map getById(@PathVariable Long id) {
        Map model = new HashMap<>();

        model.put("status", statusService.findById(id));
        return model;
    }

    @RequestMapping(value ="/all", method = RequestMethod.GET)
    public @ResponseBody Map getAll() {
        Map model = new HashMap<>();

        //Status status = new Status();
        //status.setId(1L);
        //status.setValue("ilvana");

        //statusService.save(status);

        model.put("status", statusService.findItemsByStatus("ilvana"));
        //model.put("status", statusService.findAll());
        return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveCv(@RequestBody Status statusSaveRequest) {

        try {
            Status savedStatus = statusService.save(statusSaveRequest);
            StatusViewModel statusViewModel = new StatusViewModel(savedStatus);
            return new ResponseEntity(statusViewModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
