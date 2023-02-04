package com.kras.shoppingapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "It is a title of the app", description = "There is a description of the app"))
public class SpringInitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInitApplication.class, args);
	}

}
