package com.seatseller.handlers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.seatseller.api.IReservarLugarHandler;
import com.seatseller.api.exceptions.DoesNotExistException;
import com.seatseller.api.exceptions.InvalidCreditCardException;
import com.seatseller.api.wrappers.Combinacao;

public class ReservarLugarHandler implements IReservarLugarHandler {

	@Override
	public void indicarCliente(String username) throws DoesNotExistException {
		// TODO
	}


	@Override
	public Iterable<Combinacao> indicarDataHora(LocalDate date, LocalTime time) {
		// TODO
		return new ArrayList<>();
	}


	@Override
	public String indicarCombinacao(String grelha, String tipoDeLugar) throws DoesNotExistException {
		// TODO
		return "";
	}


	@Override
	public void terminarLugares() {
		// TODO
	}


	@Override
	public double indicarCC(String numero, int ccv, int mes, int ano) throws InvalidCreditCardException {
		// TODO
		return 0.0;
	}


	@Override
	public String confirmarReserva() {
		// TODO
		return "";
	}

}
