package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.*;
import com.chc.tanda.concepthubclassessbackend.model.Achievement;
import com.chc.tanda.concepthubclassessbackend.model.AchievementScore;
import com.chc.tanda.concepthubclassessbackend.model.Faculty;
import com.chc.tanda.concepthubclassessbackend.repositories.AchievementScoreRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */

@Service
public class AchievementScoreServiceImpl implements AchievementScoreService {

    @Autowired
    AchievementScoreRepository achievementScoreRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public AchievementScoreResponse saveAchievementScore(AchievementScoreRequest achievementScoreRequest) {
        if (achievementScoreRequest.getAchievementPara() == null) {
            throw new RuntimeException("Parameter getFacultyName not found in request");
        }
        AchievementScore savedAchievementScore = null;
        if (achievementScoreRequest.getId() != null) {
            AchievementScore oldAchievementScore = achievementScoreRepository.findAllValid(achievementScoreRequest.getId());
            if (oldAchievementScore != null) {
                oldAchievementScore.setAchievementPara(achievementScoreRequest.getAchievementPara());
                savedAchievementScore = achievementScoreRepository.save(oldAchievementScore);
                achievementScoreRepository.refresh(oldAchievementScore);
            } else {
                throw new RuntimeException("Cannot find AchievementScore with identifier: " + achievementScoreRequest.getId());
            }

        } else {
            AchievementScore achievementScore = modelMapper.map(achievementScoreRequest, AchievementScore.class);
            savedAchievementScore = achievementScoreRepository.save(achievementScore);
            achievementScoreRepository.refresh(achievementScore);


        }
        AchievementScoreResponse achievementScoreResponse = modelMapper.map(savedAchievementScore, AchievementScoreResponse.class);
        return achievementScoreResponse;
    }

    @Override
    public List<AchievementScoreResponse> getAllAchievementScore() {
        List<AchievementScore> achievementScores = (List<AchievementScore>) achievementScoreRepository.findByValidSortedCreated();
        Type listOfAchievementScoreRes = new TypeToken<List<AchievementScoreResponse>>() {
        }.getType();
        List<AchievementScoreResponse> achievementScoreResponses = modelMapper.map(achievementScores, listOfAchievementScoreRes);
        return achievementScoreResponses;
    }

    @Override
    public AchievementScoreResponse retire(Integer id) {
        AchievementScore achievementScore = achievementScoreRepository.findAllValid(id);
        achievementScore.setRetired(true);
        achievementScore.setRetiredDate(new Date());
        achievementScoreRepository.save(achievementScore);
        AchievementScoreResponse achievementScoreResponse = modelMapper.map(achievementScore, AchievementScoreResponse.class);
        return achievementScoreResponse;
    }
}
