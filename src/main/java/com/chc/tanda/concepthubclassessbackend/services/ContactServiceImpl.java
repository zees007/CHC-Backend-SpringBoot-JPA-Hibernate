package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.AchievementResponse;
import com.chc.tanda.concepthubclassessbackend.dto.ContactRequest;
import com.chc.tanda.concepthubclassessbackend.dto.ContactResponse;
import com.chc.tanda.concepthubclassessbackend.dto.FacultyResponse;
import com.chc.tanda.concepthubclassessbackend.model.Achievement;
import com.chc.tanda.concepthubclassessbackend.model.ContactUs;
import com.chc.tanda.concepthubclassessbackend.model.Faculty;
import com.chc.tanda.concepthubclassessbackend.repositories.ContactUsRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 15, 2020
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactUsRepository contactUsRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public ContactResponse saveContactUsMessage(ContactRequest contactRequest) {
        if (contactRequest.getMessage() == null) {
            throw new RuntimeException("Parameter getMessage not found in request");
        } else if (contactRequest.getEmail() == null) {
            throw new RuntimeException("Parameter getEmail not found in request");
        }else if (contactRequest.getName() == null) {
            throw new RuntimeException("Parameter getName not found in request");
        }else if (contactRequest.getSubject() == null) {
            throw new RuntimeException("Parameter getSubject not found in request");
        }

        ContactUs contactUs = modelMapper.map(contactRequest, ContactUs.class);
        ContactUs savedContactUs = contactUsRepository.save(contactUs);

        ContactResponse contactResponse = modelMapper.map(savedContactUs, ContactResponse.class);
        return contactResponse;
    }

    @Override
    public List<ContactResponse> getAllContactUsMessage() {
        List<ContactUs> contactMsgs = (List<ContactUs>) contactUsRepository.findByValidSortedCreated();
        Type listOfcontactMsgsRes = new TypeToken<List<ContactResponse>>() {
        }.getType();
        List<ContactResponse> contactResponses = modelMapper.map(contactMsgs, listOfcontactMsgsRes);
        return contactResponses;
    }

    @Override
    public ContactResponse retire(Integer id) {
        ContactUs contactUs = contactUsRepository.findAllValid(id);
        contactUs.setRetired(true);
        contactUs.setRetiredDate(new Date());
        contactUsRepository.save(contactUs);
        ContactResponse contactResponse = modelMapper.map(contactUs, ContactResponse.class);
        return contactResponse;
    }

    @Override
    public ContactResponse getOneContact(String email) {
        ContactUs contactUs = contactUsRepository.findAllValidByEmail(email);
        ContactResponse contactResponse = modelMapper.map(contactUs, ContactResponse.class);
        return contactResponse;
    }
}
