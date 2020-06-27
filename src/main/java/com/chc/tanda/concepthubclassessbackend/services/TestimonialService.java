package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;
import com.chc.tanda.concepthubclassessbackend.dto.TestimonialRequest;
import com.chc.tanda.concepthubclassessbackend.dto.TestimonialResponse;

import java.util.List;

public interface TestimonialService {

    TestimonialResponse saveTestimonial(TestimonialRequest testimonialRequest);

    List<TestimonialResponse> getAllTestimonials();

    TestimonialResponse retire(Integer id);
}
