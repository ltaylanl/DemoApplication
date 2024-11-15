package com.example.log.controller;

import com.example.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LogController 
{

    @Autowired
    private LogService logService;

    @PostMapping("/api/logs")
    public void addLog(@RequestBody Map<String, String> logData) 
    {
        String logType = logData.get("logType");
        String message = logData.get("message");
        logService.createLog(logType, message);
    }

    @PostMapping("/log")
    public void log(@RequestBody String message) 
    {
        System.out.println("Log entry: " + message);
    }
}


