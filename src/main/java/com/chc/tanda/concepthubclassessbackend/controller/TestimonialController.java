package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;
import com.chc.tanda.concepthubclassessbackend.dto.TestimonialRequest;
import com.chc.tanda.concepthubclassessbackend.dto.TestimonialResponse;
import com.chc.tanda.concepthubclassessbackend.services.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestimonialController {

    @Autowired
    TestimonialService testimonialService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/testimonial/save")
    public ResponseEntity saveTestimonial(@RequestBody TestimonialRequest testimonialRequest) {

        TestimonialResponse testimonialResponse = testimonialService.saveTestimonial(testimonialRequest);
        return ResponseEntity.ok(testimonialResponse);
    }

    @GetMapping(value = "/testimonials")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getAllTestimonials() {
        List<TestimonialResponse> testimonialResponses = testimonialService.getAllTestimonials();
        return ResponseEntity.ok(testimonialResponses);
    }

    @PostMapping(value = "/testimonial/delete/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<TestimonialResponse> retire(@PathVariable("id") Integer id) {

        TestimonialResponse testimonialResponse = testimonialService.retire(id);
        return ResponseEntity.ok().body(testimonialResponse);
    }
}
