package com.andkantor.snowfox.stock.model;

import java.io.StringWriter;
import java.io.Writer;

import org.junit.Before;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public abstract class AbstractJackson2MarshallingTest {

    protected ObjectMapper mapper;

    @Before
    public void setUp() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    protected String write(Object object) throws Exception {
        Writer writer = new StringWriter();
        mapper.writeValue(writer, object);
        return writer.toString();
    }

    protected <T> T read(String source, Class<T> targetType) throws Exception {
        return mapper.readValue(source, targetType);
    }
}
