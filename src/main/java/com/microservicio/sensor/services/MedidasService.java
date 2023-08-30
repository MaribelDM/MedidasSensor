package com.microservicio.sensor.services;

import com.microservicio.sensor.bean.MedidasRequest;

public interface MedidasService {

	public String almacenarHumedades(MedidasRequest request);

	public String almacenarTemperaturas(MedidasRequest request);
}
