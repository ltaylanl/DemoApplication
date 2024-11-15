package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LogService {

    @Autowired
    private RestTemplate restTemplate;

    private final String logApplicationUrl = "http://localhost:8081/api/logs";  // LogApplication’ın URL'si

    public void log(String logType, String message) {
        Map<String, String> logData = new HashMap<>();
        logData.put("logType", logType);
        logData.put("message", message);
        restTemplate.postForEntity(logApplicationUrl, logData, Void.class);
    }
}

