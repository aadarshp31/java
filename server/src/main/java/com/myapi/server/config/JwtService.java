package com.myapi.server.config;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
@ConfigurationProperties("MY_CONFIG")
public class JwtService {

  private static String SECRET_KEY;

  public String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  private Date extractExpiration(String token) {
    return extractClaim(token, Claims::getExpiration);
  }

  private SecretKey getSecretKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
  }

  /**
   * This is a generic method that takes a JWT and a Function as parameters.
   * It then applies the provided claimsResolver function to extract a specific
   * claim from the set of claims.
   * 
   * @param <T>            Type of {@code Claim}
   * @param Token          JWT token
   * @param claimsResolver function to extract a particular {@code Claim}
   * @return The extracted claim of type T is returned.
   */
  public <T> T extractClaim(String Token, Function<Claims, T> claimsResolver) {
    Claims claims = extractAllClaims(Token);
    return claimsResolver.apply(claims);
  }

  private Claims extractAllClaims(String token) {
    return Jwts
        .parser()
        .verifyWith(getSecretKey())
        .build()
        .parseSignedClaims(token)
        .getPayload();
  }

  public String generateToken(UserDetails userDetails) {
    return generateToken(userDetails, new HashMap<>());
  }

  public String generateToken(UserDetails userDetails, HashMap<String, Object> extraClaims) {
    return Jwts
        .builder()
        .claims(extraClaims)
        .subject(userDetails.getUsername())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 1)) // 1 hour expiration
        .signWith(getSecretKey(), SIG.HS256)
        .compact();
  }

  public boolean isTokenValid(String token, UserDetails userDetails) {
    String username = extractUsername(token);
    return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
  }

  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

}
