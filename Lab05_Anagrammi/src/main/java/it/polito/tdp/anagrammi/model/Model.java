package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.ParolaDao;

public class Model {
	private List<Parola> risultato;
	private ParolaDao parolaDao;
	
	public Model() {
		parolaDao=new ParolaDao();
	}

	public List<Parola> anagrammi(String parola) {
		risultato=new ArrayList<>();
		doAnagrammi("", parola, 0);
		verificaCorrettezza();
		return risultato;
	}

	private void doAnagrammi(String parziale, String lettere, int livello) {
		if(lettere.length()==0) {
			risultato.add(new Parola(parziale));
		}
		else {
			int i;
			for(i=0; i<lettere.length(); i++) {
				char prova=lettere.charAt(i);
				
				String nuovoParziale=parziale+prova;
				String nuoveLettere=lettere.substring(0, i)+lettere.substring(i+1);
				this.doAnagrammi(nuovoParziale, nuoveLettere, livello+1);
			}
		}
	}
	
	private void verificaCorrettezza() {
		for(int i=0; i<risultato.size();i++) {
			if(parolaDao.verificaCorrettezza(risultato.get(i)))
				risultato.get(i).setCorretto(true);
		}
	}

}