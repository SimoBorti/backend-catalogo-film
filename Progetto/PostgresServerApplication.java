package main.postgresserver.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "main.postgresserver.springboot")
@EntityScan(basePackages = "main.postgresserver.springboot")
@EnableCaching

public class PostgresServerApplication {

	/**
	 * Fa partire l'applicazione .
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PostgresServerApplication.class, args);
	}
}
