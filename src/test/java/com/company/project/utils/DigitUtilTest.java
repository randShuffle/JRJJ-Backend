package com.company.project.utils;

import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class DigitUtilTest {

    @Test
    public void testGeneratorLongId() {
        assertThat(DigitUtil.generatorLongId()).isEqualTo(0L);
    }

    @Test
    public void testParseToInt1() {
        assertThat(DigitUtil.parseToInt("str")).isEqualTo(0);
    }

    @Test
    public void testParseToInt2() {
        assertThat(DigitUtil.parseToInt("str", 0)).isEqualTo(0);
    }

    @Test
    public void testParseToLong1() {
        assertThat(DigitUtil.parseToLong("str")).isEqualTo(0L);
    }

    @Test
    public void testParseToLong2() {
        assertThat(DigitUtil.parseToLong("str", 0L)).isEqualTo(0L);
    }

    @Test
    public void testParseToFloat1() {
        assertThat(DigitUtil.parseToFloat("str")).isEqualTo(0.0f, within(0.0001f));
    }

    @Test
    public void testParseToFloat2() {
        assertThat(DigitUtil.parseToFloat("str", 0.0f)).isEqualTo(0.0f, within(0.0001f));
    }

    @Test
    public void testParseToDouble1() {
        assertThat(DigitUtil.parseToDouble("str")).isEqualTo(0.0, within(0.0001));
    }

    @Test
    public void testParseToDouble2() {
        assertThat(DigitUtil.parseToDouble("str", 0.0)).isEqualTo(0.0, within(0.0001));
    }

    @Test
    public void testAdd1() {
        assertThat(DigitUtil.add(0.0, 0.0)).isEqualTo(0.0, within(0.0001));
    }

    @Test
    public void testAdd2() {
        assertThat(DigitUtil.add(0.0, 0.0, 0)).isEqualTo(0.0, within(0.0001));
    }

    @Test
    public void testSub() {
        assertThat(DigitUtil.sub(0.0, 0.0)).isEqualTo(0.0, within(0.0001));
    }

    @Test
    public void testMul1() {
        assertThat(DigitUtil.mul(0.0, 0.0)).isEqualTo(0.0, within(0.0001));
    }

    @Test
    public void testMul2() {
        assertThat(DigitUtil.mul(0.0f, 0.0f, 0)).isEqualTo(0.0f, within(0.0001f));
    }

    @Test
    public void testMul3() {
        assertThat(DigitUtil.mul(0.0, 0.0, 0)).isEqualTo(0.0, within(0.0001));
    }

    @Test
    public void testDiv1() {
        assertThat(DigitUtil.div(0.0, 0.0)).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void testDiv2() {
        assertThat(DigitUtil.div(0.0, 0.0, 0)).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void testDivDouble() {
        assertThat(DigitUtil.divDouble(0.0, 0.0, 0)).isEqualTo(0.0, within(0.0001));
    }

    @Test
    public void testRound1() {
        assertThat(DigitUtil.round(0.0, 0)).isEqualTo(0.0, within(0.0001));
    }

    @Test
    public void testRound2() {
        assertThat(DigitUtil.round(0.0f, 0)).isEqualTo(0.0f, within(0.0001f));
    }

    @Test
    public void testGenRandomNum() {
        assertThat(DigitUtil.genRandomNum()).isEqualTo("result");
    }

    @Test
    public void testMain() {
        // Setup
        // Run the test
        DigitUtil.main(new String[]{"args"});

        // Verify the results
    }
}
