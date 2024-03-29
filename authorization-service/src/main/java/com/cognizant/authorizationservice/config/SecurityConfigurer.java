package com.cognizant.authorizationservice.config;

import com.cognizant.authorizationservice.service.AdminDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    private static Logger logger = LoggerFactory.getLogger(SecurityConfigurer.class);

    @Autowired
    AdminDetailService adminDetailService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("START");
        super.configure(auth);
        auth.userDetailsService(adminDetailService);
        logger.info("END");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        logger.info("START");

        web.ignoring().antMatchers("/authapp/login", "/h2-console/**", "/v2/api-docs", "/configuration/ui",
                "/configuration/security", "/webjars/**");
        logger.info("END");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("START");
        http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
                .exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        logger.info("END");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        logger.info("START");
        logger.info("END");
        return super.authenticationManagerBean();
    }

}
