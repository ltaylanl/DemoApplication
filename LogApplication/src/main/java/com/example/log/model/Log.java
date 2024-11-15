package com.example.log.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Log 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String logType;
    private String timestamp;

    // Getters ve Setters
    public Long getId() 
    { 
        return id; 
    }
    public void setId(Long id) 
    { 
        this.id = id; 
    }
    public String getMessage() 
    { 
        return message; 
    }
    public void setMessage(String message) 
    { 
        this.message = message; 
    }

    public String getLogType() 
    { 
        return logType; 
    }
    public void setLogType(String logType) 
    { 
        this.logType = logType; 
    }

    public String getTimestamp() 
    { 
        return timestamp; 
    }
    public void setTimestamp(String timestamp) 
    { 
        this.timestamp = timestamp; 
    }
}
