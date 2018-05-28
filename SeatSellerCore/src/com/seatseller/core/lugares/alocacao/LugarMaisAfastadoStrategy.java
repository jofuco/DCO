package com.seatseller.core.lugares.alocacao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import com.seatseller.core.lugares.Grelha;
import com.seatseller.core.lugares.Lugar;
import com.seatseller.core.lugares.TipoDeLugar;

public class LugarMaisAfastadoStrategy implements IEncontrarLugarStrategy {

	public Optional<Lugar> getLugar(Grelha g, TipoDeLugar tp, LocalDate d, LocalTime t) {
		ArrayList<Lugar> all = new ArrayList<Lugar> ();
		ArrayList<Lugar> cache = g.getLugares();
		double dist = 0;
		double distComp;
		int maxIndex = 0;
		Lugar x, y;
		// Math.sqrt(Math.pow(p1.x - p2.x, 2.0) + Math.pow(p1.y - p2.y, 2.0))
		//Cria lista de lugares indisponíveis para realizar cálculos posteriormente.

		for(int i = 0; i<cache.size(); i++) {
			if(!cache.get(i).disponivel(d, t)) {
				all.add(cache.get(i));				
			}
			for(int j = 0; j<cache.size(); j++) {
				x = cache.get(j);
				y = all.get(j);
				distComp = Math.sqrt(Math.pow(x.getLarg() - y.getLarg(), 2) + Math.pow(x.getAlt() - y.getAlt(), 2));
				if (distComp > dist) {
					dist = distComp;
					maxIndex = j;
				}
			}
		}
		return Optional.ofNullable(cache.get(maxIndex));
	}

}


