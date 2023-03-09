package com.online.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties", "classpath:packages.properties" })
public class JpaConfig {

	private final Environment environment;

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setConnectionTestQuery("SELECT 1");
		config.setPoolName("springHikariCP");
		config.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		config.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
		config.setUsername(environment.getRequiredProperty("jdbc.username"));
		config.setPassword(environment.getRequiredProperty("jdbc.password"));
		config.setMaximumPoolSize(Integer.parseInt(environment.getProperty("hikari.maximum.pool.size")));
		config.addDataSourceProperty("dataSource.cachePrepStmts", environment.getProperty("hikari.cachePrepStmts"));
		config.addDataSourceProperty("dataSource.prepStmtCacheSize",
				environment.getProperty("hikari.prepStmtCacheSize"));
		config.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit",
				environment.getProperty("hikari.prepStmtCacheSqlLimit"));
		config.addDataSourceProperty("dataSource.useServerPrepStmts",
				environment.getProperty("hikari.useServerPrepStmts"));
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] { environment.getProperty("scan.entity") });
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.setJpaProperties(jpaProperties());
		return factoryBean;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		return vendorAdapter;
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.physical_naming_strategy",
				environment.getProperty("hibernate.physical_naming_strategy"));
		return properties;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
