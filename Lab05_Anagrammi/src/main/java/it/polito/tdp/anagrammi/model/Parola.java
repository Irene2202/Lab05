package it.polito.tdp.anagrammi.model;

public class Parola {
	
	private String parola;
	private boolean corretto;
	
	public Parola(String parola) {
		this.parola = parola;
		this.corretto=false;
	}

	public boolean isCorretto() {
		return corretto;
	}

	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}

	public String getParola() {
		return parola;
	}

	@Override
	public String toString() {
		return parola;
	}
	
}
