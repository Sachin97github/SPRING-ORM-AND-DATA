package com.nit.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class PersistenceConfig {

	public DataSource getHkDs()
	{
		HikariDataSource hkds=new HikariDataSource();
		
		
		return hkds;
	}
	
	
	

}
