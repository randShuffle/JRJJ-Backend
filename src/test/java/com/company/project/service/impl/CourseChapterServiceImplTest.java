package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.CourseChapterMapper;
import com.company.project.model.Course;
import com.company.project.model.CourseChapter;
import com.company.project.model.CourseChapterVideo;
import com.company.project.service.CourseChapterVideoService;
import com.company.project.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseChapterServiceImplTest {

    @Mock
    private CourseChapterMapper mockCourseChapterMapper;
    @Mock
    private CourseChapterVideoService mockCourseChapterVideoService;
    @Mock
    private CourseService mockCourseService;

    @InjectMocks
    private CourseChapterServiceImpl courseChapterServiceImplUnderTest;

    @Test
    public void testList() throws Exception {
        // Setup
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        courseChapter.setId(0L);
        courseChapter.setIsDelete(false);
        courseChapter.setCourseId(0L);

        // Configure CourseChapterMapper.list(...).
        final CourseChapter courseChapter1 = new CourseChapter();
        courseChapter1.setPage(0);
        courseChapter1.setLimit(0);
        courseChapter1.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo1 = new CourseChapterVideo();
        courseChapterVideo1.setPage(0);
        courseChapterVideo1.setLimit(0);
        courseChapter1.setCourseChapterVideoList(Arrays.asList(courseChapterVideo1));
        courseChapter1.setId(0L);
        courseChapter1.setIsDelete(false);
        courseChapter1.setCourseId(0L);
        final List<CourseChapter> courseChapters = Arrays.asList(courseChapter1);
        final CourseChapter courseChapter2 = new CourseChapter();
        courseChapter2.setPage(0);
        courseChapter2.setLimit(0);
        courseChapter2.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo2 = new CourseChapterVideo();
        courseChapterVideo2.setPage(0);
        courseChapterVideo2.setLimit(0);
        courseChapter2.setCourseChapterVideoList(Arrays.asList(courseChapterVideo2));
        courseChapter2.setId(0L);
        courseChapter2.setIsDelete(false);
        courseChapter2.setCourseId(0L);
        when(mockCourseChapterMapper.list(courseChapter2)).thenReturn(courseChapters);

        // Run the test
        final Result result = courseChapterServiceImplUnderTest.list(courseChapter);

        // Verify the results
    }

    @Test
    public void testList_CourseChapterMapperReturnsNoItems() {
        // Setup
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        courseChapter.setId(0L);
        courseChapter.setIsDelete(false);
        courseChapter.setCourseId(0L);

        // Configure CourseChapterMapper.list(...).
        final CourseChapter courseChapter1 = new CourseChapter();
        courseChapter1.setPage(0);
        courseChapter1.setLimit(0);
        courseChapter1.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo1 = new CourseChapterVideo();
        courseChapterVideo1.setPage(0);
        courseChapterVideo1.setLimit(0);
        courseChapter1.setCourseChapterVideoList(Arrays.asList(courseChapterVideo1));
        courseChapter1.setId(0L);
        courseChapter1.setIsDelete(false);
        courseChapter1.setCourseId(0L);
        when(mockCourseChapterMapper.list(courseChapter1)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = courseChapterServiceImplUnderTest.list(courseChapter);

        // Verify the results
    }

    @Test
    public void testSelectByCourseId() {
        // Setup
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        courseChapter.setId(0L);
        courseChapter.setIsDelete(false);
        courseChapter.setCourseId(0L);
        final List<CourseChapter> expectedResult = Arrays.asList(courseChapter);

        // Configure CourseChapterMapper.selectByCourseId(...).
        final CourseChapter courseChapter1 = new CourseChapter();
        courseChapter1.setPage(0);
        courseChapter1.setLimit(0);
        courseChapter1.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo1 = new CourseChapterVideo();
        courseChapterVideo1.setPage(0);
        courseChapterVideo1.setLimit(0);
        courseChapter1.setCourseChapterVideoList(Arrays.asList(courseChapterVideo1));
        courseChapter1.setId(0L);
        courseChapter1.setIsDelete(false);
        courseChapter1.setCourseId(0L);
        final List<CourseChapter> courseChapters = Arrays.asList(courseChapter1);
        when(mockCourseChapterMapper.selectByCourseId(0L)).thenReturn(courseChapters);

        // Configure CourseChapterVideoService.selectByCourseChapterId(...).
        final CourseChapterVideo courseChapterVideo2 = new CourseChapterVideo();
        courseChapterVideo2.setPage(0);
        courseChapterVideo2.setLimit(0);
        courseChapterVideo2.setChapterNumber(0);
        courseChapterVideo2.setCourseChapterName("courseChapterName");
        courseChapterVideo2.setGraphicDetails("graphicDetails");
        final List<CourseChapterVideo> courseChapterVideos = Arrays.asList(courseChapterVideo2);
        when(mockCourseChapterVideoService.selectByCourseChapterId(0L)).thenReturn(courseChapterVideos);

        // Run the test
        final List<CourseChapter> result = courseChapterServiceImplUnderTest.selectByCourseId(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testSelectByCourseId_CourseChapterMapperReturnsNull() {
        // Setup
        when(mockCourseChapterMapper.selectByCourseId(0L)).thenReturn(null);

        // Run the test
        final List<CourseChapter> result = courseChapterServiceImplUnderTest.selectByCourseId(0L);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    public void testSelectByCourseId_CourseChapterMapperReturnsNoItems() {
        // Setup
        when(mockCourseChapterMapper.selectByCourseId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<CourseChapter> result = courseChapterServiceImplUnderTest.selectByCourseId(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testSelectByCourseId_CourseChapterVideoServiceReturnsNoItems() {
        // Setup
        // Configure CourseChapterMapper.selectByCourseId(...).
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        courseChapter.setId(0L);
        courseChapter.setIsDelete(false);
        courseChapter.setCourseId(0L);
        final List<CourseChapter> courseChapters = Arrays.asList(courseChapter);
        when(mockCourseChapterMapper.selectByCourseId(0L)).thenReturn(courseChapters);

        when(mockCourseChapterVideoService.selectByCourseChapterId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<CourseChapter> result = courseChapterServiceImplUnderTest.selectByCourseId(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure CourseChapterMapper.getByChapterIdAndNumber(...).
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        courseChapter.setId(0L);
        courseChapter.setIsDelete(false);
        courseChapter.setCourseId(0L);
        when(mockCourseChapterMapper.getByChapterIdAndNumber(0L, 0)).thenReturn(courseChapter);

        // Run the test
        final Result result = courseChapterServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testAdd() throws Exception {
        // Setup
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        courseChapter.setId(0L);
        courseChapter.setIsDelete(false);
        courseChapter.setCourseId(0L);

        // Configure CourseService.findByIdAndValidDelete(...).
        final Course course = new Course();
        course.setPage(0);
        course.setLimit(0);
        course.setPrice(new BigDecimal("0.00"));
        course.setViews(0);
        final CourseChapter courseChapter1 = new CourseChapter();
        course.setCourseChapterList(Arrays.asList(courseChapter1));
        when(mockCourseService.findByIdAndValidDelete(0L)).thenReturn(course);

        when(mockCourseChapterMapper.getCountByCourseId(0L)).thenReturn(0);

        // Run the test
        final Result result = courseChapterServiceImplUnderTest.add(courseChapter);

        // Verify the results
    }

    @Test
    public void testAdd_CourseServiceReturnsNull() {
        // Setup
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        courseChapter.setId(0L);
        courseChapter.setIsDelete(false);
        courseChapter.setCourseId(0L);

        when(mockCourseService.findByIdAndValidDelete(0L)).thenReturn(null);

        // Run the test
        final Result result = courseChapterServiceImplUnderTest.add(courseChapter);

        // Verify the results
    }

    @Test
    public void testAdd_CourseChapterMapperReturnsNull() {
        // Setup
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo));
        courseChapter.setId(0L);
        courseChapter.setIsDelete(false);
        courseChapter.setCourseId(0L);

        // Configure CourseService.findByIdAndValidDelete(...).
        final Course course = new Course();
        course.setPage(0);
        course.setLimit(0);
        course.setPrice(new BigDecimal("0.00"));
        course.setViews(0);
        final CourseChapter courseChapter1 = new CourseChapter();
        course.setCourseChapterList(Arrays.asList(courseChapter1));
        when(mockCourseService.findByIdAndValidDelete(0L)).thenReturn(course);

        when(mockCourseChapterMapper.getCountByCourseId(0L)).thenReturn(null);

        // Run the test
        final Result result = courseChapterServiceImplUnderTest.add(courseChapter);

        // Verify the results
    }
}
