package com.neoteric.student.avootaCode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neoteric.student.avootaCode.RootResponse;

import java.io.IOException;

public class JsonReader {
    public RootResponse readJsonFromString(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, RootResponse.class);
    }}

