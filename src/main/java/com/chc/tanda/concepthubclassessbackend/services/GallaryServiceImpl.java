package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.FacultyResponse;
import com.chc.tanda.concepthubclassessbackend.dto.GallaryRequest;
import com.chc.tanda.concepthubclassessbackend.dto.GallaryResponse;
import com.chc.tanda.concepthubclassessbackend.model.Faculty;
import com.chc.tanda.concepthubclassessbackend.model.Gallary;
import com.chc.tanda.concepthubclassessbackend.repositories.GallaryRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

@Service
public class GallaryServiceImpl implements GallaryService {

    @Autowired
    GallaryRepository gallaryRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public GallaryResponse saveGallary(GallaryRequest gallaryRequest) {
        if (gallaryRequest.getEventTitle() == null) {
            throw new RuntimeException("Parameter getEventTitle not found in request");
        } else if (gallaryRequest.getImage() == null) {
            throw new RuntimeException("Parameter getImage not found in request");
        }
        Gallary savedGallary = null;
        if (gallaryRequest.getId() != null) {
            Gallary oldGallary= gallaryRepository.findAllValid(gallaryRequest.getId());
            if (oldGallary != null) {
                // oldGallary.setId(gallaryRequest.getId());
                oldGallary.setEventTitle(gallaryRequest.getEventTitle());
                oldGallary.setImage(gallaryRequest.getImage());
                savedGallary = gallaryRepository.save(oldGallary);
                gallaryRepository.refresh(oldGallary);
            } else {
                throw new RuntimeException("Cannot find Gallary with identifier: " + gallaryRequest.getId());
            }

        } else {
            Gallary gallary = modelMapper.map(gallaryRequest, Gallary.class);
            savedGallary = gallaryRepository.save(gallary);
            gallaryRepository.refresh(gallary);


        }
        GallaryResponse gallaryResponse = modelMapper.map(savedGallary, GallaryResponse.class);
        return gallaryResponse;
    }

    @Override
    public List<GallaryResponse> getAllGallary() {
        List<Gallary> gallaries = (List<Gallary>) gallaryRepository.findByValidSortedCreated();
        Type listOfGallaryRes = new TypeToken<List<GallaryResponse>>() {
        }.getType();
        List<GallaryResponse> gallaryResponses = modelMapper.map(gallaries, listOfGallaryRes);
        return gallaryResponses;
    }

    @Override
    public GallaryResponse retire(Integer id) {
        Gallary gallary = gallaryRepository.findAllValid(id);
        gallary.setRetired(true);
        gallary.setRetiredDate(new Date());
        gallaryRepository.save(gallary);
        GallaryResponse gallaryResponse = modelMapper.map(gallary, GallaryResponse.class);
        return gallaryResponse;
    }
}
