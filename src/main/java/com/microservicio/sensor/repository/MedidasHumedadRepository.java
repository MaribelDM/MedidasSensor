package com.microservicio.sensor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservicio.sensor.entities.Humedad;

public interface MedidasHumedadRepository extends CrudRepository<Humedad, Long> {
	
	public List<Humedad> findAllByOrderByFecha();

}
