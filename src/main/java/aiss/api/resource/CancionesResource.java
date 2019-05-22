package aiss.api.resource;

import java.util.Collection;
import java.util.HashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import aiss.model.tmdb.Cancion;
import aiss.model.tmdb.Pelicula;

@Path("/Canciones")
public class CancionesResource extends PeliculasResource {

	private int index = 0;
	public static CancionesResource instance = null;

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
	public void addCancionPelicula(String idPelicula, Cancion cancion) {
		String idCancion = "c" + index++;
		cancion.setId(idCancion);
		getPeliculaById(idPelicula).addCancion(cancion);
	}

	@PUT
	@Consumes("application/json")
	public void updateCancionPelicula(String idPelicula, Cancion cancion) {
		getPeliculaById(idPelicula).updateCancion(cancion);
	}

	@DELETE
	// ???
	public void deleteCancionPelicula(String idPelicula, String idCancion) {
		getPeliculaById(idPelicula).deleteCancion(getCancionById(idCancion));
	}

	@GET
	@Produces("application/json")
	public Collection<Cancion> getAllPeliculasCanciones() {
		Collection<Cancion> canciones = new HashSet<>();
		for (Pelicula p : getAllPeliculas()) {
			canciones.addAll(p.getCanciones());
		}
		return canciones;
	}

	@GET
	@Produces("application/json")
	public Collection<Cancion> getPeliculasCancionesById(String idPelicula) {
		return getPeliculaById(idPelicula).getCanciones();
	}

	@GET
	@Produces("application/json")
	public Collection<Cancion> getPeliculasCancionesByName(String title) {
		Collection<Cancion> res = new HashSet<>();
		for (Pelicula p : getPeliculasByTitle(title)) {
			res.addAll(p.getCanciones());
		}
		return res;
	}

	@GET
	@Produces("application/json")
	public Cancion getCancionById(String id) {
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
