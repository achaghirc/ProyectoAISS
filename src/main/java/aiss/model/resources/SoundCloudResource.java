package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Logger;
import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.SoundCloud.Track;

public class SoundCloudResource {

	private static final Logger log = Logger.getLogger(SoundCloudResource.class.getName());
	
	private final String access_token;
	private static final String api_Key = "287adf40e30f73eb3cfe0af77f3a77d";
	private static final String uri = "https://api.soundcloud.com";
	private static final String uri_Track = uri + "/tracks/";
	
	
	public SoundCloudResource(String access_token) {
		this.access_token = access_token;
	}
	
	public Collection<Track> getAll(){
		ClientResource cr = null;
		Track [] tracks = null;
		try {
			cr = new ClientResource(uri);
			tracks = cr.get(Track[].class);
		}catch (ResourceException e) {
			System.err.println("Error al recopilar todas las canciones" + cr.getResponse().getStatus());
			throw e;
		}
		return Arrays.asList(tracks);
	}
	
	public Track getBusqueda(String busqueda) {
		//"http://api.soundcloud.com/tracks/13158665?client_id=YOUR_CLIENT_ID"
		Track res = null;
		ClientResource cr = null;
		try {
			String query = URLEncoder.encode(busqueda, "UTF-8");
			cr = new ClientResource(uri_Track + query);
		}catch(ResourceException e) {
			System.err.println("Error de Soundcloud: " + cr.getResponse().getStatus());
			System.err.println(uri_Track + "?access_token=" + access_token);
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res;
	}
//	 public Playlists getPlaylists() {
//	        String playlistsGetURL = uri + "/playlists/";
//	        ClientResource cr = new ClientResource(playlistsGetURL);
//
//	        ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
//	        chr.setRawValue(access_token);
//	        cr.setChallengeResponse(chr);
//
//	        Playlists playlists = null;
//	        try {
//	            playlists = cr.get(Playlists.class);
//	            return playlists;
//
//	        } catch (ResourceException re) {
//	            log.warning("Error cuando recuperabamos la playlist: " + cr.getResponse().getStatus());
//	            log.warning(playlistsGetURL);
//	            return null;
//	        }
//	    }
	 

	 public Track getTrack(Integer TrackId) throws UnsupportedEncodingException {
			//"http://api.soundcloud.com/tracks/13158665?client_id=YOUR_CLIENT_ID"
			ClientResource cr = new ClientResource(uri_Track+TrackId+"?client_id="+api_Key);
			Track m = null;
			
			ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
			try {
				m = cr.get(Track.class);
			}catch (ResourceException e) {
				log.warning("Error cuando recuperabamos la playlist: " + cr.getResponse().getStatus());
			}
			return m;
		}
	
}
