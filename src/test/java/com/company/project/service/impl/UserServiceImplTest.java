package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.UserMapper;
import com.company.project.model.Columns;
import com.company.project.model.Tables;
import com.company.project.model.User;
import com.company.project.service.SysMenuService;
import com.company.project.utils.EmailUtils;
import com.company.project.utils.MagConfig;
import com.company.project.utils.RedisService;
import com.company.project.vo.LoginVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserMapper mockUserMapper;
    @Mock
    private SysMenuService mockSysMenuService;
    @Mock
    private RedisService mockRedisService;
    @Mock
    private MagConfig mockMagConfig;
    @Mock
    private EmailUtils mockEmailUtils;

    @InjectMocks
    private UserServiceImpl userServiceImplUnderTest;

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(userServiceImplUnderTest, "databaseName", "databaseName");
        userServiceImplUnderTest.emailUtils = mockEmailUtils;
    }

    @Test
    public void testLogout() {
        // Setup
        when(mockRedisService.get("key")).thenReturn("result");

        // Run the test
        final Result result = userServiceImplUnderTest.logout(0L);

        // Verify the results
        verify(mockRedisService).delete("key");
    }

    @Test
    public void testLogin() {
        // Setup
        final LoginVo vo = new LoginVo();
        vo.setUserName("userName");
        vo.setPassword("password");
        vo.setRoleId(0L);

        // Configure UserMapper.findUserByUserName(...).
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);
        when(mockUserMapper.findUserByUserName("userName", 0L)).thenReturn(user);

        when(mockSysMenuService.selectMenuByRoleId(0L)).thenReturn(Arrays.asList("value"));
        when(mockRedisService.get("key")).thenReturn("result");
        when(mockMagConfig.getExpireTime()).thenReturn(0L);

        // Run the test
        final Result result = userServiceImplUnderTest.login(vo);

        // Verify the results
        verify(mockRedisService).delete("key");
        verify(mockRedisService).setWithExpire(eq("key"), any(Object.class), eq(2505600000L));
        verify(mockRedisService).set("key", "value");
    }

    @Test
    public void testLogin_UserMapperReturnsNull() {
        // Setup
        final LoginVo vo = new LoginVo();
        vo.setUserName("userName");
        vo.setPassword("password");
        vo.setRoleId(0L);

        when(mockUserMapper.findUserByUserName("userName", 0L)).thenReturn(null);

        // Run the test
        final Result result = userServiceImplUnderTest.login(vo);

        // Verify the results
    }

    @Test
    public void testLogin_SysMenuServiceReturnsNoItems() {
        // Setup
        final LoginVo vo = new LoginVo();
        vo.setUserName("userName");
        vo.setPassword("password");
        vo.setRoleId(0L);

        // Configure UserMapper.findUserByUserName(...).
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);
        when(mockUserMapper.findUserByUserName("userName", 0L)).thenReturn(user);

        when(mockSysMenuService.selectMenuByRoleId(0L)).thenReturn(Collections.emptyList());
        when(mockRedisService.get("key")).thenReturn("result");
        when(mockMagConfig.getExpireTime()).thenReturn(0L);

        // Run the test
        final Result result = userServiceImplUnderTest.login(vo);

        // Verify the results
        verify(mockRedisService).delete("key");
        verify(mockRedisService).setWithExpire(eq("key"), any(Object.class), eq(2505600000L));
        verify(mockRedisService).set("key", "value");
    }

    @Test
    public void testSendLogCode() {
        // Setup
        // Run the test
        final Result result = userServiceImplUnderTest.sendLogCode("phone");

        // Verify the results
        verify(mockRedisService).setWithExpire(eq("key"), any(Object.class), eq(180000L));
    }

    @Test
    public void testSendPasswordCode() {
        // Setup
        // Run the test
        final Result result = userServiceImplUnderTest.sendPasswordCode("phone");

        // Verify the results
        verify(mockRedisService).setWithExpire(eq("key"), any(Object.class), eq(180000L));
    }

    @Test
    public void testCaptcha() {
        // Setup
        // Run the test
        final Result result = userServiceImplUnderTest.captcha();

        // Verify the results
        verify(mockRedisService).setWithExpire(eq("key"), any(Object.class), eq(180000L));
    }

    @Test
    public void testRandList() {
        // Setup
        when(mockUserMapper.randList()).thenReturn("result");

        // Run the test
        final String result = userServiceImplUnderTest.randList();

        // Verify the results
        assertThat(result).isEqualTo("result");
    }

    @Test
    public void testFindUserById() {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);
        final List<User> expectedResult = Arrays.asList(user);

        // Configure UserMapper.findUserById(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setId(0L);
        user1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setIsDelete(false);
        user1.setStatus(0);
        user1.setUserName("userName");
        user1.setPassword("password");
        user1.setEmail("email");
        user1.setPhone("phone");
        user1.setRoleId(0L);
        final List<User> users = Arrays.asList(user1);
        when(mockUserMapper.findUserById(0L)).thenReturn(users);

        // Run the test
        final List<User> result = userServiceImplUnderTest.findUserById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFindUserById_UserMapperReturnsNoItems() {
        // Setup
        when(mockUserMapper.findUserById(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<User> result = userServiceImplUnderTest.findUserById(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final Result result = userServiceImplUnderTest.delete(0L);

        // Verify the results
    }

    @Test
    public void testDetailByToken() {
        // Setup
        // Run the test
        final Result result = userServiceImplUnderTest.detailByToken(0L);

        // Verify the results
    }

    @Test
    public void testList() throws Exception {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        // Configure UserMapper.list(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setId(0L);
        user1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setIsDelete(false);
        user1.setStatus(0);
        user1.setUserName("userName");
        user1.setPassword("password");
        user1.setEmail("email");
        user1.setPhone("phone");
        user1.setRoleId(0L);
        final List<User> users = Arrays.asList(user1);
        final User user2 = new User();
        user2.setPage(0);
        user2.setLimit(0);
        user2.setCode("code");
        user2.setRole(0L);
        user2.setId(0L);
        user2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user2.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user2.setIsDelete(false);
        user2.setStatus(0);
        user2.setUserName("userName");
        user2.setPassword("password");
        user2.setEmail("email");
        user2.setPhone("phone");
        user2.setRoleId(0L);
        when(mockUserMapper.list(user2)).thenReturn(users);

        // Run the test
        final Result result = userServiceImplUnderTest.list(user);

        // Verify the results
    }

    @Test
    public void testList_UserMapperReturnsNull() {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        // Configure UserMapper.list(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setId(0L);
        user1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setIsDelete(false);
        user1.setStatus(0);
        user1.setUserName("userName");
        user1.setPassword("password");
        user1.setEmail("email");
        user1.setPhone("phone");
        user1.setRoleId(0L);
        when(mockUserMapper.list(user1)).thenReturn(null);

        // Run the test
        final Result result = userServiceImplUnderTest.list(user);

        // Verify the results
    }

    @Test
    public void testList_UserMapperReturnsNoItems() {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        // Configure UserMapper.list(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setId(0L);
        user1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setIsDelete(false);
        user1.setStatus(0);
        user1.setUserName("userName");
        user1.setPassword("password");
        user1.setEmail("email");
        user1.setPhone("phone");
        user1.setRoleId(0L);
        when(mockUserMapper.list(user1)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = userServiceImplUnderTest.list(user);

        // Verify the results
    }

    @Test
    public void testFindAllColumns() {
        // Setup
        // Configure UserMapper.selectAllTable(...).
        final Tables tables1 = new Tables();
        tables1.setTableName("tableName");
        tables1.setTableComment("tableComment");
        final List<Tables> tables = Arrays.asList(tables1);
        when(mockUserMapper.selectAllTable("databaseName")).thenReturn(tables);

        // Configure UserMapper.selectAllColumnsByTableName(...).
        final Columns columns1 = new Columns();
        columns1.setField("field");
        columns1.setTitle("title");
        columns1.setWidth("width");
        final List<Columns> columns = Arrays.asList(columns1);
        when(mockUserMapper.selectAllColumnsByTableName("databaseName", "tableName")).thenReturn(columns);

        // Run the test
        final Result result = userServiceImplUnderTest.findAllColumns();

        // Verify the results
    }

    @Test
    public void testFindAllColumns_UserMapperSelectAllTableReturnsNull() {
        // Setup
        when(mockUserMapper.selectAllTable("databaseName")).thenReturn(null);

        // Run the test
        final Result result = userServiceImplUnderTest.findAllColumns();

        // Verify the results
    }

    @Test
    public void testFindAllColumns_UserMapperSelectAllTableReturnsNoItems() {
        // Setup
        when(mockUserMapper.selectAllTable("databaseName")).thenReturn(Collections.emptyList());

        // Configure UserMapper.selectAllColumnsByTableName(...).
        final Columns columns1 = new Columns();
        columns1.setField("field");
        columns1.setTitle("title");
        columns1.setWidth("width");
        final List<Columns> columns = Arrays.asList(columns1);
        when(mockUserMapper.selectAllColumnsByTableName("databaseName", "tableName")).thenReturn(columns);

        // Run the test
        final Result result = userServiceImplUnderTest.findAllColumns();

        // Verify the results
    }

    @Test
    public void testFindAllColumns_UserMapperSelectAllColumnsByTableNameReturnsNoItems() {
        // Setup
        // Configure UserMapper.selectAllTable(...).
        final Tables tables1 = new Tables();
        tables1.setTableName("tableName");
        tables1.setTableComment("tableComment");
        final List<Tables> tables = Arrays.asList(tables1);
        when(mockUserMapper.selectAllTable("databaseName")).thenReturn(tables);

        when(mockUserMapper.selectAllColumnsByTableName("databaseName", "tableName"))
                .thenReturn(Collections.emptyList());

        // Run the test
        final Result result = userServiceImplUnderTest.findAllColumns();

        // Verify the results
    }

    @Test
    public void testBatchSendEmail() throws Exception {
        // Setup
        // Configure UserMapper.selectUserListById(...).
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);
        final List<User> users = Arrays.asList(user);
        when(mockUserMapper.selectUserListById("ids")).thenReturn(users);

        // Run the test
        final Result result = userServiceImplUnderTest.batchSendEmail("ids");

        // Verify the results
        verify(mockEmailUtils).sendMail("email", "userName", "password");
    }

    @Test
    public void testBatchSendEmail_UserMapperReturnsNull() {
        // Setup
        when(mockUserMapper.selectUserListById("ids")).thenReturn(null);

        // Run the test
        final Result result = userServiceImplUnderTest.batchSendEmail("ids");

        // Verify the results
    }

    @Test
    public void testBatchSendEmail_UserMapperReturnsNoItems() throws Exception {
        // Setup
        when(mockUserMapper.selectUserListById("ids")).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = userServiceImplUnderTest.batchSendEmail("ids");

        // Verify the results
        verify(mockEmailUtils).sendMail("email", "userName", "password");
    }

    @Test
    public void testBatchSendEmail_EmailUtilsThrowsGeneralSecurityException() throws Exception {
        // Setup
        // Configure UserMapper.selectUserListById(...).
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);
        final List<User> users = Arrays.asList(user);
        when(mockUserMapper.selectUserListById("ids")).thenReturn(users);

        when(mockEmailUtils.sendMail("email", "userName", "password")).thenThrow(GeneralSecurityException.class);

        // Run the test
        final Result result = userServiceImplUnderTest.batchSendEmail("ids");

        // Verify the results
    }

    @Test
    public void testBatchSendEmail_EmailUtilsThrowsMessagingException() throws Exception {
        // Setup
        // Configure UserMapper.selectUserListById(...).
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);
        final List<User> users = Arrays.asList(user);
        when(mockUserMapper.selectUserListById("ids")).thenReturn(users);

        when(mockEmailUtils.sendMail("email", "userName", "password")).thenThrow(MessagingException.class);

        // Run the test
        final Result result = userServiceImplUnderTest.batchSendEmail("ids");

        // Verify the results
    }

    @Test
    public void testUpdatePassword() {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        when(mockRedisService.get("key")).thenReturn("result");

        // Configure UserMapper.findUserByUserName(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setId(0L);
        user1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setIsDelete(false);
        user1.setStatus(0);
        user1.setUserName("userName");
        user1.setPassword("password");
        user1.setEmail("email");
        user1.setPhone("phone");
        user1.setRoleId(0L);
        when(mockUserMapper.findUserByUserName("userName", 0L)).thenReturn(user1);

        // Run the test
        final Result result = userServiceImplUnderTest.updatePassword(user);

        // Verify the results
        // Confirm UserMapper.updatePassword(...).
        final User user2 = new User();
        user2.setPage(0);
        user2.setLimit(0);
        user2.setCode("code");
        user2.setRole(0L);
        user2.setId(0L);
        user2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user2.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user2.setIsDelete(false);
        user2.setStatus(0);
        user2.setUserName("userName");
        user2.setPassword("password");
        user2.setEmail("email");
        user2.setPhone("phone");
        user2.setRoleId(0L);
        verify(mockUserMapper).updatePassword(user2);
    }

    @Test
    public void testUpdatePassword_RedisServiceReturnsNull() {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        when(mockRedisService.get("key")).thenReturn(null);

        // Run the test
        final Result result = userServiceImplUnderTest.updatePassword(user);

        // Verify the results
    }

    @Test
    public void testUpdatePassword_UserMapperFindUserByUserNameReturnsNull() {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        when(mockRedisService.get("key")).thenReturn("result");
        when(mockUserMapper.findUserByUserName("userName", 0L)).thenReturn(null);

        // Run the test
        final Result result = userServiceImplUnderTest.updatePassword(user);

        // Verify the results
    }

    @Test
    public void testUpdateUser() {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        // Configure UserMapper.findUserByUserName(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setId(0L);
        user1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setIsDelete(false);
        user1.setStatus(0);
        user1.setUserName("userName");
        user1.setPassword("password");
        user1.setEmail("email");
        user1.setPhone("phone");
        user1.setRoleId(0L);
        when(mockUserMapper.findUserByUserName("userName", 0L)).thenReturn(user1);

        // Run the test
        final Result result = userServiceImplUnderTest.updateUser(user);

        // Verify the results
    }

    @Test
    public void testUpdateUser_UserMapperReturnsNull() {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        when(mockUserMapper.findUserByUserName("userName", 0L)).thenReturn(null);

        // Run the test
        final Result result = userServiceImplUnderTest.updateUser(user);

        // Verify the results
    }

    @Test
    public void testAdd() throws Exception {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        // Configure UserMapper.findUserByUserName(...).
        final User user1 = new User();
        user1.setPage(0);
        user1.setLimit(0);
        user1.setCode("code");
        user1.setRole(0L);
        user1.setId(0L);
        user1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user1.setIsDelete(false);
        user1.setStatus(0);
        user1.setUserName("userName");
        user1.setPassword("password");
        user1.setEmail("email");
        user1.setPhone("phone");
        user1.setRoleId(0L);
        when(mockUserMapper.findUserByUserName("userName", 0L)).thenReturn(user1);

        // Run the test
        final Result result = userServiceImplUnderTest.add(user);

        // Verify the results
    }

    @Test
    public void testAdd_UserMapperReturnsNull() {
        // Setup
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setRole(0L);
        user.setId(0L);
        user.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        user.setIsDelete(false);
        user.setStatus(0);
        user.setUserName("userName");
        user.setPassword("password");
        user.setEmail("email");
        user.setPhone("phone");
        user.setRoleId(0L);

        when(mockUserMapper.findUserByUserName("userName", 0L)).thenReturn(null);

        // Run the test
        final Result result = userServiceImplUnderTest.add(user);

        // Verify the results
    }
}
