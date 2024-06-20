package com.company.project.core;

import org.junit.Test;

public class ResultGeneratorTest {

    @Test
    public void testGenSuccessResult1() {
        // Setup
        // Run the test
        final Result result = ResultGenerator.genSuccessResult();

        // Verify the results
    }

    @Test
    public void testGenSuccessResult2() {
        // Setup
        // Run the test
        final Result<String> result = ResultGenerator.genSuccessResult("data");

        // Verify the results
    }

    @Test
    public void testGenFailResult1() {
        // Setup
        // Run the test
        final Result result = ResultGenerator.genFailResult("message");

        // Verify the results
    }

    @Test
    public void testGenFailResult2() {
        // Setup
        // Run the test
        final Result result = ResultGenerator.genFailResult(ResultCode.SUCCESS, "message");

        // Verify the results
    }
}
