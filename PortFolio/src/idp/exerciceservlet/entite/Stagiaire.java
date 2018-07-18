package idp.exerciceservlet.entite;


import java.time.LocalDate;
import java.time.Period;

import idp.exerciceservlet.utils.ConnexionBDUtils;

public class Stagiaire extends ConnexionBDUtils{
	private String civilite;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String email;
	private int age;
	
	
	
	public Stagiaire() {
		super();
	}

	public Stagiaire(String civilite, String nom, String prenom, String adresse, LocalDate dateNaissance) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = adresse;
		this.age = calculerAeg();
	}
	
	private int calculerAeg() {
		Period period = Period.between(this.dateNaissance, LocalDate.now());
		return period.getYears();

	}
	
	public boolean enregistrer() {
	      if (existe())
	         return false;
	      else {
	         super.miseAJour("INSERT INTO stagiaire VALUES (DEFAULT"+",'"+this.civilite+"','"+this.nom+"','"+this.prenom+"','"+this.email+"','"+this.dateNaissance+"',"+this.age+")");
	         return true;
	      }
	   }  
	   private boolean existe() {
	      lire("SELECT * FROM stagiaire WHERE nom='"+this.nom+"' AND prenom='"+prenom+"' AND email='"+this.email+"'");
	      return suivant();
	   }
	   
	   public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

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

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
