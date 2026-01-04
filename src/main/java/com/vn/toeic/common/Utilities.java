package com.vn.toeic.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Utilities {

    private Utilities() {
    }

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Convert JSON string to List<String>.
     *
     * @param value JSON string, example: ["a","b"]
     * @return List of String, empty list if null or empty
     */
    public static List<String> toStringList(String value) {
        if (!StringUtils.hasText(value)) {
            return Collections.emptyList();
        }

        try {
            String[] arr = OBJECT_MAPPER.readValue(value, String[].class);
            return Arrays.asList(arr);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
