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
import aiss.Movie.Rate;
import aiss.model.resources.MovieResources;

public class ValoracionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ValoracionController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValoracionController() {
	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;

		
		String idmovie = request.getParameter("idpelicula");
		String title = request.getParameter("titlePeli");
		Double rate = Double.parseDouble(request.getParameter("rate"));
		
		
		
		if(idmovie!=null || rate != null) {
			MovieResources sr = new MovieResources();
			
			Rate res = new Rate();
			
			res.setValue((double)rate);
			
			sr.postRate(res,idmovie);
			
			
			request.setAttribute("idmovie", idmovie);
			request.setAttribute("rate", rate);
			request.setAttribute("title", title);
			log.log(Level.INFO, "No hay problemas");
			log.log(Level.INFO, "Valor de rate:" + res);
			log.log(Level.INFO, "Valor de id:" + idmovie);
			rd = request.getRequestDispatcher("/ValoracionCorrecta.jsp");
			
		}else {
			rd=request.getRequestDispatcher("/error.jsp");
			log.log(Level.INFO, "No se ha podido valorar");
		}
		
		log.log(Level.INFO, "Se han mandado los datos de" + idmovie);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
