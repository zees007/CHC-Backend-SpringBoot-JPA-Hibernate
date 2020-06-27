package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.FacultyRequest;
import com.chc.tanda.concepthubclassessbackend.dto.FacultyResponse;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;

import java.util.List;

public interface FacultyService {

    FacultyResponse saveFaculty(FacultyRequest facultyRequest);

    List<FacultyResponse> getAllFaculty();

    FacultyResponse retire(Integer id);
}
