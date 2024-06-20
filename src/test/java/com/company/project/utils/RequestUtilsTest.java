package com.company.project.utils;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.Cookie;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestUtilsTest {

    @Test
    public void testGetIpAddress() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();

        // Run the test
        final String result = RequestUtils.getIpAddress(request);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    public void testGetRestURL() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();

        // Run the test
        final String result = RequestUtils.getRestURL(request);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    public void testGetRestPatternURL() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();

        // Run the test
        final String result = RequestUtils.getRestPatternURL(request);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    public void testSetCookie() {
        // Setup
        final MockHttpServletResponse response = new MockHttpServletResponse();

        // Run the test
        RequestUtils.setCookie(response, "name", "value", "path", 0);

        // Verify the results
    }

    @Test
    public void testGetCookie() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();

        // Run the test
        final Cookie result = RequestUtils.getCookie(request, "name");

        // Verify the results
    }

    @Test
    public void testDeleteCookie() {
        // Setup
        final MockHttpServletResponse response = new MockHttpServletResponse();
        final Cookie cookie = new Cookie("name", "value");

        // Run the test
        RequestUtils.deleteCookie(response, cookie, "path");

        // Verify the results
    }
}
