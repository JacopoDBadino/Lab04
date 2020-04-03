package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
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
	private Button boolButton;

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

		int matricola = -1;
		try {
			matricola = Integer.parseInt(txtMatricola.getText());
		} catch (NumberFormatException nf) {
			return;
		}
		if (model.getStudentePerMatricola(matricola) != null) {
			txtNome.setText(model.getStudentePerMatricola(matricola).getNome());
			txtCognome.setText(model.getStudentePerMatricola(matricola).getCognome());
		} else
			return;
	}

	@FXML
	void cercaCorsi(ActionEvent event) {
		int matricola = -1;
		try {
			matricola = Integer.parseInt(txtMatricola.getText());
		} catch (NumberFormatException nf) {
			return;
		}

		if (model.getStudentePerMatricola(matricola) != null) {
			if (corsoCBXbutton.getValue().equals(" ")) {
				txtFinale.setText("");
				for (Corso c : model.getCorsiPerMatricola(matricola))
					if (txtFinale.getText().equals(""))
						txtFinale.appendText(c.toString());
					else
						txtFinale.appendText("\n" + c.toString());
			} else {
				Corso c = model.getCorsoPerNome(corsoCBXbutton.getValue());
				if (model.getCorsiPerMatricola(matricola).contains(c))
					txtFinale.setText("Studente gia' iscritto a questo corso!");
				else
					txtFinale.setText("Studente non iscritto a questo corso!");
			}
		} else {
			txtFinale.setText("Studente con matricola " + matricola + " non trovato!");
		}

	}

	@FXML
	void cercaIscrCorso(ActionEvent event) {

		try {
			List<Studente> s;
			if (corsoCBXbutton.getValue() != " ") {
				Corso c = model.getCorsoPerNome(corsoCBXbutton.getValue());
				s = model.getStudentiPerCorso(c);

			} else
				s = model.getTuttiGliStudenti();

			txtFinale.setText("");
			for (Studente temp : s)
				if (txtFinale.getText().equals(""))
					txtFinale.setText(temp.toString());
				else
					txtFinale.appendText("\n" + temp.toString());
		} catch (Exception e) {
			txtFinale.appendText("Scegliere un corso!\n");
			return;
		}
	}

	@FXML
	void corsoCBX(ActionEvent event) {

	}

	@FXML
	void iscrivi(ActionEvent event) {

		int matricola = -1;
		try {
			matricola = Integer.parseInt(txtMatricola.getText());
		} catch (NumberFormatException nf) {
			return;
		}

		if (model.getStudentePerMatricola(matricola) != null) {
			if (corsoCBXbutton.getValue() != " ") {
				boolean esito = model.inscriviStudenteACorso(model.getStudentePerMatricola(matricola),
						model.getCorsoPerNome(corsoCBXbutton.getValue()));

				if (esito == true)
					txtFinale.setText("Studente iscritto con successo!");
				else
					txtFinale.setText("Errore durante l'iscrizione dello studente.");
			}
		}

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
		corsoCBXbutton.setValue("Corsi");
		for (Corso c : model.getTuttiICorsi())
			corsoCBXbutton.getItems().add(c.getNome());
		corsoCBXbutton.getItems().add(" ");
	}
}
