package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.MomentCommentMapper;
import com.company.project.model.MomentComment;
import com.company.project.model.User;
import com.company.project.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MomentCommentServiceImplTest {

    @Mock
    private MomentCommentMapper mockMomentCommentMapper;
    @Mock
    private UserService mockUserService;

    @InjectMocks
    private MomentCommentServiceImpl momentCommentServiceImplUnderTest;

    @Test
    public void testAdd() throws Exception {
        // Setup
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        momentComment.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment.setUserName("userName");
        momentComment.setId(0L);
        momentComment.setCreatedBy("createdBy");
        momentComment.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment.setIsDelete(false);

        // Run the test
        final Result result = momentCommentServiceImplUnderTest.add(momentComment);

        // Verify the results
    }

    @Test
    public void testSelectByMomentId() {
        // Setup
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        momentComment.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment.setUserName("userName");
        momentComment.setId(0L);
        momentComment.setCreatedBy("createdBy");
        momentComment.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment.setIsDelete(false);
        final List<MomentComment> expectedResult = Arrays.asList(momentComment);

        // Configure MomentCommentMapper.selectParentByMomentId(...).
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        momentComment1.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment1.setUserName("userName");
        momentComment1.setId(0L);
        momentComment1.setCreatedBy("createdBy");
        momentComment1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment1.setIsDelete(false);
        final List<MomentComment> momentComments = Arrays.asList(momentComment1);
        when(mockMomentCommentMapper.selectParentByMomentId(0L)).thenReturn(momentComments);

        // Configure MomentCommentMapper.selectChildrenByParentId(...).
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        momentComment2.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment2.setUserName("userName");
        momentComment2.setId(0L);
        momentComment2.setCreatedBy("createdBy");
        momentComment2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment2.setIsDelete(false);
        final List<MomentComment> momentComments1 = Arrays.asList(momentComment2);
        when(mockMomentCommentMapper.selectChildrenByParentId(0L)).thenReturn(momentComments1);

        // Run the test
        final List<MomentComment> result = momentCommentServiceImplUnderTest.selectByMomentId(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testSelectByMomentId_MomentCommentMapperSelectParentByMomentIdReturnsNull() {
        // Setup
        when(mockMomentCommentMapper.selectParentByMomentId(0L)).thenReturn(null);

        // Run the test
        final List<MomentComment> result = momentCommentServiceImplUnderTest.selectByMomentId(0L);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    public void testSelectByMomentId_MomentCommentMapperSelectParentByMomentIdReturnsNoItems() {
        // Setup
        when(mockMomentCommentMapper.selectParentByMomentId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<MomentComment> result = momentCommentServiceImplUnderTest.selectByMomentId(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testSelectByMomentId_MomentCommentMapperSelectChildrenByParentIdReturnsNoItems() {
        // Setup
        // Configure MomentCommentMapper.selectParentByMomentId(...).
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        momentComment.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment.setUserName("userName");
        momentComment.setId(0L);
        momentComment.setCreatedBy("createdBy");
        momentComment.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment.setIsDelete(false);
        final List<MomentComment> momentComments = Arrays.asList(momentComment);
        when(mockMomentCommentMapper.selectParentByMomentId(0L)).thenReturn(momentComments);

        when(mockMomentCommentMapper.selectChildrenByParentId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<MomentComment> result = momentCommentServiceImplUnderTest.selectByMomentId(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure MomentCommentMapper.detail(...).
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        momentComment.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment.setUserName("userName");
        momentComment.setId(0L);
        momentComment.setCreatedBy("createdBy");
        momentComment.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment.setIsDelete(false);
        final List<MomentComment> momentComments = Arrays.asList(momentComment);
        when(mockMomentCommentMapper.detail(0L)).thenReturn(momentComments);

        // Configure UserService.findByIdAndValidDelete(...).
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setUserName("userName");
        user.setRoleId(0L);
        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(user);

        // Run the test
        final Result result = momentCommentServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testDetail_MomentCommentMapperReturnsNoItems() {
        // Setup
        when(mockMomentCommentMapper.detail(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = momentCommentServiceImplUnderTest.detail(0L);

        // Verify the results
    }

    @Test
    public void testList() throws Exception {
        // Setup
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        momentComment.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment.setUserName("userName");
        momentComment.setId(0L);
        momentComment.setCreatedBy("createdBy");
        momentComment.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment.setIsDelete(false);

        // Configure UserService.findByIdAndValidDelete(...).
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setUserName("userName");
        user.setRoleId(0L);
        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(user);

        // Configure MomentCommentMapper.list(...).
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        momentComment1.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment1.setUserName("userName");
        momentComment1.setId(0L);
        momentComment1.setCreatedBy("createdBy");
        momentComment1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment1.setIsDelete(false);
        final List<MomentComment> momentComments = Arrays.asList(momentComment1);
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        momentComment2.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment2.setUserName("userName");
        momentComment2.setId(0L);
        momentComment2.setCreatedBy("createdBy");
        momentComment2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment2.setIsDelete(false);
        when(mockMomentCommentMapper.list(momentComment2)).thenReturn(momentComments);

        // Run the test
        final Result result = momentCommentServiceImplUnderTest.list(momentComment);

        // Verify the results
    }

    @Test
    public void testList_UserServiceReturnsNull() {
        // Setup
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        momentComment.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment.setUserName("userName");
        momentComment.setId(0L);
        momentComment.setCreatedBy("createdBy");
        momentComment.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment.setIsDelete(false);

        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(null);

        // Configure MomentCommentMapper.list(...).
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        momentComment1.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment1.setUserName("userName");
        momentComment1.setId(0L);
        momentComment1.setCreatedBy("createdBy");
        momentComment1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment1.setIsDelete(false);
        final List<MomentComment> momentComments = Arrays.asList(momentComment1);
        final MomentComment momentComment2 = new MomentComment();
        momentComment2.setPage(0);
        momentComment2.setLimit(0);
        momentComment2.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment2.setUserName("userName");
        momentComment2.setId(0L);
        momentComment2.setCreatedBy("createdBy");
        momentComment2.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment2.setIsDelete(false);
        when(mockMomentCommentMapper.list(momentComment2)).thenReturn(momentComments);

        // Run the test
        final Result result = momentCommentServiceImplUnderTest.list(momentComment);

        // Verify the results
    }

    @Test
    public void testList_MomentCommentMapperReturnsNoItems() {
        // Setup
        final MomentComment momentComment = new MomentComment();
        momentComment.setPage(0);
        momentComment.setLimit(0);
        momentComment.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment.setUserName("userName");
        momentComment.setId(0L);
        momentComment.setCreatedBy("createdBy");
        momentComment.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment.setIsDelete(false);

        // Configure UserService.findByIdAndValidDelete(...).
        final User user = new User();
        user.setPage(0);
        user.setLimit(0);
        user.setCode("code");
        user.setUserName("userName");
        user.setRoleId(0L);
        when(mockUserService.findByIdAndValidDelete(0L)).thenReturn(user);

        // Configure MomentCommentMapper.list(...).
        final MomentComment momentComment1 = new MomentComment();
        momentComment1.setPage(0);
        momentComment1.setLimit(0);
        momentComment1.setChildrenList(Arrays.asList(new MomentComment()));
        momentComment1.setUserName("userName");
        momentComment1.setId(0L);
        momentComment1.setCreatedBy("createdBy");
        momentComment1.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        momentComment1.setIsDelete(false);
        when(mockMomentCommentMapper.list(momentComment1)).thenReturn(Collections.emptyList());

        // Run the test
        final Result result = momentCommentServiceImplUnderTest.list(momentComment);

        // Verify the results
    }

    @Test
    public void testGetCountByMomentId() {
        // Setup
        when(mockMomentCommentMapper.getCountByMomentId(0L)).thenReturn(0);

        // Run the test
        final Integer result = momentCommentServiceImplUnderTest.getCountByMomentId(0L);

        // Verify the results
        assertThat(result).isEqualTo(0);
    }
}
