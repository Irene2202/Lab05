package it.polito.tdp.anagrammi.model;

import java.util.List;

public class TestAnagrammi {

	public static void main(String[] args) {
		String parola="eat";
		Model a=new Model();
		List<Parola> risultato;
		
		risultato=a.anagrammi(parola);
		
		
		for(int i=0; i<risultato.size(); i++) {
			if(risultato.get(i).isCorretto())
				System.out.println(risultato.get(i).toString() + " CORRETTO");
			else
				System.out.println(risultato.get(i).toString() + " ERRATO");
		}

	}

}
