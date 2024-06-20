package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.dao.CourseTypeMapper;
import com.company.project.model.Course;
import com.company.project.model.CourseType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CourseTypeServiceImplTest {

    @Mock
    private CourseTypeMapper mockCourseTypeMapper;

    @InjectMocks
    private CourseTypeServiceImpl courseTypeServiceImplUnderTest;

    @Test
    public void testList() throws Exception {
        // Setup
        final CourseType courseType = new CourseType();
        courseType.setPage(0);
        courseType.setLimit(0);
        courseType.setImgUrl("imgUrl");
        final Course course = new Course();
        courseType.setCourseList(Arrays.asList(course));
        courseType.setIsDelete(false);

        // Run the test
        final Result result = courseTypeServiceImplUnderTest.list(courseType);

        // Verify the results
    }

    @Test
    public void testSelectByGoodsId() {
        // Setup
        final CourseType courseType = new CourseType();
        courseType.setPage(0);
        courseType.setLimit(0);
        courseType.setImgUrl("imgUrl");
        final Course course = new Course();
        courseType.setCourseList(Arrays.asList(course));
        courseType.setIsDelete(false);
        final List<CourseType> expectedResult = Arrays.asList(courseType);

        // Configure CourseTypeMapper.selectByGoodsId(...).
        final CourseType courseType1 = new CourseType();
        courseType1.setPage(0);
        courseType1.setLimit(0);
        courseType1.setImgUrl("imgUrl");
        final Course course1 = new Course();
        courseType1.setCourseList(Arrays.asList(course1));
        courseType1.setIsDelete(false);
        final List<CourseType> courseTypes = Arrays.asList(courseType1);
        when(mockCourseTypeMapper.selectByGoodsId(0L)).thenReturn(courseTypes);

        // Run the test
        final List<CourseType> result = courseTypeServiceImplUnderTest.selectByGoodsId(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testSelectByGoodsId_CourseTypeMapperReturnsNoItems() {
        // Setup
        when(mockCourseTypeMapper.selectByGoodsId(0L)).thenReturn(Collections.emptyList());

        // Run the test
        final List<CourseType> result = courseTypeServiceImplUnderTest.selectByGoodsId(0L);

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }
}
