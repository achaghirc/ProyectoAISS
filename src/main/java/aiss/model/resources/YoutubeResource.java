package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.youtube.VideoSearch;

public class YoutubeResource {
	
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());
	
	private static final String api_key = "AIzaSyDmWMh1bHMPVY8IO_GVekB729r9X6e4ihc";
	private static final String URL_YOUTUBE = "https://www.googleapis.com/youtube/v3/search?part=snippet&q=%QUERY+trailer&maxResults=1&order=relevance&key=%APIKEY";
	
	public VideoSearch getVideo(String param) throws UnsupportedEncodingException{
		String query = URLEncoder.encode(param, "UTF-8");
		ClientResource cr = null;
		VideoSearch res = null;
		
		try {
			cr = new ClientResource(URL_YOUTUBE.replace("%QUERY",query).replace("%APIKEY",api_key));
			res = cr.get(VideoSearch.class);
			log.log(Level.FINE, "Busqueda de videos de "+query+"realizada correctamente.");
		}catch (Exception e) {
			log.log(Level.WARNING, "Error al obtener los videos", cr.getResponse().getStatus());
			throw e;
		}
		return res;
	}
}
