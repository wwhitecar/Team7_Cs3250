package com.team7.app.config;

import com.team7.app.business.dto.ProfessorDto;
import com.team7.app.business.dto.StudentDto;
import com.team7.app.services.ProfessorServices;
import com.team7.app.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class forces a user to log in with credentials
 * to be able to access any of the webpages associated with the
 * application.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Professor Service to access all the professors in the database
     * to give them access to the application.
     */
    @Autowired
    private ProfessorServices profServ;

    /**
     * Student service to access all the students in the database
     * to give them access to the application.
     */
    @Autowired
    private StudentServices studServ;

    /**
     * Will configure the type of security for the web application.
     * @param httpSecurity - security for the http
     * @throws Exception - throws an excetion if it comes accross it.
     */
    public void configure(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/").hasRole("USER")
                .and()
                    .formLogin().and().csrf().disable();
    }

    /**
     * Gives proper access to users so they can access the application.
     * @param auth - authentication manager builder.
     * @throws Exception if it comes accross one
     */
    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("alex")
                .password("password").roles("USER");

        for (ProfessorDto professor : profServ.listAllProfessor()) {
            auth.inMemoryAuthentication().withUser(professor.getFirstName())
                    .password(professor.getLastName()).roles("USER");
        }

        for (StudentDto student : studServ.listAllStudent()) {
            auth.inMemoryAuthentication().withUser(student.getFirstName())
                    .password(student.getLastName()).roles("USER");
        }
    }
}
