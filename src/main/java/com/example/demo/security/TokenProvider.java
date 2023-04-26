package com.example.demo.security;

import com.example.demo.model.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;


import java.security.Signature;
import java.time.Instant;
import java.util.Date;
import java.time.temporal.ChronoUnit;

@Slf4j
@Service
public class TokenProvider {
    private static final String SECRET_KEY = "NMA*LJPctFun59f5";

    public String create(UserEntity userEntity){
        Date expiryDate = Date.from(
                Instant.now()
                        .plus(1, ChronoUnit.DAYS));
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
                .setSubject(userEntity.getId())
                .setIssuer("demo app")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .compact();
    }
    public String validateAndGetUserId(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
