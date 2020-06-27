package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.*;
import com.chc.tanda.concepthubclassessbackend.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 21, 2020
 */

@RestController
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/tutorial/save")
    public ResponseEntity saveTutorial(@RequestBody TutorialRequest tutorialRequest) {

        TutorialResponse tutorialResponse = tutorialService.saveTutorial(tutorialRequest);
        return ResponseEntity.ok(tutorialResponse);
    }

    @GetMapping(value = "/tutorials")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getAllTutorials() {
        List<TutorialResponse> tutorialResponses = tutorialService.getAllTutorials();
        return ResponseEntity.ok(tutorialResponses);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/tutorial/delete/{id}")
    public ResponseEntity<TutorialResponse> retire(@PathVariable("id") Integer id) {

        TutorialResponse tutorialResponse = tutorialService.retire(id);
        return ResponseEntity.ok().body(tutorialResponse);
    }


}
