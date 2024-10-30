package com.ianniello.springsecuritydemo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;

/**
 * JsonUtils
 *
 * <p>
 * Utils for Json operations
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
@Slf4j
public class JsonUtils {

    private static final ObjectMapper jsonMapper = new ObjectMapper();

    public static String toJson(Object obj) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) throws JsonProcessingException {
        return jsonMapper.readValue(json, clazz);
    }

    public static <T> T fromJsonFile(String jsonPath, Class<T> clazz) {
        InputStream input = null;
        try {
            input = JsonUtils.class.getClassLoader().getResourceAsStream(jsonPath);
            log.info("JSON READ: {}", jsonPath);
            return jsonMapper.readValue(input, clazz);
        } catch (Exception e) {
            throw new IllegalArgumentException(jsonPath + " File Not Found or Malformed: ", e);
        }

    }

}
