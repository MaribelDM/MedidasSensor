package com.microservicio.sensor.services.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicio.sensor.bean.AlmacenHumedadRequest;
import com.microservicio.sensor.bean.AlmacenTemperaturaRequest;
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
	public String almacenarHumedades(AlmacenHumedadRequest request) {
		logger.debug("Introducimos humedad valor:{}, fecha:{} ", request.getValor(), request.getFecha());
		String ok  = "ok";
		int tamanio = (int) medidasHumedad.count();
		try {
		List<Humedad> humedades = medidasHumedad.findAllByOrderByFecha();
		
		Humedad humedad = new Humedad();
		humedad.setFecha(MedidasUtils.formatearFecha(request.getFecha()));
		humedad.setValor(request.getValor());
		humedad.setId(humedades.get(tamanio-1).getId()+1);
		
		medidasHumedad.save(humedad);
		
		
		}catch(Exception ex){
			logger.error("Error al introducir humedad en base de datos", ex);
		}
		return  ((int)medidasHumedad.count() > tamanio) ? ok : "ko";
	}

	@Override
	public String almacenarTemperaturas(AlmacenTemperaturaRequest request) {
		logger.debug("Introducimos temperatura valor:{}, fecha:{} ", request.getValor(), request.getFecha());
		String ok  = "ok";
		int tamanio = (int) medidasTemp.count();
		try {
		List<Temperatura> humedades = medidasTemp.findAllByOrderByFecha();
		
		Temperatura temp = new Temperatura();
		temp.setFecha(MedidasUtils.formatearFecha(request.getFecha()));
		temp.setValor(request.getValor());
		temp.setId(humedades.get(tamanio-1).getId()+1);
		
		medidasTemp.save(temp);
		
		
		}catch(Exception ex){
			logger.error("Error al introducir humedad en base de datos", ex);
		}
		return  ((int)medidasTemp.count() > tamanio) ? ok : "ko";
	}
}
