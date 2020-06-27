package com.chc.tanda.concepthubclassessbackend.dto;

import com.chc.tanda.concepthubclassessbackend.model.AchievementScore;
import com.chc.tanda.concepthubclassessbackend.model.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AchievementResponse {

    private Integer id;
    private String achievementYearHeading;
    private List<AchievementScoreResponse> achievementScores;
    private FileResponse achievementImage;
}
