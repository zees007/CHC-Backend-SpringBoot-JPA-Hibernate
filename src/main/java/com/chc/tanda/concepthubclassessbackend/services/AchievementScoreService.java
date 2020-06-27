package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.AchievementRequest;
import com.chc.tanda.concepthubclassessbackend.dto.AchievementResponse;
import com.chc.tanda.concepthubclassessbackend.dto.AchievementScoreRequest;
import com.chc.tanda.concepthubclassessbackend.dto.AchievementScoreResponse;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */
public interface AchievementScoreService {

    AchievementScoreResponse saveAchievementScore(AchievementScoreRequest achievementScoreRequest);

    List<AchievementScoreResponse> getAllAchievementScore();

    AchievementScoreResponse retire(Integer id);


}
