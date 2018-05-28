package com.seatseller.core.lugares.alocacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import com.seatseller.core.lugares.Grelha;
import com.seatseller.core.lugares.Lugar;
import com.seatseller.core.lugares.TipoDeLugar;

public class PrimeiroLugarStrategy implements IEncontrarLugarStrategy {

	public Optional<Lugar> getLugar(Grelha g, TipoDeLugar tp, LocalDate d, LocalTime t) {
		ArrayList<Lugar> lg = g.getLugares();
		Lugar teste = lg.get(0);
		return Optional.ofNullable(teste);
	}

}
