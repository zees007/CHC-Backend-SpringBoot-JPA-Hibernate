package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.AchievementRequest;
import com.chc.tanda.concepthubclassessbackend.dto.AchievementResponse;
import com.chc.tanda.concepthubclassessbackend.dto.FacultyRequest;
import com.chc.tanda.concepthubclassessbackend.dto.FacultyResponse;
import com.chc.tanda.concepthubclassessbackend.services.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 13, 2020
 */
@RestController
public class AchievementController {

    @Autowired
    AchievementService achievementService;

    @PostMapping(value = "/achievement/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity saveAchievement(@RequestBody AchievementRequest achievementRequest) {

        AchievementResponse achievementResponse = achievementService.saveAchievement(achievementRequest);
        return ResponseEntity.ok(achievementResponse);
    }


    @GetMapping(value = "/achievements")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity getAllAchievements() {
        List<AchievementResponse> achievementResponses = achievementService.getAllAchievement();
        return ResponseEntity.ok(achievementResponses);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/achievement/delete/{id}")
    public ResponseEntity<AchievementResponse> retire(@PathVariable("id") Integer id) {

        AchievementResponse achievementResponse = achievementService.retire(id);
        return ResponseEntity.ok().body(achievementResponse);
    }

}
