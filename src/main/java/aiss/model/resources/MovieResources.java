package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;


import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;



import aiss.Movie.Credits;
import aiss.Movie.Movie;
import aiss.Movie.MovieSearch;
import aiss.Movie.Videos;
import aiss.model.tmdb.Session;

import aiss.model.tmdb.TMDBRegistry;

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
		String param = URLEncoder.encode(movieId, "UTF-8");
		ClientResource cr = null;
		Movie m = null;
		try {
			cr = new ClientResource(URL_MOVIE+param+"?api_key="+api_Key+"&language=es-ES");
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
	public Videos getVideos(String movieId) {
		/*https://api.themoviedb.org/3/movie/11/videos?api_key=1cb3b67dfeb8452b822808e663f7b97c&language=en-US*/
		ClientResource cr = null;
		Videos v = null;
		
		try {
			cr = new ClientResource(URL_MOVIE+movieId+"/videos?api_key="+api_Key);
			v = cr.get(Videos.class);
		}catch (ResourceException e) {
			System.err.println("Error al obtener el Cast de la pelicula: "+ cr.getResponse().getStatus());
		}
		return v;
	}
	public TMDBRegistry getToken() {
		ClientResource cr = null;
		TMDBRegistry token = null;
		
		try {
			cr = new ClientResource("https://api.themoviedb.org/3/authentication/token/new?api_key="+api_Key);
			token = cr.get(TMDBRegistry.class);
		}catch (ResourceException e){
			System.err.println("Error al obtener el token "+cr.getResponse().getStatus());
			throw e;
		}
		return token;
		}

	public Session getSession(String token) {
		ClientResource cr = null;
		Session s = null;
		
		try {
			cr = new ClientResource("https://api.themoviedb.org/3/authentication/session/new?api_key="+api_Key);
			s = cr.get(Session.class);
		}catch (ResourceException e) {
			System.err.println("Error al obtener la sesion "+cr.getResponse().getStatus());
			throw e;
		}
		return s;
	}
	public MovieSearch getPopular() {
		//https://api.themoviedb.org/3/movie/popular?api_key=1cb3b67dfeb8452b822808e663f7b97c&language=en-US&page=1
		ClientResource cr = null; 
		MovieSearch v = null;
		
		try { 
			cr = new ClientResource(URL_MOVIE+"popular?api_key="+api_Key+"&language=es-ES");
			v = cr.get(MovieSearch.class);
		}catch (ResourceException e) {
			System.err.println("Error al obtener la pelicula mas vista: "+cr.getResponse().getStatus());
			throw e;
		}
		return v;
	}
	public MovieSearch getUpcoming() {
		//https://api.themoviedb.org/3/movie/upcoming?api_key=1cb3b67dfeb8452b822808e663f7b97c&language=es-ES&page=1
		ClientResource cr = null; 
		MovieSearch v = null;
		
		try { 
			cr = new ClientResource(URL_MOVIE+"upcoming?api_key="+api_Key+"&language=es-ES");
			v = cr.get(MovieSearch.class);
		}catch (ResourceException e) {
			System.err.println("Error al obtener la pelicula mas a estrenar: "+cr.getResponse().getStatus());
			throw e;
		}
		return v;
	}
	public MovieSearch getTrending() {
		//https://api.themoviedb.org/3/trending/movie/day?api_key=1cb3b67dfeb8452b822808e663f7b97c
		ClientResource cr = null; 
		MovieSearch v = null;
		
		try { 
			cr = new ClientResource(URL_BASE+"/trending/movie/day?api_key="+api_Key+"&language=es-ES");
			v = cr.get(MovieSearch.class);
		}catch (ResourceException e) {
			System.err.println("Error al obtener la pelicula mas vista: "+cr.getResponse().getStatus());
			throw e;
		}
		return v;
	}
}
