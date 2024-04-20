package com.example.demo;

import com.example.demo.service.DemoService;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DemoController {

    @Autowired
    private DemoService service;


    @GetMapping("/csv")
    public ResponseEntity getCsv(@RequestBody String requestBody) throws IOException {

        //call service
        CsvMapper mapper = service.convertJsonToCsvMapper(requestBody);

        return mapper.writeValueAsBytes();

    }
}
