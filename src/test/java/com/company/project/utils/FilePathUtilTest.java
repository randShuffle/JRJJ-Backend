package com.company.project.utils;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilePathUtilTest {

    @Test
    public void testFilePath() {
        assertThat(FilePathUtil.filePath()).isEqualTo("result");
    }
}
