package aiss.api.resource;

import java.util.Collection;
import java.util.HashSet;

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
import aiss.model.tmdb.Cancion;
import aiss.model.tmdb.Pelicula;

@Path("/Canciones")
public class CancionesResource extends PeliculasResource {

	private int index = 0;
	public static CancionesResource instance = null;
	WikifilmRepository repository;
	public CancionesResource() {
		repository = WikifilmRepositoryImpl.getInstance();
	}
	
	public static CancionesResource getInstance() {
		if (instance == null) {
			instance = new CancionesResource();
		}
		return instance;
	}

	// Cancion
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/idPelicula({idPelicula}")
	public void addCancionPelicula(@PathParam("idPelicula")String idPelicula, Cancion cancion) {
		String idCancion = "c" + index++;
		cancion.setId(idCancion);
		getPeliculaById(idPelicula).addCancion(cancion);
	}

//	@PUT
//	@Consumes("application/json")
//	public void updateCancionPelicula(@PathParam("idPelicula")String idPelicula, Cancion cancion) {
//		getPeliculaById(idPelicula).updateCancion(cancion);
//	}

	@DELETE
	@Path("/idPelicula/{idPelicula}/idCancion/{idCancion}")
	public void deleteCancionPelicula(@PathParam("idPelicula")String idPelicula, @PathParam("idCancion")String idCancion) {
		getPeliculaById(idPelicula).deleteCancion(getCancionById(idCancion));
	}
	
	
	//No llamar en Swagger
	@GET
	@Produces("application/json")
	public Collection<Cancion> getAllPeliculasCanciones() {
		Collection<Cancion> canciones = new HashSet<>();
		for (Pelicula p : getAllPeliculas()) {
			canciones.addAll(p.getCanciones());
		}
		return canciones;
	}

//	@GET
//	@Produces("application/json")
//	public Collection<Cancion> getPeliculasCancionesById(@PathParam("idPelicula")String idPelicula) {
//		return getPeliculaById(idPelicula).getCanciones();
//	}

	@GET
	@Produces("application/json")
	@Path("/tituloPelicula/{titlePelicula}")
	public Collection<Cancion> getPeliculasCancionesByName(@PathParam("titlePelicula")String title) {
		Collection<Cancion> res = new HashSet<>();
		for (Pelicula p : getPeliculasByTitle(title)) {
			res.addAll(p.getCanciones());
		}
		return res;
	}

	@GET
	@Produces("application/json")
	@Path("/idCancion/{idCancion}")
	public Cancion getCancionById(@PathParam("idCancion")String id) {
		Cancion res = null;
		for (Cancion c : getAllPeliculasCanciones()) {
			if (c.getId().equals(id)) {
				res = c;
				break;
			}
		}
		return res;
	}

}
