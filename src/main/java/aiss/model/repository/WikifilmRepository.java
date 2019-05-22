package aiss.model.repository;

import java.util.Collection;

import aiss.model.tmdb.Cancion;
import aiss.model.tmdb.Pelicula;
import aiss.model.tmdb.Producto;
import aiss.model.tmdb.Video;

public interface WikifilmRepository {
	public Collection<Pelicula> getAllPeliculas();

	public Pelicula getPeliculaById(String id);

	public Collection<Pelicula> getPeliculasByTitle(String title);

	public void addPelicula(Pelicula pelicula);

	public void updatePelicula(Pelicula pelicula);

	public void deletePelicula(String id);
	
	public void addVideoPelicula(String idPelicula, Video video);

	public void updateVideoPelicula(String idPelicula, Video video);

	public void deleteVideo(String idPelicula, String idVideo);

	public void addProductoPelicula(String idPelicula, Producto producto);

	public void updateProductoPelicula(String idPelicula, Producto producto);

	public void deleteProductoPelicula(String idPelicula, String idProducto);
	
	public void addCancionPelicula(String idPelicula,Cancion Cancion);
	
	public void updateCancionPelicula(String idPelicula, Cancion cancion);
	
	public void deleteCancionPelicula(String idPelicula,String idCancion);

	
	
	public Collection<Video> getAllPeliculaVideos();

	public Collection<Video> getPeliculaVideosById(String idPelicula);

	public Collection<Video> getPeliculaVideosByName(String title);

	public Video getVideoById(String id);
	
	

	public Collection<Producto> getAllPeliculasProductos();

	public Collection<Producto> getPeliculaProductosById(String idPelicula);

	public Collection<Producto> getPeliculaProductosByName(String title);

	public Producto getProductoById(String id);
	
	
	
	public Collection<Cancion> getAllPeliculasCanciones();
	
	public Collection<Cancion> getPeliculasCancionesById(String idPelicula);
	
	public Collection<Cancion> getPeliculasCancionesByName(String title);
	
	public Cancion getCancionById(String id);
	
}
