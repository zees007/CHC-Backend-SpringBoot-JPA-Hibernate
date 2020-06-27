package com.chc.tanda.concepthubclassessbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "STUDENT_REGISTRATION_DB")
public class StudentRegistration extends DataModelEntity {

    @Column(name = "SERIAL")
    private String serial;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FULLNAME")
    private String fullname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CONTACT")
    private String contact;
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Address address;
    @CreationTimestamp
    @Column(name = "REGISTRATION_TIME")
    private Timestamp registerTime;
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "role")
//    private Role role;
}
