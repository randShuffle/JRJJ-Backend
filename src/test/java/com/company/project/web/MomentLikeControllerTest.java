package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.model.MomentLike;
import com.company.project.service.MomentLikeService;
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
@WebMvcTest(MomentLikeController.class)
public class MomentLikeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MomentLikeService mockMomentLikeService;

    @Test
    public void testAddOrCancel() throws Exception {
        // Setup
        // Configure MomentLikeService.addOrCancel(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final MomentLike momentLike = new MomentLike();
        momentLike.setId(0L);
        momentLike.setCreatedBy("createdBy");
        momentLike.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike.setIsDelete(false);
        when(mockMomentLikeService.addOrCancel(momentLike)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/like/addOrCancel")
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
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/like/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm MomentLikeService.update(...).
        final MomentLike model = new MomentLike();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockMomentLikeService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/like/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm MomentLikeService.update(...).
        final MomentLike model = new MomentLike();
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockMomentLikeService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure MomentLikeService.findById(...).
        final MomentLike momentLike = new MomentLike();
        momentLike.setId(0L);
        momentLike.setCreatedBy("createdBy");
        momentLike.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike.setIsDelete(false);
        when(mockMomentLikeService.findById(0L)).thenReturn(momentLike);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/like/detail")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testDetail_MomentLikeServiceReturnsNull() throws Exception {
        // Setup
        when(mockMomentLikeService.findById(0L)).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/like/detail")
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
        // Configure MomentLikeService.list(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final MomentLike momentLike = new MomentLike();
        momentLike.setId(0L);
        momentLike.setCreatedBy("createdBy");
        momentLike.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentLike.setIsDelete(false);
        when(mockMomentLikeService.list(momentLike)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/like/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
