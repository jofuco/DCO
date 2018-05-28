package com.seatseller.handlers;

import com.seatseller.api.IAssociarGrelhaHandler;
import com.seatseller.api.IConcluirReservaHandler;
import com.seatseller.api.ICriarGrelhaHandler;
import com.seatseller.api.ICriarTipoDeLugarHandler;
import com.seatseller.api.IDesassociarGrelhaHandler;
import com.seatseller.api.IReservarLugarHandler;
import com.seatseller.api.ISessao;
import com.seatseller.core.lugares.CatalogoTiposDeLugar;
import com.seatseller.core.utilizadores.Administrador;
import com.seatseller.core.utilizadores.CatalogoUtilizadores;
import com.seatseller.core.utilizadores.ClienteFinal;
import com.seatseller.core.utilizadores.Funcionario;
import com.seatseller.core.utilizadores.Utilizador;

public class Sessao implements ISessao {

	private Utilizador utilizador;	
	private CatalogoTiposDeLugar catTipos;

	public Sessao(String u, CatalogoUtilizadores catUtilizadores, CatalogoTiposDeLugar catTipos) { // TODO
		// TODO
	}

	@Override
	public ICriarTipoDeLugarHandler getCriarTipoDeLugarHandler() {
		return new CriarTipoDeLugarHandler(catTipos);
	}

	@Override
	public ICriarGrelhaHandler getCriarGrelhaHandler() {
		return new CriarGrelhaHandler();
	}
	
	public IReservarLugarHandler getReservarLugarHandler() {
		return new ReservarLugarHandler();
	}

	@Override
	public IConcluirReservaHandler getConcluirReservaHandler() {
		return new ConcluirReservaHandler();
	}

	@Override
	public boolean isClienteFinal() {
		return utilizador instanceof ClienteFinal;
	}

	@Override
	public boolean isAdministrador() {
		return utilizador instanceof Administrador;
	}

	@Override
	public boolean isFuncionario() {
		return utilizador instanceof Funcionario;
	}
	
	@Override
	public IAssociarGrelhaHandler getAssociarGrelhaHandler() {
		return new AssociarGrelhaHandler();
	}
	
	@Override
	public IDesassociarGrelhaHandler getDesassociarGrelhaHandler() {
		return new DesassociarGrelhaHandler();
	}

	

}
