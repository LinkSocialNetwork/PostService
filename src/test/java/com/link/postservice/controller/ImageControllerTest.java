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
        byte[] testContent = new byte[2];
        MockMultipartFile testFile = new MockMultipartFile("originalFileName", testContent);
        String keyName = testFile.getOriginalFilename();

        Mockito.doNothing().when(s3Service).uploadFile(keyName, testFile);

        CustomResponseMessage actualReturn = imageController.uploadImg(testFile);

        Mockito.verify(s3Service).uploadFile(keyName, testFile);

        assertEquals(new CustomResponseMessage(keyName), actualReturn);

    }
}