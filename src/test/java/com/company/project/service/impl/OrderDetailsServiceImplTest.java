package com.company.project.service.impl;

import com.company.project.dao.OrderDetailsMapper;
import com.company.project.model.OrderDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderDetailsServiceImplTest {

    @Mock
    private OrderDetailsMapper mockOrderDetailsMapper;

    @InjectMocks
    private OrderDetailsServiceImpl orderDetailsServiceImplUnderTest;

    @Test
    public void testSelectByOrderId() {
        // Setup
        final OrderDetails orderDetails = new OrderDetails();
        orderDetails.setVideoName("videoName");
        orderDetails.setVideoImgUrl("videoImgUrl");
        orderDetails.setId(0L);
        orderDetails.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails.setCreatedBy("createdBy");
        final List<OrderDetails> expectedResult = Arrays.asList(orderDetails);

        // Configure OrderDetailsMapper.selectByOrderId(...).
        final OrderDetails orderDetails2 = new OrderDetails();
        orderDetails2.setVideoName("videoName");
        orderDetails2.setVideoImgUrl("videoImgUrl");
        orderDetails2.setId(0L);
        orderDetails2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderDetails2.setCreatedBy("createdBy");
        final List<OrderDetails> orderDetails1 = Arrays.asList(orderDetails2);
        when(mockOrderDetailsMapper.selectByOrderId(0L)).thenReturn(orderDetails1);

        // Run the test
        final List<OrderDetails> result = orderDetailsServiceImplUnderTest.selectByOrderId(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testSelectByOrderId_OrderDetailsMapperReturnsNoItems() {
        // Setup
        when(mockOrderDetailsMapper.selectByOrderId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<OrderDetails> result = orderDetailsServiceImplUnderTest.selectByOrderId(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testGetCountByGoodsId() {
        // Setup
        when(mockOrderDetailsMapper.getCountByGoodsId(0L)).thenReturn(0);

        // Run the test
        final int result = orderDetailsServiceImplUnderTest.getCountByGoodsId(0L);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testGetSaleCount() {
        assertThat(orderDetailsServiceImplUnderTest.getSaleCount(0L)).isEqualTo(new BigDecimal("0.00"));
    }
}
