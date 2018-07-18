package idp.exerciceservlet.filtre;

import java.io.IOException;
import java.sql.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConnexionBDFiltre implements Filter {
	public Connection connexion = null;

	public ConnexionBDFiltre() {

	}

	public Connection getConnexion() {
		connexion = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Portfolio", "postgres", "admin");

		}
		catch (SQLException e) {

			e.printStackTrace();
		}
		if (connexion != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connexion;
	}

	@Override
	public void destroy() {
		try {
			connexion.close();
		} catch (SQLException ex) {
			System.out.println("Erreur sur l'arrÍt de la connexion ‡ la base de donnÈes");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setAttribute("connexionBD", connexion);
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		getConnexion();

	}
}