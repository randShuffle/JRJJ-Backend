package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.model.Order;
import com.company.project.service.OrderService;
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

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService mockOrderService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Configure OrderService.add(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final Order order = new Order();
        order.setDiscountCouponPrice(new BigDecimal("0.00"));
        order.setId(0L);
        order.setCreatedBy("createdBy");
        order.setIsDelete(false);
        order.setStatus(0);
        when(mockOrderService.add(order)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/add")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testAliPay() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/order/aliPay")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockOrderService).aliPay(any(HttpServletResponse.class));
    }

    @Test
    public void testWapPay() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/order/wapPay")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockOrderService).wapPay(any(HttpServletResponse.class));
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm OrderService.update(...).
        final Order model = new Order();
        model.setDiscountCouponPrice(new BigDecimal("0.00"));
        model.setId(0L);
        model.setCreatedBy("createdBy");
        model.setIsDelete(false);
        model.setStatus(0);
        verify(mockOrderService).update(model);
    }

    @Test
    public void testUpdateGoods() throws Exception {
        // Setup
        // Configure OrderService.updateGoods(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final Order order = new Order();
        order.setDiscountCouponPrice(new BigDecimal("0.00"));
        order.setId(0L);
        order.setCreatedBy("createdBy");
        order.setIsDelete(false);
        order.setStatus(0);
        when(mockOrderService.updateGoods(order)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/updateGoods")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure OrderService.detail(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        when(mockOrderService.detail(0L)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/detail")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testPay() throws Exception {
        // Setup
        // Configure OrderService.pay(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        when(mockOrderService.pay("out_trade_no")).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/order/ali/pay/notify/url")
                        .param("out_trade_no", "out_trade_no")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testList() throws Exception {
        // Setup
        // Configure OrderService.list(...).
        final Result result1 = new Result<>();
        result1.setCode(ResultCode.SUCCESS);
        result1.setMessage("message");
        result1.setData(null);
        result1.setStatus(false);
        final Order order = new Order();
        order.setDiscountCouponPrice(new BigDecimal("0.00"));
        order.setId(0L);
        order.setCreatedBy("createdBy");
        order.setIsDelete(false);
        order.setStatus(0);
        when(mockOrderService.list(order)).thenReturn(result1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/order/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
