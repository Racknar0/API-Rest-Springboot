package com.deg.clientservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExeption {
    
    public ResponseEntity<String> handleException(Exception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
