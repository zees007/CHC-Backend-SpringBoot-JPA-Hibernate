package com.chc.tanda.concepthubclassessbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 17, 2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailReply {

    private String email;
    private  String subject;
    private String message;

}
