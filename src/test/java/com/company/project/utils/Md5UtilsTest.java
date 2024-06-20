package com.company.project.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Md5UtilsTest {

    @Test
    public void testGetMd5() {
        assertThat(Md5Utils.getMd5("msg")).isEqualTo("msg");
    }

    @Test
    public void testGetToken() {
        assertThat(Md5Utils.getToken("msg")).isEqualTo("msg");
    }

    @Test
    public void testString2MD5() {
        assertThat(Md5Utils.string2MD5("inStr")).isEqualTo("");
    }
}
