package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.Movie.Credits;
import aiss.Movie.Movie;
import aiss.Movie.MovieSearch;
import aiss.model.resources.MovieResources;
import aiss.model.resources.MovieSearchResource;
import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.VideoSearch;

public class InicioController extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SelectedMovieController.class.getName());
	
		public InicioController() {
			super();
		}
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String query = request.getParameter("searchQuery");
			String id = request.getParameter("id");
			RequestDispatcher rd = null;
			
			//Search for movie most Popular
			log.log(Level.FINE, "Searching for TMDB movies most Popular");
			
			MovieResources tmdb = new MovieResources();
			MovieSearch tmdbResults = tmdb.getPopular();
						
			
			
			
 
			if(tmdbResults != null) {
				
				request.setAttribute("movie", tmdbResults.getResults());

				rd = request.getRequestDispatcher("index1.jsp");
			
			}else {
				if(tmdbResults == null) {
					log.log(Level.SEVERE, "TMDB object: " + tmdbResults);
					rd = request.getRequestDispatcher("/error.jsp");
				}
				
			}
			rd.forward(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
			}
		
}
