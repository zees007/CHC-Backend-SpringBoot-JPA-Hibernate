package com.chc.tanda.concepthubclassessbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ACHIEVEMENT")
public class Achievement extends DataModelEntity {

    @Column(name = "ACHIEVEMENT_YEAR_HEADING")
    private String achievementYearHeading;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AchievementScore> achievementScores;
    @OneToOne
    private File achievementImage;

}
