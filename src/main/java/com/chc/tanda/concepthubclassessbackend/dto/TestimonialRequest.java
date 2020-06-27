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
public class TestimonialRequest {

    private Integer id;

    private String studentName;

    private String studentCurrentStatus;

    private String studentFeedback;

    private String studentBatch;

    private File studentImage;
}
