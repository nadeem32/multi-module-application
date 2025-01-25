package com.las.moduler.application.core.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.function.Function;
import org.springframework.stereotype.Component;	
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
	
  private Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Strong secret key for HS512
  private int jwtExpirationMs = 600000; // 10 minutes
  private int refreshExpirationMs = 3600000; // 1 hour

  // Generate JWT Token
  public String generateToken(String username) {
      return Jwts.builder()
              .setSubject(username)
              .setIssuedAt(new Date())
              .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
              .signWith(secretKey)
              .compact();
  }

  // Generate Refresh Token
  public String generateRefreshToken(String username) {
      return Jwts.builder()
              .setSubject(username)
              .setIssuedAt(new Date())
              .setExpiration(new Date(System.currentTimeMillis() + refreshExpirationMs))
              .signWith(secretKey)
              .compact();
  }

  // Extract username from token
  public String extractUsername(String token) {
      return extractClaim(token, Claims::getSubject);
  }

  // Extract claim from token
  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
      final Claims claims = extractAllClaims(token);
      return claimsResolver.apply(claims);
  }

  // Extract all claims from token
  private Claims extractAllClaims(String token) {
      return Jwts.parser()
              .setSigningKey(secretKey)
              .parseClaimsJws(token)
              .getBody();
  }

  // Validate token
  public boolean validateToken(String token, String username) {
      final String extractedUsername = extractUsername(token);
      return (username.equals(extractedUsername) && !isTokenExpired(token));
  }

  // Check if token is expired
  private boolean isTokenExpired(String token) {
      return extractExpiration(token).before(new Date());
  }

  // Extract expiration date from token
  private Date extractExpiration(String token) {
      return extractClaim(token, Claims::getExpiration);
  }

	
}

//    @Value("${jwt.secret}")
//    private String secretKey;
//
//    @Value("${jwt.expiration}")
//    private long jwtExpiration;
//
//    // Generate token
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
//
//    // Validate token
//    public boolean validateToken(String token, String username) {
//        final String extractedUsername = extractUsername(token);
//        return (extractedUsername.equals(username) && !isTokenExpired(token));
//    }
//
//    // Extract username
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    // Extract claims
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//    }
//
//    // Check token expiration
//    private boolean isTokenExpired(String token) {
//        return extractClaim(token, Claims::getExpiration).before(new Date());
//    }
//}