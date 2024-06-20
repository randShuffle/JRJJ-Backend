package com.company.project.common;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBeanTest {

    private BaseBean baseBeanUnderTest;

    @Before
    public void setUp() {
        baseBeanUnderTest = new BaseBean();
    }

    @Test
    public void testEquals() {
        assertThat(baseBeanUnderTest.equals("obj")).isFalse();
    }

    @Test
    public void testHashCode() {
        assertThat(baseBeanUnderTest.hashCode()).isEqualTo(0);
    }

    @Test
    public void testToString() {
        assertThat(baseBeanUnderTest.toString()).isEqualTo("result");
    }
}
