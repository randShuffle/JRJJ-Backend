package com.company.project.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {

    @Test
    public void testCreateRandom1() {
        assertThat(RandomUtil.createRandom(0)).isEqualTo(0);
    }

    @Test
    public void testCreateRandom2() {
        assertThat(RandomUtil.createRandom(false, 0)).isEqualTo("");
    }
}
