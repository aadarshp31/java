package com.myapi.server.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    // Create a new cookie
    Cookie cookie = new Cookie("customCookie", "cookieValue");

    // Set the path of the cookie (optional)
    cookie.setPath("/");

    // Set the maximum age of the cookie in seconds (optional)
    cookie.setMaxAge(3600); // 1 hour

    // Add the cookie to the response
    response.addCookie(cookie);
  }

}
