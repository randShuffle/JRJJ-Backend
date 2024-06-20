package com.company.project.service.impl;

import com.company.project.core.Page;
import com.company.project.dao.SysRoleMapper;
import com.company.project.model.SysRole;
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
public class SysRoleServiceImplTest {

    @Mock
    private SysRoleMapper mockTSysRoleMapper;

    @InjectMocks
    private SysRoleServiceImpl sysRoleServiceImplUnderTest;

    @Test
    public void testSave1() {
        // Setup
        final SysRole model = new SysRole();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");

        // Run the test
        sysRoleServiceImplUnderTest.save(model);

        // Verify the results
    }

    @Test
    public void testSave2() {
        // Setup
        final SysRole sysRole = new SysRole();
        sysRole.setId(0L);
        sysRole.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setCreatedBy("createdBy");
        sysRole.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setUpdatedBy("updatedBy");
        final List<SysRole> models = Arrays.asList(sysRole);

        // Run the test
        sysRoleServiceImplUnderTest.save(models);

        // Verify the results
    }

    @Test
    public void testDeleteById() {
        // Setup
        // Run the test
        sysRoleServiceImplUnderTest.deleteById(0);

        // Verify the results
    }

    @Test
    public void testDeleteByIds() {
        // Setup
        // Run the test
        sysRoleServiceImplUnderTest.deleteByIds("ids");

        // Verify the results
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        final SysRole model = new SysRole();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");

        // Run the test
        sysRoleServiceImplUnderTest.update(model);

        // Verify the results
    }

    @Test
    public void testFindById() {
        // Setup
        final SysRole expectedResult = new SysRole();
        expectedResult.setId(0L);
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");

        // Run the test
        final SysRole result = sysRoleServiceImplUnderTest.findById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindBy() {
        // Setup
        final SysRole expectedResult = new SysRole();
        expectedResult.setId(0L);
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");

        // Run the test
        final SysRole result = sysRoleServiceImplUnderTest.findBy("fieldName", "value");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindBy_ThrowsTooManyResultsException() {
        // Setup
        // Run the test
        assertThatThrownBy(() -> sysRoleServiceImplUnderTest.findBy("fieldName", "value"))
                .isInstanceOf(TooManyResultsException.class);
    }

    @Test
    public void testFindByIds() {
        // Setup
        final SysRole sysRole = new SysRole();
        sysRole.setId(0L);
        sysRole.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setCreatedBy("createdBy");
        sysRole.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setUpdatedBy("updatedBy");
        final List<SysRole> expectedResult = Arrays.asList(sysRole);

        // Run the test
        final List<SysRole> result = sysRoleServiceImplUnderTest.findByIds("ids");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByCondition() {
        // Setup
        final Condition condition = new Condition(String.class, false, false);
        final SysRole sysRole = new SysRole();
        sysRole.setId(0L);
        sysRole.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setCreatedBy("createdBy");
        sysRole.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setUpdatedBy("updatedBy");
        final List<SysRole> expectedResult = Arrays.asList(sysRole);

        // Run the test
        final List<SysRole> result = sysRoleServiceImplUnderTest.findByCondition(condition);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindAll() {
        // Setup
        final SysRole sysRole = new SysRole();
        sysRole.setId(0L);
        sysRole.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setCreatedBy("createdBy");
        sysRole.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setUpdatedBy("updatedBy");
        final List<SysRole> expectedResult = Arrays.asList(sysRole);

        // Run the test
        final List<SysRole> result = sysRoleServiceImplUnderTest.findAll();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByIdAndValidDelete() {
        // Setup
        final SysRole expectedResult = new SysRole();
        expectedResult.setId(0L);
        expectedResult.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setCreatedBy("createdBy");
        expectedResult.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        expectedResult.setUpdatedBy("updatedBy");

        // Run the test
        final SysRole result = sysRoleServiceImplUnderTest.findByIdAndValidDelete(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByModel() {
        // Setup
        final SysRole model = new SysRole();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");

        final SysRole sysRole = new SysRole();
        sysRole.setId(0L);
        sysRole.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setCreatedBy("createdBy");
        sysRole.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setUpdatedBy("updatedBy");
        final List<SysRole> expectedResult = Arrays.asList(sysRole);

        // Run the test
        final List<SysRole> result = sysRoleServiceImplUnderTest.findByModel(model);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindByModel_ThrowsTooManyResultsException() {
        // Setup
        final SysRole model = new SysRole();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedBy("updatedBy");

        // Run the test
        assertThatThrownBy(() -> sysRoleServiceImplUnderTest.findByModel(model))
                .isInstanceOf(TooManyResultsException.class);
    }

    @Test
    public void testFindValidDeleteAll() {
        // Setup
        final Page<SysRole> page = new Page<>();
        page.setPage(0);
        page.setSize(0);
        final SysRole sysRole = new SysRole();
        sysRole.setId(0L);
        page.setModel(sysRole);
        page.setParams(new HashMap<>());

        final SysRole sysRole1 = new SysRole();
        sysRole1.setId(0L);
        sysRole1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole1.setCreatedBy("createdBy");
        sysRole1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole1.setUpdatedBy("updatedBy");
        final List<SysRole> expectedResult = Arrays.asList(sysRole1);

        // Run the test
        final List<SysRole> result = sysRoleServiceImplUnderTest.findValidDeleteAll(page);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }
}
