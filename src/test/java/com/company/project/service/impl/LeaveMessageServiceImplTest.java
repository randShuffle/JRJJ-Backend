package com.company.project.service.impl;

import com.company.project.core.Page;
import com.company.project.dao.LeaveMessageMapper;
import com.company.project.model.LeaveMessage;
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
public class LeaveMessageServiceImplTest {

    @Mock
    private LeaveMessageMapper mockTLeaveMessageMapper;

    @InjectMocks
    private LeaveMessageServiceImpl leaveMessageServiceImplUnderTest;

    @Test
    public void testSave1() {
        // Setup
        final LeaveMessage model = new LeaveMessage();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        leaveMessageServiceImplUnderTest.save(model);

        // Verify the results
    }

    @Test
    public void testSave2() {
        // Setup
        final LeaveMessage leaveMessage = new LeaveMessage();
        leaveMessage.setId(0L);
        leaveMessage.setCreatedBy("createdBy");
        leaveMessage.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage.setUpdatedBy("updatedBy");
        leaveMessage.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<LeaveMessage> models = Arrays.asList(leaveMessage);

        // Run the test
        leaveMessageServiceImplUnderTest.save(models);

        // Verify the results
    }

    @Test
    public void testDeleteById() {
        // Setup
        // Run the test
        leaveMessageServiceImplUnderTest.deleteById(0);

        // Verify the results
    }

    @Test
    public void testDeleteByIds() {
        // Setup
        // Run the test
        leaveMessageServiceImplUnderTest.deleteByIds("ids");

        // Verify the results
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        final LeaveMessage model = new LeaveMessage();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        leaveMessageServiceImplUnderTest.update(model);

        // Verify the results
    }

    @Test
    public void testFindById() {
        // Setup
        final LeaveMessage expectedResult = new LeaveMessage();
        expectedResult.setId(0L);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final LeaveMessage result = leaveMessageServiceImplUnderTest.findById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindBy() {
        // Setup
        final LeaveMessage expectedResult = new LeaveMessage();
        expectedResult.setId(0L);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final LeaveMessage result = leaveMessageServiceImplUnderTest.findBy("fieldName", "value");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindBy_ThrowsTooManyResultsException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> leaveMessageServiceImplUnderTest.findBy("fieldName", "value"))
                .isInstanceOf(TooManyResultsException.class);
    }

    @Test
    public void testFindByIds() {
        // Setup
        final LeaveMessage leaveMessage = new LeaveMessage();
        leaveMessage.setId(0L);
        leaveMessage.setCreatedBy("createdBy");
        leaveMessage.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage.setUpdatedBy("updatedBy");
        leaveMessage.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<LeaveMessage> expectedResult = Arrays.asList(leaveMessage);

        // Run the test
        final List<LeaveMessage> result = leaveMessageServiceImplUnderTest.findByIds("ids");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByCondition() {
        // Setup
        final Condition condition = new Condition(String.class, false, false);
        final LeaveMessage leaveMessage = new LeaveMessage();
        leaveMessage.setId(0L);
        leaveMessage.setCreatedBy("createdBy");
        leaveMessage.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage.setUpdatedBy("updatedBy");
        leaveMessage.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<LeaveMessage> expectedResult = Arrays.asList(leaveMessage);

        // Run the test
        final List<LeaveMessage> result = leaveMessageServiceImplUnderTest.findByCondition(condition);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindAll() {
        // Setup
        final LeaveMessage leaveMessage = new LeaveMessage();
        leaveMessage.setId(0L);
        leaveMessage.setCreatedBy("createdBy");
        leaveMessage.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage.setUpdatedBy("updatedBy");
        leaveMessage.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<LeaveMessage> expectedResult = Arrays.asList(leaveMessage);

        // Run the test
        final List<LeaveMessage> result = leaveMessageServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByIdAndValidDelete() {
        // Setup
        final LeaveMessage expectedResult = new LeaveMessage();
        expectedResult.setId(0L);
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final LeaveMessage result = leaveMessageServiceImplUnderTest.findByIdAndValidDelete(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByModel() {
        // Setup
        final LeaveMessage model = new LeaveMessage();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        final LeaveMessage leaveMessage = new LeaveMessage();
        leaveMessage.setId(0L);
        leaveMessage.setCreatedBy("createdBy");
        leaveMessage.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage.setUpdatedBy("updatedBy");
        leaveMessage.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<LeaveMessage> expectedResult = Arrays.asList(leaveMessage);

        // Run the test
        final List<LeaveMessage> result = leaveMessageServiceImplUnderTest.findByModel(model);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByModel_ThrowsTooManyResultsException() {
        // Setup
        final LeaveMessage model = new LeaveMessage();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        assertThatThrownBy(() -> leaveMessageServiceImplUnderTest.findByModel(model))
                .isInstanceOf(TooManyResultsException.class);
    }

    @Test
    public void testFindValidDeleteAll() {
        // Setup
        final Page<LeaveMessage> page = new Page<>();
        page.setPage(0);
        page.setSize(0);
        final LeaveMessage leaveMessage = new LeaveMessage();
        leaveMessage.setId(0L);
        page.setModel(leaveMessage);
        page.setParams(new HashMap<>());

        final LeaveMessage leaveMessage1 = new LeaveMessage();
        leaveMessage1.setId(0L);
        leaveMessage1.setCreatedBy("createdBy");
        leaveMessage1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage1.setUpdatedBy("updatedBy");
        leaveMessage1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        final List<LeaveMessage> expectedResult = Arrays.asList(leaveMessage1);

        // Run the test
        final List<LeaveMessage> result = leaveMessageServiceImplUnderTest.findValidDeleteAll(page);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
