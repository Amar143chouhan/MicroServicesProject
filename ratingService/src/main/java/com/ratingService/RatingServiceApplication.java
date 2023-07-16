package com.ratingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"com.ratingService"})
@EnableEurekaClient
public class RatingServiceApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(RatingServiceApplication.class, args);
		System.out.println("application started");
	}
}
