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
		
		for(int i = 0; i< lg.size(); i++) {
			Lugar teste = lg.get(i);
			if(teste.disponivel(d, t) && (teste.getDesignacaoTipo().equals(tp.getDesig()))) 
				return Optional.ofNullable(teste);
			
		}
		return Optional.empty();
	}
}
