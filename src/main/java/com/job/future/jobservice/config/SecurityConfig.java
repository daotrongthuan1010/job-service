package com.job.future.jobservice.config;

import com.job.future.jobservice.config.oauthen2.CustomOAuthen2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final CustomOAuthen2UserService userService;

  private final String[] urlPermitAll = {
      "/province/**", "/add/**","/job/**","/login"
  };
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/login/**","/").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin().permitAll()
        .loginPage("/login")
        .and()
        .oauth2Login()
        .loginPage("/login")
        .userInfoEndpoint()
        .userService(userService);
  }




}
