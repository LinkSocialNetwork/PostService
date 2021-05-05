package com.link.postservice.controller;

import com.link.postservice.model.CustomResponseMessage;
import com.link.postservice.service.S3Service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ImageControllerTest {

    ImageController imageController;

    @Mock
    S3Service s3Service;

    @BeforeEach
    void setUp() {
        imageController = new ImageController(s3Service);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void uploadImg() throws IOException {

        /*Assign*/
        MockMultipartFile testFile = new MockMultipartFile("originalFileName", new byte[10]);
        String keyName = testFile.getOriginalFilename();
        String bucketUrl = "https://linksocialnetworkbucket.s3.us-east-2.amazonaws.com/";
        CustomResponseMessage expectedResponse = new CustomResponseMessage(bucketUrl+keyName);

        /*Act*/
        CustomResponseMessage actualResponse = this.imageController.uploadImg(testFile);

        /*Assert*/
        assertEquals(expectedResponse,actualResponse);
        Mockito.verify(s3Service).uploadFile(keyName, testFile);

    }
}