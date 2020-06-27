package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.services.StudentRegistrationByAdminService;
import com.chc.tanda.concepthubclassessbackend.services.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRegistrationController {

    @Autowired
    StudentRegistrationService studentRegistrationService;

    @Autowired
    StudentRegistrationByAdminService studentRegistrationByAdminService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/registration/save")
    public ResponseEntity saveRegistration(@RequestBody StudentRegistrationRequest studentRegistrationRequest) throws Exception {


        String tempUsername = studentRegistrationRequest.getUsername();
        if(tempUsername != null && !"".equals(tempUsername)){
            StudentRegistration studentRegistration = studentRegistrationService.fetchStudentRegistrationByUsername(tempUsername);
            if(studentRegistration != null){
                throw new Exception("Student with "+tempUsername+" is already exist.");
            }
        }

        StudentRegistrationResponse studentRegistrationResponse = studentRegistrationService.saveRegistration(studentRegistrationRequest);
        return ResponseEntity.ok(studentRegistrationResponse);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/registrations")
    public ResponseEntity getAllRegisteredStudents() {
        List<StudentRegistrationResponse> studentRegistrationResponses = studentRegistrationService.getAllRegisteredStudents();
        return ResponseEntity.ok(studentRegistrationResponses);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/registration/delete/{id}")
    public ResponseEntity<StudentRegistrationResponse> retire(@PathVariable("id") Integer id) {

        StudentRegistrationResponse studentRegistrationResponse = studentRegistrationService.retire(id);
        return ResponseEntity.ok().body(studentRegistrationResponse);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/login")
    public ResponseEntity<StudentRegistration> loginStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest) throws Exception {
        String tempUsername = studentRegistrationRequest.getUsername();
        String tempPassword = studentRegistrationRequest.getPassword();
        StudentRegistration studentRegistration = null;
        if(tempUsername != null && tempPassword != null){
            studentRegistration = studentRegistrationService.fetchStudentRegistrationByUsernameAndPassword(tempUsername, tempPassword);
        }
        if(studentRegistration == null){
            throw new Exception("Bad Credentials.");
        }
        return ResponseEntity.ok(studentRegistration);

    }
}
