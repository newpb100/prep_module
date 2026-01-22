package com.ams.train.supply.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


///
/// Данные пример:
///
///   "person": [
///     {
///       "key": "name",
///       "type": "string",
///       "value": "John"
///     },
///     {
///       "key": "id",
///       "type": "long",
///       "value": 25
///     },
///     {
///       "key": "age",
///       "type": "int",
///       "value": 30
///     }
///   ]
///
@Getter
public class PersonDTOWithType {

    private List<KeyValuePair> person;

    @Getter
    public static class KeyValuePair {
        private String key;
        private String type;

        @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
        @JsonSubTypes({
                @JsonSubTypes.Type(value = String.class, name = "string"),
                @JsonSubTypes.Type(value = Long.class, name = "long"),
                @JsonSubTypes.Type(value = Integer.class, name = "int")
        })
        private Object value;

    }
}
