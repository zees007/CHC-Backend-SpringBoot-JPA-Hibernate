package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.FacultyRequest;
import com.chc.tanda.concepthubclassessbackend.dto.FacultyResponse;
import com.chc.tanda.concepthubclassessbackend.dto.GallaryRequest;
import com.chc.tanda.concepthubclassessbackend.dto.GallaryResponse;
import com.chc.tanda.concepthubclassessbackend.services.GallaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GallaryController {

    @Autowired
    GallaryService gallaryService;

    @PostMapping(value = "/gallary/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity saveGallary(@RequestBody GallaryRequest gallaryRequest) {

        GallaryResponse gallaryResponse = gallaryService.saveGallary(gallaryRequest);
        return ResponseEntity.ok(gallaryResponse);
    }

    @GetMapping(value = "/gallaries")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getAllGallary() {
        List<GallaryResponse> gallaryResponses = gallaryService.getAllGallary();
        return ResponseEntity.ok(gallaryResponses);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/gallary/delete/{id}")
    public ResponseEntity<GallaryResponse> retire(@PathVariable("id") Integer id) {

        GallaryResponse gallaryResponse = gallaryService.retire(id);
        return ResponseEntity.ok().body(gallaryResponse);
    }
}
