package com.company.project.utils;

import com.company.project.core.Result;
import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EmailUtilsTest {

    private EmailUtils emailUtilsUnderTest;

    @Before
    public void setUp() {
        emailUtilsUnderTest = new EmailUtils();
    }

    @Test
    public void testSendMail() throws Exception {
        // Setup
        // Run the test
        final Result result = emailUtilsUnderTest.sendMail("email", "account", "password");

        // Verify the results
    }

    @Test
    public void testSendMail_ThrowsGeneralSecurityException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> emailUtilsUnderTest.sendMail("email", "account", "password"))
                .isInstanceOf(GeneralSecurityException.class);
    }

    @Test
    public void testSendMail_ThrowsMessagingException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> emailUtilsUnderTest.sendMail("email", "account", "password"))
                .isInstanceOf(MessagingException.class);
    }
}
