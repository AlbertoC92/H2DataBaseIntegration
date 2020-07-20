package com.core.H2DataBaseIntegration.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class H2DataBaseIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2DataBaseIntegrationApplication.class, args);
	}

}
