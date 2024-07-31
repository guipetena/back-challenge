package com.jwt.itau.controller;

import com.jwt.itau.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JwtController {

    @Autowired
    private JwtService jwtValidationService;

    @GetMapping("/validate-jwt")
    public ResponseEntity<Boolean> validateJwt(@RequestParam String jwt) {
        boolean isValid = jwtValidationService.isValid(jwt);
        return ResponseEntity.ok(isValid);
    }
}

