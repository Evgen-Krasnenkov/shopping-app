package com.kras.shoppingapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "It is a title of the app", description = "There is a description of the app"))
public class SpringInitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInitApplication.class, args);
	}

}
