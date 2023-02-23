package com.advance.aurore_rh.config;

import com.advance.aurore_rh.service.auth.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity


public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private ApplicationUserService applicationUserService;

    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationUserService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf().and().cors().disable()
              .authorizeHttpRequests()
              .antMatchers(
                      "/swagger-ui.html",
                      "/v2/api-docs",
                      "/**/swagger-resources/**",
                      "/configuration/ui",
                      "/webjars/**" ,
                      "/employer/**",
                      "/contrat/**",
                      "/sanction/**",
                      "/type de contrat/**",
                      "/auth/**")
              .permitAll()
              .anyRequest()
              .authenticated();
    }




    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }
}
