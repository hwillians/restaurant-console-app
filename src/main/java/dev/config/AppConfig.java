package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

//Le stéréotype @Configuration précise que cette classe servira de configuration.
@Configuration
@ComponentScan("dev")


public class AppConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
