package com.microservicio.sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class MicroservicioSensorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioSensorApplication.class, args);
	}

}
