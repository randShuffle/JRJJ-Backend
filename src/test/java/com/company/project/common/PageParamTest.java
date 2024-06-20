package com.company.project.common;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PageParamTest {

    private PageParam pageParamUnderTest;

    @Before
    public void setUp() throws Exception {
        pageParamUnderTest = new PageParam();
    }

    @Test
    public void testGetPage() {
        assertThat(pageParamUnderTest.getPage()).isEqualTo(0);
    }

    @Test
    public void testSetPage() {
        // Setup
        // Run the test
        pageParamUnderTest.setPage(0);

        // Verify the results
    }

    @Test
    public void testGetLimit() {
        assertThat(pageParamUnderTest.getLimit()).isEqualTo(0);
    }

    @Test
    public void testSetLimit() {
        // Setup
        // Run the test
        pageParamUnderTest.setLimit(0);

        // Verify the results
    }
}
