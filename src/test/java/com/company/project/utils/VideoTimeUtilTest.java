package com.company.project.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoTimeUtilTest {

    @Test
    public void testParseDuration() {
        assertThat(VideoTimeUtil.parseDuration("fileUrl")).isEqualTo(new String[]{"result"});
        assertThat(VideoTimeUtil.parseDuration("fileUrl")).isEqualTo(new String[]{});
    }

    @Test
    public void testMain() {
        // Setup
        // Run the test
        VideoTimeUtil.main(new String[]{"args"});

        // Verify the results
    }
}
