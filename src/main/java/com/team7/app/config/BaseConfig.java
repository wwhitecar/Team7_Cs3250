package com.team7.app.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Enable spring to instantiate each object.
 */
@Configuration
public class BaseConfig {

    /**
     * There are only SINGLE instance of a given bean.
     * @return DataSource
     */
    @Bean(name = "scheduleDataSource")

    /**
     * Wires the YAML file configurations to the data source.
     * @return DataSource
     */
    @ConfigurationProperties(prefix = "schedule.database")
    public DataSource scheduleDataSource() {
        return DataSourceBuilder.create().build();
    }
}
