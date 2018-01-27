package com.ionwallet.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
@EnableJpaRepositories(basePackages={"com.ionwallet.repository"})
public class JPAConfiguration {
	    
		@Autowired
		Environment env;

	    @Bean
	    DataSource dataSource() {
	    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setUsername(env.getProperty("expenses.username"));
	        dataSource.setPassword(env.getProperty("expenses.password"));
	        dataSource.setUrl(env.getProperty("expenses.url"));
	        return dataSource;
	    }
	    
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	       LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	       em.setDataSource(dataSource());
	       em.setPackagesToScan(new String[] { "com.ionwallet.domain" });
	  
	       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	       em.setJpaVendorAdapter(vendorAdapter);
	       em.setJpaProperties(additionalProperties());
	  
	       return em;
	    }
	    
	    Properties additionalProperties() {
	        Properties properties = new Properties();
	        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
	        properties.setProperty("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
	        return properties;
	     }
}
