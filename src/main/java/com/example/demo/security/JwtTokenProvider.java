// package com.example.demo.security;

// import com.example.demo.model.UserAccount;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// import javax.crypto.SecretKey;
// import javax.crypto.spec.SecretKeySpec;
// import java.util.Date;

// public class JwtTokenProvider {

//     private final SecretKey secretKey;
//     private final long validityInMs;

//     public JwtTokenProvider(String secret, long validityInMs) {
//         this.secretKey = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
//         this.validityInMs = validityInMs;
//     }

//     public String generateToken(UserAccount user) {
//         Date now = new Date();
//         Date expiry = new Date(now.getTime() + validityInMs);

//         return Jwts.builder()
//                 .setSubject(user.getEmail())
//                 .claim("id", user.getId())
//                 .claim("role", user.getRole())
//                 .setIssuedAt(now)
//                 .setExpiration(expiry)
//                 .signWith(secretKey, SignatureAlgorithm.HS256)
//                 .compact();
//     }

//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(secretKey)
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (Exception e) {
//             return false;
//         }
//     }

//     public String getUsername(String token) {
//         Claims claims = Jwts.parserBuilder()
//                 .setSigningKey(secretKey)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//         return claims.getSubject();
//     }
// }
package com.example.demo.security;

import com.example.demo.model.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.validity}")
    private long validityInMs;

    private SecretKey secretKey;

    @PostConstruct
    protected void init() {
        byte[] keyBytes = Base64.getEncoder().encode(secret.getBytes());
        this.secretKey =
                new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    public String generateToken(UserAccount user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMs);

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("id", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
