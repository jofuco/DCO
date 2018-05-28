package com.seatseller.handlers;

import java.util.Optional;

import com.seatseller.api.ICriarGrelhaHandler;
import com.seatseller.api.exceptions.DoesNotExistException;
import com.seatseller.api.exceptions.NonUniqueException;

public class CriarGrelhaHandler implements ICriarGrelhaHandler {

	@Override
	public void iniciarGrelha(String desig, double ind) throws NonUniqueException {
		// TODO
	}

	@Override
	public Optional<String> indicarDimensao(int i, int j) {
		// TODO
		return Optional.empty();
	}

	@Override
	public void indicarTipoPadrao(String desig) throws DoesNotExistException {
		// TODO
	}

	@Override
	public void indicarTipoLugar(int i, int j, String desig) throws DoesNotExistException {
		// TODO
	}

	@Override
	public void terminar() {
		// TODO
	}

}
