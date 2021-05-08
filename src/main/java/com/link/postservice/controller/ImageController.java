package com.link.postservice.controller;

import com.link.postservice.model.CustomResponseMessage;
import com.link.postservice.service.S3Service;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/postservice")
public class ImageController {

    private S3Service s3Service;

    /**
     * Image endpoint that converts and passes an image file to be stored in an s3 bucket.
     * @param file Image file from HTTP request body (form-data).
     * @return String containing the file name that was uploaded.
     */
    @PostMapping("/protected/image")
    public CustomResponseMessage uploadImg(@RequestParam("file") MultipartFile file) {
        String keyName = file.getOriginalFilename();
        String bucketUrl = "https://linksocialnetworkbucket.s3.us-east-2.amazonaws.com/";

        s3Service.uploadFile(keyName, file);
        return new CustomResponseMessage(bucketUrl+keyName);
    }

    @Autowired
    public ImageController(S3Service s3Service) {
        this.s3Service = s3Service;
    }

}
