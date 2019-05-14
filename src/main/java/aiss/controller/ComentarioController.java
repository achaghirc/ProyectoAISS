package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.CommentResponse;



public class ComentarioController extends HttpServlet {
	 private static final Logger log = Logger.getLogger(ComentarioController.class.getName());

	    @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        String accessToken = (String) req.getSession().getAttribute("YouTube-token");
	        String videoId = req.getParameter("id");
	        String content = req.getParameter("content");
	        if (accessToken != null && !"".equals(accessToken)) {
	            if (videoId != null && !"".equals(videoId)) {
	                YoutubeResource ytResource = new YoutubeResource(accessToken);
	                CommentResponse comment = new CommentResponse();
	                comment.getSnippet().setVideoId(videoId);;
	                comment.getSnippet().getTopLevelComment().getSnippet_().setTextOriginal(content);
	                ytResource.insertComment(comment, content);
	                req.setAttribute("message", "Comment '" + videoId + "' added to the video!");
	                req.getRequestDispatcher("/SelectedMovieController").forward(req, resp);
	            } else {
	                req.setAttribute("message", "You must provide a valid videoId for coment");
	                req.setAttribute("content", content);
	                req.getRequestDispatcher("movie.jsp").forward(req, resp);
	            }
	        } else {
	            log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
	            req.getRequestDispatcher("/AuthController/YouTube").forward(req, resp);
	        }
	    }

	    @Override
	    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        doGet(req, resp);
	    }
}
