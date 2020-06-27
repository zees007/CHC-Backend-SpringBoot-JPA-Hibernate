package com.chc.tanda.concepthubclassessbackend.dto;

import com.chc.tanda.concepthubclassessbackend.model.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentRegistrationByAdminRequest {

//    private Integer id;
    private String serial;
    private String studentName;
    private String studentFatherName;
    private String studentDob;
    private String studentClass;
    private String studentSchoolName;
    private String studentContactNumber;
    private String studentEmail;
    private String studentAddress;
    private String feePaid;
    private String feeBalance;
    private File studentImage;
}
