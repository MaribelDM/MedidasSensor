package com.microservicio.sensor.services.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.sensor.bean.MedidasRequest;
import com.microservicio.sensor.entities.Humedad;
import com.microservicio.sensor.entities.Temperatura;
import com.microservicio.sensor.repository.MedidasHumedadRepository;
import com.microservicio.sensor.repository.MedidasTemperaturaRepository;
import com.microservicio.sensor.services.MedidasService;
import com.microservicio.sensor.util.MedidasUtils;

@Service
public class MedidasServiceImpl implements MedidasService {

	Logger logger = LoggerFactory.getLogger(MedidasServiceImpl.class);
	
	@Autowired
	private MedidasHumedadRepository medidasHumedad;
	
	@Autowired
	private MedidasTemperaturaRepository medidasTemp;

	@Override
	public String almacenarHumedades(List<MedidasRequest> request) {
		int tamanio = (int) medidasHumedad.count();
		String ok = "ok";
		request.stream().forEach(medidaHumedad -> introducirhumedad(medidaHumedad));

		return ((int) medidasHumedad.count() > tamanio) ? ok : "ko";
	}

	private void introducirhumedad(MedidasRequest medidaHumedad) {
		logger.debug("Introducimos humedad valor:{}, fecha:{} ", medidaHumedad.getValor(), medidaHumedad.getFecha());

		try {
			Humedad humedad = new Humedad();
			humedad.setFecha(MedidasUtils.formatearFecha(medidaHumedad.getFecha()));
			humedad.setValor(medidaHumedad.getValor());
			humedad.setIdSensor(Integer.valueOf(medidaHumedad.getIdSensor()));

			medidasHumedad.save(humedad);
		} catch (Exception ex) {
			logger.error("Error al introducir humedad en base de datos", ex);
		}
	}

	@Override
	public String almacenarTemperaturas(List<MedidasRequest> request) {
		String ok  = "ok";
		int tamanio = (int) medidasTemp.count();
		request.stream().forEach(medidaTemperatura -> introducirTemperatura(medidaTemperatura));
		return  ((int)medidasTemp.count() > tamanio) ? ok : "ko";
	}

	private void introducirTemperatura(MedidasRequest medidaTemperatura) {
		logger.debug("Introducimos temperatura valor:{}, fecha:{} ", medidaTemperatura.getValor(), medidaTemperatura.getFecha());
		try {
			Temperatura temp = new Temperatura();
			temp.setFecha(MedidasUtils.formatearFecha(medidaTemperatura.getFecha()));
			temp.setValor(medidaTemperatura.getValor());
			temp.setIdSensor(Integer.valueOf(medidaTemperatura.getIdSensor()));

			medidasTemp.save(temp);

		} catch (Exception ex) {
			logger.error("Error al introducir humedad en base de datos", ex);
		}
	}
}
