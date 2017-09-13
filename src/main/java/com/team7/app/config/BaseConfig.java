package com.team7.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration //Enables Spring to instantiate each object 
public class BaseConfig {
	@Bean(name="scheduleDataSource") //There are only SINGLE instance of a given bean. 
	@ConfigurationProperties(prefix = "schedule.database")//Wires the YAML file configurations to the data source
	public DataSource scheduleDataSource() {//
		System.out.println("Try");
		return DataSourceBuilder.create().build();
	}

	@Bean // Uses the above DataSource on instantiation
	public NamedParameterJdbcTemplate namedJdbcTemplate(@Autowired DataSource scheduleDataSource) {//Used to open a connection to the database. Allows names for parameters.
		return new NamedParameterJdbcTemplate(scheduleDataSource);
	}
}