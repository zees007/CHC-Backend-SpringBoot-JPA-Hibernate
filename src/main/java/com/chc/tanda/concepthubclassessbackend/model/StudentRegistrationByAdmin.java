package com.chc.tanda.concepthubclassessbackend.model;


import com.chc.tanda.concepthubclassessbackend.assistors.CompositeIdClass;
import com.chc.tanda.concepthubclassessbackend.assistors.DatePrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@Entity
@Table(name = "REGISTRATIONS_BY_ADMIN")
public class StudentRegistrationByAdmin{

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serial_seq")
    @GenericGenerator(
            name = "serial_seq",
            strategy = "com.chc.tanda.concepthubclassessbackend.assistors.DatePrefixedSequenceIdGenerator",
            parameters = {

                    @org.hibernate.annotations.Parameter(name = DatePrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1")
            }
    )
    @Column(name = "serial_id", nullable = false, unique = true)
    private String serial;

    @Column(name = "STUDENT_NAME")
    private String studentName;
    @Column(name = "FATHER_NAME")
    private String studentFatherName;
    @Column(name = "DOB")
    private String studentDob;
    @Column(name = "CLASS")
    private String studentClass;
    @Column(name = "SCHOOL")
    private String studentSchoolName;
    @Column(name = "CONTACT")
    private String studentContactNumber;
    @Column(name = "EMAIL")
    private String studentEmail;
    @Column(name = "ADDRESS")
    private String studentAddress;
    @Column(name = "PAID_FEE")
    private String feePaid;
    @Column(name = "BALANCE")
    private String feeBalance;
    @OneToOne
    private File studentImage;
    @ColumnDefault("0")
    @Column(name = "RETIRED")
    private Boolean retired = false;
    @Column(name = "RETIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retiredDate;
    @CreationTimestamp
    @Column(name = "REGISTERED_DATE")
    private Timestamp registeredDate;

    public StudentRegistrationByAdmin() {
    }

//    public StudentRegistrationByAdmin(Integer id, String serial) {
//        this.id = id;
//        this.serial = serial;
//    }
}
