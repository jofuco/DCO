package com.seatseller.core.lugares.alocacao;


import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import com.seatseller.Configuration;
import com.seatseller.core.lugares.Grelha;
import com.seatseller.core.lugares.Lugar;
import com.seatseller.core.lugares.TipoDeLugar;

public class EncontrarLugarStrategyFactory  {
	
	private final LugarAleatorioStrategy las = new LugarAleatorioStrategy();
	private final LugarMaisAfastadoStrategy lmas = new LugarMaisAfastadoStrategy();
	private final PrimeiroLugarStrategy pls = new PrimeiroLugarStrategy();
	

	public String getEncontrarLugarStrategy()  {
		Configuration cfg = new Configuration();
		 return cfg.getProperty("encontrarLugarStrategy");
	}
	
	public Optional<Lugar> getLugar(Grelha g, TipoDeLugar tp, LocalDate d, LocalTime t) {
		String estrategia = null;
		estrategia = getEncontrarLugarStrategy();
		
		Optional<Lugar> lg;
		switch(estrategia) {
		case "PrimeiroLugarStrategy": lg = pls.getLugar(g, tp, d, t);
		case "LugarMaisAfastadoStrategy": lg = lmas.getLugar(g,tp,d,t);
		default: lg = las.getLugar(g, tp, d, t);
		}
		
		return lg;
	}
	
	

}
