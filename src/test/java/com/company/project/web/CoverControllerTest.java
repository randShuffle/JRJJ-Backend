package com.company.project.web;

import com.company.project.model.Cover;
import com.company.project.service.CoverService;
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
@WebMvcTest(CoverController.class)
public class CoverControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoverService mockCoverService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/cover/add")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CoverService.save(...).
        final Cover model = new Cover();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCoverService).save(model);
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/cover/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CoverService.update(...).
        final Cover model = new Cover();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCoverService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/cover/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CoverService.update(...).
        final Cover model = new Cover();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCoverService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure CoverService.findById(...).
        final Cover cover = new Cover();
        cover.setPage(0);
        cover.setLimit(0);
        cover.setId(0L);
        cover.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover.setIsDelete(false);
        when(mockCoverService.findById(0L)).thenReturn(cover);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/cover/detail")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testDetail_CoverServiceReturnsNull() throws Exception {
        // Setup
        when(mockCoverService.findById(0L)).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/cover/detail")
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
        // Configure CoverService.findByModel(...).
        final Cover cover = new Cover();
        cover.setPage(0);
        cover.setLimit(0);
        cover.setId(0L);
        cover.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        cover.setIsDelete(false);
        final List<Cover> covers = Arrays.asList(cover);
        final Cover model = new Cover();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockCoverService.findByModel(model)).thenReturn(covers);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/cover/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testList_CoverServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure CoverService.findByModel(...).
        final Cover model = new Cover();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockCoverService.findByModel(model)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/cover/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
