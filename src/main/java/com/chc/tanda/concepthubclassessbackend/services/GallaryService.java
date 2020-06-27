package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.GallaryRequest;
import com.chc.tanda.concepthubclassessbackend.dto.GallaryResponse;

import java.util.List;

public interface GallaryService {

    GallaryResponse saveGallary(GallaryRequest gallaryRequest);

    List<GallaryResponse> getAllGallary();

    GallaryResponse retire(Integer id);
}
