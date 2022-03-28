package com.razal.lawyerappback.advokat.security;

import com.razal.lawyerappback.advokat.security.filter.JwtTokenVerifier;
import com.razal.lawyerappback.advokat.security.filter.JwtUsernameAndPasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final JwtConfig jwtConfig;
    final UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("IMplementacija");
        auth.userDetailsService(userDetailsService).passwordEncoder(jwtConfig.passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(super.authenticationManager(),jwtConfig))
                .addFilterAfter(new JwtTokenVerifier(jwtConfig),JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/loginPage")
                .permitAll();
    }


}
