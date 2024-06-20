package com.company.project.service.impl;

import com.company.project.core.Page;
import com.company.project.dao.CollectionListMapper;
import com.company.project.model.CollectionList;
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
public class CollectionListServiceImplTest {

    @Mock
    private CollectionListMapper mockTCollectionListMapper;

    @InjectMocks
    private CollectionListServiceImpl collectionListServiceImplUnderTest;

    @Test
    public void testSave1() {
        // Setup
        final CollectionList model = new CollectionList();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");

        // Run the test
        collectionListServiceImplUnderTest.save(model);

        // Verify the results
    }

    @Test
    public void testSave2() {
        // Setup
        final CollectionList collectionList = new CollectionList();
        collectionList.setId(0L);
        collectionList.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setCreatedBy("createdBy");
        collectionList.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setUpdatedBy("updatedBy");
        final List<CollectionList> models = Arrays.asList(collectionList);

        // Run the test
        collectionListServiceImplUnderTest.save(models);

        // Verify the results
    }

    @Test
    public void testDeleteById() {
        // Setup
        // Run the test
        collectionListServiceImplUnderTest.deleteById(0);

        // Verify the results
    }

    @Test
    public void testDeleteByIds() {
        // Setup
        // Run the test
        collectionListServiceImplUnderTest.deleteByIds("ids");

        // Verify the results
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        final CollectionList model = new CollectionList();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");

        // Run the test
        collectionListServiceImplUnderTest.update(model);

        // Verify the results
    }

    @Test
    public void testFindById() {
        // Setup
        final CollectionList expectedResult = new CollectionList();
        expectedResult.setId(0L);
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");

        // Run the test
        final CollectionList result = collectionListServiceImplUnderTest.findById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindBy() {
        // Setup
        final CollectionList expectedResult = new CollectionList();
        expectedResult.setId(0L);
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");

        // Run the test
        final CollectionList result = collectionListServiceImplUnderTest.findBy("fieldName", "value");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindBy_ThrowsTooManyResultsException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> collectionListServiceImplUnderTest.findBy("fieldName", "value"))
                .isInstanceOf(TooManyResultsException.class);
    }

    @Test
    public void testFindByIds() {
        // Setup
        final CollectionList collectionList = new CollectionList();
        collectionList.setId(0L);
        collectionList.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setCreatedBy("createdBy");
        collectionList.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setUpdatedBy("updatedBy");
        final List<CollectionList> expectedResult = Arrays.asList(collectionList);

        // Run the test
        final List<CollectionList> result = collectionListServiceImplUnderTest.findByIds("ids");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByCondition() {
        // Setup
        final Condition condition = new Condition(String.class, false, false);
        final CollectionList collectionList = new CollectionList();
        collectionList.setId(0L);
        collectionList.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setCreatedBy("createdBy");
        collectionList.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setUpdatedBy("updatedBy");
        final List<CollectionList> expectedResult = Arrays.asList(collectionList);

        // Run the test
        final List<CollectionList> result = collectionListServiceImplUnderTest.findByCondition(condition);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindAll() {
        // Setup
        final CollectionList collectionList = new CollectionList();
        collectionList.setId(0L);
        collectionList.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setCreatedBy("createdBy");
        collectionList.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setUpdatedBy("updatedBy");
        final List<CollectionList> expectedResult = Arrays.asList(collectionList);

        // Run the test
        final List<CollectionList> result = collectionListServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByIdAndValidDelete() {
        // Setup
        final CollectionList expectedResult = new CollectionList();
        expectedResult.setId(0L);
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");

        // Run the test
        final CollectionList result = collectionListServiceImplUnderTest.findByIdAndValidDelete(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByModel() {
        // Setup
        final CollectionList model = new CollectionList();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");

        final CollectionList collectionList = new CollectionList();
        collectionList.setId(0L);
        collectionList.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setCreatedBy("createdBy");
        collectionList.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setUpdatedBy("updatedBy");
        final List<CollectionList> expectedResult = Arrays.asList(collectionList);

        // Run the test
        final List<CollectionList> result = collectionListServiceImplUnderTest.findByModel(model);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByModel_ThrowsTooManyResultsException() {
        // Setup
        final CollectionList model = new CollectionList();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");

        // Run the test
        assertThatThrownBy(() -> collectionListServiceImplUnderTest.findByModel(model))
                .isInstanceOf(TooManyResultsException.class);
    }

    @Test
    public void testFindValidDeleteAll() {
        // Setup
        final Page<CollectionList> page = new Page<>();
        page.setPage(0);
        page.setSize(0);
        final CollectionList collectionList = new CollectionList();
        collectionList.setId(0L);
        page.setModel(collectionList);
        page.setParams(new HashMap<>());

        final CollectionList collectionList1 = new CollectionList();
        collectionList1.setId(0L);
        collectionList1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList1.setCreatedBy("createdBy");
        collectionList1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList1.setUpdatedBy("updatedBy");
        final List<CollectionList> expectedResult = Arrays.asList(collectionList1);

        // Run the test
        final List<CollectionList> result = collectionListServiceImplUnderTest.findValidDeleteAll(page);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
