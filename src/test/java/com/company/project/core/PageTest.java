package com.company.project.core;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PageTest {

    private Page<String> pageUnderTest;

    @Before
    public void setUp() throws Exception {
        pageUnderTest = new Page<>();
    }

    @Test
    public void testPageGetterAndSetter() {
        final Integer page = 0;
        pageUnderTest.setPage(page);
        assertThat(pageUnderTest.getPage()).isEqualTo(page);
    }

    @Test
    public void testSizeGetterAndSetter() {
        final Integer size = 0;
        pageUnderTest.setSize(size);
        assertThat(pageUnderTest.getSize()).isEqualTo(size);
    }

    @Test
    public void testModelGetterAndSetter() {
        final String model = "model";
        pageUnderTest.setModel(model);
        assertThat(pageUnderTest.getModel()).isEqualTo(model);
    }

    @Test
    public void testParamsGetterAndSetter() {
        final Map<String, String> params = new HashMap<>();
        pageUnderTest.setParams(params);
        assertThat(pageUnderTest.getParams()).isEqualTo(params);
    }
}
