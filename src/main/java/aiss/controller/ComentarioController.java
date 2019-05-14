package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.Comment;



public class ComentarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ComentarioController.class.getName());

	    @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        String accessToken = (String) req.getSession().getAttribute("Youtube-token");
	        String videoId = req.getParameter("videoId");
	        String content = req.getParameter("textOriginal");
	        if (accessToken != null && !"".equals(accessToken)) {
	            if (videoId != null && !"".equals(videoId)) {
	                YoutubeResource ytResource = new YoutubeResource(accessToken);
	                Comment comment = new Comment();
	                comment.getSnippet().setVideoId(videoId);;
	                comment.getSnippet().getTopLevelComment().getSnippet().getTextOriginal();
	                ytResource.insertComment(comment, content);
	                req.setAttribute("message", "Comment '" + videoId + "' added to the video!");
	                req.getRequestDispatcher("/googleDriveFileList").forward(req, resp);
	            } else {
	                req.setAttribute("message", "You must provide a valid title for file");
	                req.setAttribute("content", content);
	                req.getRequestDispatcher("movie.jsp").forward(req, resp);
	            }
	        } else {
	            log.info("Trying to access Google Drive without an access token, redirecting to OAuth servlet");
	            req.getRequestDispatcher("/AuthController/Youtube").forward(req, resp);
	        }
	    }

	    @Override
	    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        doGet(req, resp);
	    }
}
