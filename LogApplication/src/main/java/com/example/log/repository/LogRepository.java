package com.example.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.log.model.Log;

public interface LogRepository extends JpaRepository<Log, Long> 
{
}

