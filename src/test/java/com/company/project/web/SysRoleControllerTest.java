package com.company.project.web;

import com.company.project.model.SysRole;
import com.company.project.service.SysRoleService;
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
@WebMvcTest(SysRoleController.class)
public class SysRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SysRoleService mockSysRoleService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/role/add")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm SysRoleService.save(...).
        final SysRole model = new SysRole();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockSysRoleService).save(model);
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/role/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm SysRoleService.update(...).
        final SysRole model = new SysRole();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockSysRoleService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/role/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm SysRoleService.update(...).
        final SysRole model = new SysRole();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockSysRoleService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure SysRoleService.findById(...).
        final SysRole sysRole = new SysRole();
        sysRole.setPage(0);
        sysRole.setLimit(0);
        sysRole.setId(0L);
        sysRole.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setIsDelete(false);
        when(mockSysRoleService.findById(0L)).thenReturn(sysRole);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/role/detail")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testDetail_SysRoleServiceReturnsNull() throws Exception {
        // Setup
        when(mockSysRoleService.findById(0L)).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/role/detail")
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
        // Configure SysRoleService.findByModel(...).
        final SysRole sysRole = new SysRole();
        sysRole.setPage(0);
        sysRole.setLimit(0);
        sysRole.setId(0L);
        sysRole.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysRole.setIsDelete(false);
        final List<SysRole> sysRoles = Arrays.asList(sysRole);
        final SysRole model = new SysRole();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockSysRoleService.findByModel(model)).thenReturn(sysRoles);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/role/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testList_SysRoleServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure SysRoleService.findByModel(...).
        final SysRole model = new SysRole();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockSysRoleService.findByModel(model)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/role/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
