package ru.iorikimura.elitejavaapp.services.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.iorikimura.elitejavaapp.dto.models.UserModel;
import ru.iorikimura.elitejavaapp.enums.UserRole;
import ru.iorikimura.elitejavaapp.properties.TokenProperties;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private final TokenProperties tokenProperties;
    @Override
    public UserModel parseToken(String jwtToken) {
        try {
            JwtParser jwtParser = Jwts.parserBuilder()
                    .setSigningKey(getSigninKey())
                    .build();

            Jws<Claims> parsedJwt = jwtParser.parseClaimsJws(jwtToken);

            Claims claims = parsedJwt.getBody();

            return UserModel.builder()
                    .email(claims.getSubject())
                    .userRole(UserRole.valueOf((String) claims.get("role")))
                    .build();
        } catch (ExpiredJwtException e){
            log.info("Jwt is expired: {}", e.getMessage());
            throw new ExpiredJwtException(e.getHeader(), e.getClaims(), e.getMessage());
        }
    }

    @Override
    public String generateToken(UserModel user) {
        Claims claims = Jwts.claims();
        claims.setSubject(user.getEmail());
        claims.put("role", user.getUserRole().getAuthority());
        claims.setExpiration(getExpirationDate());

        return Jwts.builder()
                .addClaims(claims)
                .signWith(getSigninKey())
                .compact();
    }

    private Key getSigninKey() {
        byte[] keyBytes = Base64.getDecoder().decode(tokenProperties.getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Date getExpirationDate(){
        Date now = new Date();
        now.setTime(now.getTime() + 100000);
        return now;
    }
}
