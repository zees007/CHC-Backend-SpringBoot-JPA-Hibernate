package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.FileResponse;
import com.chc.tanda.concepthubclassessbackend.model.File;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    FileResponse storeFileAndGetDBObject(MultipartFile file);

    File loadFile(Integer fileID, String fileName);

    FileResponse retireFileUpload(Integer id);
}
