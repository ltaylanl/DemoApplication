package com.example.log.service;

import com.example.log.model.Log;
import com.example.log.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService 
{
    
    @Autowired
    private LogRepository logRepository;

    public void createLog(String logType, String message) {
        Log log = new Log();
        log.setLogType(logType);
        log.setMessage(message);
        log.setTimestamp(String.valueOf(LocalDateTime.now()));
        logRepository.save(log);
    }
}
