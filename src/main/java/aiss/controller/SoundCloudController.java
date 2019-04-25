package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.SoundCloud.Track;
import aiss.model.resources.SoundCloudResource;

public class SoundCloudController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(SoundCloudController.class.getName());


	public SoundCloudController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Integer query = Integer.parseInt(request.getParameter("searchQuery"));
		String accessToken = (String) request.getSession().getAttribute("SoundCloud-token");

		if (accessToken != null && !"".equals(accessToken)) {
			SoundCloudResource scResource = new SoundCloudResource(accessToken);
//			Track track = scResource.getTrack(query);
			Track track = scResource.getBusqueda(request.getParameter("searchQuery"));
			if (track != null) {
				request.setAttribute("track", track);
				request.getRequestDispatcher("/track.jsp").forward(request, response);
			} else {
				log.log(Level.SEVERE, "SoundCloud object: " + track);
				request.getRequestDispatcher("/error.jsp");
			}
		} else {
			log.info("Intentando acceder a SoundCloud sin el access token, redirigiendo al OAUTH servlet");
			request.getRequestDispatcher("/AuthController/SoundCloud").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
