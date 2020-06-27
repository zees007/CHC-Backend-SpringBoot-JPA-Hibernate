package com.chc.tanda.concepthubclassessbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 21, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TUTORIALS")
public class Tutorials extends DataModelEntity {

    private String videoTitle;
    private String videoIdUrl;
}
