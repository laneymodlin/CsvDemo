package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface DemoService {

    CsvMapper convertJsonToCsvMapper(String json) throws IOException;
}
