package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.Movie.Cast;
import aiss.Movie.Credits;
import aiss.Movie.Movie;

public class MovieResources {
	private static final String api_Key = "1cb3b67dfeb8452b822808e663f7b97c";
	private static final String URL_BASE = "https://api.themoviedb.org/3";
	private static final String URL_MOVIE = URL_BASE+"/movie/";
	
	public Collection<Movie> getAll(){
		ClientResource cr = null;
		Movie [] movies = null;
		try {
			cr = new ClientResource(URL_BASE);
			movies = cr.get(Movie[].class);
		}catch (ResourceException e) {
			System.err.println("Error al recopilar todas las peliculas" + cr.getResponse().getStatus());
			throw e;
		}
		return Arrays.asList(movies);
	}
	
	public Movie getMovie(String movieId) throws UnsupportedEncodingException {
		//https://api.themoviedb.org/3/movie/{movie_id}?api_key=<<api_key>>&language=en-US
		ClientResource cr = null;
		Movie m = null;
		try {
			cr = new ClientResource(URL_MOVIE+movieId+"?api_key="+api_Key);
			m = cr.get(Movie.class);
		}catch (ResourceException e) {
			System.err.println("Error al querer obtener la pelicula: "+cr.getResponse().getStatus());
		}
		return m;
	}
	public Credits getCasting(String movieId) {
		//https://api.themoviedb.org/3/movie/11/credits?api_key=1cb3b67dfeb8452b822808e663f7b97c
		ClientResource cr = null;
		Credits c = null;
		
		try {
			cr = new ClientResource(URL_MOVIE+movieId+"/credits?api_key="+api_Key);
			c = cr.get(Credits.class);
		}catch (ResourceException e) {
			System.err.println("Error al obtener el Cast de la pelicula: "+ cr.getResponse().getStatus());
		}
		return c;
	}
	
}
