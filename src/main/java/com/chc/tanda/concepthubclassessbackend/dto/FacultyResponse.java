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
public class FacultyResponse {


    private Integer id;

    private String facultyName;

    private String facultyEducation;

    private String facultySubject;

    private FileResponse facultyImage;
}
