package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.AchievementRequest;
import com.chc.tanda.concepthubclassessbackend.dto.AchievementResponse;


import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */
public interface AchievementService {

    AchievementResponse saveAchievement(AchievementRequest achievementRequest);

    List<AchievementResponse> getAllAchievement();

    AchievementResponse retire(Integer id);
}
