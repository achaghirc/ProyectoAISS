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


public class InicioController extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SelectedMovieController.class.getName());
	
		public InicioController() {
			super();
		}
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher rd = null;
			
			//Search for movie most Popular
			log.log(Level.FINE, "Searching for TMDB movies most ");
			
			MovieResources tmdb = new MovieResources();
			MovieSearch popularResults = tmdb.getPopular();
			MovieSearch upcomingResults = tmdb.getUpcoming();
			MovieSearch trendingResults = tmdb.getTrending();
						
			
			
			
 
			if(popularResults != null && upcomingResults!=null && trendingResults!=null) {
				
				request.setAttribute("movie", popularResults.getResults());
				request.setAttribute("upcoming", upcomingResults.getResults());
				request.setAttribute("trending", trendingResults.getResults());

				rd = request.getRequestDispatcher("index2.jsp");
			
			}else {
				if(popularResults == null) {
					log.log(Level.SEVERE, "TMDB object: " + popularResults);
					rd = request.getRequestDispatcher("/error.jsp");
				}
				if(upcomingResults == null) {
					log.log(Level.SEVERE, "TMDB object: " + upcomingResults);
					rd = request.getRequestDispatcher("/error.jsp");
				}
				if(trendingResults == null) {
					log.log(Level.SEVERE, "TMDB object: " + trendingResults);
					rd = request.getRequestDispatcher("/error.jsp");
				}
			}
			rd.forward(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
			}
		
}
