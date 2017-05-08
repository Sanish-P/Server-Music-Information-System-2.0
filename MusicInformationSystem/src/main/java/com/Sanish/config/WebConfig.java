package com.Sanish.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.Sanish.entity.Audio;
import com.Sanish.entity.Track;
import com.Sanish.entity.User;

@Configuration
@ComponentScan("com.Sanish")
@PropertySource("classpath:database/database.properties")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/views/");
		
		viewResolver.setSuffix(".jsp");
		
		viewResolver.setExposeContextBeansAsAttributes(true);
		
		return viewResolver;
		
	}
	
	@Bean
	public DriverManagerDataSource dataSource(
			@Value("${jdbc.driverClassName}") String driverClassName,
			@Value("${jdbc.url}") String url,
			@Value("${jdbc.username}") String username,
			@Value("${jdbc.password}") String password
			){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(driverClassName);
		
		
		dataSource.setUrl(url);
		
		dataSource.setUsername(username);
		
		dataSource.setPassword(password);
	
		return dataSource;
		
	}
	
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DriverManagerDataSource dataSource){
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		
		
		sessionFactory.setHibernateProperties(hibernateProperties);
		
		
		sessionFactory.setAnnotatedClasses(Track.class,Audio.class,User.class);
		
		sessionFactory.setDataSource(dataSource);
		
		
		return sessionFactory;
		
	}
	

}
