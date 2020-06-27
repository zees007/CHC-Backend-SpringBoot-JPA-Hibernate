package com.chc.tanda.concepthubclassessbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 15, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ContactResponse {

    private Integer id;
    private String name;
    private String email;
    private  String subject;
    private String message;

}
