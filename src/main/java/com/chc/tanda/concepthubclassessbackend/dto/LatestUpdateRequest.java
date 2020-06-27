package com.chc.tanda.concepthubclassessbackend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 12, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LatestUpdateRequest {

    private Integer id;

    private String heading;

    private String subHeading;

    private String latestNote;
}
