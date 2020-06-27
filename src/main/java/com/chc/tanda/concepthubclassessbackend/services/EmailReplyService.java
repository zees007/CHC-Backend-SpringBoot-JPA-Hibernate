package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.ContactRequest;
import com.chc.tanda.concepthubclassessbackend.dto.ContactResponse;
import com.chc.tanda.concepthubclassessbackend.model.EmailReply;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 17, 2020
 */
public interface EmailReplyService {

    // for sending Email which is not used in CHC project. Just for learning JavaMail topic
    EmailReply sendEmail(EmailReply emailReply);
}
