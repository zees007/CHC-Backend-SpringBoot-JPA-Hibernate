package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.AchievementScoreRequest;
import com.chc.tanda.concepthubclassessbackend.dto.AchievementScoreResponse;
import com.chc.tanda.concepthubclassessbackend.services.AchievementScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */

@RestController
public class AchievementScoreController {

    @Autowired
    AchievementScoreService achievementScoreService;

    @PostMapping(value = "/achievementScore/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity saveAchievementScore(@RequestBody AchievementScoreRequest achievementScoreRequest) {

        AchievementScoreResponse achievementScoreResponse = achievementScoreService.saveAchievementScore(achievementScoreRequest);
        return ResponseEntity.ok(achievementScoreResponse);
    }


    @GetMapping(value = "/achievementScores")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getAllAchievements() {
        List<AchievementScoreResponse> achievementScoreResponses = achievementScoreService.getAllAchievementScore();
        return ResponseEntity.ok(achievementScoreResponses);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/achievementScore/delete/{id}")
    public ResponseEntity<AchievementScoreResponse> retire(@PathVariable("id") Integer id) {

        AchievementScoreResponse achievementScoreResponse = achievementScoreService.retire(id);
        return ResponseEntity.ok().body(achievementScoreResponse);
    }
}
