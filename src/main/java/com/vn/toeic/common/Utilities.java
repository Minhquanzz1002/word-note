package com.vn.toeic.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
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

    /**
     * Convert a List of String to JSON array string.
     * Example: List.of("a","b") -> ["a","b"]
     *
     * @param list the list of strings
     * @return JSON string representation of the list, or "[]" if null/empty
     */
    public static String listToJson(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "[]";
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            log.error("Return empty array string on error");
            return "[]";
        }
    }
}
