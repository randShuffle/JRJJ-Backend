package com.company.project.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonBinderUtilTest {

    @Test
    public void testToJson() {
        assertThat(JsonBinderUtil.toJson("object")).isEqualTo("result");
    }

    @Test
    public void testFromJson() {
        assertThat(JsonBinderUtil.fromJson("jsonString", String.class)).isEqualTo("result");
    }

    @Test
    public void testGetCollectionType() {
        // Setup
        final JavaType expectedResult = null;

        // Run the test
        final JavaType result = JsonBinderUtil.getCollectionType(String.class, String.class);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void testFromJsonToListByType() {
        assertThat(JsonBinderUtil.fromJsonToListByType("jsonString", String.class)).isEqualTo(Arrays.asList("value"));
        assertThat(JsonBinderUtil.fromJsonToListByType("jsonString", String.class)).isEqualTo(Collections.emptyList());
    }

    @Test
    public void testFromJsonToListByParseArray() {
        assertThat(JsonBinderUtil.fromJsonToListByParseArray("jsonString", String.class))
                .isEqualTo(Arrays.asList("value"));
        assertThat(JsonBinderUtil.fromJsonToListByParseArray("jsonString", String.class))
                .isEqualTo(Collections.emptyList());
    }

    @Test
    public void testFromJsontolist() {
        assertThat(JsonBinderUtil.fromJsontolist("jsonString", new TypeReference<String>() {})).isEqualTo("result");
    }
}
