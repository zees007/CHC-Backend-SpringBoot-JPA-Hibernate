package com.chc.tanda.concepthubclassessbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 15, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "CONTACT_US_MESSAGE")
public class ContactUs extends DataModelEntity {

    private String name;
    private String email;
    private  String subject;
    private String message;

}
