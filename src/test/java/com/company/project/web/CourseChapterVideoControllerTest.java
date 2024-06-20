package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.model.CourseChapterVideo;
import com.company.project.service.CourseChapterVideoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(CourseChapterVideoController.class)
public class CourseChapterVideoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseChapterVideoService mockCourseChapterVideoService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Configure CourseChapterVideoService.add(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setId(0L);
        courseChapterVideo.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        courseChapterVideo.setCreatedBy("createdBy");
        courseChapterVideo.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        courseChapterVideo.setIsDelete(false);
        when(mockCourseChapterVideoService.add(courseChapterVideo)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/chapter/video/add")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/chapter/video/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CourseChapterVideoService.update(...).
        final CourseChapterVideo model = new CourseChapterVideo();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCourseChapterVideoService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/chapter/video/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CourseChapterVideoService.update(...).
        final CourseChapterVideo model = new CourseChapterVideo();
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCourseChapterVideoService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure CourseChapterVideoService.detail(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        when(mockCourseChapterVideoService.detail(0L)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/chapter/video/detail")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testList() throws Exception {
        // Setup
        // Configure CourseChapterVideoService.list(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final CourseChapterVideo courseChapterVideo = new CourseChapterVideo();
        courseChapterVideo.setId(0L);
        courseChapterVideo.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        courseChapterVideo.setCreatedBy("createdBy");
        courseChapterVideo.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        courseChapterVideo.setIsDelete(false);
        when(mockCourseChapterVideoService.list(courseChapterVideo)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/chapter/video/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
