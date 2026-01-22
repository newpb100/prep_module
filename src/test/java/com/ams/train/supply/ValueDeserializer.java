package com.ams.train.supply;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
public class ValueDeserializer extends JsonDeserializer<Object> {
        @Override
        public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonToken currentToken = p.getCurrentToken();
            if (currentToken == JsonToken.VALUE_NUMBER_INT) {
                return p.getLongValue();
            } else if (currentToken == JsonToken.VALUE_STRING) {
                return p.getText();
            }
            return null;
        }
}

