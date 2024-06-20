package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.OrderMapper;
import com.company.project.model.MomentComment;
import com.company.project.model.Order;
import com.company.project.model.OrderDetails;
import com.company.project.model.User;
import com.company.project.service.MomentCommentService;
import com.company.project.service.OrderDetailsService;
import com.company.project.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletResponse;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    @Mock
    private OrderMapper mockOrderMapper;
    @Mock
    private OrderDetailsService mockOrderDetailsService;
    @Mock
    private UserService mockUserService;
    @Mock
    private MomentCommentService mockMomentCommentService;

    @InjectMocks
    private OrderServiceImpl orderServiceImplUnderTest;

    @Test
    public void testGetTotalMoney() {
        assertThat(orderServiceImplUnderTest.getTotalMoney(0L)).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void testGetNumber() {
        // Setup
        when(mockOrderMapper.getNumber(0L)).thenReturn(0);

        // Run the test
        final Integer result = orderServiceImplUnderTest.getNumber(0L);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testPay() {
        // Setup
        // Run the test
        final Result result = orderServiceImplUnderTest.pay("id");

        // Verify the results
    }

    @Test
    public void testAdd() throws Exception {
        // Setup
        final Order order = new Order();
        order.setPage(0);
        order.setLimit(0);
        order.setTotalMoney(new BigDecimal("0.00"));
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setRoleId(0L);
        order.setUser(user);
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        orderDetails.setOrderId(0L);
        order.setOrderDetailsList(Arrays.asList(orderDetails));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        order.setMomentCommentList(Arrays.asList(momentComment));
        order.setId(0L);
        order.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setCreatedBy("createdBy");
        order.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setIsDelete(false);
        order.setStatus(0);

        // Run the test
        final Result result = orderServiceImplUnderTest.add(order);

        // Verify the results
        // Confirm OrderDetailsService.save(...).
        final OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setPage(0);
        orderDetails1.setLimit(0);
        orderDetails1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails1.setIsDelete(false);
        orderDetails1.setOrderId(0L);
        final List<OrderDetails> models = Arrays.asList(orderDetails1);
        verify(mockOrderDetailsService).save(models);
    }

    @Test
    public void testAliPay() {
        // Setup
        final MockHttpServletResponse httpResponse = new MockHttpServletResponse();

        // Run the test
        orderServiceImplUnderTest.aliPay(httpResponse);

        // Verify the results
    }

    @Test
    public void testWapPay() {
        // Setup
        final MockHttpServletResponse httpResponse = new MockHttpServletResponse();

        // Run the test
        orderServiceImplUnderTest.wapPay(httpResponse);

        // Verify the results
    }

    @Test
    public void testList() throws Exception {
        // Setup
        final Order order = new Order();
        order.setPage(0);
        order.setLimit(0);
        order.setTotalMoney(new BigDecimal("0.00"));
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setRoleId(0L);
        order.setUser(user);
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        orderDetails.setOrderId(0L);
        order.setOrderDetailsList(Arrays.asList(orderDetails));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        order.setMomentCommentList(Arrays.asList(momentComment));
        order.setId(0L);
        order.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setCreatedBy("createdBy");
        order.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setIsDelete(false);
        order.setStatus(0);

        // Configure UserService.findByIdAndValidDelete(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setRoleId(0L);
        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(user1);

        // Configure OrderMapper.list(...).
        final Order order1 = new Order();
        order1.setPage(0);
        order1.setLimit(0);
        order1.setTotalMoney(new BigDecimal("0.00"));
        final User user2 = new User();
        user2.setPage(0);
        user2.setLimit(0);
        user2.setRoleId(0L);
        order1.setUser(user2);
        final OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setPage(0);
        orderDetails1.setLimit(0);
        orderDetails1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails1.setIsDelete(false);
        orderDetails1.setOrderId(0L);
        order1.setOrderDetailsList(Arrays.asList(orderDetails1));
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        order1.setMomentCommentList(Arrays.asList(momentComment1));
        order1.setId(0L);
        order1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setCreatedBy("createdBy");
        order1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setIsDelete(false);
        order1.setStatus(0);
        final List<Order> orders = Arrays.asList(order1);
        final Order order2 = new Order();
        order2.setPage(0);
        order2.setLimit(0);
        order2.setTotalMoney(new BigDecimal("0.00"));
        final User user3 = new User();
        user3.setPage(0);
        user3.setLimit(0);
        user3.setRoleId(0L);
        order2.setUser(user3);
        final OrderDetails orderDetails2 = new OrderDetails();
        orderDetails2.setPage(0);
        orderDetails2.setLimit(0);
        orderDetails2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails2.setIsDelete(false);
        orderDetails2.setOrderId(0L);
        order2.setOrderDetailsList(Arrays.asList(orderDetails2));
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        order2.setMomentCommentList(Arrays.asList(momentComment2));
        order2.setId(0L);
        order2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order2.setCreatedBy("createdBy");
        order2.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order2.setIsDelete(false);
        order2.setStatus(0);
        when(mockOrderMapper.list(order2)).thenReturn(orders);

        // Configure OrderDetailsService.selectByOrderId(...).
        final OrderDetails orderDetails4 = new OrderDetails();
        orderDetails4.setPage(0);
        orderDetails4.setLimit(0);
        orderDetails4.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails4.setIsDelete(false);
        orderDetails4.setOrderId(0L);
        final List<OrderDetails> orderDetails3 = Arrays.asList(orderDetails4);
        when(mockOrderDetailsService.selectByOrderId(0L)).thenReturn(orderDetails3);

        // Configure MomentCommentService.selectByMomentId(...).
        final MomentComment momentComment3 = new MomentComment();
        momentComment3.setPage(0);
        momentComment3.setLimit(0);
        momentComment3.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment3.setImgUrl("imgUrl");
        momentComment3.setTitle("title");
        final List<MomentComment> momentComments = Arrays.asList(momentComment3);
        when(mockMomentCommentService.selectByMomentId(0L)).thenReturn(momentComments);

        // Run the test
        final Result result = orderServiceImplUnderTest.list(order);

        // Verify the results
    }

    @Test
    public void testList_UserServiceReturnsNull() {
        // Setup
        final Order order = new Order();
        order.setPage(0);
        order.setLimit(0);
        order.setTotalMoney(new BigDecimal("0.00"));
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setRoleId(0L);
        order.setUser(user);
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        orderDetails.setOrderId(0L);
        order.setOrderDetailsList(Arrays.asList(orderDetails));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        order.setMomentCommentList(Arrays.asList(momentComment));
        order.setId(0L);
        order.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setCreatedBy("createdBy");
        order.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setIsDelete(false);
        order.setStatus(0);

        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(null);

        // Configure OrderMapper.list(...).
        final Order order1 = new Order();
        order1.setPage(0);
        order1.setLimit(0);
        order1.setTotalMoney(new BigDecimal("0.00"));
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setRoleId(0L);
        order1.setUser(user1);
        final OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setPage(0);
        orderDetails1.setLimit(0);
        orderDetails1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails1.setIsDelete(false);
        orderDetails1.setOrderId(0L);
        order1.setOrderDetailsList(Arrays.asList(orderDetails1));
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        order1.setMomentCommentList(Arrays.asList(momentComment1));
        order1.setId(0L);
        order1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setCreatedBy("createdBy");
        order1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setIsDelete(false);
        order1.setStatus(0);
        final List<Order> orders = Arrays.asList(order1);
        final Order order2 = new Order();
        order2.setPage(0);
        order2.setLimit(0);
        order2.setTotalMoney(new BigDecimal("0.00"));
        final User user2 = new User();
        user2.setPage(0);
        user2.setLimit(0);
        user2.setRoleId(0L);
        order2.setUser(user2);
        final OrderDetails orderDetails2 = new OrderDetails();
        orderDetails2.setPage(0);
        orderDetails2.setLimit(0);
        orderDetails2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails2.setIsDelete(false);
        orderDetails2.setOrderId(0L);
        order2.setOrderDetailsList(Arrays.asList(orderDetails2));
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        order2.setMomentCommentList(Arrays.asList(momentComment2));
        order2.setId(0L);
        order2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order2.setCreatedBy("createdBy");
        order2.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order2.setIsDelete(false);
        order2.setStatus(0);
        when(mockOrderMapper.list(order2)).thenReturn(orders);

        // Configure OrderDetailsService.selectByOrderId(...).
        final OrderDetails orderDetails4 = new OrderDetails();
        orderDetails4.setPage(0);
        orderDetails4.setLimit(0);
        orderDetails4.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails4.setIsDelete(false);
        orderDetails4.setOrderId(0L);
        final List<OrderDetails> orderDetails3 = Arrays.asList(orderDetails4);
        when(mockOrderDetailsService.selectByOrderId(0L)).thenReturn(orderDetails3);

        // Configure MomentCommentService.selectByMomentId(...).
        final MomentComment momentComment3 = new MomentComment();
        momentComment3.setPage(0);
        momentComment3.setLimit(0);
        momentComment3.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment3.setImgUrl("imgUrl");
        momentComment3.setTitle("title");
        final List<MomentComment> momentComments = Arrays.asList(momentComment3);
        when(mockMomentCommentService.selectByMomentId(0L)).thenReturn(momentComments);

        // Run the test
        final Result result = orderServiceImplUnderTest.list(order);

        // Verify the results
    }

    @Test
    public void testList_OrderMapperReturnsNoItems() {
        // Setup
        final Order order = new Order();
        order.setPage(0);
        order.setLimit(0);
        order.setTotalMoney(new BigDecimal("0.00"));
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setRoleId(0L);
        order.setUser(user);
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        orderDetails.setOrderId(0L);
        order.setOrderDetailsList(Arrays.asList(orderDetails));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        order.setMomentCommentList(Arrays.asList(momentComment));
        order.setId(0L);
        order.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setCreatedBy("createdBy");
        order.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setIsDelete(false);
        order.setStatus(0);

        // Configure UserService.findByIdAndValidDelete(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setRoleId(0L);
        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(user1);

        // Configure OrderMapper.list(...).
        final Order order1 = new Order();
        order1.setPage(0);
        order1.setLimit(0);
        order1.setTotalMoney(new BigDecimal("0.00"));
        final User user2 = new User();
        user2.setPage(0);
        user2.setLimit(0);
        user2.setRoleId(0L);
        order1.setUser(user2);
        final OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setPage(0);
        orderDetails1.setLimit(0);
        orderDetails1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails1.setIsDelete(false);
        orderDetails1.setOrderId(0L);
        order1.setOrderDetailsList(Arrays.asList(orderDetails1));
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        order1.setMomentCommentList(Arrays.asList(momentComment1));
        order1.setId(0L);
        order1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setCreatedBy("createdBy");
        order1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setIsDelete(false);
        order1.setStatus(0);
        when(mockOrderMapper.list(order1)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = orderServiceImplUnderTest.list(order);

        // Verify the results
    }

    @Test
    public void testList_OrderDetailsServiceReturnsNoItems() {
        // Setup
        final Order order = new Order();
        order.setPage(0);
        order.setLimit(0);
        order.setTotalMoney(new BigDecimal("0.00"));
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setRoleId(0L);
        order.setUser(user);
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        orderDetails.setOrderId(0L);
        order.setOrderDetailsList(Arrays.asList(orderDetails));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        order.setMomentCommentList(Arrays.asList(momentComment));
        order.setId(0L);
        order.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setCreatedBy("createdBy");
        order.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setIsDelete(false);
        order.setStatus(0);

        // Configure UserService.findByIdAndValidDelete(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setRoleId(0L);
        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(user1);

        // Configure OrderMapper.list(...).
        final Order order1 = new Order();
        order1.setPage(0);
        order1.setLimit(0);
        order1.setTotalMoney(new BigDecimal("0.00"));
        final User user2 = new User();
        user2.setPage(0);
        user2.setLimit(0);
        user2.setRoleId(0L);
        order1.setUser(user2);
        final OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setPage(0);
        orderDetails1.setLimit(0);
        orderDetails1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails1.setIsDelete(false);
        orderDetails1.setOrderId(0L);
        order1.setOrderDetailsList(Arrays.asList(orderDetails1));
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        order1.setMomentCommentList(Arrays.asList(momentComment1));
        order1.setId(0L);
        order1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setCreatedBy("createdBy");
        order1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setIsDelete(false);
        order1.setStatus(0);
        final List<Order> orders = Arrays.asList(order1);
        final Order order2 = new Order();
        order2.setPage(0);
        order2.setLimit(0);
        order2.setTotalMoney(new BigDecimal("0.00"));
        final User user3 = new User();
        user3.setPage(0);
        user3.setLimit(0);
        user3.setRoleId(0L);
        order2.setUser(user3);
        final OrderDetails orderDetails2 = new OrderDetails();
        orderDetails2.setPage(0);
        orderDetails2.setLimit(0);
        orderDetails2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails2.setIsDelete(false);
        orderDetails2.setOrderId(0L);
        order2.setOrderDetailsList(Arrays.asList(orderDetails2));
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        order2.setMomentCommentList(Arrays.asList(momentComment2));
        order2.setId(0L);
        order2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order2.setCreatedBy("createdBy");
        order2.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order2.setIsDelete(false);
        order2.setStatus(0);
        when(mockOrderMapper.list(order2)).thenReturn(orders);

        when(mockOrderDetailsService.selectByOrderId(0L)).thenReturn(Collections.emptyList());

        // Configure MomentCommentService.selectByMomentId(...).
        final MomentComment momentComment3 = new MomentComment();
        momentComment3.setPage(0);
        momentComment3.setLimit(0);
        momentComment3.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment3.setImgUrl("imgUrl");
        momentComment3.setTitle("title");
        final List<MomentComment> momentComments = Arrays.asList(momentComment3);
        when(mockMomentCommentService.selectByMomentId(0L)).thenReturn(momentComments);

        // Run the test
        final Result result = orderServiceImplUnderTest.list(order);

        // Verify the results
    }

    @Test
    public void testList_MomentCommentServiceReturnsNoItems() {
        // Setup
        final Order order = new Order();
        order.setPage(0);
        order.setLimit(0);
        order.setTotalMoney(new BigDecimal("0.00"));
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setRoleId(0L);
        order.setUser(user);
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        orderDetails.setOrderId(0L);
        order.setOrderDetailsList(Arrays.asList(orderDetails));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        order.setMomentCommentList(Arrays.asList(momentComment));
        order.setId(0L);
        order.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setCreatedBy("createdBy");
        order.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setIsDelete(false);
        order.setStatus(0);

        // Configure UserService.findByIdAndValidDelete(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setRoleId(0L);
        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(user1);

        // Configure OrderMapper.list(...).
        final Order order1 = new Order();
        order1.setPage(0);
        order1.setLimit(0);
        order1.setTotalMoney(new BigDecimal("0.00"));
        final User user2 = new User();
        user2.setPage(0);
        user2.setLimit(0);
        user2.setRoleId(0L);
        order1.setUser(user2);
        final OrderDetails orderDetails1 = new OrderDetails();
        orderDetails1.setPage(0);
        orderDetails1.setLimit(0);
        orderDetails1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails1.setIsDelete(false);
        orderDetails1.setOrderId(0L);
        order1.setOrderDetailsList(Arrays.asList(orderDetails1));
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        order1.setMomentCommentList(Arrays.asList(momentComment1));
        order1.setId(0L);
        order1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setCreatedBy("createdBy");
        order1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order1.setIsDelete(false);
        order1.setStatus(0);
        final List<Order> orders = Arrays.asList(order1);
        final Order order2 = new Order();
        order2.setPage(0);
        order2.setLimit(0);
        order2.setTotalMoney(new BigDecimal("0.00"));
        final User user3 = new User();
        user3.setPage(0);
        user3.setLimit(0);
        user3.setRoleId(0L);
        order2.setUser(user3);
        final OrderDetails orderDetails2 = new OrderDetails();
        orderDetails2.setPage(0);
        orderDetails2.setLimit(0);
        orderDetails2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails2.setIsDelete(false);
        orderDetails2.setOrderId(0L);
        order2.setOrderDetailsList(Arrays.asList(orderDetails2));
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        order2.setMomentCommentList(Arrays.asList(momentComment2));
        order2.setId(0L);
        order2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order2.setCreatedBy("createdBy");
        order2.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order2.setIsDelete(false);
        order2.setStatus(0);
        when(mockOrderMapper.list(order2)).thenReturn(orders);

        // Configure OrderDetailsService.selectByOrderId(...).
        final OrderDetails orderDetails4 = new OrderDetails();
        orderDetails4.setPage(0);
        orderDetails4.setLimit(0);
        orderDetails4.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails4.setIsDelete(false);
        orderDetails4.setOrderId(0L);
        final List<OrderDetails> orderDetails3 = Arrays.asList(orderDetails4);
        when(mockOrderDetailsService.selectByOrderId(0L)).thenReturn(orderDetails3);

        when(mockMomentCommentService.selectByMomentId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = orderServiceImplUnderTest.list(order);

        // Verify the results
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure OrderMapper.detail(...).
        final Order order = new Order();
        order.setPage(0);
        order.setLimit(0);
        order.setTotalMoney(new BigDecimal("0.00"));
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setRoleId(0L);
        order.setUser(user);
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        orderDetails.setOrderId(0L);
        order.setOrderDetailsList(Arrays.asList(orderDetails));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        order.setMomentCommentList(Arrays.asList(momentComment));
        order.setId(0L);
        order.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setCreatedBy("createdBy");
        order.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setIsDelete(false);
        order.setStatus(0);
        when(mockOrderMapper.detail(0L)).thenReturn(order);

        // Configure OrderDetailsService.selectByOrderId(...).
        final OrderDetails orderDetails2 = new OrderDetails();
        orderDetails2.setPage(0);
        orderDetails2.setLimit(0);
        orderDetails2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails2.setIsDelete(false);
        orderDetails2.setOrderId(0L);
        final List<OrderDetails> orderDetails1 = Arrays.asList(orderDetails2);
        when(mockOrderDetailsService.selectByOrderId(0L)).thenReturn(orderDetails1);

        // Configure UserService.findByIdAndValidDelete(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setRoleId(0L);
        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(user1);

        // Run the test
        final Result result = orderServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testDetail_OrderMapperReturnsNull() {
        // Setup
        when(mockOrderMapper.detail(0L)).thenReturn(null);

        // Run the test
        final Result result = orderServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testDetail_OrderDetailsServiceReturnsNoItems() {
        // Setup
        // Configure OrderMapper.detail(...).
        final Order order = new Order();
        order.setPage(0);
        order.setLimit(0);
        order.setTotalMoney(new BigDecimal("0.00"));
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setRoleId(0L);
        order.setUser(user);
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        orderDetails.setOrderId(0L);
        order.setOrderDetailsList(Arrays.asList(orderDetails));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        order.setMomentCommentList(Arrays.asList(momentComment));
        order.setId(0L);
        order.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setCreatedBy("createdBy");
        order.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setIsDelete(false);
        order.setStatus(0);
        when(mockOrderMapper.detail(0L)).thenReturn(order);

        when(mockOrderDetailsService.selectByOrderId(0L)).thenReturn(Collections.emptyList());

        // Configure UserService.findByIdAndValidDelete(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setRoleId(0L);
        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(user1);

        // Run the test
        final Result result = orderServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testGetMarketCount() {
        // Setup
        when(mockOrderMapper.getMarketCount()).thenReturn(new BigDecimal("0.00"));

        // Run the test
        final BigDecimal result = orderServiceImplUnderTest.getMarketCount();

        // Verify the results
        assertThat(result).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void testGetTodayCount() {
        // Setup
        when(mockOrderMapper.getTodayCount(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()))
                .thenReturn(new BigDecimal("0.00"));

        // Run the test
        final BigDecimal result = orderServiceImplUnderTest.getTodayCount(
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Verify the results
        assertThat(result).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void testGetMarketOrderCount() {
        // Setup
        when(mockOrderMapper.getMarketOrderCount()).thenReturn(new BigDecimal("0.00"));

        // Run the test
        final BigDecimal result = orderServiceImplUnderTest.getMarketOrderCount();

        // Verify the results
        assertThat(result).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void testGetTodayOrderCount() {
        // Setup
        when(mockOrderMapper.getTodayOrderCount(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime()))
                .thenReturn(new BigDecimal("0.00"));

        // Run the test
        final BigDecimal result = orderServiceImplUnderTest.getTodayOrderCount(
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Verify the results
        assertThat(result).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void testUpdateGoods() {
        // Setup
        final Order order = new Order();
        order.setPage(0);
        order.setLimit(0);
        order.setTotalMoney(new BigDecimal("0.00"));
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setRoleId(0L);
        order.setUser(user);
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setPage(0);
        orderDetails.setLimit(0);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setIsDelete(false);
        orderDetails.setOrderId(0L);
        order.setOrderDetailsList(Arrays.asList(orderDetails));
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        order.setMomentCommentList(Arrays.asList(momentComment));
        order.setId(0L);
        order.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setCreatedBy("createdBy");
        order.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        order.setIsDelete(false);
        order.setStatus(0);

        // Run the test
        final Result result = orderServiceImplUnderTest.updateGoods(order);

        // Verify the results
    }
}
