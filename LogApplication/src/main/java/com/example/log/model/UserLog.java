package com.example.log.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class UserLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private LocalDateTime timestamp;
    private Long userId;

    // Getter ve Setter'lar
    public Long getId() 
    {
        return id;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }
    public String getAction() 
    {
        return action;
    }
    public void setAction(String action) 
    {
        this.action = action;
    }
    public LocalDateTime getTimestamp() 
    {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) 
    {
        this.timestamp = timestamp;
    }
    public Long getUserId() 
    {
        return userId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }
}

