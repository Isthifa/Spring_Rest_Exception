package com.example.spring_exception_validation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger API Demo", version = "1.2", description = "crud operation"))
public class SpringExceptionValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExceptionValidationApplication.class, args);
	}

}
