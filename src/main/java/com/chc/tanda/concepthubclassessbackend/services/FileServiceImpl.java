package com.chc.tanda.concepthubclassessbackend.services;

import com.chc.tanda.concepthubclassessbackend.dto.FileResponse;
import com.chc.tanda.concepthubclassessbackend.dto.GallaryResponse;
import com.chc.tanda.concepthubclassessbackend.model.File;
import com.chc.tanda.concepthubclassessbackend.model.Gallary;
import com.chc.tanda.concepthubclassessbackend.repositories.FileRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private final Path fileStorageLocation;

    @Autowired
    FileRepository fileRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private FileServiceImpl(FileStorageProperties fileStorageProperties) {

        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public FileResponse storeFileAndGetDBObject(MultipartFile file) {
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileType = file.getContentType();
        String savedFileName = UUID.randomUUID().toString() + "-" + originalFileName;
        try {
            Path targetLocation = this.fileStorageLocation.resolve(savedFileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            File fileObject = new File(originalFileName, fileType, targetLocation.toAbsolutePath().toString());

            fileObject = fileRepository.save(fileObject);
            FileResponse fileResponse = modelMapper.map(fileObject, FileResponse.class);
            return fileResponse;
        } catch (Exception ex) {
            throw new RuntimeException("Could not store file " + originalFileName + ". Please try again!", ex);
        }

    }

    public File loadFile(Integer fileID, String fileName) {
        File fileObject = fileRepository.findValidById(fileID);
        if (fileObject == null) {
            throw new RuntimeException("File Object not found in database " + fileName);
        } else if (!fileObject.getName().equalsIgnoreCase(fileName)) {
            throw new RuntimeException("File name mismatch " + fileName);
        }
        return fileObject;
    }

    @Override
    public FileResponse retireFileUpload(Integer id) {
        File file = fileRepository.findValidById(id);
        // file.setRetired(true);
        // file.setRetiredDate(new Date());
        fileRepository.delete(file);
        FileResponse fileResponse = modelMapper.map(file, FileResponse.class);
        return fileResponse;
    }

}
