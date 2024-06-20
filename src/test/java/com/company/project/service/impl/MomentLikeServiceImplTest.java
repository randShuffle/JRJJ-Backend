package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.MomentLikeMapper;
import com.company.project.model.MomentLike;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MomentLikeServiceImplTest {

    @Mock
    private MomentLikeMapper mockMomentLikeMapper;

    @InjectMocks
    private MomentLikeServiceImpl momentLikeServiceImplUnderTest;

    @Test
    public void testAddOrCancel() {
        // Setup
        final MomentLike momentLike = new MomentLike();
        momentLike.setPage(0);
        momentLike.setLimit(0);
        momentLike.setCreatedBy("createdBy");
        momentLike.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike.setIsDelete(false);
        momentLike.setStatus(0);
        momentLike.setSubjectId(0L);

        // Configure MomentLikeMapper.findUserMomentLikeById(...).
        final MomentLike momentLike1 = new MomentLike();
        momentLike1.setPage(0);
        momentLike1.setLimit(0);
        momentLike1.setCreatedBy("createdBy");
        momentLike1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike1.setIsDelete(false);
        momentLike1.setStatus(0);
        momentLike1.setSubjectId(0L);
        when(mockMomentLikeMapper.findUserMomentLikeById(momentLike1)).thenReturn(0);

        // Configure MomentLikeMapper.selectByIdAndIsDelete(...).
        final MomentLike momentLike2 = new MomentLike();
        momentLike2.setPage(0);
        momentLike2.setLimit(0);
        momentLike2.setCreatedBy("createdBy");
        momentLike2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike2.setIsDelete(false);
        momentLike2.setStatus(0);
        momentLike2.setSubjectId(0L);
        when(mockMomentLikeMapper.selectByIdAndIsDelete(0L, "createdBy", 0)).thenReturn(momentLike2);

        // Configure MomentLikeMapper.cancelMomentLike(...).
        final MomentLike momentLike3 = new MomentLike();
        momentLike3.setPage(0);
        momentLike3.setLimit(0);
        momentLike3.setCreatedBy("createdBy");
        momentLike3.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike3.setIsDelete(false);
        momentLike3.setStatus(0);
        momentLike3.setSubjectId(0L);
        when(mockMomentLikeMapper.cancelMomentLike(momentLike3)).thenReturn(0);

        // Run the test
        final Result result = momentLikeServiceImplUnderTest.addOrCancel(momentLike);

        // Verify the results
    }

    @Test
    public void testAddOrCancel_MomentLikeMapperSelectByIdAndIsDeleteReturnsNull() {
        // Setup
        final MomentLike momentLike = new MomentLike();
        momentLike.setPage(0);
        momentLike.setLimit(0);
        momentLike.setCreatedBy("createdBy");
        momentLike.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike.setIsDelete(false);
        momentLike.setStatus(0);
        momentLike.setSubjectId(0L);

        when(mockMomentLikeMapper.selectByIdAndIsDelete(0L, "createdBy", 0)).thenReturn(null);

        // Run the test
        final Result result = momentLikeServiceImplUnderTest.addOrCancel(momentLike);

        // Verify the results
    }

    @Test
    public void testGetCountBySubjectId() {
        // Setup
        when(mockMomentLikeMapper.getCountBySubjectId(0L)).thenReturn(0);

        // Run the test
        final Integer result = momentLikeServiceImplUnderTest.getCountBySubjectId(0L);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testGetCountStateBySubjectId() {
        // Setup
        when(mockMomentLikeMapper.getCountStateBySubjectId("userId", 0L)).thenReturn(0);

        // Run the test
        final Integer result = momentLikeServiceImplUnderTest.getCountStateBySubjectId("userId", 0L);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testList() throws Exception {
        // Setup
        final MomentLike momentLike = new MomentLike();
        momentLike.setPage(0);
        momentLike.setLimit(0);
        momentLike.setCreatedBy("createdBy");
        momentLike.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike.setIsDelete(false);
        momentLike.setStatus(0);
        momentLike.setSubjectId(0L);

        // Run the test
        final Result result = momentLikeServiceImplUnderTest.list(momentLike);

        // Verify the results
    }
}
