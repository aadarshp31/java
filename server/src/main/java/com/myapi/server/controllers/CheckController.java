package com.myapi.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapi.server.models.CommonRes;

@RestController
@RequestMapping("/api")
public class CheckController {
  
  @GetMapping({"", "/"})  // This allows both /api and /api/ to map to the status method
  public CommonRes status(){ 
    return new CommonRes(CommonRes.EStatus.success, "Server is running!");
  }
}
