package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.CourseMapper;
import com.company.project.model.Course;
import com.company.project.model.CourseChapter;
import com.company.project.model.CourseChapterVideo;
import com.company.project.model.MomentComment;
import com.company.project.service.CourseChapterService;
import com.company.project.service.MomentCommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {

    @Mock
    private CourseMapper mockCourseMapper;
    @Mock
    private MomentCommentService mockMomentCommentService;
    @Mock
    private CourseChapterService mockCourseChapterService;

    @InjectMocks
    private CourseServiceImpl courseServiceImplUnderTest;

    @Test
    public void testSelectByCourseTypeId() {
        // Setup
        final Course course = new Course();
        course.setPage(0);
        course.setLimit(0);
        course.setViews(0);
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        course.setCourseChapterList(Arrays.asList(courseChapter));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        course.setMomentCommentList(Arrays.asList(momentComment));
        course.setId(0L);
        course.setIsDelete(false);
        final List<Course> expectedResult = Arrays.asList(course);

        // Configure CourseMapper.selectByCourseTypeId(...).
        final Course course1 = new Course();
        course1.setPage(0);
        course1.setLimit(0);
        course1.setViews(0);
        final CourseChapter courseChapter1 = new CourseChapter();
        courseChapter1.setPage(0);
        courseChapter1.setLimit(0);
        course1.setCourseChapterList(Arrays.asList(courseChapter1));
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        course1.setMomentCommentList(Arrays.asList(momentComment1));
        course1.setId(0L);
        course1.setIsDelete(false);
        final List<Course> courses = Arrays.asList(course1);
        when(mockCourseMapper.selectByCourseTypeId(0L)).thenReturn(courses);

        // Run the test
        final List<Course> result = courseServiceImplUnderTest.selectByCourseTypeId(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testSelectByCourseTypeId_CourseMapperReturnsNoItems() {
        // Setup
        when(mockCourseMapper.selectByCourseTypeId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<Course> result = courseServiceImplUnderTest.selectByCourseTypeId(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure CourseMapper.detail(...).
        final Course course = new Course();
        course.setPage(0);
        course.setLimit(0);
        course.setViews(0);
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        course.setCourseChapterList(Arrays.asList(courseChapter));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        course.setMomentCommentList(Arrays.asList(momentComment));
        course.setId(0L);
        course.setIsDelete(false);
        when(mockCourseMapper.detail(0L)).thenReturn(course);

        // Configure MomentCommentService.selectByMomentId(...).
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        momentComment1.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment1.setImgUrl("imgUrl");
        momentComment1.setTitle("title");
        final List<MomentComment> momentComments = Arrays.asList(momentComment1);
        when(mockMomentCommentService.selectByMomentId(0L)).thenReturn(momentComments);

        // Configure CourseChapterService.selectByCourseId(...).
        final CourseChapter courseChapter1 = new CourseChapter();
        courseChapter1.setPage(0);
        courseChapter1.setLimit(0);
        courseChapter1.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setChapterNumber(0);
        courseChapter1.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        final List<CourseChapter> courseChapters = Arrays.asList(courseChapter1);
        when(mockCourseChapterService.selectByCourseId(0L)).thenReturn(courseChapters);

        // Run the test
        final Result result = courseServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testDetail_CourseMapperReturnsNull() {
        // Setup
        when(mockCourseMapper.detail(0L)).thenReturn(null);

        // Run the test
        final Result result = courseServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testDetail_MomentCommentServiceReturnsNoItems() {
        // Setup
        // Configure CourseMapper.detail(...).
        final Course course = new Course();
        course.setPage(0);
        course.setLimit(0);
        course.setViews(0);
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        course.setCourseChapterList(Arrays.asList(courseChapter));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        course.setMomentCommentList(Arrays.asList(momentComment));
        course.setId(0L);
        course.setIsDelete(false);
        when(mockCourseMapper.detail(0L)).thenReturn(course);

        when(mockMomentCommentService.selectByMomentId(0L)).thenReturn(Collections.emptyList());

        // Configure CourseChapterService.selectByCourseId(...).
        final CourseChapter courseChapter1 = new CourseChapter();
        courseChapter1.setPage(0);
        courseChapter1.setLimit(0);
        courseChapter1.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setChapterNumber(0);
        courseChapter1.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        final List<CourseChapter> courseChapters = Arrays.asList(courseChapter1);
        when(mockCourseChapterService.selectByCourseId(0L)).thenReturn(courseChapters);

        // Run the test
        final Result result = courseServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testDetail_CourseChapterServiceReturnsNoItems() {
        // Setup
        // Configure CourseMapper.detail(...).
        final Course course = new Course();
        course.setPage(0);
        course.setLimit(0);
        course.setViews(0);
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        course.setCourseChapterList(Arrays.asList(courseChapter));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        course.setMomentCommentList(Arrays.asList(momentComment));
        course.setId(0L);
        course.setIsDelete(false);
        when(mockCourseMapper.detail(0L)).thenReturn(course);

        // Configure MomentCommentService.selectByMomentId(...).
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        momentComment1.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment1.setImgUrl("imgUrl");
        momentComment1.setTitle("title");
        final List<MomentComment> momentComments = Arrays.asList(momentComment1);
        when(mockMomentCommentService.selectByMomentId(0L)).thenReturn(momentComments);

        when(mockCourseChapterService.selectByCourseId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = courseServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testList() throws Exception {
        // Setup
        final Course course = new Course();
        course.setPage(0);
        course.setLimit(0);
        course.setViews(0);
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        course.setCourseChapterList(Arrays.asList(courseChapter));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        course.setMomentCommentList(Arrays.asList(momentComment));
        course.setId(0L);
        course.setIsDelete(false);

        // Configure CourseMapper.list(...).
        final Course course1 = new Course();
        course1.setPage(0);
        course1.setLimit(0);
        course1.setViews(0);
        final CourseChapter courseChapter1 = new CourseChapter();
        courseChapter1.setPage(0);
        courseChapter1.setLimit(0);
        course1.setCourseChapterList(Arrays.asList(courseChapter1));
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        course1.setMomentCommentList(Arrays.asList(momentComment1));
        course1.setId(0L);
        course1.setIsDelete(false);
        final List<Course> courses = Arrays.asList(course1);
        final Course course2 = new Course();
        course2.setPage(0);
        course2.setLimit(0);
        course2.setViews(0);
        final CourseChapter courseChapter2 = new CourseChapter();
        courseChapter2.setPage(0);
        courseChapter2.setLimit(0);
        course2.setCourseChapterList(Arrays.asList(courseChapter2));
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        course2.setMomentCommentList(Arrays.asList(momentComment2));
        course2.setId(0L);
        course2.setIsDelete(false);
        when(mockCourseMapper.list(course2)).thenReturn(courses);

        // Run the test
        final Result result = courseServiceImplUnderTest.list(course);

        // Verify the results
    }

    @Test
    public void testList_CourseMapperReturnsNoItems() {
        // Setup
        final Course course = new Course();
        course.setPage(0);
        course.setLimit(0);
        course.setViews(0);
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        course.setCourseChapterList(Arrays.asList(courseChapter));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        course.setMomentCommentList(Arrays.asList(momentComment));
        course.setId(0L);
        course.setIsDelete(false);

        // Configure CourseMapper.list(...).
        final Course course1 = new Course();
        course1.setPage(0);
        course1.setLimit(0);
        course1.setViews(0);
        final CourseChapter courseChapter1 = new CourseChapter();
        courseChapter1.setPage(0);
        courseChapter1.setLimit(0);
        course1.setCourseChapterList(Arrays.asList(courseChapter1));
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        course1.setMomentCommentList(Arrays.asList(momentComment1));
        course1.setId(0L);
        course1.setIsDelete(false);
        when(mockCourseMapper.list(course1)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = courseServiceImplUnderTest.list(course);

        // Verify the results
    }
}
