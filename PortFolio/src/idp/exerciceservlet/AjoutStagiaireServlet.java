package idp.exerciceservlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import idp.exerciceservlet.entite.Stagiaire;


public class AjoutStagiaireServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);

	}

	public AjoutStagiaireServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Bienvenue Creation Stagiaire");
		HttpSession session = request.getSession(true);
		Connection connect = (Connection)request.getAttribute("connexionBD");
		String email = session.getAttribute("email").toString();
		String nom = session.getAttribute("nom").toString();
		String prenom = session.getAttribute("prenom").toString();
		String civilite = session.getAttribute("civilite").toString();
		String str_date = session.getAttribute("dateNaissance").toString();
		LocalDate date = LocalDate.parse(str_date);

		Stagiaire stagiaire = new Stagiaire(civilite, nom, prenom,email, date);
		try {
			stagiaire.setConnexion(connect);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("stagiaire", stagiaire);

		if(stagiaire.enregistrer()){
			System.out.println("redirection OK ...");

			
			 String okPage = "/WEB-INF/ValidationAjoutStagiaire.jsp";
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher(okPage) ;
			    
		     // redirection de la requête vers cette ressource
		    requestDispatcher.forward(request, response) ;

		}
		else {
			System.out.println("redirection erreur ...");

			String okPage = "/WEB-INF/ErreurAjoutStagiaire.jsp";
			 RequestDispatcher requestDispatcher = request.getRequestDispatcher(okPage) ;
			    
		     // redirection de la requête vers cette ressource
		    requestDispatcher.forward(request, response) ;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}



}
