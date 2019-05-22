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

import aiss.model.tmdb.Pelicula;
import aiss.model.tmdb.Producto;

@Path("/Productos")
public class ProductosResource extends PeliculasResource  {

	private int index = 0;
	public static ProductosResource instance = null;

	public static ProductosResource getInstance() {
		if (instance == null) {
			instance = new ProductosResource();
		}
		return instance;
	}
	
	// Producto
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public void addProductoPelicula(String idPelicula, Producto producto) {
		String idProducto = "p" + index++;
		producto.setId(idProducto);
		getPeliculaById(idPelicula).addProducto(producto);

	}

	@PUT
	@Consumes("application/json")
	public void updateProductoPelicula(String idPelicula, Producto producto) {
		getPeliculaById(idPelicula).updateProducto(producto);
	}

	@DELETE
	// ???
	public void deleteProductoPelicula(String idPelicula, String idProducto) {
		getPeliculaById(idPelicula).deleteProducto(getProductoById(idProducto));

	}

	@GET
	@Produces("application/json")
	public Collection<Producto> getAllPeliculasProductos() {
		Collection<Producto> productos = new HashSet<>();
		for (Pelicula p : getAllPeliculas()) {
			productos.addAll(p.getProductos());
		}
		return productos;
	}

	@GET
	@Produces("application/json")
	public Collection<Producto> getPeliculaProductosById(String idPelicula) {
		return getPeliculaById(idPelicula).getProductos();
	}

	@GET
	@Produces("application/json")
	public Collection<Producto> getPeliculaProductosByName(String title) {
		Collection<Producto> res = new HashSet<>();
		for (Pelicula p : getPeliculasByTitle(title)) {
			res.addAll(p.getProductos());
		}
		return res;
	}

	@GET
	@Produces("application/json")
	public Producto getProductoById(String id) {
		Producto res = null;
		for (Producto p : getAllPeliculasProductos()) {
			if (p.getId().equals(id)) {
				res = p;
				break;
			}
		}
		return res;
	}

}
