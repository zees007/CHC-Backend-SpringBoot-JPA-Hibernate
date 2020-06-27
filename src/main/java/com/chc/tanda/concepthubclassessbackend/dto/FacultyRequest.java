package com.chc.tanda.concepthubclassessbackend.dto;

import com.chc.tanda.concepthubclassessbackend.model.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacultyRequest {


    private Integer id;

    private String facultyName;

    private String facultyEducation;

    private String facultySubject;

    private File facultyImage;
}
