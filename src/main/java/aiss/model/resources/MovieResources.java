package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import aiss.model.movie.Credits;
import aiss.model.movie.GuessID;
import aiss.model.movie.Movie;
import aiss.model.movie.MovieSearch;
import aiss.model.movie.Rate;
import aiss.model.movie.Videos;




public class MovieResources {
	private static final String api_Key = "1cb3b67dfeb8452b822808e663f7b97c";
	private static final String URL_BASE = "https://api.themoviedb.org/3";
	private static final String URL_MOVIE = URL_BASE+"/movie/";
	private static final String URL_SESSION = "https://api.themoviedb.org/3/authentication/guest_session/new?api_key=";
	
	
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
			cr = new ClientResource(URL_MOVIE+movieId+"?api_key="+api_Key+"&language=en-US");
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
			System.err.println("Error al obtener el video de la pelicula: "+ cr.getResponse().getStatus());
		}
		return v;
	}
	
	public MovieSearch getPopular() {
		//https://api.themoviedb.org/3/movie/popular?api_key=1cb3b67dfeb8452b822808e663f7b97c&language=en-US&page=1
		ClientResource cr = null; 
		MovieSearch v = null;
		
		try { 
			cr = new ClientResource(URL_MOVIE+"popular?api_key="+api_Key+"&language=en-US");
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
			cr = new ClientResource(URL_MOVIE+"upcoming?api_key="+api_Key+"&language=en-US");
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
			cr = new ClientResource(URL_BASE+"/trending/movie/day?api_key="+api_Key);
			v = cr.get(MovieSearch.class);
		}catch (ResourceException e) {
			System.err.println("Error al obtener la pelicula mas vista: "+cr.getResponse().getStatus());
			throw e;
		}
		return v;
	}
	public GuessID getGuessId() {
		GuessID res = null;
		ClientResource cr = null;
		
		try {
			cr = new ClientResource(URL_SESSION+api_Key);
			res = cr.get(GuessID.class);
		}catch(ResourceException e) {
			System.err.println("La sesion Id no se ha obtenido correctamente");
		}
		return res;
	}
	public Rate postRate(Rate rate,String movieId) throws UnsupportedEncodingException {
		Rate res = null;
		GuessID guess = getGuessId();
		String sessionId = guess.getGuestSessionId();
		System.out.println( "El session id es "+sessionId);
		ClientResource cr = null;
		try {
			cr = new ClientResource("https://api.themoviedb.org/3/movie/"+movieId+"/rating?api_key="+api_Key+"&guest_session_id="+sessionId);
			res = cr.post(rate,Rate.class);
		}catch (ResourceException e){
			System.err.println("Error al hacer post de la valoracion "+cr.getResponse().getStatus());
			throw e;
		}
		
		
		return res;
	}
}
