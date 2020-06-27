package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;
import com.chc.tanda.concepthubclassessbackend.dto.TestimonialRequest;
import com.chc.tanda.concepthubclassessbackend.dto.TestimonialResponse;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.model.Testimonial;
import com.chc.tanda.concepthubclassessbackend.repositories.TestimonialRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    TestimonialRepository testimonialRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public TestimonialResponse saveTestimonial(TestimonialRequest testimonialRequest) {
        if (testimonialRequest.getStudentBatch() == null) {
            throw new RuntimeException("Parameter getStudentBatch not found in request");
        } else if (testimonialRequest.getStudentCurrentStatus() == null) {
            throw new RuntimeException("Parameter getStudentCurrentStatus not found in request");
        } else if (testimonialRequest.getStudentFeedback() == null) {
            throw new RuntimeException("Parameter getStudentFeedback not found in request");
        }else if (testimonialRequest.getStudentName() == null) {
            throw new RuntimeException("Parameter getStudentName not found in request");
        }else if (testimonialRequest.getStudentImage() == null) {
            throw new RuntimeException("Parameter getStudentImage  not found in request");
        }
        Testimonial savedTestimonials = null;
        if (testimonialRequest.getId() != null) {
            Testimonial oldTestimonials= testimonialRepository.findAllValid(testimonialRequest.getId());
            if (oldTestimonials != null) {
                oldTestimonials.setStudentName(testimonialRequest.getStudentName());
                oldTestimonials.setStudentBatch(testimonialRequest.getStudentBatch());
                oldTestimonials.setStudentCurrentStatus(testimonialRequest.getStudentCurrentStatus());
                oldTestimonials.setStudentFeedback(testimonialRequest.getStudentFeedback());
                oldTestimonials.setStudentImage(testimonialRequest.getStudentImage());
                savedTestimonials = testimonialRepository.save(oldTestimonials);
                testimonialRepository.refresh(oldTestimonials);
            } else {
                throw new RuntimeException("Cannot find permission with identifier: " + testimonialRequest.getId());
            }

        } else {
            Testimonial testimonial = modelMapper.map(testimonialRequest, Testimonial.class);
            savedTestimonials = testimonialRepository.save(testimonial);
            testimonialRepository.refresh(testimonial);


        }
        TestimonialResponse testimonialResponse = modelMapper.map(savedTestimonials, TestimonialResponse.class);
        return testimonialResponse;
    }

    @Override
    public List<TestimonialResponse> getAllTestimonials() {
        List<Testimonial> testimonials = (List<Testimonial>) testimonialRepository.findByValidSortedCreated();
        Type listOfTestimonialsRes = new TypeToken<List<TestimonialResponse>>() {
        }.getType();
        List<TestimonialResponse> testimonialResponses = modelMapper.map(testimonials, listOfTestimonialsRes);
        return testimonialResponses;
    }

    @Override
    public TestimonialResponse retire(Integer id) {
        Testimonial testimonial = testimonialRepository.findAllValid(id);
        testimonial.setRetired(true);
        testimonial.setRetiredDate(new Date());
        testimonialRepository.save(testimonial);
        TestimonialResponse testimonialResponse = modelMapper.map(testimonial, TestimonialResponse.class);
        return testimonialResponse;
    }
}
