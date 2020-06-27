package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;

import java.util.List;

public interface StudentRegistrationService {

    StudentRegistrationResponse saveRegistration(StudentRegistrationRequest studentRegistrationRequest);

    List<StudentRegistrationResponse> getAllRegisteredStudents();

    StudentRegistrationResponse retire(Integer id);

    StudentRegistration fetchStudentRegistrationByUsernameAndPassword(String username, String password);

    StudentRegistration fetchStudentRegistrationByUsername(String username);
}
