package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.LatestUpdateRequest;
import com.chc.tanda.concepthubclassessbackend.dto.LatestUpdateResponse;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Jun 12, 2020
 */
public interface LatestUpdateService {

    LatestUpdateResponse saveLatestUpdate(LatestUpdateRequest latestUpdateRequest);

    List<LatestUpdateResponse> getAllLatestUpdates();

    LatestUpdateResponse retireLatestUpdate(Integer id);
}
