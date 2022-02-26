package com.microservicio.sensor.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MedidasUtils {
	
	private MedidasUtils() {}

	public static LocalDateTime formatearFecha(String fecha)
    {

    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    	//convert String to LocalDate
    	LocalDateTime localDate = LocalDateTime.parse(fecha, formatter);
    	return localDate;
        
		
    }
}
