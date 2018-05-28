package com.seatseller.core.lugares;

import java.time.LocalDate;
import java.time.LocalTime;

import com.seatseller.core.lugares.alocacao.IEncontrarLugarStrategy;

public class Lugar {
	private int alt;
	private int larg;
	private TipoDeLugar tipo;
	private Grelha grelha;
	private double preco;
	private boolean disponivel;
	
	public Lugar(int alt, int larg, TipoDeLugar padrao, Grelha grelha ) {
		this.alt = alt;
		this.larg = larg;
		tipo = padrao;
		this.grelha = grelha;
		preco = tipo.getPreco() * grelha.getIndice();
		this.disponivel = true;
	}

	
	/**
	 * 
	 * @return
	 * @requires disponivel(data,hora)
	 */
	public String getDesignacaoTipo() {
		return tipo.getDesig();
	}

	public void definirTipo(TipoDeLugar tipo) {
		this.tipo = tipo;
	}

	public int getAlt() {
		return alt;
	}

	public int getLarg() {
		return larg;
	}

	public Grelha getGrelha() {
		return grelha;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void mudaDisp() {
		if(disponivel)
			disponivel = false;
		else
			disponivel = true;
	}
	
	public boolean disponivel(LocalDate data, LocalTime hora) {
		return true;
			
	}



}
