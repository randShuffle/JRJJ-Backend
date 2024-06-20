package com.company.project.web;

import com.company.project.model.SysMenu;
import com.company.project.service.SysMenuService;
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
@WebMvcTest(SysMenuController.class)
public class SysMenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SysMenuService mockSysMenuService;

    @Test
    public void testAdd() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/menu/add")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm SysMenuService.save(...).
        final SysMenu model = new SysMenu();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockSysMenuService).save(model);
    }

    @Test
    public void testDelete() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/menu/delete")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm SysMenuService.update(...).
        final SysMenu model = new SysMenu();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockSysMenuService).update(model);
    }

    @Test
    public void testUpdate() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/menu/update")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");

        // Confirm SysMenuService.update(...).
        final SysMenu model = new SysMenu();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        verify(mockSysMenuService).update(model);
    }

    @Test
    public void testDetail() throws Exception {
        // Setup
        // Configure SysMenuService.findById(...).
        final SysMenu sysMenu = new SysMenu();
        sysMenu.setPage(0);
        sysMenu.setLimit(0);
        sysMenu.setId(0L);
        sysMenu.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysMenu.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysMenu.setIsDelete(false);
        when(mockSysMenuService.findById(0L)).thenReturn(sysMenu);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/menu/detail")
                        .param("id", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testDetail_SysMenuServiceReturnsNull() throws Exception {
        // Setup
        when(mockSysMenuService.findById(0L)).thenReturn(null);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/menu/detail")
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
        // Configure SysMenuService.findByModel(...).
        final SysMenu sysMenu = new SysMenu();
        sysMenu.setPage(0);
        sysMenu.setLimit(0);
        sysMenu.setId(0L);
        sysMenu.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysMenu.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        sysMenu.setIsDelete(false);
        final List<SysMenu> sysMenus = Arrays.asList(sysMenu);
        final SysMenu model = new SysMenu();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockSysMenuService.findByModel(model)).thenReturn(sysMenus);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/menu/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    public void testList_SysMenuServiceReturnsNoItems() throws Exception {
        // Setup
        // Configure SysMenuService.findByModel(...).
        final SysMenu model = new SysMenu();
        model.setPage(0);
        model.setLimit(0);
        model.setId(0L);
        model.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setUpdatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        model.setIsDelete(false);
        when(mockSysMenuService.findByModel(model)).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/sys/menu/findByModal")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
