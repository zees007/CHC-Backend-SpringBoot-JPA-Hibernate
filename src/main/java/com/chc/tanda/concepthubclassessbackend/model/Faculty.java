package com.chc.tanda.concepthubclassessbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "FACULTY")
public class Faculty extends DataModelEntity {

    @Column(name = "FACULTY_NAME")
    private String facultyName;
    @Column(name = "FACULTY_EDUCATION")
    private String facultyEducation;
    @Column(name = "FACULTY_SUBJECT")
    private String facultySubject;
    @OneToOne
    private File FacultyImage;
}
