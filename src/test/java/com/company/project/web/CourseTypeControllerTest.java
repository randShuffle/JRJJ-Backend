package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.model.CourseType;
import com.company.project.service.CourseTypeService;
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
@WebMvcTest(CourseTypeController.class)
public class CourseTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseTypeService mockCourseTypeService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/type/add")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CourseTypeService.save(...).
        final CourseType model = new CourseType();
        model.setImgUrl("imgUrl");
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCourseTypeService).save(model);
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/type/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CourseTypeService.update(...).
        final CourseType model = new CourseType();
        model.setImgUrl("imgUrl");
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCourseTypeService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/type/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CourseTypeService.update(...).
        final CourseType model = new CourseType();
        model.setImgUrl("imgUrl");
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCourseTypeService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure CourseTypeService.findById(...).
        final CourseType courseType = new CourseType();
        courseType.setImgUrl("imgUrl");
        courseType.setId(0L);
        courseType.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        courseType.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        courseType.setIsDelete(false);
        when(mockCourseTypeService.findById(0L)).thenReturn(courseType);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/type/detail")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testDetail_CourseTypeServiceReturnsNull() throws Exception {
        // Setup
        when(mockCourseTypeService.findById(0L)).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/type/detail")
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
        // Configure CourseTypeService.list(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final CourseType courseType = new CourseType();
        courseType.setImgUrl("imgUrl");
        courseType.setId(0L);
        courseType.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        courseType.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        courseType.setIsDelete(false);
        when(mockCourseTypeService.list(courseType)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/course/type/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
