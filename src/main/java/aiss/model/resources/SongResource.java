package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Song;

public class SongResource {

	private String uri = "http://playlist-api.appspot.com/api/songs";
	//private String uri = "http://localhost:8095/api/songs";

	
	public Collection<Song> getAll() {
		ClientResource cr = null;
		Song [] songs = null;
		try {
			cr = new ClientResource(uri);
			songs = cr.get(Song[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving all songs: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return Arrays.asList(songs);
	}
	

	public Song getSong(String songId) {
		ClientResource cr = null;
		Song s = null;
		try {
			cr = new ClientResource(uri+"/"+songId);
			s = cr.get(Song.class);
		}catch (ResourceException e) {
			System.err.println("Error al querer obtener la cancion"+cr.getResponse().getStatus());
			throw e;
		}
		return s;
	}
	

	public Song addSong(Song song) {
		ClientResource cr = null;
		Song s= null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			s = cr.post(song,Song.class);
		}catch (ResourceException e) {
			System.err.println("Error al crear una cancion: "+cr.getResponse().getStatus());
			throw e;
		}
		return s;

	}
	
	public boolean updateSong(Song song) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(song);
		}catch (ResourceException e) {
			System.err.println("Error al actualizar la cancion: "+cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
	

	public boolean deleteSong(String songId) {
		ClientResource cr = null;
		boolean success = true;
		try {
			cr = new ClientResource(uri + "/" + songId);
			cr.setEntityBuffering(true);		// Needed for using RESTlet from JUnit tests
			cr.delete();
			
		} catch (ResourceException re) {
			System.err.println("Error when deleting the song: " + cr.getResponse().getStatus());
			success = false;
			throw re;
		}
		
		return success;
		
	}
}
