package com.team7.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Enable sprint to iinstantiate each object.
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
        System.out.println("Try");
        return DataSourceBuilder.create().build();
    }

    /**
     * Used to open a connection to the database.
     * Allows names for parameters.
     * @param scheduleDataSource - data source
     * @return NamedParameterJdbcTemplate - for acess to the sql DB
     */
    @Bean
    public NamedParameterJdbcTemplate namedJdbcTemplate(
            final @Autowired DataSource scheduleDataSource) {
        return new NamedParameterJdbcTemplate(scheduleDataSource);
    }
}
