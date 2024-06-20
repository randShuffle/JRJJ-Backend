package com.company.project.utils;

import org.apache.commons.io.input.BrokenInputStream;
import org.apache.commons.io.input.NullInputStream;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {

    @Test
    public void testGetRandomString() {
        assertThat(StringUtil.getRandomString(0)).isEqualTo("result");
    }

    @Test
    public void testLineToHump() {
        assertThat(StringUtil.lineToHump("str")).isEqualTo("str");
    }

    @Test
    public void testHumpToLine() {
        assertThat(StringUtil.humpToLine("str")).isEqualTo("result");
    }

    @Test
    public void testHumpToLine2() {
        assertThat(StringUtil.humpToLine2("str")).isEqualTo("result");
    }

    @Test
    public void testToLowerCaseFirstOne() {
        assertThat(StringUtil.toLowerCaseFirstOne("s")).isEqualTo("s");
    }

    @Test
    public void testToUpperCaseFirstOne() {
        assertThat(StringUtil.toUpperCaseFirstOne("s")).isEqualTo("s");
    }

    @Test
    public void testGetString1() {
        assertThat(StringUtil.getString("object")).isEqualTo("result");
    }

    @Test
    public void testGetString2() {
        assertThat(StringUtil.getString("defaultValue", "defaultValue")).isEqualTo("defaultValue");
    }

    @Test
    public void testGetInt1() {
        assertThat(StringUtil.getInt("object")).isEqualTo(0);
    }

    @Test
    public void testGetInt2() {
        assertThat(StringUtil.getInt("object", 0)).isEqualTo(0);
    }

    @Test
    public void testGetBoolean1() {
        assertThat(StringUtil.getBoolean("object")).isFalse();
    }

    @Test
    public void testGetBoolean2() {
        assertThat(StringUtil.getBoolean("object", false)).isFalse();
    }

    @Test
    public void testEncoderPassword() {
        assertThat(StringUtil.encoderPassword("password")).isEqualTo("result");
    }

    @Test
    public void testGetMD5Digest32() {
        assertThat(StringUtil.getMD5Digest32("str")).isEqualTo("result");
    }

    @Test
    public void testGetEndDigit() {
        assertThat(StringUtil.getEndDigit("str")).isEqualTo("");
    }

    @Test
    public void testTrimMark() {
        assertThat(StringUtil.trimMark("str")).isEqualTo("result");
    }

    @Test
    public void testGetFormatterDate1() {
        assertThat(StringUtil.getFormatterDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                "formatter")).isEqualTo("result");
    }

    @Test
    public void testIsAjax() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();

        // Run the test
        final boolean result = StringUtil.isAjax(request);

        // Verify the results
        assertThat(result).isFalse();
    }

    @Test
    public void testGetStringFromInputStream() {
        // Setup
        final InputStream inputStream = new ByteArrayInputStream("content".getBytes());

        // Run the test
        final String result = StringUtil.getStringFromInputStream(inputStream);

        // Verify the results
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testGetStringFromInputStream_EmptyInputStream() {
        // Setup
        final InputStream inputStream = new NullInputStream(0L);

        // Run the test
        final String result = StringUtil.getStringFromInputStream(inputStream);

        // Verify the results
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testGetStringFromInputStream_BrokenInputStream() {
        // Setup
        final InputStream inputStream = new BrokenInputStream();

        // Run the test
        final String result = StringUtil.getStringFromInputStream(inputStream);

        // Verify the results
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testGetFormatterDate2() {
        assertThat(StringUtil.getFormatterDate("date", "formatter", 0)).isEqualTo("result");
    }

    @Test
    public void testGetBeforeDate() {
        assertThat(StringUtil.getBeforeDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), 0))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetBeforeDaysDate() {
        assertThat(
                StringUtil.getBeforeDaysDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), 0))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGenerateSn() {
        assertThat(StringUtil.generateSn()).isEqualTo("result");
    }

    @Test
    public void testGetMac() {
        assertThat(StringUtil.getMac()).isEqualTo("result");
    }

    @Test
    public void testReadFileToString() {
        // Setup
        final File file = new File("filename.txt");

        // Run the test
        final String result = StringUtil.readFileToString(file);

        // Verify the results
        assertThat(result).isEqualTo("");
    }

    @Test
    public void testHandleFile() {
        // Setup
        final File file = new File("filename.txt");

        // Run the test
        StringUtil.handleFile(file);

        // Verify the results
    }
}
