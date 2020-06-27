package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.TutorialRequest;
import com.chc.tanda.concepthubclassessbackend.dto.TutorialResponse;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 21, 2020
 */
public interface TutorialService {

    TutorialResponse saveTutorial(TutorialRequest tutorialRequest);

    List<TutorialResponse> getAllTutorials();

    TutorialResponse retire(Integer id);
}
