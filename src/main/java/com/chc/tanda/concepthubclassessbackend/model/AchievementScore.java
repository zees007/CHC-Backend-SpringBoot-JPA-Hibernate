package com.chc.tanda.concepthubclassessbackend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ACHIEVEMENT_SCORE")
public class AchievementScore extends DataModelEntity {

    private String achievementPara;
}
