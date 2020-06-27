package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.AchievementRequest;
import com.chc.tanda.concepthubclassessbackend.dto.AchievementResponse;
import com.chc.tanda.concepthubclassessbackend.dto.ContactRequest;
import com.chc.tanda.concepthubclassessbackend.dto.ContactResponse;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 15, 2020
 */
public interface ContactService {



    ContactResponse saveContactUsMessage(ContactRequest contactRequest);

    List<ContactResponse> getAllContactUsMessage();

    ContactResponse retire(Integer id);

    ContactResponse getOneContact(String email);
}
