package it.polito.tdp.meteo;

import java.net.URL;
import java.time.Month;
import java.util.ResourceBundle;

import it.polito.tdp.meteo.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class MeteoController {
	
	private Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ChoiceBox<Month> boxMese;

	@FXML
	private Button btnCalcola;

	@FXML
	private Button btnUmidita;

	@FXML
	private TextArea txtResult;

	@FXML
	void doCalcolaSequenza(ActionEvent event) {

	}

	@FXML
	void doCalcolaUmidita(ActionEvent event) {
		txtResult.clear();
		String result = "";
		try {
			Month mese = boxMese.getValue();
			if(mese==null) {
				txtResult.setText("Selezionare un mese");
			}
			else {
			result = model.getUmiditaMedia(mese);
			txtResult.setText(result);
			}
		} catch (RuntimeException e) {
    		txtResult.setText("Errore di connessione al database!");
    	}
	}

	@FXML
	void initialize() {
		assert boxMese != null : "fx:id=\"boxMese\" was not injected: check your FXML file 'Meteo.fxml'.";
		assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Meteo.fxml'.";
		assert btnUmidita != null : "fx:id=\"btnUmidita\" was not injected: check your FXML file 'Meteo.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Meteo.fxml'.";
	}

	public void setModel(Model model) {
		this.model=model;
		this.setComboItems();	
	}

	private void setComboItems() {
		for(int mese=1; mese<13; mese++) {
			boxMese.getItems().add(Month.of(mese));
		}
	}

}
