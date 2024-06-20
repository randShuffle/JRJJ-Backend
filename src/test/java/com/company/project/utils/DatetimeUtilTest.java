package com.company.project.utils;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class DatetimeUtilTest {

    @Test
    public void testGetLastMonth() {
        assertThat(DatetimeUtil.getLastMonth()).isEqualTo("result");
    }

    @Test
    public void testGetWeek() {
        assertThat(DatetimeUtil.getWeek(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()))
                .isEqualTo("result");
    }

    @Test
    public void testTimeStamp2Date() {
        assertThat(DatetimeUtil.timeStamp2Date("seconds", "format")).isEqualTo("");
    }

    @Test
    public void testStringToDate() {
        assertThat(DatetimeUtil.StringToDate("dat", "format"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testTomorrowSecond() {
        assertThat(DatetimeUtil.tomorrowSecond()).isEqualTo("result");
    }

    @Test
    public void testYesterSecond() {
        assertThat(DatetimeUtil.yesterSecond()).isEqualTo("result");
    }

    @Test
    public void testYesterDay() {
        assertThat(DatetimeUtil.yesterDay()).isEqualTo("result");
    }

    @Test
    public void testTimeStamp() {
        assertThat(DatetimeUtil.timeStamp()).isEqualTo("result");
    }

    @Test
    public void testDateToStamp() {
        assertThat(DatetimeUtil.dateToStamp("s")).isEqualTo("result");
    }

    @Test
    public void testDateTOString() {
        assertThat(DatetimeUtil.DateTOString(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()))
                .isEqualTo("result");
    }

    @Test
    public void testGetLongDateByStr1() {
        assertThat(DatetimeUtil.getLongDateByStr("str"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetShortDateByStrChinese() {
        assertThat(DatetimeUtil.getShortDateByStrChinese("str"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetShortDateByStrSlash1() {
        assertThat(DatetimeUtil.getShortDateByStrSlash("str"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetShortDateByStrSlashAndMinute() {
        assertThat(DatetimeUtil.getShortDateByStrSlashAndMinute("str"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetShortDateByStr1() {
        assertThat(DatetimeUtil.getShortDateByStr("str"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetSmallShortDateByStr() {
        assertThat(DatetimeUtil.getSmallShortDateByStr("str"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetLongDateByStr2() {
        assertThat(DatetimeUtil.getLongDateByStr(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()))
                .isEqualTo("");
    }

    @Test
    public void testGetShortDateByStr2() {
        assertThat(
                DatetimeUtil.getShortDateByStr(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()))
                .isEqualTo("");
    }

    @Test
    public void testGetShortDateByStrSlash2() {
        assertThat(DatetimeUtil.getShortDateByStrSlash(
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())).isEqualTo("");
    }

    @Test
    public void testGetDateStrByPattern() {
        assertThat(DatetimeUtil.getDateStrByPattern(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                "format")).isEqualTo("");
    }

    @Test
    public void testGetDateByStr1() {
        assertThat(DatetimeUtil.getDateByStr("dateStr"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetDateByStr2() {
        assertThat(DatetimeUtil.getDateByStr("dateStr", "format"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetWorkingDay() {
        assertThat(DatetimeUtil.getWorkingDay(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())).isEqualTo(0);
    }

    @Test
    public void testGetMonthFirstDay() {
        assertThat(DatetimeUtil.getMonthFirstDay(2020, 1))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetMonthLastDay() {
        assertThat(DatetimeUtil.getMonthLastDay(2020, 1))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetISODateByStr() {
        assertThat(DatetimeUtil.getISODateByStr("str"))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetISODateString() {
        assertThat(DatetimeUtil.getISODateString(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()))
                .isEqualTo("result");
    }

    @Test
    public void testGetCurrYearFirst() {
        assertThat(DatetimeUtil.getCurrYearFirst())
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetCurrYearLast() {
        assertThat(DatetimeUtil.getCurrYearLast())
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetYearFirst() {
        assertThat(DatetimeUtil.getYearFirst(2020))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetYearMiddle() {
        assertThat(DatetimeUtil.getYearMiddle(2020))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetYearLast() {
        assertThat(DatetimeUtil.getYearLast(2020))
                .isEqualTo(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
    }

    @Test
    public void testGetCron() {
        assertThat(DatetimeUtil.getCron(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()))
                .isEqualTo("result");
    }

    @Test
    public void testMain() {
        // Setup
        // Run the test
        DatetimeUtil.main(new String[]{"args"});

        // Verify the results
    }
}
