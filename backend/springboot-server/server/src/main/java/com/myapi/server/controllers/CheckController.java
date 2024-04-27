package com.myapi.server.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CheckController {
  
  @GetMapping({"", "/"})  // This allows both /api and /api/ to map to the status method
  public ResponseEntity<Object> status(){ 
    Map<String, Object> resBody = new HashMap<String, Object>();
    resBody.put("status", "success");
    resBody.put("message", "Server is running!");
    return new ResponseEntity<Object>(resBody, HttpStatus.OK);
  }
}
