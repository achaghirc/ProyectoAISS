package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.Movie.Movie;
import aiss.model.resources.MovieResources;

public class MovieController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(MovieController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Request Data
	
		String id = request.getParameter("id");
		RequestDispatcher rd = null;
		
		//View Movie
		MovieResources mvr = new MovieResources();
		Movie datosMovie = mvr.getMovie(id);
		
		if(datosMovie!=null) {
			rd = request.getRequestDispatcher("/movie.jsp");
			request.setAttribute("title", datosMovie.getTitle());
			request.setAttribute("movieById", datosMovie.getId());
			log.log(Level.FINE, "La peli con id="+id,"ha sido mostrada" );
		}else {
			request.setAttribute("movie", "La pelicula no se ha podido mostrar");
			log.log(Level.FINE, "La peli con id="+id,"no ha sido mostrada" );
			rd = request.getRequestDispatcher("error.jsp");
		}
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
