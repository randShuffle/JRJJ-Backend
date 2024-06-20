package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.model.MomentComment;
import com.company.project.service.MomentCommentService;
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

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(MomentCommentController.class)
public class MomentCommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MomentCommentService mockMomentCommentService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Configure MomentCommentService.add(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final MomentComment momentComment = new MomentComment();
        momentComment.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment.setId(0L);
        momentComment.setCreatedBy("createdBy");
        momentComment.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment.setIsDelete(false);
        when(mockMomentCommentService.add(momentComment)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/comment/add")
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
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/comment/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm MomentCommentService.update(...).
        final MomentComment model = new MomentComment();
        model.setChildrenList(Arrays.asList(new MomentComment()));
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockMomentCommentService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/comment/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm MomentCommentService.update(...).
        final MomentComment model = new MomentComment();
        model.setChildrenList(Arrays.asList(new MomentComment()));
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockMomentCommentService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure MomentCommentService.detail(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        when(mockMomentCommentService.detail(0L)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/comment/detail")
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
        // Configure MomentCommentService.list(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final MomentComment momentComment = new MomentComment();
        momentComment.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment.setId(0L);
        momentComment.setCreatedBy("createdBy");
        momentComment.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment.setIsDelete(false);
        when(mockMomentCommentService.list(momentComment)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/moment/comment/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
