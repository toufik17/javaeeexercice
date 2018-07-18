package idp.exerciceservlet.filtre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Filtre0
 */

public class JournalFiltre implements Filter {

	private String pathLog = "";
	private File file_log = null;
	private FileWriter fw_log = null;


	/**
	 * Default constructor.
	 */
	public JournalFiltre() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		try {
			fw_log.close();
		} catch (IOException e) {
			System.out.println("Problème lors de la fermiture du fichier de log");
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// place your code here
		
		HttpServletRequest request1 = (HttpServletRequest) request;
		
		
		log("-------------------------------------------------------------------------------------------- \n ");
		log(new StringBuffer(50).append(LocalDate.now().toString()).append(" ").append(LocalTime.now().toString()).toString() + " URI : " + request1.getMethod() + request1.getRequestURI());
		log(new StringBuffer(50).append(LocalDate.now().toString()).append(" ").append(LocalTime.now().toString()).toString() + " Poste hote client : " + request1.getRemoteHost());
		log(new StringBuffer(50).append(LocalDate.now().toString()).append(" ").append(LocalTime.now().toString()).toString() + " Adresse IP du client " + request.getRemoteAddr());
		log(new StringBuffer(50).append(LocalDate.now().toString()).append(" ").append(LocalTime.now().toString()).toString() + " Paramètres envoyés : " + request1.getQueryString());
		log(new StringBuffer(50).append(LocalDate.now().toString()).append(" ").append(LocalTime.now().toString()).toString() + " Numéro de port cu client : " + request1.getRemotePort());
		log(new StringBuffer(50).append(LocalDate.now().toString()).append(" ").append(LocalTime.now().toString()).toString() + " Nom du client : " + request1.getRemoteUser());
		log("-------------------------------------------------------------------------------------------- \n");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	private void log(String msg) {

		try {

			fw_log.write(msg);
			fw_log.write("\r\n");

		} catch (IOException e) {
			System.out.println("Problème lors de la lecture / ecriture du fichier de log");
			e.printStackTrace();
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {

		pathLog = fConfig.getServletContext().getInitParameter("path_log")+"log-" + LocalDate.now() + ".log";
		file_log = new File(pathLog);
		try {
			fw_log = new FileWriter(file_log, true);
		} catch (IOException e) {
			System.out.println("Problème lors de la création du fichier de log");
			e.printStackTrace();
		}

		
	}

}
