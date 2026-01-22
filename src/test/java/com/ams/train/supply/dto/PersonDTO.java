package com.ams.train.supply.dto;

import com.ams.train.supply.ValueDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.util.List;

///
/// Данные пример:
/// {
///   "person": [
///     {
///       "key": "name",
///       "value": "John"
///     },
///     {
///       "key": "id",
///       "value": 25
///     }
///   ]
/// }
@Getter
public class PersonDTO {
    private List<KeyValuePair> person;

    @Getter
    public static class KeyValuePair {
        private String key;

        @JsonDeserialize(using = ValueDeserializer.class)
        private Object value;
    }
}
