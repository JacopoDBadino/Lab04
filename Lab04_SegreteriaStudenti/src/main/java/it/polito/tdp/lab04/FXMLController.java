package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> corsoCBXbutton;

	@FXML
	private Button cercaIscrCorsoButton;

	@FXML
	private TextField txtMatricola;

	@FXML
	private CheckBox boolButton;

	@FXML
	private TextField txtNome;

	@FXML
	private TextField txtCognome;

	@FXML
	private Button cercaCorsiButton;

	@FXML
	private Button iscriviButton;

	@FXML
	private TextArea txtFinale;

	@FXML
	private Button resetButton;

	@FXML
	void bool(ActionEvent event) {

	}

	@FXML
	void cercaCorsi(ActionEvent event) {

	}

	@FXML
	void cercaIscrCorso(ActionEvent event) {

	}

	@FXML
	void corsoCBX(ActionEvent event) {

	}

	@FXML
	void iscrivi(ActionEvent event) {

	}

	@FXML
	void reset(ActionEvent event) {
		txtCognome.setText("");
		txtFinale.setText("");
		txtMatricola.setText("");
		txtNome.setText("");
	}

	@FXML
	void initialize() {
		assert corsoCBXbutton != null : "fx:id=\"corsoCBXbutton\" was not injected: check your FXML file 'Scene.fxml'.";
		assert cercaIscrCorsoButton != null : "fx:id=\"cercaIscrCorsoButton\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert boolButton != null : "fx:id=\"boolButton\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
		assert cercaCorsiButton != null : "fx:id=\"cercaCorsiButton\" was not injected: check your FXML file 'Scene.fxml'.";
		assert iscriviButton != null : "fx:id=\"iscriviButton\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtFinale != null : "fx:id=\"txtFinale\" was not injected: check your FXML file 'Scene.fxml'.";
		assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
		for (Corso c : model.getTuttiICorsi())
			corsoCBXbutton.getItems().add(c.getNome());
		corsoCBXbutton.getItems().add("");
	}
}
