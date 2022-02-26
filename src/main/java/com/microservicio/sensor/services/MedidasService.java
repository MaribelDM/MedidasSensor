package com.microservicio.sensor.services;

import com.microservicio.sensor.bean.AlmacenHumedadRequest;
import com.microservicio.sensor.bean.AlmacenTemperaturaRequest;

public interface MedidasService {

	public String almacenarHumedades(AlmacenHumedadRequest request);

	public String almacenarTemperaturas(AlmacenTemperaturaRequest request);
}
