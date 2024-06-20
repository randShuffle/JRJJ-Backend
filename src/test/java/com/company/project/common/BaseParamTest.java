package com.company.project.common;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseParamTest {

    private BaseParam baseParamUnderTest;

    @Before
    public void setUp() {
        baseParamUnderTest = new BaseParam();
    }

    @Test
    public void testEquals() {
        assertThat(baseParamUnderTest.equals("obj")).isFalse();
    }

    @Test
    public void testHashCode() {
        assertThat(baseParamUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    public void testToString() {
        assertThat(baseParamUnderTest.toString()).isEqualTo("result");
    }
}
