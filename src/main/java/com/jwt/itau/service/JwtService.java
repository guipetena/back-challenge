package com.jwt.itau.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwt.itau.model.Name;
import com.jwt.itau.model.Role;
import com.jwt.itau.model.Seed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Base64;
import java.util.Map;

@Service
public class JwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public boolean isValid(String jwt) {
        try {
            // Extrai o payload do JWT (segunda parte do token)
            String[] parts = jwt.split("\\.");
            if (parts.length != 3) {
                logger.debug("Invalid JWT format");
                return false;
            }

            String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]));
            logger.debug("Decoded payload: {}", payloadJson);

            Map<String, Object> claims = objectMapper.readValue(payloadJson, Map.class);

            // Validação do número de claims
            if (claims.size() != 3) {
                logger.debug("Invalid number of claims: {}", claims.size());
                return false;
            }

            // Validação das claims específicas
            Name name = new Name((String) claims.get("Name"));
            Role role = new Role((String) claims.get("Role"));
            Seed seed = new Seed((String) claims.get("Seed"));

            logger.debug("JWT is valid");
            return true;
        } catch (Exception e) {
            logger.debug("Error processing JWT: {}", e.getMessage());
            return false;
        }
    }
}
