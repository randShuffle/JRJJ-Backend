package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.CourseChapterVideoMapper;
import com.company.project.model.CourseChapter;
import com.company.project.model.CourseChapterVideo;
import com.company.project.service.CourseChapterService;
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
public class CourseChapterVideoServiceImplTest {

    @Mock
    private CourseChapterVideoMapper mockCourseChapterVideoMapper;
    @Mock
    private CourseChapterService mockCourseChapterService;

    @InjectMocks
    private CourseChapterVideoServiceImpl courseChapterVideoServiceImplUnderTest;

    @Test
    public void testList() throws Exception {
        // Setup
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapterVideo.setChapterNumber(0);
        courseChapterVideo.setIsDelete(false);
        courseChapterVideo.setCourseChapterId(0L);

        // Configure CourseChapterVideoMapper.list(...).
        final CourseChapterVideo courseChapterVideo1 = new CourseChapterVideo();
        courseChapterVideo1.setPage(0);
        courseChapterVideo1.setLimit(0);
        courseChapterVideo1.setChapterNumber(0);
        courseChapterVideo1.setIsDelete(false);
        courseChapterVideo1.setCourseChapterId(0L);
        final List<CourseChapterVideo> courseChapterVideos = Arrays.asList(courseChapterVideo1);
        final CourseChapterVideo courseChapterVideo2 = new CourseChapterVideo();
        courseChapterVideo2.setPage(0);
        courseChapterVideo2.setLimit(0);
        courseChapterVideo2.setChapterNumber(0);
        courseChapterVideo2.setIsDelete(false);
        courseChapterVideo2.setCourseChapterId(0L);
        when(mockCourseChapterVideoMapper.list(courseChapterVideo2)).thenReturn(courseChapterVideos);

        // Run the test
        final Result result = courseChapterVideoServiceImplUnderTest.list(courseChapterVideo);

        // Verify the results
    }

    @Test
    public void testList_CourseChapterVideoMapperReturnsNoItems() {
        // Setup
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapterVideo.setChapterNumber(0);
        courseChapterVideo.setIsDelete(false);
        courseChapterVideo.setCourseChapterId(0L);

        // Configure CourseChapterVideoMapper.list(...).
        final CourseChapterVideo courseChapterVideo1 = new CourseChapterVideo();
        courseChapterVideo1.setPage(0);
        courseChapterVideo1.setLimit(0);
        courseChapterVideo1.setChapterNumber(0);
        courseChapterVideo1.setIsDelete(false);
        courseChapterVideo1.setCourseChapterId(0L);
        when(mockCourseChapterVideoMapper.list(courseChapterVideo1)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = courseChapterVideoServiceImplUnderTest.list(courseChapterVideo);

        // Verify the results
    }

    @Test
    public void testSelectByCourseChapterId() {
        // Setup
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapterVideo.setChapterNumber(0);
        courseChapterVideo.setIsDelete(false);
        courseChapterVideo.setCourseChapterId(0L);
        final List<CourseChapterVideo> expectedResult = Arrays.asList(courseChapterVideo);

        // Configure CourseChapterVideoMapper.selectByCourseChapterId(...).
        final CourseChapterVideo courseChapterVideo1 = new CourseChapterVideo();
        courseChapterVideo1.setPage(0);
        courseChapterVideo1.setLimit(0);
        courseChapterVideo1.setChapterNumber(0);
        courseChapterVideo1.setIsDelete(false);
        courseChapterVideo1.setCourseChapterId(0L);
        final List<CourseChapterVideo> courseChapterVideos = Arrays.asList(courseChapterVideo1);
        when(mockCourseChapterVideoMapper.selectByCourseChapterId(0L)).thenReturn(courseChapterVideos);

        // Run the test
        final List<CourseChapterVideo> result = courseChapterVideoServiceImplUnderTest.selectByCourseChapterId(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testSelectByCourseChapterId_CourseChapterVideoMapperReturnsNoItems() {
        // Setup
        when(mockCourseChapterVideoMapper.selectByCourseChapterId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<CourseChapterVideo> result = courseChapterVideoServiceImplUnderTest.selectByCourseChapterId(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure CourseChapterVideoMapper.detail(...).
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapterVideo.setChapterNumber(0);
        courseChapterVideo.setIsDelete(false);
        courseChapterVideo.setCourseChapterId(0L);
        when(mockCourseChapterVideoMapper.detail(0L)).thenReturn(courseChapterVideo);

        // Configure CourseChapterVideoMapper.getByChapterIdAndNumber(...).
        final CourseChapterVideo courseChapterVideo1 = new CourseChapterVideo();
        courseChapterVideo1.setPage(0);
        courseChapterVideo1.setLimit(0);
        courseChapterVideo1.setChapterNumber(0);
        courseChapterVideo1.setIsDelete(false);
        courseChapterVideo1.setCourseChapterId(0L);
        when(mockCourseChapterVideoMapper.getByChapterIdAndNumber(0L, 0)).thenReturn(courseChapterVideo1);

        // Run the test
        final Result result = courseChapterVideoServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testDetail_CourseChapterVideoMapperDetailReturnsNull() {
        // Setup
        when(mockCourseChapterVideoMapper.detail(0L)).thenReturn(null);

        // Run the test
        final Result result = courseChapterVideoServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testAdd() throws Exception {
        // Setup
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapterVideo.setChapterNumber(0);
        courseChapterVideo.setIsDelete(false);
        courseChapterVideo.setCourseChapterId(0L);

        // Configure CourseChapterService.findByIdAndValidDelete(...).
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo1 = new CourseChapterVideo();
        courseChapterVideo1.setChapterNumber(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo1));
        when(mockCourseChapterService.findByIdAndValidDelete(0L)).thenReturn(courseChapter);

        when(mockCourseChapterVideoMapper.getCountByChapterVideoId(0L)).thenReturn(0);

        // Run the test
        final Result result = courseChapterVideoServiceImplUnderTest.add(courseChapterVideo);

        // Verify the results
    }

    @Test
    public void testAdd_CourseChapterServiceReturnsNull() {
        // Setup
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapterVideo.setChapterNumber(0);
        courseChapterVideo.setIsDelete(false);
        courseChapterVideo.setCourseChapterId(0L);

        when(mockCourseChapterService.findByIdAndValidDelete(0L)).thenReturn(null);

        // Run the test
        final Result result = courseChapterVideoServiceImplUnderTest.add(courseChapterVideo);

        // Verify the results
    }

    @Test
    public void testAdd_CourseChapterVideoMapperReturnsNull() {
        // Setup
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setPage(0);
        courseChapterVideo.setLimit(0);
        courseChapterVideo.setChapterNumber(0);
        courseChapterVideo.setIsDelete(false);
        courseChapterVideo.setCourseChapterId(0L);

        // Configure CourseChapterService.findByIdAndValidDelete(...).
        final CourseChapter courseChapter = new CourseChapter();
        courseChapter.setPage(0);
        courseChapter.setLimit(0);
        courseChapter.setChapterNumber(0);
        final CourseChapterVideo courseChapterVideo1 = new CourseChapterVideo();
        courseChapterVideo1.setChapterNumber(0);
        courseChapter.setCourseChapterVideoList(Arrays.asList(courseChapterVideo1));
        when(mockCourseChapterService.findByIdAndValidDelete(0L)).thenReturn(courseChapter);

        when(mockCourseChapterVideoMapper.getCountByChapterVideoId(0L)).thenReturn(null);

        // Run the test
        final Result result = courseChapterVideoServiceImplUnderTest.add(courseChapterVideo);

        // Verify the results
    }
}
