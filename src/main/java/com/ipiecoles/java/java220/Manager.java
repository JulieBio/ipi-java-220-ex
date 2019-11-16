package com.ipiecoles.java.java220;

import java.util.HashSet;
import java.util.Objects;

import org.joda.time.LocalDate;

public class Manager extends Employe {
	
	private HashSet<Technicien> equipe = new HashSet<Technicien>();

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe) {
		super(nom, prenom, matricule, dateEmbauche, salaire);
		this.equipe = equipe;
	}

	@Override
	public Double getPrimeAnnuelle() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void ajoutTechnicienEquipe(Technicien t) {
		if(equipe == null) {
			equipe = new HashSet<Technicien>();
		}
		this.equipe.add(t);	
	}
	
	@Override
	public void setSalaire(Double salaire) {
		super.setSalaire(salaire * Entreprise.INDICE_MANAGER + (10 * salaire/100) * equipe.size());
		//super.setSalaire(salaire * Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size()/10));
	}

	public HashSet<Technicien> getEquipe() {
		return equipe;
	}

	public void setEquipe(HashSet<Technicien> equipe) {
		this.equipe = equipe;
	}
	

//	public Double getPrimeAnnuelle() { 				
//		return Entreprise.primeAnnuelleBase();
//	}
	
	// Getter et setter
	


	

}
