package com.company.project.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TokenUtilTest {

    @Test
    public void testGetSeed() {
        assertThat(TokenUtil.getSeed("username")).isEqualTo("result");
    }

    @Test
    public void testGetToken() {
        assertThat(TokenUtil.getToken()).isEqualTo("result");
    }

    @Test
    public void testGetNoSplitUniqueId() {
        assertThat(TokenUtil.getNoSplitUniqueId()).isEqualTo("result");
    }

    @Test
    public void testGetUniqueId() {
        assertThat(TokenUtil.getUniqueId()).isEqualTo("4a767435-542b-4262-a9cb-8f6e5b317b59");
    }
}
