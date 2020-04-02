package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();

		Studente s = model.getStudentePerMatricola(146101);
		System.out.println(s.getNome()+" " + s.getCognome());

		Corso c = new Corso("01NBAPG", 8, "Ingegneria della qualità", 1);
		for (Studente temp : model.getStudentiPerCorso(c))
		System.out.println(temp.getNome());
		
	}

}
