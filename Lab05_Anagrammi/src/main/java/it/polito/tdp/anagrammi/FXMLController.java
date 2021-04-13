package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtResultCorretto;

    @FXML
    private TextArea txtResultErrato;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	txtResultCorretto.clear();
    	txtResultErrato.clear();
    	String parola=txtInput.getText().toLowerCase();
    	if(parola.length()==0) {
    		txtResultCorretto.setText("Inserire una parola");
    		return ;
    	}
    	if(!parola.matches("^[a-zA-Z]*$")) {
    		txtResultCorretto.setText("Inserire una parola VALIDA");
    		return;
    	}
    	
    	List<Parola> result=this.model.anagrammi(parola);
    	for(Parola p:result) {
    		if(p.isCorretto())
    			txtResultCorretto.appendText(p.toString()+"\n");
    		else
    			txtResultErrato.appendText(p.toString()+"\n");
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInput.clear();
    	txtResultCorretto.clear();
    	txtResultErrato.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultCorretto != null : "fx:id=\"txtResultCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultErrato != null : "fx:id=\"txtResultErrato\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
	}
}
