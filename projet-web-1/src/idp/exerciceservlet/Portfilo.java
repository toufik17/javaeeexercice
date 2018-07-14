package idp.exerciceservlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet
 */

public class Portfilo extends HttpServlet {

	private String utilisateur;
	
	@Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
 
        // Obtenez la valeur du paramètre d'initialisation (initialization parameter) du Servlet.
        // (Selon la configuration de ce servlet dans web.xml).
        this.utilisateur = config.getInitParameter("utilisateur");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();

		String age = request.getParameter("age");
		out.println("<html>");
		out.println("<head><title>Bonjour " + this.utilisateur +"... </title></head>");

		out.println("<body>");
		out.println("<h2> Création de stagiaire par " + this.utilisateur + "</h2>");
		out.println("</body>");
		out.println("<html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	@Override
	public void log(String msg) {
		// TODO Auto-generated method stub
		super.log(msg);
	}
	
}
