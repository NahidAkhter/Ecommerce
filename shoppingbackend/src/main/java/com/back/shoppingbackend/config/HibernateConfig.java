package com.back.shoppingbackend.config;
import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.back.shoppingbackend.dto")
@EnableTransactionManagement
public class HibernateConfig {
	private final static String DATABASE_URL = "jdbc:oracle:thin:@//Nahid-HP:1522/CIRRUS";
	private final static String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.Oracle12cDialect";
	private final static String DATABASE_USERNAME = "NAHID";
	private final static String DATABASE_PASSWORD = "Welcome123";
	
	@Bean("dataSource")
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println("-------------Inside getSessionFactory 1-----------");
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.back.shoppingbackend.dto");
		System.out.println("-------------Inside getSessionFactory 2-----------");
		return builder.buildSessionFactory();
		
	}


	//All the hibernate properties will be return in this
	private Properties getHibernateProperties() {
		System.out.println("-------------Inside getHibernateProperties 1-----------");
		Properties  properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		System.out.println("-------------Inside getHibernateProperties 2-----------");
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory ){
		System.out.println("-------------Inside getTransactionManager-----------");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	
}
