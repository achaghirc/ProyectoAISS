package resources;

import java.io.UnsupportedEncodingException;
import org.junit.Test;

import aiss.model.movie.Cast;
import aiss.model.movie.Credits;
import aiss.model.movie.Movie;
import aiss.model.movie.MovieSearch;
import aiss.model.resources.MovieResources;
import aiss.model.resources.MovieSearchResource;

public class TMDBResourceTest {
	
	static MovieSearch search;
	static MovieSearchResource sr = new MovieSearchResource();
	static MovieResources sm = new MovieResources();
	static Movie movie;
	static Credits credits;
	
	@Test
	public void testGetMovie() throws UnsupportedEncodingException {
		
		search = sr.getMovieSearch("Avengers");
		
		System.out.println(search.getResults());
		
		for(Movie m:search.getResults()) {
			System.out.println("Id de la pelicula: " + m.getId());
			System.out.println("Titulo de la pelicula: " + m.getTitle());
		}
		
		credits = sm.getCasting(search.getResults().get(0).getId().toString());
		
		for(Cast c: credits.getCast()) {
			System.out.println("Nombre del Actor: " + c.getName());
		}
		
	}
}
