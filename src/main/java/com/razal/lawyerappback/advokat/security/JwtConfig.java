package com.razal.lawyerappback.advokat.security;

import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.crypto.SecretKey;
import com.google.common.net.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

//key - random word
//secretKey - signed key

@Data
@Component
@ConfigurationProperties(prefix = "app.jwt")
public class JwtConfig {

    String key;
    String tokenPrefix;
    Integer tokenExpirationAfterDays;

    public String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }

    @Bean
    public SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
