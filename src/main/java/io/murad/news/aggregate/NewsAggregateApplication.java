package io.murad.news.aggregate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "io.murad.news.aggregate.repository")
public class NewsAggregateApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsAggregateApplication.class, args);
	}

}
