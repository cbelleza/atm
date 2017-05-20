package com.backbase.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Application to expose and receive all ING ATMs
 * 
 * @author Carlos Alberto
 *
 */
@SpringBootApplication
public class AtmApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AtmApplication.class);
    }

    public static void main(final String[] args) {
        SpringApplication.run(AtmApplication.class, args);
    }
}