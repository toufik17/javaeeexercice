package idp.exerciceservlet.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBDUtils {
	private Statement instruction;
	protected ResultSet resultat;
	private Connection connexion;

	public ConnexionBDUtils() {
		super();
	}
	
	public Connection getConnexion() {
		return connexion;
	}

	public void setConnexion(Connection connexion) throws SQLException {
		this.connexion = connexion;
		this.instruction = this.connexion.createStatement();
	}

	public void lire(String requête) {
		try {
			resultat = instruction.executeQuery(requête);
		} catch (SQLException ex) {
			System.err.println("Requête incorrecte " + requête);
		}
	}

	public void miseAJour(String requête) {
		try {
			instruction.executeUpdate(requête);
		} catch (SQLException ex) {
			System.err.println("Requête incorrecte " + requête);
		}
	}

	public boolean suivant() {
		try {
			return resultat.next();
		} catch (SQLException ex) {
			return false;
		}
	}
}