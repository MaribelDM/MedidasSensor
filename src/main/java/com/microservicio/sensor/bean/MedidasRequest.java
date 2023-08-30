package com.microservicio.sensor.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedidasRequest {

	@Schema(name = "valor", description = "Valor tomado por el sensor de humedad", example = "32.4")
	private float valor;

	@Schema(name = "fecha", description = "Fecha en la que se realizó la medición", example = "2020-10-22 11:22:11")
	private String fecha;

	@Schema(name = "idSensor", description = "Identificador sensor ", example = "2")
	private String idSensor;
}
