package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.FacultyRequest;
import com.chc.tanda.concepthubclassessbackend.dto.FacultyResponse;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;
import com.chc.tanda.concepthubclassessbackend.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @PostMapping(value = "/faculty/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity saveFaculty(@RequestBody FacultyRequest facultyRequest) {

        FacultyResponse facultyResponse = facultyService.saveFaculty(facultyRequest);
        return ResponseEntity.ok(facultyResponse);
    }

    @GetMapping(value = "/faculties")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getAllFaculty() {
        List<FacultyResponse> facultyResponses = facultyService.getAllFaculty();
        return ResponseEntity.ok(facultyResponses);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/faculty/delete/{id}")
    public ResponseEntity<FacultyResponse> retire(@PathVariable("id") Integer id) {

        FacultyResponse facultyResponse = facultyService.retire(id);
        return ResponseEntity.ok().body(facultyResponse);
    }
}
