package com.chc.tanda.concepthubclassessbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 21, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TutorialResponse {

    private Integer id;
    private String videoTitle;
    private String videoIdUrl;
}
