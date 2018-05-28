package com.seatseller.core.lugares;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Observable;
import java.util.Optional;

import com.seatseller.api.wrappers.Combinacao;
import com.seatseller.core.lugares.alocacao.EncontrarLugarStrategyFactory;
import com.seatseller.core.lugares.alocacao.IEncontrarLugarStrategy;

public class Grelha extends Observable {
	private String desig;
	private double indice;
	private int alt;
	private int larg;
	private ArrayList<Lugar> lugares;
	private TipoDeLugar tlp;
	private ArrayList<Combinacao> lc;
	private String estrategia;

	/**
	 * Construtor da Grelha, apenas se não existir já grelha com desig dada
	 * @param desig
	 * @param ind
	 */
	public Grelha(String desig, double ind) {
		this.desig = desig;
		this.indice = ind;
		tlp = null;
		lugares = new ArrayList<>();
	}

	public String getDesig() {
		return desig;
	}

	public double getIndice() {
		return indice;
	}

	public int getAlt() {
		return alt;
	}

	public int getLarg() {
		return larg;
	}

	public ArrayList<Lugar> getLugares() {
		return lugares;
	}

	public TipoDeLugar getTlp() {
		return tlp;
	}


	public void criaLugares(int alt,int larg, Optional<TipoDeLugar> tipo){
		if(tipo.isPresent()) {
			criaLugAux(alt,larg,tipo.get());
		}else {
			criaLugAux(alt,larg,null);
		}
		
		setChanged(); 
	    notifyObservers(this);
		
		
	}


	/**
	 * 
	 * @param tipo
	 * @requires tipo.isPresent()
	 */
	public void defineTipoLugarPadrao(TipoDeLugar tipo) {
		tlp = tipo;
		lugares.stream().forEach(l-> l.definirTipo(tipo));
	}
	
	
	
	/**
	 * 
	 * @param tipo
	 * @requires tipo.isPresent() && coordenadasValidas()
	 */
	public void defineTipoLugar(int i, int j, TipoDeLugar tipo) {
		getLugar(i,j).definirTipo(tipo);
	}
	
	

	public boolean coordenadasValidas(int i, int j) {
		return getLugar(i,j)!=null;
	}
	
	
	
	
	public Lugar getLugar(int i, int j) {
		for (Lugar lugar : lugares) {
			if(lugar.getAlt() == i && lugar.getLarg() == j) {
				return lugar;
			}
		}
		return null;
	}
	
	public Lugar getDisponivel(TipoDeLugar tipo, LocalDate data, LocalTime hora) {
		EncontrarLugarStrategyFactory elsf = new EncontrarLugarStrategyFactory();
		Optional<Lugar> l = elsf.getLugar(this, tipo, data, hora);
		return l.get();
	}
	
	
	private void criaLugAux(int alt, int larg, TipoDeLugar tipo) {
		for (int i = 0; i < alt; i++) {
			for (int j = 0; j < larg; j++) {
				lugares.add(new Lugar(i,j,tipo,this));
			}
		}
	}

	public ArrayList<Combinacao> getCombinacoes(LocalDate date, LocalTime time) {
		
		String desig = this.getDesig();
		lc = new ArrayList<>();
		
		
		for (Lugar lug : lugares){
		    if(lug.disponivel(date, time)) {
		    	String tp = lug.getDesignacaoTipo();
		    	boolean haTipoLugar = verificaTipoIgual(tp);
		    	double preco = lug.getPreco();
		    	if(!haTipoLugar) {
		    		Combinacao novaC = new Combinacao(desig, tp, preco);
		    		lc.add(novaC);
		    	}
		    }
		    
		}
		
		return null;
	}

	private boolean verificaTipoIgual(String tp) {
		for(Combinacao comb : lc) {
			if(comb.getTipoDeLugar() == tp) {
				comb.aumentaDisponibilidade();
				return true;
			}
		}
		return false;
	}
	
	


	
}


