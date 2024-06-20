package com.company.project.web;

import com.company.project.model.LeaveMessage;
import com.company.project.service.LeaveMessageService;
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

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(LeaveMessageController.class)
public class LeaveMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LeaveMessageService mockLeaveMessageService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/leave/message/add")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm LeaveMessageService.save(...).
        final LeaveMessage model = new LeaveMessage();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockLeaveMessageService).save(model);
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/leave/message/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm LeaveMessageService.update(...).
        final LeaveMessage model = new LeaveMessage();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockLeaveMessageService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/leave/message/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm LeaveMessageService.update(...).
        final LeaveMessage model = new LeaveMessage();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockLeaveMessageService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure LeaveMessageService.findById(...).
        final LeaveMessage leaveMessage = new LeaveMessage();
        leaveMessage.setPage(0);
        leaveMessage.setLimit(0);
        leaveMessage.setId(0L);
        leaveMessage.setCreatedBy("createdBy");
        leaveMessage.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage.setIsDelete(false);
        when(mockLeaveMessageService.findById(0L)).thenReturn(leaveMessage);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/leave/message/detail")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testDetail_LeaveMessageServiceReturnsNull() throws Exception {
        // Setup
        when(mockLeaveMessageService.findById(0L)).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/leave/message/detail")
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
        // Configure LeaveMessageService.findByModel(...).
        final LeaveMessage leaveMessage = new LeaveMessage();
        leaveMessage.setPage(0);
        leaveMessage.setLimit(0);
        leaveMessage.setId(0L);
        leaveMessage.setCreatedBy("createdBy");
        leaveMessage.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        leaveMessage.setIsDelete(false);
        final List<LeaveMessage> leaveMessages = Arrays.asList(leaveMessage);
        final LeaveMessage model = new LeaveMessage();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockLeaveMessageService.findByModel(model)).thenReturn(leaveMessages);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/leave/message/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testList_LeaveMessageServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure LeaveMessageService.findByModel(...).
        final LeaveMessage model = new LeaveMessage();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockLeaveMessageService.findByModel(model)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/leave/message/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
