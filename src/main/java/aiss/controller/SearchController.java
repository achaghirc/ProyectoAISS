package aiss.controller;

import java.io.IOException;
import java.util.Collection;
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
		RequestDispatcher rd = null;
		
		// Search for movies in OMDb
		log.log(Level.FINE, "Searching for OMDb movies that contain " + query);
		MovieSearchResource tmdb = new MovieSearchResource();
		MovieSearch tmdbResults = tmdb.getMovieSearch(query);
		// Search for movies in Flickr
		//log.log(Level.FINE, "Seraching for flickr photos that contain"+query);
		//FlickrResource flickr = new FlickrResource();
		//PhotoSearch flickrResults = flickr.getFlickrPhotos(query);
		
		
		if (tmdbResults!=null){
			request.setAttribute("movies", tmdbResults.getResults());
			rd = request.getRequestDispatcher("/movieSearch.jsp");
			//request.setAttribute("photos",flickrResults.getPhotos());
			
		} else {
			log.log(Level.SEVERE, "OMDb object: " + tmdbResults);
		//	log.log(Level.SEVERE, "Flickr object: " + omdbResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
		
		//Foward to movieList view
		//request.setAttribute("movies", omdb.getAll());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
