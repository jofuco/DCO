package com.seatseller.core.lugares;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.seatseller.core.utilizadores.ClienteFinal;

public class Reserva {

	private int codigo;
	private ClienteFinal cli;
	private LocalDate data;
	private LocalTime hora;
	private LinhaReserva liRes;
	private ArrayList<LinhaReserva> linhasRes;
	
	public Reserva(int codigo) {
		this.codigo = codigo;
		data = liRes.getDate();
		hora = liRes.getTime();
		linhasRes = new ArrayList<>();
	}
	
	public void setCliente(ClienteFinal cli) {
		this.cli = cli;
	}
	
	public void finalizar() {
		linhasRes.add(liRes);
	}
	
	public ClienteFinal getCliente() {
		return cli;
	}
	
	public void novaLinha(LocalDate data,LocalTime hora) {
		liRes = new LinhaReserva(data,hora);
	}

	public LocalDate getDataCorrente() {
		return liRes.getDate();
	}

	public LocalTime getHoraCorrente() {
		return liRes.getTime();
	}
	
}
