package com.musiccommunity.jwt.authenticationManger;

import com.musiccommunity.jwt.filter.JwtFilter;
import com.musiccommunity.jwt.provider.JwtAuthenticationProvider;
import com.musiccommunity.jwt.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Configuration
@RequiredArgsConstructor
public class AuthenticationManagerConfig extends AbstractHttpConfigurer<AuthenticationManagerConfig, HttpSecurity> {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

        builder.addFilterBefore(
                        new JwtFilter(authenticationManager),
                        UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(jwtAuthenticationProvider);
    }
}