package com.company.project.utils;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SmsUtilsTest {

    private SmsUtils smsUtilsUnderTest;

    @Before
    public void setUp() {
        smsUtilsUnderTest = new SmsUtils();
    }

    @Test
    public void testSendSms() {
        assertThat(smsUtilsUnderTest.sendSms("phone", "templateId", "code")).isFalse();
    }
}
