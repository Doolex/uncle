package com.uncle.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;


public class JSONUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static String toJSONString(Object source) throws JsonProcessingException {
        ObjectWriter writer = OBJECT_MAPPER.writer();
        String jsonString = writer.writeValueAsString(source);
        return jsonString;
    }

    public static JsonNode readTree(String jsonString) throws IOException {
        ObjectReader objectReader = OBJECT_MAPPER.reader();
        return objectReader.readTree(jsonString);
    }

    public static <T> T readObject(String jsonString, Class<?> type) throws IOException {
        ObjectReader objectReader = OBJECT_MAPPER.readerFor(type);
        return objectReader.readValue(jsonString);
    }

    public static <T> T readObject(String jsonString, TypeReference valueTypeRef) throws IOException {
        return OBJECT_MAPPER.readValue(jsonString, valueTypeRef);
    }

    public static <T> T readObject(String jsonString, JavaType valueTypeRef) throws IOException {
        return OBJECT_MAPPER.readValue(jsonString, valueTypeRef);
    }

    public static <T extends Collection> T readObject(String jsonString, Class<T> collectionClazz, Class<?> elementClazz) throws IOException {

        return OBJECT_MAPPER.readValue(jsonString, OBJECT_MAPPER.getTypeFactory().constructCollectionType(collectionClazz, elementClazz));
    }

    public static <T extends Map> T readObject(String jsonString, Class<?> mapClazz, Class<?> keyClazz, Class<?> valueClazz) throws IOException {

        return OBJECT_MAPPER.readValue(jsonString, OBJECT_MAPPER.getTypeFactory().constructMapLikeType(mapClazz, keyClazz, valueClazz));
    }


}
