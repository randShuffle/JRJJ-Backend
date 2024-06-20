package com.company.project.service.impl;

import com.company.project.core.Result;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class FileServiceImplTest {

    private FileServiceImpl fileServiceImplUnderTest;

    @Before
    public void setUp() throws Exception {
        fileServiceImplUnderTest = new FileServiceImpl();
    }

    @Test
    public void testUploadFile() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();
        final MultipartFile file = new MockMultipartFile("name", "content".getBytes());

        // Run the test
        final Result result = fileServiceImplUnderTest.uploadFile(request, file);

        // Verify the results
    }

    @Test
    public void testUploadSinglePhoto() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();
        final MultipartFile file = new MockMultipartFile("name", "content".getBytes());

        // Run the test
        final Result result = fileServiceImplUnderTest.uploadSinglePhoto(request, file);

        // Verify the results
    }

    @Test
    public void testUploadSingleName() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();
        final MultipartFile file = new MockMultipartFile("name", "content".getBytes());

        // Run the test
        final Result result = fileServiceImplUnderTest.uploadSingleName(request, file);

        // Verify the results
    }

    @Test
    public void testUploadSingle() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();
        final MultipartFile file = new MockMultipartFile("name", "content".getBytes());

        // Run the test
        final Result result = fileServiceImplUnderTest.uploadSingle(request, file);

        // Verify the results
    }

    @Test
    public void testGetVideoDuration() {
        // Setup
        // Run the test
        final Result result = fileServiceImplUnderTest.getVideoDuration("fileUrl");

        // Verify the results
    }
}
