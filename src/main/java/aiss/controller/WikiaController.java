package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.Wiki.Wiki;
import aiss.model.resources.WikiaResources;

public class WikiaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(WikiaController.class.getName());
	
	public WikiaController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for info in WikiPedia
		log.log(Level.FINE, "Buscando información de la película " + query);
		WikiaResources wiki = new WikiaResources();
		Wiki wikiResults = wiki.getWiki(query);
		
		if (wikiResults!=null){
	
			rd = request.getRequestDispatcher("/wikiView.jsp");
			request.setAttribute("wikis", wikiResults.getParse().getWikitext());
			
		} else {
			log.log(Level.SEVERE, "Wiki objects: " + wikiResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
