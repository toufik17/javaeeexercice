package idp.exerciceservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author tham
 *
 */
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String civilite = request.getParameter("civilite");
		String email = request.getParameter("email");
		String dateNaissance = request.getParameter("dateNaissance");
		

		HttpSession session = request.getSession();
		
		session.setAttribute("nom", nom);
		session.setAttribute("prenom", prenom);
		session.setAttribute("civilite", civilite);
		session.setAttribute("email", email);
		session.setAttribute("dateNaissance", dateNaissance);

		ServletOutputStream servlet_out = response.getOutputStream();

		String url = response.encodeURL(request.getContextPath() + "/ajoutstagiaire");

		
		servlet_out.print("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Confirmation des données</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<h1 style=\"text-align: center\">Bienvenue dans la page de Confirmation </h1>"
				+ "	<h2>Confirmez vous la saisie ? </h2>\r\n" + 
				"Civilité : " + civilite + "</br>"
				+ "Nom : " + nom 
				+ "</br>" + "Prénom : " + prenom + "</br>" 
				+ "Date de naissance : " + dateNaissance
				+ "</br>" + 
				"Voulez vous validez ces données? </br></br>" + "<a href=\"" + url
				+ "\">Confirmez</a>" + "</body>\r\n" + "</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
