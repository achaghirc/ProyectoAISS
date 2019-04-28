package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.Movie.Movie;
import aiss.model.resources.MovieResources;
import aiss.model.tmdb.TMDBRegistry;

public class TMDBRegistryController {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(MovieController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Request Data
	
		
		RequestDispatcher rd = null;
		
		//View Movie
		MovieResources mvr = new MovieResources();
	
		
		TMDBRegistry token = mvr.getToken();
		
		if(token!=null) {
			rd = request.getRequestDispatcher("/inicio.jsp");
			request.setAttribute("token",token);
			log.log(Level.FINE, "La peli con id="+token,"ha sido mostrada" );
		}else {
			request.setAttribute("movie", "La pelicula no se ha podido mostrar");
			log.log(Level.FINE, "La peli con id="+token,"no ha sido mostrada" );
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
