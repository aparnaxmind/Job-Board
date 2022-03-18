package com.example.Job.Board.app.security;

//import com.example.Job.Board.app.filter.AuthenticationFilter;
import com.example.Job.Board.app.filter.AuthenticationFilter;
import com.example.Job.Board.app.filter.AutherizationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import static org.springframework.http.HttpMethod.GET;
//import static org.springframework.http.HttpMethod.POST;
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;


import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManagerBean());
        authenticationFilter.setFilterPocessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/api/login/**","/api/token/refresh/**").permitAll();

        http.authorizeRequests().antMatchers(GET, "/api/applicant/**").hasAnyAuthority("ROLE_APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/applicant/save/**").hasAnyAuthority("ROLE_EMPLOYER");
        http.authorizeRequests().antMatchers(GET, "/api/employer/**").hasAnyAuthority("ROLE_APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/employer/save/**").hasAnyAuthority("ROLE_EMPLOYER");
        http.authorizeRequests().antMatchers(GET, "/api/job/**").hasAnyAuthority("ROLE_APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/job/save/**").hasAnyAuthority("ROLE_EMPLOYER");
        http.authorizeRequests().antMatchers(GET, "/api/role/**").hasAnyAuthority("ROLE_APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/role/save/**").hasAnyAuthority("ROLE_EMPLOYER");
        http.authorizeRequests().antMatchers(GET, "/api/skills/**").hasAnyAuthority("ROLE_APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/skills/save/**").hasAnyAuthority("ROLE_EMPLOYER");
        http.authorizeRequests().antMatchers(GET, "/api/users/**").hasAnyAuthority("ROLE_APPLICANT");
        http.authorizeRequests().antMatchers(POST, "/api/users/save/**").hasAnyAuthority("ROLE_EMPLOYER");

        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilter(authenticationFilter );
        http.addFilterBefore(new AutherizationFilter(), UsernamePasswordAuthenticationFilter.class);


    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws  Exception{
        return super.authenticationManagerBean();
    }
}


