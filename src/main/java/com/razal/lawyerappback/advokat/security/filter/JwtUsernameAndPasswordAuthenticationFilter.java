package com.razal.lawyerappback.advokat.security.filter;

import com.razal.lawyerappback.advokat.security.JwtConfig;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@Slf4j
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    final AuthenticationManager authenticationManager;
    final JwtConfig jwtConfig;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager,JwtConfig jwtConfig) {
        this.authenticationManager = authenticationManager;
        this.jwtConfig = jwtConfig;
        this.setFilterProcessesUrl("/welcome");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        log.info("Attepmting authentication with username:{} password:{}",username,password);
        Authentication authentication = new UsernamePasswordAuthenticationToken(username,password);
        Authentication authenticate = authenticationManager.authenticate(authentication);
        return authenticate;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        //if auth success send token in header to user
        String token = Jwts.builder() //header, payload, signature
                .setSubject(authentication.getName()) //Advokat username
                .claim("authorities", authentication.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .signWith(jwtConfig.getSecretKey())
                .compact();

        /* Ne radi redirect
        String redirectUrl = request.getContextPath();
        redirectUrl += "/index";
        System.out.println(redirectUrl);*/

        response.addHeader(jwtConfig.getAuthorizationHeader(),jwtConfig.getTokenPrefix() + token);

    }
}
