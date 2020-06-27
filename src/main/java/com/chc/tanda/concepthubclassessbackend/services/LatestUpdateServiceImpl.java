package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.LatestUpdateRequest;
import com.chc.tanda.concepthubclassessbackend.dto.LatestUpdateResponse;
import com.chc.tanda.concepthubclassessbackend.model.LatestUpdate;
import com.chc.tanda.concepthubclassessbackend.repositories.LatestUpdateRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 12, 2020
 */

@Service
public class LatestUpdateServiceImpl implements LatestUpdateService{

    @Autowired
    LatestUpdateRepository latestUpdateRepository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public LatestUpdateResponse saveLatestUpdate(LatestUpdateRequest latestUpdateRequest) {
        if (latestUpdateRequest.getHeading() == null) {
            throw new RuntimeException("Parameter Heading not found in request");
        }
        LatestUpdate savedLatestUpdate = null;
        if (latestUpdateRequest.getId() != null) {
            LatestUpdate oldLatestUpdate= latestUpdateRepository.findAllValid(latestUpdateRequest.getId());
            if (oldLatestUpdate != null) {
                oldLatestUpdate.setId(latestUpdateRequest.getId());
                oldLatestUpdate.setHeading(latestUpdateRequest.getHeading());
                oldLatestUpdate.setSubHeading(latestUpdateRequest.getSubHeading());
                oldLatestUpdate.setLatestNote(latestUpdateRequest.getLatestNote());
                savedLatestUpdate = latestUpdateRepository.save(oldLatestUpdate);
            } else {
                throw new RuntimeException("Cannot find Latest Update with identifier: " + latestUpdateRequest.getId());
            }

        } else {
            LatestUpdate latestUpdate = modelMapper.map(latestUpdateRequest, LatestUpdate.class);
            savedLatestUpdate = latestUpdateRepository.save(latestUpdate);

        }
        LatestUpdateResponse latestUpdateResponse = modelMapper.map(savedLatestUpdate, LatestUpdateResponse.class);
        return latestUpdateResponse;
    }

    @Override
    public List<LatestUpdateResponse> getAllLatestUpdates() {
        List<LatestUpdate> latestUpdates = (List<LatestUpdate>) latestUpdateRepository.findAll();
        Type listOfLatestUpdateRes = new TypeToken<List<LatestUpdateResponse>>() {
        }.getType();
        List<LatestUpdateResponse> latestUpdateResponses = modelMapper.map(latestUpdates, listOfLatestUpdateRes);
        return latestUpdateResponses;
    }


    @Override
    public LatestUpdateResponse retireLatestUpdate(Integer id) {
        LatestUpdate latestUpdate = latestUpdateRepository.findValidById(id);
        // file.setRetired(true);
        // file.setRetiredDate(new Date());
        latestUpdateRepository.delete(latestUpdate);
        LatestUpdateResponse latestUpdateResponse = modelMapper.map(latestUpdate, LatestUpdateResponse.class);
        return latestUpdateResponse;
    }
}
