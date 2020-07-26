package com.person.config;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

@Configuration
@ComponentScan(basePackages = { "com.person.service" })
@EnableNeo4jRepositories(basePackages = "com.person.dao")
public class PersonDBConfig {

	public static final String URL = System.getenv("NEO4J_URL") != null ? System.getenv("NEO4J_URL")
			: "http://neo4j:person@localhost:7474";

	@Bean
	public org.neo4j.ogm.config.Configuration config() {
		return new Builder().uri(URL).build();
	}

	@Bean
	public SessionFactory sessionFactory() {
		return new SessionFactory(config(), "com.person.domain");
	}
	
	@Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }
}
