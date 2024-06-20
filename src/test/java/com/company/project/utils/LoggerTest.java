package com.company.project.utils;

import org.junit.Test;

public class LoggerTest {

    @Test
    public void testWarn1() {
        // Setup
        // Run the test
        Logger.warn("obj", "message", new Exception("message"));

        // Verify the results
    }

    @Test
    public void testWarn2() {
        // Setup
        // Run the test
        Logger.warn("obj", "message");

        // Verify the results
    }

    @Test
    public void testError1() {
        // Setup
        // Run the test
        Logger.error("obj", "message");

        // Verify the results
    }

    @Test
    public void testError2() {
        // Setup
        // Run the test
        Logger.error(String.class, "message");

        // Verify the results
    }

    @Test
    public void testError3() {
        // Setup
        // Run the test
        Logger.error("obj", "message", new Exception("message"));

        // Verify the results
    }

    @Test
    public void testInfo1() {
        // Setup
        // Run the test
        Logger.info("obj", "message");

        // Verify the results
    }

    @Test
    public void testInfo2() {
        // Setup
        // Run the test
        Logger.info(String.class, "message");

        // Verify the results
    }

    @Test
    public void testInfoAndTrace1() {
        // Setup
        // Run the test
        Logger.infoAndTrace("obj", "message");

        // Verify the results
    }

    @Test
    public void testInfoAndTrace2() {
        // Setup
        // Run the test
        Logger.infoAndTrace(String.class, "message");

        // Verify the results
    }

    @Test
    public void testDebug1() {
        // Setup
        // Run the test
        Logger.debug("obj", "message");

        // Verify the results
    }

    @Test
    public void testDebug2() {
        // Setup
        // Run the test
        Logger.debug(String.class, "message");

        // Verify the results
    }
}
