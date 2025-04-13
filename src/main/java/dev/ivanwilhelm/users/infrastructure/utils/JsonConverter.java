package dev.ivanwilhelm.users.infrastructure.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

public abstract class JsonConverter {
    private JsonConverter() {
    }

    public static String toJson(Object object) {
        try {
            final var javaTimeModule = new JavaTimeModule();
            javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(ISO_DATE_TIME));

            final var mapper = new ObjectMapper();
            mapper.registerModule(javaTimeModule);
            mapper.setSerializationInclusion(NON_NULL);

            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return object.toString();
        }
    }
}
