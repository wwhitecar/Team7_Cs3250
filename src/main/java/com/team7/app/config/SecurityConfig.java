package com.team7.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("").hasRole("Student")
                .antMatchers("").hasRole("Professor")
                .antMatchers("").hasRole("ADMIN")
                .and()
                .formLogin();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("").password("").roles("Student")
                .and()
                .withUser("mike").password("").roles("Professor")
                .and()
                .withUser("jim").password("").roles("Professor","Student","ADMIN");
    }

}
