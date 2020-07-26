package com.person.config;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@Configuration
@ComponentScan(basePackages = { "com.person.service" })
@EnableNeo4jRepositories(basePackages = "com.person.dao")
@Profile({ "embedded", "test" })
public class PersonDBTestConfig {

	@Bean
	public org.neo4j.ogm.config.Configuration config() {
		org.neo4j.ogm.config.Configuration config = new Builder().build();
		return config;
	}

	@Bean
	public SessionFactory getSessionFactory() {
		return new SessionFactory(config(), "com.person.domain");
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(getSessionFactory());
	}
}
