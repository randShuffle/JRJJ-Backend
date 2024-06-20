package com.company.project.utils;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchUrlUtilsTest {

    private MatchUrlUtils matchUrlUtilsUnderTest;

    @Before
    public void setUp() {
        matchUrlUtilsUnderTest = new MatchUrlUtils();
        ReflectionTestUtils.setField(matchUrlUtilsUnderTest, "checkLoginUrl", "checkLoginUrl");
    }

    @Test
    public void testCheckUrls() {
        // Setup
        // Run the test
        final boolean result = matchUrlUtilsUnderTest.checkUrls("url");

        // Verify the results
        assertThat(result).isFalse();
    }
}
