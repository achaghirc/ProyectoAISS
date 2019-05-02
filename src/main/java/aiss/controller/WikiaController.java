package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.WikiaResource;
import aiss.model.wiki.Wiki;

public class WikiaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(WikiaController.class.getName());
	
	public WikiaController() {
		super();
	}
	
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		RequestDispatcher rd = null;
		
		// Search for info in WikiPedia
		log.log(Level.FINE, "Buscando información del actor " + name);
		WikiaResource wiki = new WikiaResource();
		Wiki wikiResults = wiki.getWiki(name);
		
		if (wikiResults.getParse()!=null){
			rd = request.getRequestDispatcher("/wikiView.jsp");
			request.setAttribute("wiki", wikiResults);
		}else if(wikiResults.getParse()==null){
			log.log(Level.SEVERE, "Wiki objects: " + wikiResults);
			rd = request.getRequestDispatcher("/wikiViewError.jsp");
		}else {
			log.log(Level.SEVERE, "Wiki objects: " + wikiResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
