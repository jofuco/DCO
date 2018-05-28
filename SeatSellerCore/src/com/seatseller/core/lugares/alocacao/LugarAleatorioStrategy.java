package com.seatseller.core.lugares.alocacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import com.seatseller.core.lugares.Grelha;
import com.seatseller.core.lugares.Lugar;
import com.seatseller.core.lugares.TipoDeLugar;

public class LugarAleatorioStrategy implements IEncontrarLugarStrategy {

	public Lugar getLugar(ArrayList<Lugar> lugares, String estrategia) {
		Random r = new Random();
		return lugares.get(r.nextInt((lugares.size() - 0) + 1) + 0);

	}


	public Optional<Lugar> getLugar(Grelha g, TipoDeLugar tp, LocalDate d, LocalTime t) {
		ArrayList<Lugar> lg = g.getLugares();
		

		Random r = new Random();
		for(int i = 0; i<lg.size(); i++) {
			Lugar teste = lg.get(r.nextInt((lg.size() - 0) + 1) + 0);
			if(teste.disponivel(d, t) && (tp.getDesig().equals(teste.getDesignacaoTipo()))) 
				return Optional.ofNullable(teste);
			
		}
		return Optional.empty();

	}
}
