package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.AchievementRequest;
import com.chc.tanda.concepthubclassessbackend.dto.AchievementResponse;
import com.chc.tanda.concepthubclassessbackend.dto.FacultyResponse;
import com.chc.tanda.concepthubclassessbackend.model.Achievement;
import com.chc.tanda.concepthubclassessbackend.model.Faculty;
import com.chc.tanda.concepthubclassessbackend.repositories.AchievementRepository;
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
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    AchievementRepository achievementRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public AchievementResponse saveAchievement(AchievementRequest achievementRequest) {
        if (achievementRequest.getAchievementYearHeading() == null) {
            throw new RuntimeException("Parameter getAchievementYearHeading not found in request");
        } else if (achievementRequest.getAchievementScores() == null) {
            throw new RuntimeException("Parameter getAchievementPara not found in request");
        }
        Achievement savedAchievement = null;
        if (achievementRequest.getId() != null) {
            Achievement oldAchievement= achievementRepository.findAllValid(achievementRequest.getId());
            if (oldAchievement != null) {
                oldAchievement.setAchievementYearHeading(achievementRequest.getAchievementYearHeading());
                oldAchievement.setAchievementScores(achievementRequest.getAchievementScores());
                oldAchievement.setAchievementImage(achievementRequest.getAchievementImage());
                savedAchievement = achievementRepository.save(oldAchievement);
                achievementRepository.refresh(oldAchievement);
            } else {
                throw new RuntimeException("Cannot find Achievement with identifier: " + achievementRequest.getId());
            }

        } else {
            Achievement achievement = modelMapper.map(achievementRequest, Achievement.class);
            savedAchievement = achievementRepository.save(achievement);
            achievementRepository.refresh(achievement);


        }
        AchievementResponse achievementResponse = modelMapper.map(savedAchievement, AchievementResponse.class);
        return achievementResponse;
    }

    @Override
    public List<AchievementResponse> getAllAchievement() {
        List<Achievement> achievements = (List<Achievement>) achievementRepository.findByValidSortedCreated();
        Type listOfachievementRes = new TypeToken<List<AchievementResponse>>() {
        }.getType();
        List<AchievementResponse> achievementResponses = modelMapper.map(achievements, listOfachievementRes);
        return achievementResponses;
    }

    @Override
    public AchievementResponse retire(Integer id) {
        Achievement achievement = achievementRepository.findAllValid(id);
        achievement.setRetired(true);
        achievement.setRetiredDate(new Date());
        achievementRepository.save(achievement);
        AchievementResponse achievementResponse = modelMapper.map(achievement, AchievementResponse.class);
        return achievementResponse;
    }
}
