package com.microservicio.sensor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservicio.sensor.entities.Temperatura;

public interface MedidasTemperaturaRepository extends CrudRepository<Temperatura, Long> {
	
	public List<Temperatura> findAllByOrderByFecha();

}
