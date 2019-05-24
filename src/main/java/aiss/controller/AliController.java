package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import aiss.model.aliexpress.AliExpress;
import aiss.model.resources.AliExpressResource;

public class AliController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(AliController.class.getName());
	
	public AliController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String query = (String) request.getSession().getAttribute("queryBusqueda");
		RequestDispatcher rd = null;
		log.log(Level.FINE,"EL QUERY DE BUSQUEDA ES " + query);
		// Search for products in Aliexpress
		log.log(Level.FINE,"Buscado productos de AliExpress que contengan " + query);
		AliExpressResource ali = new AliExpressResource();
		AliExpress aliResults = ali.getProducts(query);
		
		if (aliResults!=null) {
			rd = request.getRequestDispatcher("/AliExpressView.jsp");
			request.setAttribute("products", aliResults.getResult().getProducts());
			request.setAttribute("title", title);
		}else {
			log.log(Level.SEVERE,"AliExpress object: "+ aliResults);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
