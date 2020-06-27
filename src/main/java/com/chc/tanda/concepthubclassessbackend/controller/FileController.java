package com.chc.tanda.concepthubclassessbackend.controller;

import com.chc.tanda.concepthubclassessbackend.dto.FileResponse;
import com.chc.tanda.concepthubclassessbackend.dto.GallaryResponse;
import com.chc.tanda.concepthubclassessbackend.model.File;
import com.chc.tanda.concepthubclassessbackend.services.FileService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    FileService fileService;

    ModelMapper modelMapper = new ModelMapper();


    @PostMapping("/upload")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {

        FileResponse fileResponse = fileService.storeFileAndGetDBObject(file);


        return ResponseEntity.ok(fileResponse);

    }

    @GetMapping("/download/{fileID}/{fileName:.+}")
    public ResponseEntity downloadFile(@PathVariable Integer fileID, @PathVariable String fileName, HttpServletRequest request) throws MalformedURLException {

        File fileObject = fileService.loadFile(fileID, fileName);
        Path filePath = Paths.get(fileObject.getPath()).normalize();
        Resource resource = new UrlResource(filePath.toUri());
        if (!resource.exists()) {
            throw new RuntimeException("File not found " + fileName);
        }

        String contentType = fileObject.getType();
        if (contentType == null) {
            contentType = "application/octet-stream";
        }
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName= \" "+ resource.getFilename()+"\"")
//                .body(resource);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<FileResponse> retire(@PathVariable("id") Integer id) {

        FileResponse fileResponse = fileService.retireFileUpload(id);
        return ResponseEntity.ok().body(fileResponse);
    }
}
