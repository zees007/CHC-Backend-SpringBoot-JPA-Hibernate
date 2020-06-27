package com.chc.tanda.concepthubclassessbackend.dto;

import com.chc.tanda.concepthubclassessbackend.model.AchievementScore;
import com.chc.tanda.concepthubclassessbackend.model.File;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AchievementRequest {

    private Integer id;
    private String achievementYearHeading;
    private List<AchievementScore> achievementScores;
    private File achievementImage;
}
