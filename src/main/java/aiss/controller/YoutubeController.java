package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.ldap.Rdn;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.VideoSearch;

public class YoutubeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private static final Logger log = Logger.getLogger(YoutubeController.class.getName());
	
	/**
	 * @see HttpServlet #HttpServlet()
	 */
	public YoutubeController() {
		
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String query = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		
		//Search for Videos in Youtube
		log.log(Level.FINE, "Searching for Youtube videos that contain" + query);
		YoutubeResource ytr = new YoutubeResource();
		VideoSearch youtubeResults = ytr.getVideo(query);
		
		if(youtubeResults!= null){
			rd = request.getRequestDispatcher("/movie.jsp");
			request.setAttribute("items", youtubeResults.getItems());
		}else {
			log.log(Level.SEVERE,"Youtube object: "+youtubeResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}