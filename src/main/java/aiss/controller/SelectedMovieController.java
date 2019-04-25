package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.Movie.Cast;
import aiss.Movie.Credits;
import aiss.Movie.Movie;
import aiss.SoundCloud.Track;
import aiss.model.resources.MovieResources;
import aiss.model.resources.SoundCloudResource;
import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.VideoSearch;

public class SelectedMovieController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(SelectedMovieController.class.getName());
	
		public SelectedMovieController() {
			super();
		}
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String query = request.getParameter("searchQuery");
			String id = request.getParameter("id");
			RequestDispatcher rd = null;
			
			//Search for movie in TMDB
			log.log(Level.FINE, "Searching for TMDB movies that contain"+id);
			MovieResources tmdb = new MovieResources();
			Movie tmdbResults = tmdb.getMovie(id);
			Credits creditsResults = tmdb.getCasting(id);
			
			//Searching Trailer Youtube
			log.log(Level.FINE, "Searching for Youtube videos with query ", query);
			YoutubeResource ytr = new YoutubeResource();
			VideoSearch youtubeResults = ytr.getVideo(id);
			
			
			if(tmdbResults != null && youtubeResults!= null && creditsResults!= null) {
				request.setAttribute("movies", tmdbResults);
				request.setAttribute("credits", creditsResults);
				request.setAttribute("items", youtubeResults.getItems());
				rd = request.getRequestDispatcher("/movie.jsp");
			}else {
				if(tmdbResults == null) {
					log.log(Level.SEVERE, "TMDB Object: "+tmdbResults);
					rd = request.getRequestDispatcher("/error.jsp");
				}
			}
			rd.forward(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
			}
		
}
