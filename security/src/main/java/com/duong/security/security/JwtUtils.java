package com.duong.security.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
@Component
public class JwtUtils {
    @Value("${duong.app.jwtSecret}")
    private String jwtSecret;
    @Value("${duong.app.jwtExpirationMs}")
    private int jwtExpiration;

    private Key getSigningKey() {
        byte[] keyBytes = this.jwtSecret.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateTokenByUserName(String userName) {
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration ))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUserNameByToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateJwtToken(String authToken) {
        try { Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            System.out.println("loi token: " + e.getMessage());
        }
        return false;
    }

}
