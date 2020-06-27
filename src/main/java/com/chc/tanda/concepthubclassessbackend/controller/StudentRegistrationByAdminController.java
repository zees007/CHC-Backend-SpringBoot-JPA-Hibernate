package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.assistors.NotDeletedStudentSearchApiSpecification;
import com.chc.tanda.concepthubclassessbackend.dto.*;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistrationByAdmin;
import com.chc.tanda.concepthubclassessbackend.repositories.StudentRegistrationByAdminRepository;
import com.chc.tanda.concepthubclassessbackend.services.StudentRegistrationByAdminService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentRegistrationByAdminController {

    @Autowired
    StudentRegistrationByAdminService studentRegistrationByAdminService;

    @Autowired
    StudentRegistrationByAdminRepository studentRegistrationByAdminRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/registrationByAdmin/save")
    public ResponseEntity saveRegistrationByAdmin(@RequestBody StudentRegistrationByAdminRequest studentRegistrationByAdminRequest) throws Exception {

        StudentRegistrationByAdminResponse studentRegistrationByAdminResponse = studentRegistrationByAdminService.saveRegistrationByAdmin(studentRegistrationByAdminRequest);
        return ResponseEntity.ok(studentRegistrationByAdminResponse);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/allRegistrationsByAdmin")
    public ResponseEntity getAllRegisteredStudentByAdmin() {
        List<StudentRegistrationByAdminResponse> studentRegistrationByAdminResponses = studentRegistrationByAdminService.getAllRegistrationByAdmin();
        return ResponseEntity.ok(studentRegistrationByAdminResponses);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/registrationByAdmin/delete/{serial}")
    public ResponseEntity<StudentRegistrationByAdminResponse> retire(@PathVariable("serial") String serial) {

        StudentRegistrationByAdminResponse studentRegistrationByAdminResponse = studentRegistrationByAdminService.retire(serial);
        return ResponseEntity.ok().body(studentRegistrationByAdminResponse);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getOne/registrationByAdmin/{serial}")
    public ResponseEntity<StudentRegistrationByAdminResponse> getOneAdminRegistration(@PathVariable("serial") String serial) {

        StudentRegistrationByAdminResponse studentRegistrationByAdminResponse = studentRegistrationByAdminService.getOneRegistrationBySerial(serial);
        return ResponseEntity.ok().body(studentRegistrationByAdminResponse);
    }


    //Search Api controller for visitor entity with active permissions
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/student/search")
    public List<StudentRegistrationByAdmin> searchAttributes(
            @Or({
                    @Spec(path = "studentName", params = "name", spec = LikeIgnoreCase.class),
                    @Spec(path = "studentFatherName", params = "fathername", spec = LikeIgnoreCase.class),
                    @Spec(path = "studentSchoolName", params = "school", spec = LikeIgnoreCase.class),
                    @Spec(path = "studentContactNumber", params = "contact", spec = LikeIgnoreCase.class),
                    @Spec(path = "studentEmail", params = "email", spec = LikeIgnoreCase.class),
                    @Spec(path = "serial", params = "enroll", spec = Equal.class)
            })
                    NotDeletedStudentSearchApiSpecification permissionSpec, Sort sort) {

        return studentRegistrationByAdminRepository.findAll(permissionSpec, Sort.by("serial").descending());
    }

}
