package com.company.project.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tk.mybatis.mapper.entity.Condition;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbstractServiceTest {

    @Mock
    private Mapper<String> mockMapper;

    private AbstractService<String> abstractServiceUnderTest;

    @Before
    public void setUp() throws Exception {
        abstractServiceUnderTest = new AbstractService() {};
        abstractServiceUnderTest.mapper = mockMapper;
    }

    @Test
    public void testSave1() {
        // Setup
        // Run the test
        abstractServiceUnderTest.save("model");

        // Verify the results
        verify(mockMapper).insertSelective("t");
    }

    @Test
    public void testSave2() {
        // Setup
        // Run the test
        abstractServiceUnderTest.save(Arrays.asList("value"));

        // Verify the results
        verify(mockMapper).insertList(Arrays.asList("value"));
    }

    @Test
    public void testDeleteById() {
        // Setup
        // Run the test
        abstractServiceUnderTest.deleteById(0);

        // Verify the results
        verify(mockMapper).deleteByPrimaryKey(0);
    }

    @Test
    public void testDeleteByIds() {
        // Setup
        // Run the test
        abstractServiceUnderTest.deleteByIds("ids");

        // Verify the results
        verify(mockMapper).deleteByIds("ids");
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        abstractServiceUnderTest.update("model");

        // Verify the results
        verify(mockMapper).updateByPrimaryKeySelective("t");
    }

    @Test
    public void testFindById() {
        // Setup
        when(mockMapper.selectByPrimaryKey(0L)).thenReturn("result");

        // Run the test
        final String result = abstractServiceUnderTest.findById(0L);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    public void testFindBy() {
        // Setup
        when(mockMapper.selectOne("t")).thenReturn("result");

        // Run the test
        final String result = abstractServiceUnderTest.findBy("fieldName", "value");

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    public void testFindByIds() {
        // Setup
        when(mockMapper.selectByIds("ids")).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = abstractServiceUnderTest.findByIds("ids");

        // Verify the results
        assertThat(result).isEqualTo(Arrays.asList("value"));
    }

    @Test
    public void testFindByIds_MapperReturnsNoItems() {
        // Setup
        when(mockMapper.selectByIds("ids")).thenReturn(Collections.emptyList());

        // Run the test
        final List<String> result = abstractServiceUnderTest.findByIds("ids");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testFindByCondition() {
        // Setup
        final Condition condition = new Condition(String.class, false, false);
        when(mockMapper.selectByCondition(any(Object.class))).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = abstractServiceUnderTest.findByCondition(condition);

        // Verify the results
        assertThat(result).isEqualTo(Arrays.asList("value"));
    }

    @Test
    public void testFindByCondition_MapperReturnsNoItems() {
        // Setup
        final Condition condition = new Condition(String.class, false, false);
        when(mockMapper.selectByCondition(any(Object.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<String> result = abstractServiceUnderTest.findByCondition(condition);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testFindAll() {
        // Setup
        when(mockMapper.selectAll()).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = abstractServiceUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(Arrays.asList("value"));
    }

    @Test
    public void testFindAll_MapperReturnsNoItems() {
        // Setup
        when(mockMapper.selectAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<String> result = abstractServiceUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testFindByIdAndValidDelete() {
        // Setup
        when(mockMapper.selectByCondition(any(Object.class))).thenReturn(Arrays.asList("value"));

        // Run the test
        final String result = abstractServiceUnderTest.findByIdAndValidDelete(0L);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    public void testFindByIdAndValidDelete_MapperReturnsNull() {
        // Setup
        when(mockMapper.selectByCondition(any(Object.class))).thenReturn(null);

        // Run the test
        final String result = abstractServiceUnderTest.findByIdAndValidDelete(0L);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    public void testFindByIdAndValidDelete_MapperReturnsNoItems() {
        // Setup
        when(mockMapper.selectByCondition(any(Object.class))).thenReturn(Collections.emptyList());

        // Run the test
        final String result = abstractServiceUnderTest.findByIdAndValidDelete(0L);

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    public void testFindByModel() {
        // Setup
        when(mockMapper.selectByCondition(any(Object.class))).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = abstractServiceUnderTest.findByModel("model");

        // Verify the results
        assertThat(result).isEqualTo(Arrays.asList("value"));
    }

    @Test
    public void testFindByModel_MapperReturnsNoItems() {
        // Setup
        when(mockMapper.selectByCondition(any(Object.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<String> result = abstractServiceUnderTest.findByModel("model");

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testFindValidDeleteAll() {
        // Setup
        final Page<String> page = new Page<>();
        page.setPage(0);
        page.setSize(0);
        page.setModel("value");
        page.setParams(new HashMap<>());

        when(mockMapper.selectByCondition(any(Object.class))).thenReturn(Arrays.asList("value"));

        // Run the test
        final List<String> result = abstractServiceUnderTest.findValidDeleteAll(page);

        // Verify the results
        assertThat(result).isEqualTo(Arrays.asList("value"));
    }

    @Test
    public void testFindValidDeleteAll_MapperReturnsNoItems() {
        // Setup
        final Page<String> page = new Page<>();
        page.setPage(0);
        page.setSize(0);
        page.setModel("value");
        page.setParams(new HashMap<>());

        when(mockMapper.selectByCondition(any(Object.class))).thenReturn(Collections.emptyList());

        // Run the test
        final List<String> result = abstractServiceUnderTest.findValidDeleteAll(page);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
