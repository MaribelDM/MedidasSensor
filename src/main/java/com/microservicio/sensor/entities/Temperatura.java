package com.microservicio.sensor.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="temperaturas")
public class Temperatura {

	@Id
	private Integer id;
	
	@Column
	private float valor;
	
	@Column
	private LocalDateTime fecha;

	
}
