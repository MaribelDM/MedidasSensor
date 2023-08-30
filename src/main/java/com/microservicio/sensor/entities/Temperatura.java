package com.microservicio.sensor.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "temperatura") 
public class Temperatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private float valor; 
	
	@Column
	private LocalDateTime fecha;
	
	@Column(name = "id_sensor")
	private Integer idSensor;
	
}
