package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.CommentResponse;
import aiss.model.youtube.Snippet;
import aiss.model.youtube.Snippet_;
import aiss.model.youtube.TopLevelComment;



public class ComentarioController extends HttpServlet {
	 private static final Logger log = Logger.getLogger(ComentarioController.class.getName());

	    @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        String accessToken = (String) req.getSession().getAttribute("YouTube-token");
	        String videoId = req.getParameter("videoId");
	        String content = req.getParameter("comentarios");
	        if (accessToken != null && !"".equals(accessToken)) {
	            if (videoId != null && !"".equals(videoId)) {
	                YoutubeResource ytResource = new YoutubeResource(accessToken);
	                
	                CommentResponse comment = new CommentResponse();
	                
	                Snippet snp = new Snippet();
	                TopLevelComment tlc = new TopLevelComment();
	                Snippet_ snp_ = new Snippet_();
	                
	                snp.setVideoId(videoId);
	                snp.setTopLevelComment(tlc);
	                tlc.setSnippet_(snp_);
	                snp_.setTextOriginal(content);
	                
	                comment.setSnippet(snp);
	               
	                /*Insertar el comentario en Youtube, con el contenido*/
	                ytResource.insertComment(comment, content);
	                
	                /*Log de exito en el post del comentario*/
	                req.setAttribute("message", "Comment '" + videoId + "' added to the video!");
	             //   req.getRequestDispatcher("index2.jsp").forward(req, resp);
	            } else {
	                req.setAttribute("message", "You must provide a valid comment for coment");
	                req.setAttribute("content", content);
	                req.getRequestDispatcher("SelectedMovieController").forward(req, resp);
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
