package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
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
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ComentarioController.class.getName());
	
	
	    @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        String accessToken = (String) req.getSession().getAttribute("YouTube-token");
	       
	        
	        String sid = (String) req.getSession().getAttribute("movieId");
	        String id = req.getParameter("id");
	        String vid = "";
	    	if(id!=null ) {
				vid = id;
				req.getSession().setAttribute("movieId", id);
				log.log(Level.FINE, "ComentarioController: ID con valor, en sesion hay: "+ (String) req.getSession().getAttribute("movieId"));
			}else if(id == null && sid != null && vid=="") {
				vid = sid;
				log.log(Level.FINE, "ComentarioController: ID sin valor, sid con valor, en sesion hay: "+ (String) req.getSession().getAttribute("movieId"));
			}else {
				log.log(Level.FINE, "ComentarioController: ID sin valor, sid sin valor, en sesion hay: "+ (String) req.getSession().getAttribute("movieId"));
			}
	        
	        
	        
	        
	        String videoId = req.getParameter("videoId");
	        String channelId = req.getParameter("channelId");
	        String content = req.getParameter("comentarios");
	        if (accessToken != null && !"".equals(accessToken)) {
	            
	                YoutubeResource ytResource = new YoutubeResource(accessToken);
	               
	                CommentResponse comment = new CommentResponse();
	                
	                Snippet snp = new Snippet();
	                TopLevelComment tlc = new TopLevelComment();
	                Snippet_ snp_ = new Snippet_();
	                
	                /*Cargo el contenido del texto*/
	                snp_.setTextOriginal(content);
	               
	                /*Añado el snippet_ a Top Level Comment*/
	                tlc.setSnippet_(snp_);
	                
	                /*Añado ahora a snippet el top level comment configurado*/
	                snp.setTopLevelComment(tlc);
	                
	                /*Capturo el id del canal del video*/
	                snp.setChannelId(channelId);
	               
	                /*Capturo el id del video*/
	                snp.setVideoId(videoId);
	                
	                snp.setIsPublic(true);
	                
	                /*añado el snippet al commentario para que vaya en la request*/
	                comment.setSnippet(snp);
	               
	              
	                /*Insertar el comentario en Youtube, con el contenido*/
	                CommentResponse a = ytResource.insertComment(comment);
	                
	          
	                log.log(Level.FINE, "EL ID DEL VIDEO ES "+videoId+" EL channelID ES "+channelId+" EL COMENTARIO ES "+content);
	                log.log(Level.FINE, "EL SNIPPET ES "+snp.toString());
	                log.log(Level.FINE, "EL SNIPPET ES "+accessToken);
	                log.log(Level.FINE, "RESPUESTA DE YOUTUBE", a.getId());
	                /*Log de exito en el post del comentario*/
	                req.setAttribute("message", "Comment '" + content + "' added to the video!");
	                req.getRequestDispatcher("/index1.jsp").forward(req, resp);
	    
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
