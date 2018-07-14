package idp.exerciceservlet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stagiaire {
	private String nom;
	private String prenom;
	private Date DateNaissance;
	private String idStagiere;
	private String adresse;
	private int age;
	
	
	
	public Stagiaire(String nom, String prenom, String idStagiere, String adresse, Date dateNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.DateNaissance = dateNaissance;
		this.idStagiere = idStagiere;
		this.adresse = adresse;
		this.age = calculerAeg();
	}
	
	private int calculerAeg() {
		final long YEAR_IN_MILLIS = 31449600000l;

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String date = "11/12/1986";
		
		long today = new Date().getTime();
		long diff;
		try {
			diff = today - simpleDateFormat.parse(date).getTime();
			long age = diff / YEAR_IN_MILLIS;
			return Integer.valueOf(String.valueOf(age));
		} catch (ParseException e) {
			return 0;
		}

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
	public Date getDateNaissance() {
		return DateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		DateNaissance = dateNaissance;
	}
	public String getIdStagiere() {
		return idStagiere;
	}
	public void setIdStagiere(String idStagiere) {
		this.idStagiere = idStagiere;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
