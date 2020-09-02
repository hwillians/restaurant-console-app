package dev.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author helvin
 *
 */
@Configuration // Le stéréotype @Configuration précise que cette classe servira de
				// configuration.
@ComponentScan({ "dev" })
@PropertySource("app.properties")
public class AppConfig {

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
