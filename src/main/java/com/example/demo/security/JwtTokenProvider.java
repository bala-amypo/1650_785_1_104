// src/main/java/com/example/demo/security/JwtTokenProvider.java
package com.example.demo.security;

import com.example.demo.entity.User;
import com.example.demo.entity.Role;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class JwtTokenProvider {

    // Just a marker so the token is not plain text
    private static final String SECRET_PREFIX = "SECRET:";

    // Generate token from a User: base64("id|email|ROLE1,ROLE2")
    public String generateToken(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        Long id = user.getId();
        String email = user.getEmail();

        String rolesPart = "";
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            rolesPart = user.getRoles()
                    .stream()
                    .map(Role::getName)
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(","));
        }

        String raw = id + "|" + (email == null ? "" : email) + "|" + rolesPart;
        String tokenBody = Base64.getEncoder()
                .encodeToString(raw.getBytes(StandardCharsets.UTF_8));

        return SECRET_PREFIX + tokenBody;
    }

    // Basic validation: format + base64 decodes and has at least 2 parts
    public boolean validateToken(String token) {
        if (token == null || !token.startsWith(SECRET_PREFIX)) {
            return false;
        }
        String body = token.substring(SECRET_PREFIX.length());
        try {
            byte[] decoded = Base64.getDecoder().decode(body);
            String raw = new String(decoded, StandardCharsets.UTF_8);
            String[] parts = raw.split("\\|", -1);
            return parts.length >= 2 && !parts[0].isEmpty();
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    private String[] decodeParts(String token) {
        if (!validateToken(token)) {
            throw new IllegalArgumentException("Invalid token");
        }
        String body = token.substring(SECRET_PREFIX.length());
        byte[] decoded = Base64.getDecoder().decode(body);
        String raw = new String(decoded, StandardCharsets.UTF_8);
        return raw.split("\\|", -1);
    }

    public Long getUserIdFromToken(String token) {
        String[] parts = decodeParts(token);
        return Long.valueOf(parts[0]);
    }

    public String getEmailFromToken(String token) {
        String[] parts = decodeParts(token);
        return parts.length > 1 ? parts[1] : null;
    }

    public List<String> getRolesFromToken(String token) {
        String[] parts = decodeParts(token);
        if (parts.length < 3 || parts[2].isEmpty()) {
            return Collections.emptyList();
        }
        String[] roleNames = parts[2].split(",");
        List<String> roles = new ArrayList<>();
        for (String r : roleNames) {
            if (!r.isBlank()) {
                roles.add(r.trim());
            }
        }
        return roles;
    }
}
