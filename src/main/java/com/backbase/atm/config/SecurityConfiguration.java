package com.backbase.atm.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configure Spring Security
 * 
 * @author Carlos Alberto
 *
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // Permit root pages and authenticate Apis using Basic Auth
        http.authorizeRequests().antMatchers("/*").permitAll().antMatchers("/api/**").authenticated().and().httpBasic();
    }
}