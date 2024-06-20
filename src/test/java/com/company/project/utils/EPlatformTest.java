package com.company.project.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EPlatformTest {

    @Test
    public void testToString() {
        assertThat(EPlatform.Linux.toString()).isEqualTo("desc");
        assertThat(EPlatform.Mac_OS.toString()).isEqualTo("desc");
        assertThat(EPlatform.Mac_OS_X.toString()).isEqualTo("desc");
        assertThat(EPlatform.Windows.toString()).isEqualTo("desc");
    }
}
