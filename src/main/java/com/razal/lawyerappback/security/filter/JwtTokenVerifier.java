package com.razal.lawyerappback.security.filter;

import com.razal.lawyerappback.security.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//invoke filter once per every single request
public class JwtTokenVerifier extends OncePerRequestFilter {

    final JwtConfig jwtConfig;

    public JwtTokenVerifier(JwtConfig config) {
        jwtConfig = config;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //get token from header
        String authorizationHeader = request.getHeader(jwtConfig.getAuthorizationHeader());
        //verify token(sign)
        if(authorizationHeader == null || authorizationHeader.isEmpty() || !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())){
            filterChain.doFilter(request,response);
            return;
        }
        String token = authorizationHeader.replace(jwtConfig.getTokenPrefix(),"");

        try{
            Jwt parsedToken = Jwts.parserBuilder()
                    .setSigningKey(jwtConfig.getSecretKey())
                    .build()
                    .parse(token);

            Claims body = (Claims) parsedToken.getBody();
            String username = body.getSubject();
            var authorities = (List<Map<String,String>>) body.get("authorities");
            Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream()
                    .map(m -> new SimpleGrantedAuthority(m.get("authority")))
                    .collect(Collectors.toSet());

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                username,null,simpleGrantedAuthorities
            );
            SecurityContextHolder.getContext().setAuthentication(authentication); //client who sent the token has been authenticated

        }catch (JwtException e){
            //token has been modified or expired
            throw new IllegalStateException(String.format("Token %s failed authentication", token));
        }

        filterChain.doFilter(request,response); //pass request and response throughout the filter chain untill it reaches api endpoint
    }
}
