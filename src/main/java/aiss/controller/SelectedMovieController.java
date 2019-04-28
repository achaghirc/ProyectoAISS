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
import aiss.SoundCloud.Track;
import aiss.model.resource.MovieResource;
import aiss.model.resource.SoundCloudResource;
import aiss.model.resource.YoutubeResource;
import aiss.model.youtube.Item;
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
			MovieResource tmdb = new MovieResource();
			Movie tmdbResults = tmdb.getMovie(id);
			Credits creditsResults = tmdb.getCasting(id);
			String param = tmdbResults.getTitle();
						
			
			//Searching Trailer Youtube
			log.log(Level.FINE, "Searching for Youtube videos with query ", query);
			YoutubeResource ytr = new YoutubeResource();
			VideoSearch youtubeResults = ytr.getVideo(param);
		
			
			if(tmdbResults != null && youtubeResults!= null && creditsResults!= null) {
				
				request.setAttribute("movies", tmdbResults);
				request.setAttribute("credits", creditsResults);
				request.setAttribute("items", youtubeResults.getItems());
				
				rd = request.getRequestDispatcher("/movie.jsp");
			
			}else {
				if(tmdbResults == null) {
					log.log(Level.SEVERE, "TMDB object: " + tmdbResults);
					rd = request.getRequestDispatcher("/error.jsp");
				}else if(youtubeResults == null) {
					log.log(Level.SEVERE, "Youtube Object: " + youtubeResults);
					rd = request.getRequestDispatcher("/error.jsp");
				}
			
				
			}
			rd.forward(request, response);
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
			}
		
}
