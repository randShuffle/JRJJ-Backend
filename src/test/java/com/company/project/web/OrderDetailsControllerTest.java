package com.company.project.web;

import com.company.project.model.OrderDetails;
import com.company.project.service.OrderDetailsService;
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
@WebMvcTest(OrderDetailsController.class)
public class OrderDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderDetailsService mockOrderDetailsService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/details/add")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm OrderDetailsService.save(...).
        final OrderDetails model = new OrderDetails();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockOrderDetailsService).save(model);
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/details/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm OrderDetailsService.update(...).
        final OrderDetails model = new OrderDetails();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockOrderDetailsService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/details/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm OrderDetailsService.update(...).
        final OrderDetails model = new OrderDetails();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockOrderDetailsService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure OrderDetailsService.findById(...).
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setId(0L);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        when(mockOrderDetailsService.findById(0L)).thenReturn(orderDetails);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/details/detail")
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
        // Configure OrderDetailsService.findByModel(...).
        final OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setPage(0);
        orderDetails1.setLimit(0);
        orderDetails1.setId(0L);
        orderDetails1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails1.setIsDelete(false);
        final List<OrderDetails> orderDetails = Arrays.asList(orderDetails1);
        final OrderDetails model = new OrderDetails();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockOrderDetailsService.findByModel(model)).thenReturn(orderDetails);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/details/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testList_OrderDetailsServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure OrderDetailsService.findByModel(...).
        final OrderDetails model = new OrderDetails();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockOrderDetailsService.findByModel(model)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/details/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
