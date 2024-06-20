package com.company.project.core;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private Result<String> resultUnderTest;

    @Before
    public void setUp() throws Exception {
        resultUnderTest = new Result<>();
    }

    @Test
    public void testSetCode() {
        // Setup
        // Run the test
        final Result result = resultUnderTest.setCode(ResultCode.SUCCESS);

        // Verify the results
    }

    @Test
    public void testGetCode() {
        assertThat(resultUnderTest.getCode()).isEqualTo(0);
    }

    @Test
    public void testMessageGetterAndSetter() {
        final String message = "message";
        resultUnderTest.setMessage(message);
        assertThat(resultUnderTest.getMessage()).isEqualTo(message);
    }

    @Test
    public void testDataGetterAndSetter() {
        final String data = "data";
        resultUnderTest.setData(data);
        assertThat(resultUnderTest.getData()).isEqualTo(data);
    }

    @Test
    public void testStatusGetterAndSetter() {
        final Boolean status = false;
        resultUnderTest.setStatus(status);
        assertThat(resultUnderTest.getStatus()).isFalse();
    }

    @Test
    public void testToString() {
        assertThat(resultUnderTest.toString()).isEqualTo("result");
    }
}
