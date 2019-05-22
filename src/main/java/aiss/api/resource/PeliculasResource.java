package aiss.api.resource;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import aiss.model.repository.WikifilmRepository;
import aiss.model.repository.WikifilmRepositoryImpl;
import aiss.model.tmdb.Pelicula;

@Path("/Peliculas")
public class PeliculasResource {
	
	public static PeliculasResource instance = null;
	WikifilmRepository repository;
	
	public PeliculasResource() {
		repository = WikifilmRepositoryImpl.getInstance();
	}
	
	public static PeliculasResource getInstance() {
		if(instance == null) {
			instance = new PeliculasResource();
		}
		return instance;
	}
	
	Map<String, Pelicula> peliculasMap;

	
	
	
	// Pelicula
	@GET
	@Produces("application/json")
	public Collection<Pelicula> getAllPeliculas() {
		return peliculasMap.values();
	}

	@GET
	@Path("/{idPelicula}")
	@Produces("application/json")
	public Pelicula getPeliculaById(@PathParam("idPelicula") String id) {
		return peliculasMap.get(id);
	}

	@GET
	@Path("/{titlePelicula}")
	@Produces("application/json")
	public Collection<Pelicula> getPeliculasByTitle(@PathParam("title") String title) {
		Collection<Pelicula> res = new HashSet<>();
		for (Pelicula p : getAllPeliculas()) {
			if (p.getTitle().equals(title)) {
				res.add(p);
			}
		}
		return res;
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public void addPelicula(Pelicula pelicula) {
		System.out.println(pelicula.getId());
		System.out.println(pelicula.getTitle());
		peliculasMap.put(pelicula.getId(), pelicula);
		System.out.println(peliculasMap.get(pelicula.getId()));

	}

	@PUT
	@Consumes("application/json")
	public void updatePelicula(Pelicula pelicula) {
		if (getAllPeliculas().contains(pelicula)) {
			peliculasMap.put(pelicula.getId(), pelicula);
		}
	}

	@DELETE
	@Path("Peliculas/{idPelicula}")
	public void deletePelicula(@PathParam("idPelicula") String id) {
		peliculasMap.remove(id);
	}

}
