package com.jwt.itau.service;

import com.jwt.itau.util.JwtUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JwtServiceTest {
    private final JwtService jwtValidationService = new JwtService();

    @Test
    void testValidJwt() {
        String jwt = JwtUtil.generateJwt("Admin", "7841", "Toninho Araujo");
        assertTrue(jwtValidationService.isValid(jwt));
    }

    @Test
    void testInvalidJwt() {
        // JWT com assinatura inválida ou malformado
        String jwt = "eyJhbGciOiJIUzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg";
        assertFalse(jwtValidationService.isValid(jwt));
    }

    @Test
    void testJwtWithInvalidName() {
        String jwt = JwtUtil.generateJwt("External", "72341", "M4ria Olivia");
        assertFalse(jwtValidationService.isValid(jwt));
    }

    @Test
    void testJwtWithExtraClaims() {
        // Gere um JWT com mais de 3 claims para teste
        String jwt = JwtUtil.generateJwt("Member", "14627", "Valdir Aranha") + ".ExtraClaim";
        assertFalse(jwtValidationService.isValid(jwt));
    }
}