package project.capstone.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String email) {
        Date expiryDate = new Date(System.currentTimeMillis() + 3600000);

        String token = Jwts.builder()
                .setSubject(email)
                .setExpiration(expiryDate)
                .signWith(SECRET_KEY)
                .compact();

        return token;
    }

    public Claims parseToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims;
    }
}
