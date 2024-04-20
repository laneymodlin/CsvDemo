package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class DemoServiceImpl implements DemoService{
    /**
     * @param json string
     * @return CsvMapper
     */
    @Override
    public CsvMapper convertJsonToCsvMapper(String json) throws IOException {
        JsonNode jsonTree = new ObjectMapper().readTree(json);
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(csvSchemaBuilder::addColumn);
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();


        //I want to use stream here
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(stream, jsonTree);

        return csvMapper;
    }
}
