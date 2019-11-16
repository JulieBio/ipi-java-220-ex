package com.ipiecoles.java.java220;

import java.util.Objects;

import org.joda.time.LocalDate;

public class Commercial extends Employe {		// EXO01

	
	private static final double PRIME_MINI_COMMERCIAL = 500d;
	private Double caAnnuel;
	private Integer performance;

	
	// constructor + constructor Employe 		//EXO04
	public Commercial() {			
		super(); 					// appelle constructeur par défaut de la super classe donc Employe
	}
	
	public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire,
			Double caAnnuel) {
		super(nom, prenom, matricule, dateEmbauche, salaire);  // gérer par la classe au dessus
		this.caAnnuel = caAnnuel;			// gérer par la classe Commercial
	}
	
	public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire,
			Double caAnnuel, Integer performance) {
		super(nom, prenom, matricule, dateEmbauche, salaire);  // gérer par la classe au dessus
		this.caAnnuel = caAnnuel;			// gérer par la classe Commercial
		this.performance = performance;
		
	}

	// getter setter
	
	public Double getCaAnnuel() {			// EXO02
		return caAnnuel;
	}

	public void setCaAnnuel(Double caAnnuel) {
		this.caAnnuel = caAnnuel;
	}

	public Integer getPerformance() {
		return performance;
	}

	public void setPerformance(Integer performance) {
		this.performance = performance;
	}

	
	public Double getPrimeAnnuelle() { 			// EXO03
		Double prime = this.caAnnuel == null ?
				PRIME_MINI_COMMERCIAL : Math.ceil(this.caAnnuel * 0.05);		
		if(prime > PRIME_MINI_COMMERCIAL) {
			return prime;
		}
		return PRIME_MINI_COMMERCIAL;
		
		// ou autre proposition mais qui ne fonctionne pas dans le cas du null :
		//return Math.max(Math.ceil(this.getCaAnnuel() * 0.05), 500);
	}
	
	@Override
	public int hashCode() {				// EX05  recupère le hashcode d'Employe, juste besoin de redefinir de hashCode
		return Objects.hash(super.hashCode(), caAnnuel);
	}
	@Override
	public boolean equals(Object obj) { 		// EX05 suite de hashCode
		if(this == obj)
			return true;
		if(!super.equals(obj)) {
			return false;
		}
		if(getClass() != obj.getClass())
			return false;
		Commercial other = (Commercial) obj;
		return Objects.equals(caAnnuel, other.caAnnuel);
	}

	public Boolean performanceEgale(Integer performance) { 		//EX06 on utilise Objects
		return Objects.equals(this.performance, performance);
	}
	
	public Note equivalenceNote() {
		switch(this.performance) {
		  case 0:
		  case 50:
		    return Note.INSUFFISANT;
		  case 100:
			  return Note.PASSABLE;
		  case 150:
			  return Note.BIEN;
		  case 200:
			  return Note.TRES_BIEN;
		  default:
			  return null;
		}
	}
	
	
}