package com.company.project.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OSinfoTest {

    @Test
    public void testIsLinux() {
        assertThat(OSinfo.isLinux()).isFalse();
    }

    @Test
    public void testIsMacOS() {
        assertThat(OSinfo.isMacOS()).isFalse();
    }

    @Test
    public void testIsMacOSX() {
        assertThat(OSinfo.isMacOSX()).isFalse();
    }

    @Test
    public void testIsWindows() {
        assertThat(OSinfo.isWindows()).isFalse();
    }

    @Test
    public void testGetOSname() {
        assertThat(OSinfo.getOSname()).isEqualTo(EPlatform.Linux);
    }
}
