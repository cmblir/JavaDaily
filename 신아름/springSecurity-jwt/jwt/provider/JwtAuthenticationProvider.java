package com.musiccommunity.jwt.provider;

import com.musiccommunity.jwt.token.JwtAuthenticationToken;
import com.musiccommunity.jwt.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        log.info("jwtAuthenticationProvider");
        JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken) authentication;

        String userId = jwtTokenUtil.getId(authenticationToken.getToken());

        List<GrantedAuthority> authorities = Collections.emptyList();

        return new JwtAuthenticationToken(authorities, userId, null);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
