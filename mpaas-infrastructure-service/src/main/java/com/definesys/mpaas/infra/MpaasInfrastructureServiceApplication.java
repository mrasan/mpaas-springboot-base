package com.definesys.mpaas.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.definesys.mpaas.common","com.definesys.mpaas.infra"})
public class MpaasInfrastructureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpaasInfrastructureServiceApplication.class, args);
	}
}
