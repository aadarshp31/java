package com.myapi.server.controllers.authentication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping({ "/api/v1/auth", "/api/v1/auth/" })
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping({ "/register", "/register/" })
  public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest reqBody) {

    return ResponseEntity.ok(authenticationService.register(reqBody));
  }

  @PostMapping({ "/authenticate", "/authenticate/" })
  public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest reqBody) {

    return ResponseEntity.ok(authenticationService.authenticate(reqBody));
  }

}
