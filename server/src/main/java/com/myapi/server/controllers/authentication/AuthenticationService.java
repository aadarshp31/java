package com.myapi.server.controllers.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myapi.server.config.JwtService;
import com.myapi.server.models.Role;
import com.myapi.server.models.User;
import com.myapi.server.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final UserDetailsService userDetailsService;

  public AuthenticationResponse register(RegisterRequest reqBody) {
    var user = User.builder()
        .firstname(reqBody.getFirstname())
        .lastname(reqBody.getLastname())
        .email(reqBody.getEmail())
        .password(passwordEncoder.encode(reqBody.getPassword()))
        .role(Role.USER)
        .build();

    userRepository.save(user);

    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .message("Registration successful")
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest reqBody) {
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
        reqBody.getEmail(), reqBody.getPassword());

    authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    UserDetails user = userDetailsService.loadUserByUsername(reqBody.getEmail());
    String jwtToken = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .token(jwtToken)
        .message("Login successful")
        .build();
  }

}
