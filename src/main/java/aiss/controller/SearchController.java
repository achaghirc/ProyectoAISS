package aiss.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import aiss.Movie.MovieSearch;
import aiss.model.resources.MovieSearchResource;


public class SearchController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SearchController.class.getName());
	
	public SearchController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				
		
		String query = request.getParameter("searchQuery");
		String param = URLEncoder.encode(query, "UTF-8");
		RequestDispatcher rd = null;
		
		// Search for movies in TMDb
		log.log(Level.FINE, "Searching for TMDb movies that contain " + param);
		MovieSearchResource tmdb = new MovieSearchResource();
		MovieSearch tmdbResults = tmdb.getMovieSearch(param);
		
		
		if (tmdbResults!=null){
			request.setAttribute("movies", tmdbResults.getResults());
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
