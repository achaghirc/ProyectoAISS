package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import aiss.Movie.MovieSearch;
import aiss.model.resources.MovieResources;
import aiss.model.resources.MovieSearchResource;
import aiss.model.tmdb.Sesion;


public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	
	public SearchController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				
		
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		// Search for movies in TMDb
		log.log(Level.FINE, "Searching for TMDb movies that contain " + query);
		MovieSearchResource tmdb = new MovieSearchResource();
		MovieSearch tmdbResults = tmdb.getMovieSearch(query);
		MovieResources mvr = new MovieResources();
		String t = request.getParameter("request_token");
		Sesion s = mvr.getSession(t);
		
		
		if (tmdbResults!=null){
			request.setAttribute("movies", tmdbResults.getResults());
			request.setAttribute("sesionId", s);
			rd = request.getRequestDispatcher("/movieSearch.jsp");
			
		} else {
			log.log(Level.SEVERE, "OMDb object: " + tmdbResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
