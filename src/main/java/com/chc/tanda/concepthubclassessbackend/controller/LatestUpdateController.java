package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.*;
import com.chc.tanda.concepthubclassessbackend.repositories.LatestUpdateRepository;
import com.chc.tanda.concepthubclassessbackend.services.LatestUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 12, 2020
 */

@RestController
public class LatestUpdateController {

    @Autowired
    LatestUpdateService latestUpdateService;

    @Autowired
    LatestUpdateRepository latestUpdateRepository;

    @PostMapping(value = "/latestUpdate/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity saveLatestUpdate(@RequestBody LatestUpdateRequest latestUpdateRequest) {

        LatestUpdateResponse latestUpdateResponse = latestUpdateService.saveLatestUpdate(latestUpdateRequest);
        return ResponseEntity.ok(latestUpdateResponse);
    }

    @GetMapping(value = "/latestUpdates")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getAllLatest() {
        List<LatestUpdateResponse> latestUpdateResponses = latestUpdateService.getAllLatestUpdates();
        return ResponseEntity.ok(latestUpdateResponses);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/latestUpdate/delete/{id}")
    public ResponseEntity<LatestUpdateResponse> retire(@PathVariable("id") Integer id) {

        LatestUpdateResponse latestUpdateResponse = latestUpdateService.retireLatestUpdate(id);
        return ResponseEntity.ok().body(latestUpdateResponse);
    }
}
