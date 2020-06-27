package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationByAdminRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationByAdminResponse;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;

import java.util.List;

public interface StudentRegistrationByAdminService {

    StudentRegistrationByAdminResponse saveRegistrationByAdmin(StudentRegistrationByAdminRequest studentRegistrationByAdminRequest);

    List<StudentRegistrationByAdminResponse> getAllRegistrationByAdmin();

    StudentRegistrationByAdminResponse retire(String serial);

    StudentRegistrationByAdminResponse getOneRegistrationBySerial(String serial);
}
