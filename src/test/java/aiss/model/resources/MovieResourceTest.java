package aiss.model.resources;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;


import aiss.Movie.MovieSearch;

public class MovieResourceTest {
	
	@Test
	public void testGetMovie() throws UnsupportedEncodingException {
		String movieId="Star Wars";
		MovieSearchResource mv = new MovieSearchResource();
		MovieSearch tmdbResults = mv.getMovieSearch(movieId);
		
		assertNotNull("The Search returned null",tmdbResults);
		assertNotNull("The search returned null",tmdbResults.getResults());
		assertFalse("La busqueda de albums para "+movieId+"is zero",tmdbResults.getResults().size()==0);
		
		System.out.println("El numero de resultados para el id " + movieId + "is zero" + tmdbResults.getResults().size() + "movies.");
		//Show results
		
		
	}
}
