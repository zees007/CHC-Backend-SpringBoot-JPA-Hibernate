package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.ContactResponse;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationByAdminRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationByAdminResponse;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;
import com.chc.tanda.concepthubclassessbackend.model.ContactUs;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistrationByAdmin;
import com.chc.tanda.concepthubclassessbackend.repositories.StudentRegistrationByAdminRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Service
public class StudentRegistrationByAdminServiceImpl implements StudentRegistrationByAdminService {

    @Autowired
    StudentRegistrationByAdminRepository studentRegistrationByAdminRepository;
    @Autowired
    StudentRegistrationByAdminService studentRegistrationByAdminService;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public StudentRegistrationByAdminResponse saveRegistrationByAdmin(StudentRegistrationByAdminRequest studentRegistrationByAdminRequest) {
        if (studentRegistrationByAdminRequest.getStudentName() == null) {
            throw new RuntimeException("Parameter getStudentName not found in request");
        } else if (studentRegistrationByAdminRequest.getStudentFatherName() == null) {
            throw new RuntimeException("Parameter getStudentFatherName not found in request");
        } else if (studentRegistrationByAdminRequest.getStudentDob() == null) {
            throw new RuntimeException("Parameter getStudentDob not found in request");
        }else if (studentRegistrationByAdminRequest.getStudentClass() == null) {
            throw new RuntimeException("Parameter getStudentClass not found in request");
        }else if (studentRegistrationByAdminRequest.getStudentSchoolName() == null) {
            throw new RuntimeException("Parameter getStudentSchoolName Date not found in request");
        } else if (studentRegistrationByAdminRequest.getStudentContactNumber() == null) {
            throw new RuntimeException("Parameter getStudentContactNumber Date not found in request");
        }else if (studentRegistrationByAdminRequest.getStudentEmail() == null) {
            throw new RuntimeException("Parameter getStudentEmail Date not found in request");
        }else if (studentRegistrationByAdminRequest.getStudentAddress() == null) {
            throw new RuntimeException("Parameter getStudentAddress Date not found in request");
        }else if (studentRegistrationByAdminRequest.getFeePaid() == null) {
            throw new RuntimeException("Parameter getFeePaid not found in request");
        } else if (studentRegistrationByAdminRequest.getFeeBalance() == null) {
            throw new RuntimeException("Parameter getFeeBalance not found in request");
        }
        StudentRegistrationByAdmin savedAdminRegistrations = null;
        if (studentRegistrationByAdminRequest.getSerial() != null) {
            StudentRegistrationByAdmin oldAdminRegistrations= studentRegistrationByAdminRepository.findAllValid(studentRegistrationByAdminRequest.getSerial());
            if (oldAdminRegistrations != null) {
                // oldAdminRegistrations.setId(studentRegistrationByAdminRequest.getId());
                oldAdminRegistrations.setSerial(studentRegistrationByAdminRequest.getSerial());
                oldAdminRegistrations.setStudentName(studentRegistrationByAdminRequest.getStudentName());
                oldAdminRegistrations.setStudentFatherName(studentRegistrationByAdminRequest.getStudentFatherName());
                oldAdminRegistrations.setStudentDob(studentRegistrationByAdminRequest.getStudentDob());
                oldAdminRegistrations.setStudentClass(studentRegistrationByAdminRequest.getStudentClass());
                oldAdminRegistrations.setStudentSchoolName(studentRegistrationByAdminRequest.getStudentSchoolName());
                oldAdminRegistrations.setStudentContactNumber(studentRegistrationByAdminRequest.getStudentContactNumber());
                oldAdminRegistrations.setStudentEmail(studentRegistrationByAdminRequest.getStudentEmail());
                oldAdminRegistrations.setStudentAddress(studentRegistrationByAdminRequest.getStudentAddress());
                oldAdminRegistrations.setFeePaid(studentRegistrationByAdminRequest.getFeePaid());
                oldAdminRegistrations.setFeeBalance(studentRegistrationByAdminRequest.getFeeBalance());
                oldAdminRegistrations.setStudentImage(studentRegistrationByAdminRequest.getStudentImage());

                savedAdminRegistrations = studentRegistrationByAdminRepository.save(oldAdminRegistrations);
                studentRegistrationByAdminRepository.refresh(oldAdminRegistrations);
            } else {
                throw new RuntimeException("Cannot find permission with identifier: " + studentRegistrationByAdminRequest.getSerial());
            }

        } else {
            StudentRegistrationByAdmin studentRegistrationByAdmin = modelMapper.map(studentRegistrationByAdminRequest, StudentRegistrationByAdmin.class);
            savedAdminRegistrations = studentRegistrationByAdminRepository.save(studentRegistrationByAdmin);
            studentRegistrationByAdminRepository.refresh(studentRegistrationByAdmin);


        }
        StudentRegistrationByAdminResponse studentRegistrationByAdminResponse = modelMapper.map(savedAdminRegistrations, StudentRegistrationByAdminResponse.class);
        return studentRegistrationByAdminResponse;
    }

    @Override
    public List<StudentRegistrationByAdminResponse> getAllRegistrationByAdmin() {
        List<StudentRegistrationByAdmin> studentRegistrationByAdmins = (List<StudentRegistrationByAdmin>) studentRegistrationByAdminRepository.findByValidSortedCreated();
        Type listOfRegisteredStudentsResByAdmin = new TypeToken<List<StudentRegistrationByAdminResponse>>() {
        }.getType();
        List<StudentRegistrationByAdminResponse> studentRegistrationByAdminResponses = modelMapper.map(studentRegistrationByAdmins, listOfRegisteredStudentsResByAdmin);
        return studentRegistrationByAdminResponses;
    }

    @Override
    public StudentRegistrationByAdminResponse retire(String serial) {
        StudentRegistrationByAdmin studentRegistrationByAdmin = studentRegistrationByAdminRepository.findAllValid(serial);
        studentRegistrationByAdmin.setRetired(true);
        studentRegistrationByAdmin.setRetiredDate(new Date());
        studentRegistrationByAdminRepository.save(studentRegistrationByAdmin);
        StudentRegistrationByAdminResponse studentRegistrationByAdminResponse = modelMapper.map(studentRegistrationByAdmin, StudentRegistrationByAdminResponse.class);
        return studentRegistrationByAdminResponse;
    }

    @Override
    public StudentRegistrationByAdminResponse getOneRegistrationBySerial(String serial) {
        StudentRegistrationByAdmin studentRegistrationByAdmin = studentRegistrationByAdminRepository.findOneBySerial(serial);
        StudentRegistrationByAdminResponse studentRegistrationByAdminResponse = modelMapper.map(studentRegistrationByAdmin, StudentRegistrationByAdminResponse.class);
        return studentRegistrationByAdminResponse;
    }
}
