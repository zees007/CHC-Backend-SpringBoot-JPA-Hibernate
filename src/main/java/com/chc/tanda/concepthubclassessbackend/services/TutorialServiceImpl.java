package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.LatestUpdateResponse;
import com.chc.tanda.concepthubclassessbackend.dto.TestimonialResponse;
import com.chc.tanda.concepthubclassessbackend.dto.TutorialRequest;
import com.chc.tanda.concepthubclassessbackend.dto.TutorialResponse;
import com.chc.tanda.concepthubclassessbackend.model.LatestUpdate;
import com.chc.tanda.concepthubclassessbackend.model.Testimonial;
import com.chc.tanda.concepthubclassessbackend.model.Tutorials;
import com.chc.tanda.concepthubclassessbackend.repositories.TutorialRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 21, 2020
 */

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    TutorialRepository tutorialRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public TutorialResponse saveTutorial(TutorialRequest tutorialRequest) {
        if (tutorialRequest.getVideoTitle() == null) {
            throw new RuntimeException("Parameter getVideoTitle not found in request");
        } else if (tutorialRequest.getVideoIdUrl() == null) {
            throw new RuntimeException("Parameter getVideoIdUrl not found in request");
        }
        Tutorials savedTutorials = null;
        if (tutorialRequest.getId() != null) {
            Tutorials oldTutorials= tutorialRepository.findAllValid(tutorialRequest.getId());
            if (oldTutorials != null) {
                oldTutorials.setId(tutorialRequest.getId());
                oldTutorials.setVideoTitle(tutorialRequest.getVideoTitle());
                oldTutorials.setVideoIdUrl(tutorialRequest.getVideoTitle());

                savedTutorials = tutorialRepository.save(oldTutorials);
                tutorialRepository.refresh(oldTutorials);
            } else {
                throw new RuntimeException("Cannot find tutorial with identifier: " + tutorialRequest.getId());
            }

        } else {
            Tutorials tutorials = modelMapper.map(tutorialRequest, Tutorials.class);
            savedTutorials = tutorialRepository.save(tutorials);
            tutorialRepository.refresh(tutorials);


        }
        TutorialResponse tutorialResponse = modelMapper.map(savedTutorials, TutorialResponse.class);
        return tutorialResponse;
    }

    @Override
    public List<TutorialResponse> getAllTutorials() {
        List<Tutorials> tutorials = (List<Tutorials>) tutorialRepository.findByValidSortedCreated();
        Type listOfTutorialsRes = new TypeToken<List<TutorialResponse>>() {
        }.getType();
        List<TutorialResponse> tutorialResponses = modelMapper.map(tutorials, listOfTutorialsRes);
        return tutorialResponses;
    }

    @Override
    public TutorialResponse retire(Integer id) {
        Tutorials tutorials = tutorialRepository.findValidById(id);
        // file.setRetired(true);
        // file.setRetiredDate(new Date());
        tutorialRepository.delete(tutorials);
        TutorialResponse tutorialResponse = modelMapper.map(tutorials, TutorialResponse.class);
        return tutorialResponse;
    }
}
