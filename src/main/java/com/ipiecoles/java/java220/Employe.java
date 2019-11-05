package com.ipiecoles.java.java220;

import java.util.Objects;

import org.joda.time.LocalDate;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
	
	private String nom;
	private String prenom;
	private String matricule;
	private LocalDate dateEmbauche;
	private Double salaire;

	
	public Employe(){
	}
	
	public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire){
		
		this.nom = nom;
		this.prenom = prenom;
		this.matricule = matricule;
		this.dateEmbauche = dateEmbauche;
		this.salaire = salaire;
		
	}
	
	public final Integer getNombreAnneeAnciennete() {
		if(dateEmbauche != null) {
			return LocalDate.now().getYear() - this.dateEmbauche.getYear();
		}
		else {
			return 0;
		}
	}

	public Integer getNbConges() {
		return Entreprise.NB_CONGES_BASE;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Employe{");
		sb.append("nom='").append(nom).append('\'');
		sb.append(", prenom='").append(prenom).append('\'');
		sb.append(", matricule='").append(matricule).append('\'');
		sb.append(", dateEmbauche=").append(dateEmbauche);
		sb.append(", salaire=").append(salaire);
		sb.append('}');
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
	}

	@Override
	public boolean equals(Object obj) {
		//return hashCode() == obj.hashCode();		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		return Objects.equals(dateEmbauche, other.dateEmbauche) && Objects.equals(matricule, other.matricule)
				&& Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom)
				&& Objects.equals(salaire, other.salaire);
	}

	public abstract Double getPrimeAnnuelle();
	
	public void augmenterSalaire(Double pourcentageAugm) {
		salaire = (salaire * pourcentageAugm) + salaire;
		
	}
	
	
	// getter setter
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	/**
	 * @param dateEmbauche the dateEmbauche to set
	 * @throws Exception 
	 */
	public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
		if(dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {
			throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
		}
		this.dateEmbauche = dateEmbauche;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	


}
