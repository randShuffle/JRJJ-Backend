package com.company.project.utils;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MagConfigTest {

    private MagConfig magConfigUnderTest;

    @Before
    public void setUp() {
        magConfigUnderTest = new MagConfig();
        magConfigUnderTest.setExpireTime(0L);
        magConfigUnderTest.setCheckLoginUrl("checkLoginUrl");
        magConfigUnderTest.setFiledir("filedir");
        magConfigUnderTest.setFileBasePath("fileBasePath");
    }

    @Test
    public void testGetFileBasePath() {
        assertThat(magConfigUnderTest.getFileBasePath()).isEqualTo("fileBasePath");
    }

    @Test
    public void testGetFiledir() {
        assertThat(magConfigUnderTest.getFiledir()).isEqualTo("filedir");
    }

    @Test
    public void testGetCheckLoginUrl() {
        assertThat(magConfigUnderTest.getCheckLoginUrl()).isEqualTo("checkLoginUrl");
    }

    @Test
    public void testGetExpireTime() {
        assertThat(magConfigUnderTest.getExpireTime()).isEqualTo(0L);
    }
}
