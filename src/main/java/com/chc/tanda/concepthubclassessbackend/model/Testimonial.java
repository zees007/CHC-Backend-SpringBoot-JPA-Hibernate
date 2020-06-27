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
@Table(name = "TESTIMONIAL")
public class Testimonial extends DataModelEntity{

    @Column(name = "STUDENT_NAME")
    private String studentName;
    @Column(name = "STUDENT_STATUS")
    private String studentCurrentStatus;
    @Column(name = "STUDENT_FEEDBACK")
    private String studentFeedback;
    @Column(name = "STUDENT_BATCH")
    private String studentBatch;
    @OneToOne
    private File studentImage;
}
