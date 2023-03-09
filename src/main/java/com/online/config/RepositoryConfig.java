package com.online.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@PropertySource(value = { "classpath:packages.properties" })
@EnableJpaRepositories(basePackages = "${scan.repository}")
public class RepositoryConfig {

}
