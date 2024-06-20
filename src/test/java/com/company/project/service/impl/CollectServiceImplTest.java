package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.CollectMapper;
import com.company.project.model.Collect;
import com.company.project.model.Course;
import com.company.project.model.CourseChapter;
import com.company.project.model.MomentComment;
import com.company.project.service.CollectService;
import com.company.project.service.CourseService;
import com.company.project.service.MomentCommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CollectServiceImplTest {

    @Mock
    private CollectMapper mockCollectMapper;
    @Mock
    private MomentCommentService mockMomentCommentService;
    @Mock
    private CollectService mockCollectService;
    @Mock
    private CourseService mockCourseService;

    @InjectMocks
    private CollectServiceImpl collectServiceImplUnderTest;

    @Test
    public void testList() throws Exception {
        // Setup
        final Collect collect = new Collect();
        collect.setPage(0);
        collect.setLimit(0);
        collect.setCollectState(0);
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        collect.setMomentCommentList(Arrays.asList(momentComment));
        collect.setCollectNumber(0);
        collect.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setCreatedBy("userId");
        collect.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setIsDelete(false);
        collect.setStatus(0);
        collect.setMomentId(0L);

        // Configure CollectMapper.list(...).
        final Collect collect1 = new Collect();
        collect1.setPage(0);
        collect1.setLimit(0);
        collect1.setCollectState(0);
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        collect1.setMomentCommentList(Arrays.asList(momentComment1));
        collect1.setCollectNumber(0);
        collect1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setCreatedBy("userId");
        collect1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setIsDelete(false);
        collect1.setStatus(0);
        collect1.setMomentId(0L);
        final List<Collect> collects = Arrays.asList(collect1);
        final Collect collect2 = new Collect();
        collect2.setPage(0);
        collect2.setLimit(0);
        collect2.setCollectState(0);
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        collect2.setMomentCommentList(Arrays.asList(momentComment2));
        collect2.setCollectNumber(0);
        collect2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect2.setCreatedBy("userId");
        collect2.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect2.setIsDelete(false);
        collect2.setStatus(0);
        collect2.setMomentId(0L);
        when(mockCollectMapper.list(collect2)).thenReturn(collects);

        when(mockCollectService.getCountByMomentId(0L)).thenReturn(0);

        // Configure MomentCommentService.selectByMomentId(...).
        final MomentComment momentComment3 = new MomentComment();
        momentComment3.setPage(0);
        momentComment3.setLimit(0);
        momentComment3.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment3.setImgUrl("imgUrl");
        momentComment3.setTitle("title");
        final List<MomentComment> momentComments = Arrays.asList(momentComment3);
        when(mockMomentCommentService.selectByMomentId(0L)).thenReturn(momentComments);

        when(mockCollectService.getCollectState(0L, "userId")).thenReturn(0);

        // Run the test
        final Result result = collectServiceImplUnderTest.list(collect);

        // Verify the results
    }

    @Test
    public void testList_CollectMapperReturnsNull() {
        // Setup
        final Collect collect = new Collect();
        collect.setPage(0);
        collect.setLimit(0);
        collect.setCollectState(0);
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        collect.setMomentCommentList(Arrays.asList(momentComment));
        collect.setCollectNumber(0);
        collect.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setCreatedBy("userId");
        collect.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setIsDelete(false);
        collect.setStatus(0);
        collect.setMomentId(0L);

        // Configure CollectMapper.list(...).
        final Collect collect1 = new Collect();
        collect1.setPage(0);
        collect1.setLimit(0);
        collect1.setCollectState(0);
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        collect1.setMomentCommentList(Arrays.asList(momentComment1));
        collect1.setCollectNumber(0);
        collect1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setCreatedBy("userId");
        collect1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setIsDelete(false);
        collect1.setStatus(0);
        collect1.setMomentId(0L);
        when(mockCollectMapper.list(collect1)).thenReturn(null);

        // Run the test
        final Result result = collectServiceImplUnderTest.list(collect);

        // Verify the results
    }

    @Test
    public void testList_CollectMapperReturnsNoItems() {
        // Setup
        final Collect collect = new Collect();
        collect.setPage(0);
        collect.setLimit(0);
        collect.setCollectState(0);
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        collect.setMomentCommentList(Arrays.asList(momentComment));
        collect.setCollectNumber(0);
        collect.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setCreatedBy("userId");
        collect.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setIsDelete(false);
        collect.setStatus(0);
        collect.setMomentId(0L);

        // Configure CollectMapper.list(...).
        final Collect collect1 = new Collect();
        collect1.setPage(0);
        collect1.setLimit(0);
        collect1.setCollectState(0);
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        collect1.setMomentCommentList(Arrays.asList(momentComment1));
        collect1.setCollectNumber(0);
        collect1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setCreatedBy("userId");
        collect1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setIsDelete(false);
        collect1.setStatus(0);
        collect1.setMomentId(0L);
        when(mockCollectMapper.list(collect1)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = collectServiceImplUnderTest.list(collect);

        // Verify the results
    }

    @Test
    public void testList_MomentCommentServiceReturnsNoItems() {
        // Setup
        final Collect collect = new Collect();
        collect.setPage(0);
        collect.setLimit(0);
        collect.setCollectState(0);
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        collect.setMomentCommentList(Arrays.asList(momentComment));
        collect.setCollectNumber(0);
        collect.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setCreatedBy("userId");
        collect.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setIsDelete(false);
        collect.setStatus(0);
        collect.setMomentId(0L);

        // Configure CollectMapper.list(...).
        final Collect collect1 = new Collect();
        collect1.setPage(0);
        collect1.setLimit(0);
        collect1.setCollectState(0);
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        collect1.setMomentCommentList(Arrays.asList(momentComment1));
        collect1.setCollectNumber(0);
        collect1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setCreatedBy("userId");
        collect1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setIsDelete(false);
        collect1.setStatus(0);
        collect1.setMomentId(0L);
        final List<Collect> collects = Arrays.asList(collect1);
        final Collect collect2 = new Collect();
        collect2.setPage(0);
        collect2.setLimit(0);
        collect2.setCollectState(0);
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        collect2.setMomentCommentList(Arrays.asList(momentComment2));
        collect2.setCollectNumber(0);
        collect2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect2.setCreatedBy("userId");
        collect2.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect2.setIsDelete(false);
        collect2.setStatus(0);
        collect2.setMomentId(0L);
        when(mockCollectMapper.list(collect2)).thenReturn(collects);

        when(mockCollectService.getCountByMomentId(0L)).thenReturn(0);
        when(mockMomentCommentService.selectByMomentId(0L)).thenReturn(Collections.emptyList());
        when(mockCollectService.getCollectState(0L, "userId")).thenReturn(0);

        // Run the test
        final Result result = collectServiceImplUnderTest.list(collect);

        // Verify the results
    }

    @Test
    public void testAddOrCancel() {
        // Setup
        final Collect collect = new Collect();
        collect.setPage(0);
        collect.setLimit(0);
        collect.setCollectState(0);
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        collect.setMomentCommentList(Arrays.asList(momentComment));
        collect.setCollectNumber(0);
        collect.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setCreatedBy("userId");
        collect.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setIsDelete(false);
        collect.setStatus(0);
        collect.setMomentId(0L);

        // Configure CourseService.findByIdAndValidDelete(...).
        final Course course = new Course();
        course.setPage(0);
        course.setLimit(0);
        course.setPrice(new BigDecimal("0.00"));
        course.setViews(0);
        final CourseChapter courseChapter = new CourseChapter();
        course.setCourseChapterList(Arrays.asList(courseChapter));
        when(mockCourseService.findByIdAndValidDelete(0L)).thenReturn(course);

        when(mockCollectMapper.findCollectCount("userId", 0L)).thenReturn(0);

        // Run the test
        final Result result = collectServiceImplUnderTest.addOrCancel(collect);

        // Verify the results
        // Confirm CollectMapper.cancel(...).
        final Collect collect1 = new Collect();
        collect1.setPage(0);
        collect1.setLimit(0);
        collect1.setCollectState(0);
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        collect1.setMomentCommentList(Arrays.asList(momentComment1));
        collect1.setCollectNumber(0);
        collect1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setCreatedBy("userId");
        collect1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setIsDelete(false);
        collect1.setStatus(0);
        collect1.setMomentId(0L);
        verify(mockCollectMapper).cancel(collect1);
    }

    @Test
    public void testAddOrCancel_CourseServiceReturnsNull() {
        // Setup
        final Collect collect = new Collect();
        collect.setPage(0);
        collect.setLimit(0);
        collect.setCollectState(0);
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        collect.setMomentCommentList(Arrays.asList(momentComment));
        collect.setCollectNumber(0);
        collect.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setCreatedBy("userId");
        collect.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setIsDelete(false);
        collect.setStatus(0);
        collect.setMomentId(0L);

        when(mockCourseService.findByIdAndValidDelete(0L)).thenReturn(null);

        // Run the test
        final Result result = collectServiceImplUnderTest.addOrCancel(collect);

        // Verify the results
    }

    @Test
    public void testSelectByUserId() {
        // Setup
        final Collect collect = new Collect();
        collect.setPage(0);
        collect.setLimit(0);
        collect.setCollectState(0);
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        collect.setMomentCommentList(Arrays.asList(momentComment));
        collect.setCollectNumber(0);
        collect.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setCreatedBy("userId");
        collect.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect.setIsDelete(false);
        collect.setStatus(0);
        collect.setMomentId(0L);
        final List<Collect> expectedResult = Arrays.asList(collect);

        // Configure CollectMapper.selectByUserId(...).
        final Collect collect1 = new Collect();
        collect1.setPage(0);
        collect1.setLimit(0);
        collect1.setCollectState(0);
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        collect1.setMomentCommentList(Arrays.asList(momentComment1));
        collect1.setCollectNumber(0);
        collect1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setCreatedBy("userId");
        collect1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collect1.setIsDelete(false);
        collect1.setStatus(0);
        collect1.setMomentId(0L);
        final List<Collect> collects = Arrays.asList(collect1);
        when(mockCollectMapper.selectByUserId(0L)).thenReturn(collects);

        // Run the test
        final List<Collect> result = collectServiceImplUnderTest.selectByUserId(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testSelectByUserId_CollectMapperReturnsNoItems() {
        // Setup
        when(mockCollectMapper.selectByUserId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<Collect> result = collectServiceImplUnderTest.selectByUserId(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testGetCollectNumber() {
        // Setup
        when(mockCollectMapper.getCollectNumber(0L)).thenReturn(0);

        // Run the test
        final Integer result = collectServiceImplUnderTest.getCollectNumber(0L);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testGetCountByMomentId() {
        // Setup
        when(mockCollectMapper.getCountByMomentId(0L)).thenReturn(0);

        // Run the test
        final Integer result = collectServiceImplUnderTest.getCountByMomentId(0L);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testDeleteByMomentId() {
        // Setup
        // Run the test
        collectServiceImplUnderTest.deleteByMomentId(0L);

        // Verify the results
        verify(mockCollectMapper).deleteByMomentId(0L);
    }

    @Test
    public void testGetCollectState() {
        // Setup
        when(mockCollectMapper.getCollectState(0L, "userId")).thenReturn(0);

        // Run the test
        final Integer result = collectServiceImplUnderTest.getCollectState(0L, "userId");

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
