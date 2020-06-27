package com.chc.tanda.concepthubclassessbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 12, 2020
 */

@Entity
@Table(name = "LATEST_UPDATE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LatestUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "HEADING")
    private String heading;
    @Column(name = "SUB_HEADING")
    private String subHeading;
    @Column(name = "LATEST_NOTE")
    private String latestNote;
}
