// // // package com.example.demo.security;

// // // import com.example.demo.model.UserAccount;
// // // import io.jsonwebtoken.*;
// // // import java.util.Date;
// // // import org.springframework.stereotype.Component;

// // // @Component

// // // public class JwtTokenProvider {
// // //     private String secretKey;
// // //     private long validityInMilliseconds;

// // //     public JwtTokenProvider(String secretKey, long validityInMilliseconds) {
// // //         this.secretKey = secretKey;
// // //         this.validityInMilliseconds = validityInMilliseconds;
// // //     }

// // //     public String generateToken(UserAccount user) {
// // //         Date now = new Date();
// // //         Date validity = new Date(now.getTime() + validityInMilliseconds);
        
// // //         return Jwts.builder()
// // //                 .setSubject(user.getEmail())
// // //                 .claim("userId", user.getId())
// // //                 .claim("role", user.getRole())
// // //                 .setIssuedAt(now)
// // //                 .setExpiration(validity)
// // //                 .signWith(SignatureAlgorithm.HS256, secretKey)
// // //                 .compact();
// // //     }

// // //     public boolean validateToken(String token) {
// // //         try {
// // //             if (token == null || token.isEmpty()) return false;
// // //             Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
// // //             return true;
// // //         } catch (JwtException | IllegalArgumentException e) {
// // //             return false;
// // //         }
// // //     }

// // //     public String getUsername(String token) {
// // //         return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
// // //     }
// // // }

// // package com.example.demo.security;

// // import org.springframework.beans.factory.annotation.Value;
// // import org.springframework.stereotype.Component;

// // @Component
// // public class JwtTokenProvider {

// //     private final String secretKey;

// //     // ✅ Spring injects value from application.properties
// //     public JwtTokenProvider(
// //             @Value("${jwt.secret}") String secretKey
// //     ) {
// //         this.secretKey = secretKey;
// //     }

// //     // example usage
// //     public String getSecretKey() {
// //         return secretKey;
// //     }
// // }
// package com.example.demo.security;

// import com.example.demo.model.UserAccount;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import java.util.Date;

// @Component
// public class JwtTokenProvider {

//     private final String secretKey;

//     public JwtTokenProvider(
//             @Value("${jwt.secret}") String secretKey
//     ) {
//         this.secretKey = secretKey;
//     }

//     // ✅ THIS METHOD WAS MISSING
//     public String generateToken(UserAccount user) {
//         return Jwts.builder()
//                 .setSubject(user.getUsername())   // or getEmail() if you prefer
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
//                 .signWith(SignatureAlgorithm.HS256, secretKey)
//                 .compact();
//     }
// }
package com.example.demo.security;

import com.example.demo.model.UserAccount;
import io.jsonwebtoken.*;
import java.util.Date;

public class JwtTokenProvider {
    private String secretKey;
    private long validityInMilliseconds;

    public JwtTokenProvider(String secretKey, long validityInMilliseconds) {
        this.secretKey = secretKey;
        this.validityInMilliseconds = validityInMilliseconds;
    }

    public String generateToken(UserAccount user) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            if (token == null || token.isEmpty()) return false;
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}