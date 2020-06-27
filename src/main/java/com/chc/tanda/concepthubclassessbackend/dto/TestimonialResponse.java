package com.chc.tanda.concepthubclassessbackend.dto;

import com.chc.tanda.concepthubclassessbackend.model.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


public class TestimonialResponse {

    private Integer id;

    private String studentName;

    private String studentCurrentStatus;

    private String studentFeedback;

    private String studentBatch;

    private FileResponse studentImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCurrentStatus() {
        return studentCurrentStatus;
    }

    public void setStudentCurrentStatus(String studentCurrentStatus) {
        this.studentCurrentStatus = studentCurrentStatus;
    }

    public String getStudentFeedback() {
        return studentFeedback;
    }

    public void setStudentFeedback(String studentFeedback) {
        this.studentFeedback = studentFeedback;
    }

    public String getStudentBatch() {
        return studentBatch;
    }

    public void setStudentBatch(String studentBatch) {
        this.studentBatch = studentBatch;
    }

    public FileResponse getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(FileResponse studentImage) {
        this.studentImage = studentImage;
    }
}
