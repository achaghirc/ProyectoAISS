package aiss.model.resources;

import java.util.Arrays;
import java.util.Collection;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.Movie.MovieSearch;

public class MovieSearchResource {
	private static final String api_Key = "1cb3b67dfeb8452b822808e663f7b97c";
	private static final String URL_BASE = "https://api.themoviedb.org/3";
	private static final String URL_MOVIE_SEARCH = URL_BASE+"/search/movie";
	
	public Collection<MovieSearch> getAll(){
		ClientResource cr = null;
		MovieSearch mv = null;
		try {
			cr = new ClientResource(URL_BASE);
			mv = cr.get(MovieSearch.class);
		}catch (ResourceException e) {
			System.err.println("Error al recopilar la busqueda de peliculas: "+cr.getResponse().getStatus());
			throw e;
		}
		return Arrays.asList(mv);
	}
	
	public MovieSearch getMovieSearch(String movieId) {
		MovieSearch mv =null;
		ClientResource cr = null;
		
		try {
			cr = new ClientResource(URL_MOVIE_SEARCH+"?api_key="+api_Key+"&query="+movieId);
			mv = cr.get(MovieSearch.class);
		}catch (ResourceException e) {
			System.err.println("Error when retrieving the movie: " + cr.getResponse().getStatus());
			throw e;
		}
		return mv;
	}
}
