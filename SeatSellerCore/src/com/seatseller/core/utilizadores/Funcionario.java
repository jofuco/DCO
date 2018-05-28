package com.seatseller.core.utilizadores;

import java.time.LocalTime;
import java.util.Observable;
import java.util.Observer;
import com.seatseller.api.INotificacaoReceiver;
import com.seatseller.core.lugares.Grelha;
import com.seatseller.core.lugares.Lugar;


public class Funcionario extends Utilizador implements Observer {
	
	
	// Hora de início de turnos
	private LocalTime start;
	// Hora de final de turnos
	private LocalTime end;
	
	public Funcionario(String u, String p, LocalTime start, LocalTime end) {
		super(u, p);
		this.start = start;
		this.end = end;
	}
	
	
	/**
	 * Deve fazser login apenas se a password estiver correta, 
	 * e se a hora actual estiver entre as horas de inicio e final
	 * de turnos deste Funcionario.
	 * 
	 * @see com.seatseller.core.utilizadores.Utilizador#tryLogin(java.lang.String)
	 */
	@Override
	public boolean tryLogin(String pw) {
		String p = getPassword();
		LocalTime ld = LocalTime.now();
		return pw.equals(p) && ld.isBefore(end) && ld.isAfter(start);
	}


	@Override
	//TODO
	public void update(Observable o, Object arg) {
		if(arg instanceof Lugar){			
			INotificacaoReceiver send = (INotificacaoReceiver) arg;
			if(o instanceof Grelha){
				send.notificar(arg,o);
			}
		}
		
	}

	
}
