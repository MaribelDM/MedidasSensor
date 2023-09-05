package com.microservicio.sensor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.sensor.entities.Temperatura;

@Repository
public interface MedidasTemperaturaRepository extends CrudRepository<Temperatura, Long> {
	
	public List<Temperatura> findAllByOrderByFecha();

}
