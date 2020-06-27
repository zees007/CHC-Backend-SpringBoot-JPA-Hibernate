package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationRequest;
import com.chc.tanda.concepthubclassessbackend.dto.StudentRegistrationResponse;
import com.chc.tanda.concepthubclassessbackend.model.StudentRegistration;
import com.chc.tanda.concepthubclassessbackend.repositories.StudentRegistrationRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

    @Autowired
    StudentRegistrationService  studentRegistrationService;

    @Autowired
    StudentRegistrationRepository studentRegistrationRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public StudentRegistrationResponse saveRegistration(StudentRegistrationRequest studentRegistrationRequest) {
        if (studentRegistrationRequest.getUsername() == null) {
            throw new RuntimeException("Parameter getUsername not found in request");
        } else if (studentRegistrationRequest.getPassword() == null) {
            throw new RuntimeException("Parameter getPassword not found in request");
        } else if (studentRegistrationRequest.getFullname() == null) {
            throw new RuntimeException("Parameter getFullname not found in request");
        }else if (studentRegistrationRequest.getSerial() == null) {
            throw new RuntimeException("Parameter getSerial not found in request");
        }else if (studentRegistrationRequest.getEmail() == null) {
            throw new RuntimeException("Parameter email not found in request");
        } else if (studentRegistrationRequest.getContact() == null) {
            throw new RuntimeException("Parameter contact Date not found in request");
        }
        StudentRegistration savedRegistrations = null;
        if (studentRegistrationRequest.getId() != null) {
            StudentRegistration oldRegistrations= studentRegistrationRepository.findAllValid(studentRegistrationRequest.getId());
            if (oldRegistrations != null) {
                oldRegistrations.setUsername(studentRegistrationRequest.getUsername());
                oldRegistrations.setPassword(studentRegistrationRequest.getPassword());
                oldRegistrations.setFullname(studentRegistrationRequest.getFullname());
                oldRegistrations.setSerial(studentRegistrationRequest.getSerial());
                oldRegistrations.setEmail(studentRegistrationRequest.getEmail());
                oldRegistrations.setContact(studentRegistrationRequest.getContact());
               // oldRegistrations.setRole(studentRegistrationRequest.getRole());
                savedRegistrations = studentRegistrationRepository.save(oldRegistrations);
                //studentRegistrationRepository.refresh(oldRegistrations);
            } else {
                throw new RuntimeException("Cannot find permission with identifier: " + studentRegistrationRequest.getId());
            }

        } else {
            StudentRegistration studentRegistration = modelMapper.map(studentRegistrationRequest, StudentRegistration.class);
            savedRegistrations = studentRegistrationRepository.save(studentRegistration);
            //studentRegistrationRepository.refresh(studentRegistration);


        }
        StudentRegistrationResponse studentRegistrationResponse = modelMapper.map(savedRegistrations, StudentRegistrationResponse.class);
        return studentRegistrationResponse;
    }

    @Override
    public List<StudentRegistrationResponse> getAllRegisteredStudents() {
        List<StudentRegistration> registrations = (List<StudentRegistration>) studentRegistrationRepository.findByValidSortedCreated();
        Type listOfRegisteredStudentsRes = new TypeToken<List<StudentRegistrationResponse>>() {
        }.getType();
        List<StudentRegistrationResponse> studentRegistrationResponses = modelMapper.map(registrations, listOfRegisteredStudentsRes);
        return studentRegistrationResponses;
    }

    @Override
    public StudentRegistrationResponse retire(Integer id) {
        StudentRegistration studentRegistration = studentRegistrationRepository.findAllValid(id);
        studentRegistration.setRetired(true);
        studentRegistration.setRetiredDate(new Date());
        studentRegistrationRepository.save(studentRegistration);
        StudentRegistrationResponse studentRegistrationResponse = modelMapper.map(studentRegistration, StudentRegistrationResponse.class);
        return studentRegistrationResponse;
    }

    @Override
    public StudentRegistration fetchStudentRegistrationByUsernameAndPassword(String username, String password) {
        return studentRegistrationRepository.findByUsernameAndPassword(username, password);
    }


    @Override
    public StudentRegistration fetchStudentRegistrationByUsername(String username) {

        StudentRegistration studentRegistration = studentRegistrationRepository.findByUsername(username);
        return studentRegistration;
    }
}
