package com.seatseller.core.utilizadores;

public abstract class Utilizador {
	private String username;
	private String password;
	
	public Utilizador(String u, String p) {
		this.username = u;
		this.password = p;
	}
	
	public boolean tryLogin(String p) {
		return p.equals(password);
	}
	
	/**
	 * Getter para aceder a password nas classes que extendem esta classe.
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return username;
	}
}
