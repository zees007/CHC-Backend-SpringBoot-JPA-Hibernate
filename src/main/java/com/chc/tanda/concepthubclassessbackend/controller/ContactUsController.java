package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.*;
import com.chc.tanda.concepthubclassessbackend.model.ContactUs;
import com.chc.tanda.concepthubclassessbackend.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 15, 2020
 */
@RestController
public class ContactUsController {

    @Autowired
    ContactService contactService;


    @PostMapping(value = "/contactusMessage/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity saveContactUsMsg(@RequestBody ContactRequest contactRequest) {

        ContactResponse contactResponse = contactService.saveContactUsMessage(contactRequest);
        return ResponseEntity.ok(contactResponse);
    }

    @GetMapping(value = "/contactusMessages")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getAllContactMsgs() {
        List<ContactResponse> contactResponses = contactService.getAllContactUsMessage();
        return ResponseEntity.ok(contactResponses);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/contactusMessage/delete/{id}")
    public ResponseEntity<ContactResponse> retire(@PathVariable("id") Integer id) {

        ContactResponse contactResponse = contactService.retire(id);
        return ResponseEntity.ok().body(contactResponse);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getOne/contactusMessage/{email}")
    public ResponseEntity<ContactResponse> retire(@PathVariable("email") String email) {

        ContactResponse contactResponse = contactService.getOneContact(email);
        return ResponseEntity.ok().body(contactResponse);
    }


}
