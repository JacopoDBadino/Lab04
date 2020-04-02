package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {

	public List<Corso> getTuttiICorsi() {
		CorsoDAO dao = new CorsoDAO();
		return dao.getTuttiICorsi();
	}

	public List<Studente> getTuttiGliStudenti() {
		CorsoDAO dao = new CorsoDAO();
		return dao.getTuttiGliStudenti();
	}

	public Studente getStudentePerMatricola(int matricola) {
		CorsoDAO dao = new CorsoDAO();
		return dao.getStudentePerMatricola(matricola);
	}

	public List<Studente> getStudentiPerCorso(Corso corso) {
		CorsoDAO dao = new CorsoDAO();
		return dao.getStudentiIscrittiAlCorso(corso);
	}

	public Corso getCorsoPerNome(String nome) {
		CorsoDAO dao = new CorsoDAO();
		return dao.getCorsoPerNome(nome);
	}

	public List<Corso> getCorsiPerMatricola(int matricola) {
		CorsoDAO dao = new CorsoDAO();
		return dao.getCorsiPerMatricola(matricola);
	}
}
