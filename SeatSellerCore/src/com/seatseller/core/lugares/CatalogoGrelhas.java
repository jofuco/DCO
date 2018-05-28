package com.seatseller.core.lugares;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.seatseller.api.wrappers.Combinacao;

public class CatalogoGrelhas {

	private Map<String, Grelha> gr = new HashMap<>();
	private ArrayList<Combinacao> combinacoes;

	/**
	 * Verifica se jah existe a grelha com a designacao design
	 * 
	 * @param desig designacao da grelha a verificar
	 * @return true se jah existe; false cc
	 */
	public boolean existeGrelha(String desig) {
		return gr.get(desig) != null;
	}

	public void acrescentaGrelha(Grelha g) {
		gr.put(g.getDesig(), g);
	}

	public Optional<Grelha> getGrelha(String desig){
		return Optional.ofNullable(gr.get(desig));
	}
	
	public ArrayList<Combinacao> getCombinacoes(LocalDate date, LocalTime time) {
		combinacoes = new ArrayList<>();
		
		for (Map.Entry<String, Grelha> entry : gr.entrySet())
		{
		    combinacoes.addAll(entry.getValue().getCombinacoes(date, time));
		}
		
		return combinacoes;
	}
}
