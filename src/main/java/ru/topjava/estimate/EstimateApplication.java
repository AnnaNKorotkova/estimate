package ru.topjava.estimate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EstimateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstimateApplication.class, args);
	}

}
