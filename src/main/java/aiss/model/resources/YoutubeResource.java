package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;


import aiss.model.youtube.CommentResponse;
import aiss.model.youtube.VideoSearch;

public class YoutubeResource {
	
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	
	private static final String api_key = "AIzaSyDmWMh1bHMPVY8IO_GVekB729r9X6e4ihc";
	private final String access_token;
	private final String URL_TRAILER = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%QUERY+trailer&maxResults=1&order=relevance&key=%APIKEY";
	private final String URL_YOUTUBE = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%QUERY+SoundTrack+Full+Album&maxResults=1&order=relevance&type=video&key=%APIKEY";
	private final String URL_COMMENT = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&key=";
	
	public YoutubeResource(String access_token) {
		this.access_token = access_token;
	}
	
	public YoutubeResource() {
		this.access_token=null;
	}
	/**
	 * 
	 * @param param
	 * @return comments
	 * @throws UnsupportedEncodingException
	 */
	
	public String insertComment(CommentResponse comentario, String contenido) {
		ClientResource cr = null;
		String newId = null;
		
		try {
			cr = new ClientResource(URL_COMMENT+api_key);
			CommentResponse newComment = cr.post(comentario,CommentResponse.class);
			newId = newComment.getSnippet().getChannelId();
			Map<String,Object> headers = cr.getRequestAttributes();
			headers.put("Content-Type", "text/plain");
			cr.put(contenido);
		}catch (ResourceException e) {
			log.warning("Error when inserting file: "+cr.getResponse().getStatus());
			// TODO: handle exception
		}
		return newId;
	}
	
	
	
	public VideoSearch getVideo(String param) throws UnsupportedEncodingException{
		String query = URLEncoder.encode(param, "UTF-8");
		ClientResource cr = null;
		VideoSearch res = null;
		
		try {

			cr = new ClientResource(URL_TRAILER.replace("%QUERY",query).replace("%APIKEY",api_key));
			res = cr.get(VideoSearch.class);
			log.log(Level.FINE, "Busqueda de videos de "+query+"realizada correctamente.");
		}catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener los videos", cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}
	
	public VideoSearch getTrack(String param) throws UnsupportedEncodingException{
		String query = URLEncoder.encode(param, "UTF-8");
		ClientResource cr = null;
		VideoSearch res = null;
		
		try {
			cr = new ClientResource(URL_YOUTUBE.replace("%QUERY",query).replace("%APIKEY",api_key));
			res = cr.get(VideoSearch.class);
			log.log(Level.FINE, "Busqueda de canciones de "+query+" realizada correctamente.");
		}catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener las canciones", cr.getResponse().getStatus());
			throw e;
		}
		return res;

	}
}
