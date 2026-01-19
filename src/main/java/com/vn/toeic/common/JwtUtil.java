package com.vn.toeic.common;

import com.vn.toeic.config.AppProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    private final AppProperties appProperties;

    public String generateAccessToken(UserDetails userDetails) {
        return buildToken(userDetails, appProperties.getAuth().getAccessTokenExpirationMilliseconds(), Constant.JwtType.ACCESS_TOKEN);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return buildToken(userDetails, appProperties.getAuth().getRefreshTokenExpirationMilliseconds(), Constant.JwtType.REFRESH_TOKEN);
    }

    private String buildToken(UserDetails userDetails, long expiration, Constant.JwtType type) {
        return Jwts
                .builder()
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .claim("type", type)
                .signWith(getSignInKey())
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractIssuedAt(String token) {
        return extractClaim(token, Claims::getIssuedAt);
    }

    public Constant.JwtType extractTokenType(String token) {
        Claims claims = extractAllClaims(token);
        return Constant.JwtType.valueOf((String) claims.get("type"));
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsFunction) {
        final Claims claims = extractAllClaims(token);
        return claimsFunction.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private SecretKey getSignInKey() {
        byte[] bytes = Decoders.BASE64.decode(appProperties.getAuth().getTokenSecret());
        return Keys.hmacShaKeyFor(bytes);
    }
}