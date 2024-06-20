package com.company.project.utils;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IdWorkerTest {

    private IdWorker idWorkerUnderTest;

    @Before
    public void setUp() {
        idWorkerUnderTest = IdWorker.getInstance();
    }

    @Test
    public void testGetInstance() {
        // Setup
        // Run the test
        final IdWorker result = IdWorker.getInstance();

        // Verify the results
    }

    @Test
    public void testNextId() {
        assertThat(idWorkerUnderTest.nextId()).isEqualTo(0L);
    }

    @Test
    public void testTilNextMillis() {
        assertThat(idWorkerUnderTest.tilNextMillis(0L)).isEqualTo(0L);
    }

    @Test
    public void testTimeGen() {
        assertThat(idWorkerUnderTest.timeGen()).isEqualTo(0L);
    }
}
