package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.youtube.VideoSearch;

public class YoutubeResource {
	
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	
	private static final String api_key = "AIzaSyDmWMh1bHMPVY8IO_GVekB729r9X6e4ihc";
	private static final String URL_YOUTUBE_Trailer = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%QUERY+trailer&maxResults=1&order=relevance&key=%APIKEY";
	private static final String URL_YOUTUBE_Track = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%QUERY+track&maxResults=1&order=relevance&key=%APIKEY";
	
	
	public VideoSearch getVideo(String param) throws UnsupportedEncodingException{
		String query = URLEncoder.encode(param, "UTF-8");
		ClientResource cr = null;
		VideoSearch res = null;
		
		try {
			cr = new ClientResource(URL_YOUTUBE_Trailer.replace("%QUERY",query).replace("%APIKEY",api_key));
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
			cr = new ClientResource(URL_YOUTUBE_Track.replace("%QUERY",query).replace("%APIKEY",api_key));
			res = cr.get(VideoSearch.class);
			log.log(Level.FINE, "Busqueda de canciones de "+query+"realizada correctamente.");
		}catch (ResourceException e) {
			log.log(Level.WARNING, "Error al obtener las canciones", cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}
}
