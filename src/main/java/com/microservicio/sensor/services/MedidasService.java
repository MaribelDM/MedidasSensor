package com.microservicio.sensor.services;

import java.util.List;

import com.microservicio.sensor.bean.MedidasRequest;

public interface MedidasService {

	public String almacenarHumedades(List<MedidasRequest> request);

	public String almacenarTemperaturas(List<MedidasRequest> request);
}
