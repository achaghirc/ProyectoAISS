package aiss.model.tmdb;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String id;
	private String title;
	private String director;
	private String actores;
	private String synopsis;
	private String fechaEstreno;
	private List<Video> videos;
	private List<Producto> productos;
	private List<Cancion> canciones;

	public Pelicula() {
	}

	public Pelicula(String id, String title, String director, String actores, String synopsis, String fechaEstreno,
			List<Video> videos, List<Producto> productos, List<Cancion> canciones) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.actores = actores;
		this.synopsis = synopsis;
		this.fechaEstreno = fechaEstreno;
		this.videos = videos;
		this.productos = productos;
		this.canciones = canciones;
	}

	public Pelicula(String title, String director, String actores, String synopsis, String fechaEstreno,
			List<Video> videos, List<Producto> productos, List<Cancion> canciones) {
		super();
		this.title = title;
		this.director = director;
		this.actores = actores;
		this.synopsis = synopsis;
		this.fechaEstreno = fechaEstreno;
		this.videos = videos;
		this.productos = productos;
		this.canciones = canciones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	public void addVideo(Video v) {
		if (videos == null) {
			videos = new ArrayList<Video>();
		}
		videos.add(v);
	}
	
	public void updateVideo(Video v) {
		List<Video> videosCopia = new ArrayList<>(videos);
		for (Video video : videosCopia) {
			if(video.getId().equals(v.getId())) {
				videosCopia.remove(video);
				videosCopia.add(v);
				break;
			}
		}
		videos = videosCopia;
	}
	
	public void deleteVideo(Video v) {
		videos.remove(v);
	}
	
	public void addProducto(Producto p) {
		if (productos == null) {
			productos = new ArrayList<Producto>();
		}
		productos.add(p);
	}
	
	public void updateProducto(Producto p) {
		List<Producto> productosCopia = new ArrayList<>(productos);
		for (Producto producto : productosCopia) {
			if(producto.getId().equals(p.getId())) {
				productosCopia.remove(producto);
				productosCopia.add(p);
				break;
			}
		}
		productos = productosCopia;
	}
	
	public void deleteProducto(Producto p) {
		productos.remove(p);
	}
	public void addCancion(Cancion c) {
		if (canciones == null) {
			canciones = new ArrayList<Cancion>();
		}
		canciones.add(c);
	}

	public void updateCancion(Cancion c) {
		List<Cancion> CancionCopia = new ArrayList<>(canciones);
		for (Cancion cancion : CancionCopia) {
			if(cancion.getId().equals(c.getId())) {
				CancionCopia.remove(cancion);
				CancionCopia.add(c);
				break;
			}
		}
		canciones = CancionCopia;
	}
	public void deleteCancion(Cancion c) {
		canciones.remove(c);
	}
}

