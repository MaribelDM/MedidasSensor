package com.microservicio.sensor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.sensor.bean.MedidasRequest;
import com.microservicio.sensor.services.MedidasService;


@RestController
@RequestMapping("/v1/sensores")
@CrossOrigin(origins = "http://localhost:4200")
public class SensorController {
	
	@Autowired
	private MedidasService service;
	
	private SensorController(MedidasService service) {
		this.service = service;
	}
	
	@PostMapping ("/medidas-humedad")
	public String almacenarMedidasHumedad(@RequestBody List<MedidasRequest> request ) {

		return service.almacenarHumedades(request);
	}
	
	@PostMapping ("/medidas-temperatura")
	public String almacenarMedidasTemperatura(@RequestBody List<MedidasRequest> request ) {

		return service.almacenarTemperaturas(request);
	}
	
}
