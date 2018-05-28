package com.seatseller.core.lugares;

import java.time.LocalDate;
import java.time.LocalTime;

public class LinhaReserva {

	private LocalDate data;
	private LocalTime hora;
	private Lugar[] lugares;
	
	
	public LinhaReserva(LocalDate data, LocalTime hora) {
		this.data = data;
		this.hora = hora;
	}

	public LocalDate getDate() {
		return data;
	}

	public LocalTime getTime() {
		return hora;
	}
	
	public double getSubtotal() {
		int ret=0;
		for (int i = 0; i < lugares.length; i++) {
			ret += lugares[i].getPreco();
		}
		return ret;
	}
	
}
