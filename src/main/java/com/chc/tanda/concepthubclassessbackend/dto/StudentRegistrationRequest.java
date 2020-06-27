package com.chc.tanda.concepthubclassessbackend.dto;

import com.chc.tanda.concepthubclassessbackend.model.Address;
import com.chc.tanda.concepthubclassessbackend.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentRegistrationRequest {

    private String serial;

    private Integer id;

    private String username;

    private String password;

    private String fullname;

    private String email;

    private String contact;


//    private Role role;
}
