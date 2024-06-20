package com.company.project.web;

import com.company.project.model.CollectionList;
import com.company.project.service.CollectionListService;
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
@WebMvcTest(CollectionListController.class)
public class CollectionListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CollectionListService mockCollectionListService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/collection/list/add")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CollectionListService.save(...).
        final CollectionList model = new CollectionList();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCollectionListService).save(model);
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/collection/list/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CollectionListService.update(...).
        final CollectionList model = new CollectionList();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCollectionListService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/collection/list/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm CollectionListService.update(...).
        final CollectionList model = new CollectionList();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockCollectionListService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure CollectionListService.findById(...).
        final CollectionList collectionList = new CollectionList();
        collectionList.setPage(0);
        collectionList.setLimit(0);
        collectionList.setId(0L);
        collectionList.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setCreatedBy("createdBy");
        collectionList.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setIsDelete(false);
        when(mockCollectionListService.findById(0L)).thenReturn(collectionList);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/collection/list/detail")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testDetail_CollectionListServiceReturnsNull() throws Exception {
        // Setup
        when(mockCollectionListService.findById(0L)).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/collection/list/detail")
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
        // Configure CollectionListService.findByModel(...).
        final CollectionList collectionList = new CollectionList();
        collectionList.setPage(0);
        collectionList.setLimit(0);
        collectionList.setId(0L);
        collectionList.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setCreatedBy("createdBy");
        collectionList.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        collectionList.setIsDelete(false);
        final List<CollectionList> collectionLists = Arrays.asList(collectionList);
        final CollectionList model = new CollectionList();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockCollectionListService.findByModel(model)).thenReturn(collectionLists);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/collection/list/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testList_CollectionListServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure CollectionListService.findByModel(...).
        final CollectionList model = new CollectionList();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setCreatedBy("createdBy");
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockCollectionListService.findByModel(model)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/collection/list/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
