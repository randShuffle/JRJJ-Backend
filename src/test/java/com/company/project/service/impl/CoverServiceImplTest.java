package com.company.project.service.impl;

import com.company.project.core.Page;
import com.company.project.dao.CoverMapper;
import com.company.project.model.Cover;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tk.mybatis.mapper.entity.Condition;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class CoverServiceImplTest {

    @Mock
    private CoverMapper mockTCoverMapper;

    @InjectMocks
    private CoverServiceImpl coverServiceImplUnderTest;

    @Test
    public void testSave1() {
        // Setup
        final Cover model = new Cover();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        coverServiceImplUnderTest.save(model);

        // Verify the results
    }

    @Test
    public void testSave2() {
        // Setup
        final Cover cover = new Cover();
        cover.setId(0L);
        cover.setCreatedBy("createdBy");
        cover.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover.setUpdatedBy("updatedBy");
        cover.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cover> models = Arrays.asList(cover);

        // Run the test
        coverServiceImplUnderTest.save(models);

        // Verify the results
    }

    @Test
    public void testDeleteById() {
        // Setup
        // Run the test
        coverServiceImplUnderTest.deleteById(0);

        // Verify the results
    }

    @Test
    public void testDeleteByIds() {
        // Setup
        // Run the test
        coverServiceImplUnderTest.deleteByIds("ids");

        // Verify the results
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        final Cover model = new Cover();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        coverServiceImplUnderTest.update(model);

        // Verify the results
    }

    @Test
    public void testFindById() {
        // Setup
        final Cover expectedResult = new Cover();
        expectedResult.setId(0L);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final Cover result = coverServiceImplUnderTest.findById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindBy() {
        // Setup
        final Cover expectedResult = new Cover();
        expectedResult.setId(0L);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final Cover result = coverServiceImplUnderTest.findBy("fieldName", "value");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindBy_ThrowsTooManyResultsException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> coverServiceImplUnderTest.findBy("fieldName", "value"))
                .isInstanceOf(TooManyResultsException.class);
    }

    @Test
    public void testFindByIds() {
        // Setup
        final Cover cover = new Cover();
        cover.setId(0L);
        cover.setCreatedBy("createdBy");
        cover.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover.setUpdatedBy("updatedBy");
        cover.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cover> expectedResult = Arrays.asList(cover);

        // Run the test
        final List<Cover> result = coverServiceImplUnderTest.findByIds("ids");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByCondition() {
        // Setup
        final Condition condition = new Condition(String.class, false, false);
        final Cover cover = new Cover();
        cover.setId(0L);
        cover.setCreatedBy("createdBy");
        cover.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover.setUpdatedBy("updatedBy");
        cover.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cover> expectedResult = Arrays.asList(cover);

        // Run the test
        final List<Cover> result = coverServiceImplUnderTest.findByCondition(condition);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindAll() {
        // Setup
        final Cover cover = new Cover();
        cover.setId(0L);
        cover.setCreatedBy("createdBy");
        cover.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover.setUpdatedBy("updatedBy");
        cover.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cover> expectedResult = Arrays.asList(cover);

        // Run the test
        final List<Cover> result = coverServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByIdAndValidDelete() {
        // Setup
        final Cover expectedResult = new Cover();
        expectedResult.setId(0L);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final Cover result = coverServiceImplUnderTest.findByIdAndValidDelete(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByModel() {
        // Setup
        final Cover model = new Cover();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        final Cover cover = new Cover();
        cover.setId(0L);
        cover.setCreatedBy("createdBy");
        cover.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover.setUpdatedBy("updatedBy");
        cover.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cover> expectedResult = Arrays.asList(cover);

        // Run the test
        final List<Cover> result = coverServiceImplUnderTest.findByModel(model);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByModel_ThrowsTooManyResultsException() {
        // Setup
        final Cover model = new Cover();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        assertThatThrownBy(() -> coverServiceImplUnderTest.findByModel(model))
                .isInstanceOf(TooManyResultsException.class);
    }

    @Test
    public void testFindValidDeleteAll() {
        // Setup
        final Page<Cover> page = new Page<>();
        page.setPage(0);
        page.setSize(0);
        final Cover cover = new Cover();
        cover.setId(0L);
        page.setModel(cover);
        page.setParams(new HashMap<>());

        final Cover cover1 = new Cover();
        cover1.setId(0L);
        cover1.setCreatedBy("createdBy");
        cover1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover1.setUpdatedBy("updatedBy");
        cover1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<Cover> expectedResult = Arrays.asList(cover1);

        // Run the test
        final List<Cover> result = coverServiceImplUnderTest.findValidDeleteAll(page);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
