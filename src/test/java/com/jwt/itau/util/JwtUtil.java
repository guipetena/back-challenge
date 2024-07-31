package com.jwt.itau.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "secret";

    public static String generateJwt(String role, String seed, String name) {
        return Jwts.builder()
                .claim("Role", role)
                .claim("Seed", seed)
                .claim("Name", name)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
