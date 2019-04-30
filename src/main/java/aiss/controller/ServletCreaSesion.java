package aiss.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.MovieResources;
import aiss.model.tmdb.Sesion;

public class ServletCreaSesion extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		String token = request.getParameter("request_token");
		MovieResources mvr = new MovieResources();
		Sesion sesion = mvr.getSession(token);
		
		if(sesion!=null) {
			request.setAttribute("sessionId",sesion.getSessionId());
			
			rd = request.getRequestDispatcher("/index1.jsp");
			
		}else {
			
		}
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
