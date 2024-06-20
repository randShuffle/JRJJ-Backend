package com.company.project.common;

import com.company.project.utils.RedisService;
import com.company.project.vo.SysUserVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BaseControllerTest {

    @Mock
    private RedisService mockRedisService;

    @InjectMocks
    private BaseController baseControllerUnderTest;

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(baseControllerUnderTest, "request", new MockHttpServletRequest());
    }

    @Test
    public void testGetUserId() {
        // Setup
        when(mockRedisService.get("key")).thenReturn("result");

        // Run the test
        final String result = baseControllerUnderTest.getUserId();

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    public void testGetUserId_RedisServiceReturnsNull() {
        // Setup
        when(mockRedisService.get("key")).thenReturn(null);

        // Run the test
        final String result = baseControllerUnderTest.getUserId();

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    public void testGetUser() {
        // Setup
        when(mockRedisService.get("key")).thenReturn("result");

        // Run the test
        final SysUserVo result = baseControllerUnderTest.getUser();

        // Verify the results
    }

    @Test
    public void testGetUser_RedisServiceReturnsNull() {
        // Setup
        when(mockRedisService.get("key")).thenReturn(null);

        // Run the test
        final SysUserVo result = baseControllerUnderTest.getUser();

        // Verify the results
        assertThat(result).isNull();
    }
}
