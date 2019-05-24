package aiss.api.resource;

import java.util.Collection;
import java.util.HashSet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import aiss.api.classes.Pelicula;
import aiss.api.classes.Producto;
import aiss.model.repository.WikifilmRepository;
import aiss.model.repository.WikifilmRepositoryImpl;

@Path("/Productos")
public class ProductosResource extends PeliculasResource  {

	private int index = 0;
	public static ProductosResource instance = null;
	
	WikifilmRepository repository;
	
	public ProductosResource() {
		repository = WikifilmRepositoryImpl.getInstance();
	}
	
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
	public void addProductoPelicula(@PathParam("idPelicula")String idPelicula, Producto producto) {
		String idProducto = "p" + index++;
		producto.setId(idProducto);
		getPeliculaById(idPelicula).addProducto(producto);
	}

//	@PUT
//	@Consumes("application/json")
//	public void updateProductoPelicula(@PathParam("idPelicula")String idPelicula, Producto producto) {
//		getPeliculaById(idPelicula).updateProducto(producto);
//	}

	@DELETE
	@Path("/idPelicula/{idPelicula}/idProducto/{idProducto}")
	public void deleteProductoPelicula(@PathParam("idPelicula")String idPelicula,@PathParam("idProducto") String idProducto) {
		getPeliculaById(idPelicula).deleteProducto(getProductoById(idProducto));

	}
	
	//No llamar a Swagger
	@GET
	@Produces("application/json")
	public Collection<Producto> getAllPeliculasProductos() {
		Collection<Producto> productos = new HashSet<>();
		for (Pelicula p : getAllPeliculas()) {
			productos.addAll(p.getProductos());
		}
		return productos;
	}

//	@GET
//	@Produces("application/json")
//	public Collection<Producto> getPeliculaProductosById(@PathParam("idPelicula")String idPelicula) {
//		return getPeliculaById(idPelicula).getProductos();
//	}

	@GET
	@Produces("application/json")
	@Path("/tituloPelicula/{titlePelicula}")
	public Collection<Producto> getPeliculaProductosByName(@PathParam("titlePelicula")String title) {
		Collection<Producto> res = new HashSet<>();
		for (Pelicula p : getPeliculasByTitle(title)) {
			res.addAll(p.getProductos());
		}
		return res;
	}

	@GET
	@Produces("application/json")
	@Path("/idProducto/{idProducto}")
	public Producto getProductoById(@PathParam("idProducto")String id) {
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
