package com.example.vegan_life.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Component
public class TokenProvider {
    private static final String AUTHORITES_KEY ="auth";

    private static final String secret = "sdfwelifji34r9ufsdfe4t4y65u567sdfb5768miupdgnokewlrkjciiwjediprc903u50coiewrajtajwjiwocijoiejgfoijawecr";


    public static String createToken(String subject, long expTime){
        if (expTime<0){
            throw new RuntimeException("만료시간이 0보다 커야 함");
        }
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(secret);
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());

        return Jwts.builder()
                .setSubject(subject) // User Id
                .signWith(signingKey, signatureAlgorithm)
                .setExpiration(new Date(System.currentTimeMillis()+expTime))
                .compact();

    }

    public String getSubject(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey((DatatypeConverter.parseBase64Binary(secret)))
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

}
