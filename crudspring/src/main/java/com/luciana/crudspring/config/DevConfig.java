package com.luciana.crudspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.luciana.crudspring.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired
    private DBService dbservice;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean dataBaseInstance() {
        if (strategy.equals("create")) {
            this.dbservice.dataBaseInstance();
        }
        return false;
    }
}
