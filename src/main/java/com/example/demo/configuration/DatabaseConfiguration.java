package com.example.demo.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {
    public static final String MAIN_DATASOURCE = "MainDS";

    @Bean(name = MAIN_DATASOURCE, destroyMethod = "")
    @ConfigurationProperties(prefix = "spring.datasource.main")
    @Primary
    public DataSource dataSourceMain() {
        return new HikariDataSource();
    }

}
