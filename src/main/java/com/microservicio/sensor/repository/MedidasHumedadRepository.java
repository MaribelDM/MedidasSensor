package com.microservicio.sensor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservicio.sensor.entities.Humedad;

@Repository
public interface MedidasHumedadRepository extends CrudRepository<Humedad, Long> {
	
	public List<Humedad> findAllByOrderByFecha();

}
