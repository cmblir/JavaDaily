package com.musiccommunity.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenUtil {

    @Value("${jwt.token.secret}")
    private String secretKey;
    private final Long accessExpireTimeMs = 1000 * 60l; // 1분
    private final Long refreshExpireTimeMs = 1000 * 60l * 5; // 5분

    public String createToken(String id, String nickname, String key, long expireTimeMs){
        Claims clams = Jwts.claims();
        clams.put("id", id);
        clams.put("nickname", nickname);

        return Jwts.builder()
                .setClaims(clams)
                .setIssuedAt(new Date(System.currentTimeMillis())) // 만든 날짜
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs)) // 만료 날짜
                .signWith(SignatureAlgorithm.HS256, key)
                .compact()
                ;
    }

    public String createAccessToken(String id, String nickname){
        return createToken(id, nickname, secretKey, accessExpireTimeMs);
    }

    public String createRefreshToken(String id, String nickname){
        return createToken(id, nickname, secretKey, refreshExpireTimeMs);
    }

    public boolean isExpired(String token){
        try {
            return Jwts.parserBuilder().setSigningKey(secretKey).build()
                    .parseClaimsJws(token).getBody().getExpiration().before(new Date());
        } catch (ExpiredJwtException ex) {
            // 토큰이 만료된 경우 처리
            return true;
        }
    }

    public String getNickname(String token){
        return Jwts.parserBuilder().setSigningKey(secretKey).build()
                .parseClaimsJws(token).getBody().get("nickname", String.class);
    }

    public String getId(String token){
        return Jwts.parserBuilder().setSigningKey(secretKey).build()
                .parseClaimsJws(token).getBody().get("id", String.class);
    }

}