package com.myapi.server.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CookieUtils {

  private final HttpServletResponse response;

  public void setCookieValue(String key, String value) {
    Cookie cookie = new Cookie(key, value);
    cookie.setPath("/");
    cookie.setMaxAge(60 * 60); // Token expiration time in seconds
    cookie.setHttpOnly(true);
    response.addCookie(cookie);
  }

  public String getCookieValue(String cookie, String key) {
    // Create a map object to store key value pairs from the cookie string
    Map<String, String> cookieMap = new HashMap<>();
    String[] cookieKeyValuePairs = cookie.split("; ");

    for (String cookieKeyValuePair : cookieKeyValuePairs) {
      String[] splitCookieKeyValuePair = cookieKeyValuePair.split("=");
      cookieMap.put(splitCookieKeyValuePair[0], splitCookieKeyValuePair[1]);
    }

    return cookieMap.get(key);
  }

}
