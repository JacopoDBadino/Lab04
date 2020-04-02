package it.polito.tdp.lab04.DAO;

import java.util.LinkedList;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		
		Corso c = new Corso("01NBAPG", 8, "Ingegneria della qualità", 1);
		for (Corso s : cdao.getCorsiPerMatricola(170447))
		System.out.println(s.toString());

	}

}
