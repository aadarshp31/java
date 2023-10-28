package com.myapi.server.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapi.server.models.CommonRes;

@RestController
@RequestMapping("/api")
public class CheckController {
  
  @GetMapping("/")
  public CommonRes status(){ 
    System.out.println("Hu");
    return new CommonRes(CommonRes.EStatus.success, "Server is running!");
  }
}
