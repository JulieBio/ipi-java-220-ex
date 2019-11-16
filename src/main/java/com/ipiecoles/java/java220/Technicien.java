package com.ipiecoles.java.java220;

import java.util.Objects;

import org.joda.time.LocalDate;


public class Technicien extends Employe implements Comparable<Technicien>{			// EXO01
	
	private Integer grade;							// EXO02
	
	
	public Technicien() {
		// TODO Auto-generated constructor stub
	}

	public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
		super(nom, prenom, matricule, dateEmbauche, salaire); 							// EXO03
		this.grade = grade;
		// TODO Auto-generated constructor stub
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	@Override 
	public void setSalaire(Double salaire) { 			// EXO05
		super.setSalaire(salaire * (1 + (double) grade / 10));
	}
	
	@Override
	public Integer getNbConges() {
		return super.getNbConges() + getNombreAnneeAnciennete();
	}
	
	@Override
	public Double getPrimeAnnuelle() { 					// EXO07
		return Entreprise.primeAnnuelleBase() +
				Entreprise.primeAnnuelleBase() * (grade / 10d) +
				Entreprise.PRIME_ANCIENNETE * getNombreAnneeAnciennete();
	}
	

	@Override
	public int compareTo(Technicien o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.grade, o.grade);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), grade);
	}
	
}
