package com.hotelserivce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobslExceptionHandler
{
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> notfoundhandler(ResourceNotFoundException ex){

       Map<String ,Object> map =new HashMap<>();

          map.put("message",ex.getMessage());
          map.put("Success",false);
          map.put("status", HttpStatus.NOT_FOUND);

         return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);





    }


}
