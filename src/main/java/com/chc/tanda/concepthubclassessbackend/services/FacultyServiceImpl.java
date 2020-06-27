package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.FacultyRequest;
import com.chc.tanda.concepthubclassessbackend.dto.FacultyResponse;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;
import com.chc.tanda.concepthubclassessbackend.dto.TestimonialResponse;
import com.chc.tanda.concepthubclassessbackend.model.Faculty;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.model.Testimonial;
import com.chc.tanda.concepthubclassessbackend.repositories.FacultyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public FacultyResponse saveFaculty(FacultyRequest facultyRequest) {
        if (facultyRequest.getFacultyName() == null) {
            throw new RuntimeException("Parameter getFacultyName not found in request");
        } else if (facultyRequest.getFacultyEducation() == null) {
            throw new RuntimeException("Parameter getFacultyEducation not found in request");
        } else if (facultyRequest.getFacultySubject() == null) {
            throw new RuntimeException("Parameter getFacultySubject not found in request");
        }
        Faculty savedFaculty = null;
        if (facultyRequest.getId() != null) {
            Faculty oldFaculty= facultyRepository.findAllValid(facultyRequest.getId());
            if (oldFaculty != null) {
                oldFaculty.setFacultyName(facultyRequest.getFacultyName());
                oldFaculty.setFacultyEducation(facultyRequest.getFacultyEducation());
                oldFaculty.setFacultySubject(facultyRequest.getFacultySubject());
                oldFaculty.setFacultyImage(facultyRequest.getFacultyImage());
                savedFaculty = facultyRepository.save(oldFaculty);
                facultyRepository.refresh(oldFaculty);
            } else {
                throw new RuntimeException("Cannot find faculty with identifier: " + facultyRequest.getId());
            }

        } else {
            Faculty faculty = modelMapper.map(facultyRequest, Faculty.class);
            savedFaculty = facultyRepository.save(faculty);
            facultyRepository.refresh(faculty);


        }
        FacultyResponse facultyResponse = modelMapper.map(savedFaculty, FacultyResponse.class);
        return facultyResponse;
    }

    @Override
    public List<FacultyResponse> getAllFaculty() {
        List<Faculty> faculties = (List<Faculty>) facultyRepository.findByValidSortedCreated();
        Type listOfFacultyRes = new TypeToken<List<FacultyResponse>>() {
        }.getType();
        List<FacultyResponse> facultyResponses = modelMapper.map(faculties, listOfFacultyRes);
        return facultyResponses;
    }

    @Override
    public FacultyResponse retire(Integer id) {
        Faculty faculty = facultyRepository.findAllValid(id);
        faculty.setRetired(true);
        faculty.setRetiredDate(new Date());
        facultyRepository.save(faculty);
        FacultyResponse facultyResponse = modelMapper.map(faculty, FacultyResponse.class);
        return facultyResponse;
    }
}
