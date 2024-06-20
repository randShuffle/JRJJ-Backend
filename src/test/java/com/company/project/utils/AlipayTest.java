package com.company.project.utils;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AlipayTest {

    @Test
    public void testGeneratePayHtml() {
        assertThat(Alipay.generatePayHtml("orderId", new BigDecimal("0.00"), "title", "content")).isEqualTo("body");
    }

    @Test
    public void testGenerateWapPayHtml() {
        assertThat(Alipay.generateWapPayHtml("orderId", new BigDecimal("0.00"), "title", "content")).isEqualTo("body");
    }

    @Test
    public void testIsValid() {
        // Setup
        final MockHttpServletRequest request = new MockHttpServletRequest();

        // Run the test
        final boolean result = Alipay.isValid(request);

        // Verify the results
        assertThat(result).isFalse();
    }
}
