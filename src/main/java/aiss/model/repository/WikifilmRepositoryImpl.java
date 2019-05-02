package aiss.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import aiss.model.tmdb.Cancion;
import aiss.model.tmdb.Pelicula;
import aiss.model.tmdb.Producto;
import aiss.model.tmdb.Video;

public class WikifilmRepositoryImpl implements WikifilmRepository {
	Map<String, Pelicula> peliculasMap;

	
	private static WikifilmRepositoryImpl instance = null;
	private int index = 0;

	public static WikifilmRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new WikifilmRepositoryImpl();
			instance.init();
		}
		return instance;
	}
	
	public void init() {
		
		peliculasMap = new HashMap<String, Pelicula>();

		//Crear Video
		
		Video v1 = new Video("v01", "Trailer - Black Panther", "https://www.youtube.com/watch?v=JK-wAfAvJ0g");
		Video v2 = new Video("v02", "Trailer - Iron Man 3", "https://www.youtube.com/watch?v=6Cl8PmVm3YE");
		List<Video> videoBlackPanther = new ArrayList<>();
		List<Video> videoIronMan3 = new ArrayList<>();
		videoBlackPanther.add(v1);
		videoIronMan3.add(v2);
		
		
		//Crear Producto
		
		Producto p1 = new Producto("p01", "Máscara Black Panther", "10€", "https://es.aliexpress.com/store/product/Black-Panther-Masks-Captain-America-Civil-War-Roles-Cosplay-Latex-Mask-Helmet-Halloween-Realistic-Adult-Party/2966019_32841067993.html?ws_ab_test=searchweb0_0,searchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815,searchweb201603_2,ppcSwitch_7&algo_expid=8a145633-c336-4bd8-af9c-41ff4b0518ff-0&algo_pvid=8a145633-c336-4bd8-af9c-41ff4b0518ff&transAbTest=ae803_2&priceBeautifyAB=0", "Máscara sintetica negra de Black Panther");
		Producto p2 = new Producto("p02", "Busto de Black Panther", "54€", "https://es.aliexpress.com/store/product/Negro-Panther-busto-estatua-resina-figura-de-acci-n-figura-pintada-busto-negro-Panther-resina-figura/2410033_32856229096.html?ws_ab_test=searchweb0_0%2Csearchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815%2Csearchweb201603_2%2CppcSwitch_7&algo_expid=8a145633-c336-4bd8-af9c-41ff4b0518ff-19&algo_pvid=8a145633-c336-4bd8-af9c-41ff4b0518ff&transAbTest=ae803_2&priceBeautifyAB=0", "Busto de Black Panther hecho de resina");
		Producto p3 = new Producto("p03", "Figura de Black Panther 1/6", "21€", "https://es.aliexpress.com/item/Negro-Pantera-acci-n-figura-1-6-escala-negro-Panther-modelo-mu-ecas-decoraci-n-PVC/32860314288.html?s=p", "Figura de accion de 1/6 de Black Panther");
		Producto p4 = new Producto("p04", "Figura de Iron Man 38cm", "37€", "https://es.aliexpress.com/store/product/Loco-Juguetes-Iron-Man-Mark-XLVI-MK-46-1-6-B-sculas-PVC-figura-juguete-modelo/2313004_32837787629.html?ws_ab_test=searchweb0_0%2Csearchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815%2Csearchweb201603_2%2CppcSwitch_7&algo_expid=0082ced8-c8c3-476f-a432-28d031ced164-4&algo_pvid=0082ced8-c8c3-476f-a432-28d031ced164&transAbTest=ae803_2&priceBeautifyAB=0", "Figura colleccionable de Iron Man de 38 cm");
		Producto p5 = new Producto("p05", "Reactor Iron Man", "38€", "https://es.aliexpress.com/store/product/Toys-Legend-1-1-scale-Iron-Man-MK6-Arc-Reactor-with-LED-Light-Iron-Man-3/2795179_32804369969.html?ws_ab_test=searchweb0_0,searchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815,searchweb201603_2,ppcSwitch_7&algo_expid=0082ced8-c8c3-476f-a432-28d031ced164-5&algo_pvid=0082ced8-c8c3-476f-a432-28d031ced164&transAbTest=ae803_2&priceBeautifyAB=0", "Figura del reactor de Iron Man escala 1:1 con luces LED");
		Producto p6 = new Producto("p06", "Figura de accion de Iron Man", "16€", "https://es.aliexpress.com/store/product/NEW-Hot-1-pcs-Marvel-Movie-Iron-Man-3-Evolution-version-Action-Figure-Superhero-Mark-42/535439_32223118727.html?ws_ab_test=searchweb0_0,searchweb201602_5_10152_10151_10065_10344_10068_10547_10342_10343_10340_10548_10341_10696_10084_10083_10618_10307_10301_10303_10059_308_100031_10103_10624_10623_10622_10621_10620_10814_10815,searchweb201603_2,ppcSwitch_7&algo_expid=0082ced8-c8c3-476f-a432-28d031ced164-8&algo_pvid=0082ced8-c8c3-476f-a432-28d031ced164&transAbTest=ae803_2&priceBeautifyAB=0", "Figura de accion movil de Iron Man de 18 cm");
		
		List<Producto> productosBlackPanther = new ArrayList<>();
		List<Producto> productosIronMan = new ArrayList<>();
		
		productosBlackPanther.add(p1);
		productosBlackPanther.add(p2);
		productosBlackPanther.add(p3);
		
		productosIronMan.add(p4);
		productosIronMan.add(p5);
		productosIronMan.add(p6);
	     //Crear Cancion
		Cancion c1= new Cancion("https://open.spotify.com/track/12SJpYZEdj4kzWZ8FPFg4Y","All the stars","c01",240,86);
		Cancion c2=new Cancion("https://open.spotify.com/track/4ofvoCdXq99vpMZO4Cfp8x","Pray for me","c02",210,82);
		Cancion c3=new Cancion("https://open.spotify.com/track/5fIXvEcVEQV5vK3IJapBp3","BagBak","c03",240,80);
		Cancion c4=new Cancion("https://open.spotify.com/track/6C67ZEgSBc64tof7xKMYA1","Mark I","c04",120,69);
		Cancion c5=new Cancion("https://open.spotify.com/track/19utKBiyGQH8I45pIBNhJL","Mark II","c05",120,69);
		Cancion c6=new Cancion("https://open.spotify.com/track/2iXt0dtlAOA6LS0k6pR6bg","Merchant of Death","c06",180,76);
		  List<Cancion> cancionesBlackPanther=new ArrayList<>();
		  List<Cancion> cancionesIronMan=new ArrayList<>();
		  cancionesBlackPanther.add(c1);
		  cancionesBlackPanther.add(c2);
		  cancionesBlackPanther.add(c3);
		  cancionesIronMan.add(c4);
		  cancionesIronMan.add(c5);
		  cancionesIronMan.add(c6);
		//Crear Pelicula
		
		Pelicula f1 = new Pelicula("f1", "Black Panther", "Ryan Coogler", " Chadwick Boseman, Michael B. Jordan, Lupita Nyong'o,...", "Cuenta la historia de T'Challa quien, después de los acontecimientos de Capitán América: Civil War, vuelve a casa, a la nación de Wakanda, aislada y muy avanzada tecnológicamente, para ser proclamado Rey. Pero la reaparición de un viejo enemigo pone a prueba el temple de T'Challa como Rey y Black Panther ya que se ve arrastrado a un conflicto que pone en peligro todo el destino de Wakanda y del mundo", "Febrero 13, 2018",
											videoBlackPanther, productosBlackPanther, cancionesBlackPanther);
		Pelicula f2 = new Pelicula("f2", "Iron Man 3", "Shane Black", " Robert Downey Jr., Guy Pearce, Gwyneth Paltrow,...", "En esta ocasión el imponente superhéroe Iron Man intentará mejorar su armadura mediante una nueva tecnología y, entre otros personajes, estará acompañado de su gran amiga Pepper Potts (Gwyneth Paltrow), su aliado de armas James Rhodes y su guardaespaldas Happy Hogan. Esta nueva entrega de la historia se inspira en la colección de comics titulada 'Extremis', escrita por Warren Ellis y dibujada por Adi Granov que fue publicada entre el año 2005 y el año 2006. En esta parte, el argumento se desarrolla en un mundo más realista y menos fantasioso que el de las anteriores, donde los acontecimientos sucedidos en 'Marvel: Los Vengadores' tienen constancia pero no resultan ser el eje central de la película. De esta forma, el tercer capítulo de la saga Iron Man revolucionará el estilo de las anteriores conservando su esencia, pero con originales innovaciones que sorprenderán a todos los fans de la serie.", "Abril 18, 2013", 
											videoIronMan3, productosIronMan, cancionesIronMan);
		
		addPelicula(f1);
		addPelicula(f2);
	
	
	}
	
	
	
	@Override
	public Collection<Pelicula> getAllPeliculas() {
		return peliculasMap.values();
	}

	@Override
	public Pelicula getPeliculaById(String id) {
		
		return peliculasMap.get(id);
	}

	@Override
	public Collection<Pelicula> getPeliculasByTitle(String title) {
		Collection<Pelicula> res = new HashSet<>();
		for (Pelicula p : getAllPeliculas()) {
			if (p.getTitle().equals(title)) {
				res.add(p);
			}
		}
		return res;
	}

	@Override
	public void addPelicula(Pelicula pelicula) {
		System.out.println(pelicula.getId());
		System.out.println(pelicula.getTitle());
		peliculasMap.put(pelicula.getId(), pelicula);
		System.out.println(peliculasMap.get(pelicula.getId()));

	}

	@Override
	public void updatePelicula(Pelicula pelicula) {
		if (getAllPeliculas().contains(pelicula)) {
			peliculasMap.put(pelicula.getId(), pelicula);
		}

	}

	@Override
	public void deletePelicula(String id) {
		peliculasMap.remove(id);

	}

	@Override
	public void addVideoPelicula(String idPelicula, Video video) {
		String idVideo = "v" + index++;
		video.setId(idVideo);
		getPeliculaById(idPelicula).addVideo(video);
	}


	@Override
	public void updateVideoPelicula(String idPelicula, Video video) {
		getPeliculaById(idPelicula).updateVideo(video);

	}

	@Override
	public void deleteVideoAnime(String idPelicula, String idVideo) {
		getPeliculaById(idPelicula).deleteVideo(getVideoById(idVideo));

	}

	@Override
	public void addProductoPelicula(String idPelicula, Producto producto) {
		String idProducto = "p" + index++;
		producto.setId(idProducto);
		getPeliculaById(idPelicula).addProducto(producto);

	}

	@Override
	public void updateProductoPelicula(String idPelicula, Producto producto) {
		getPeliculaById(idPelicula).updateProducto(producto);
	}

	@Override
	public void deleteProductoPelicula(String idPelicula, String idProducto) {
		getPeliculaById(idPelicula).deleteProducto(getProductoById(idProducto));

	}
    @Override
    public void addCancionPelicula(String idPelicula,Cancion cancion) {
    	String idCancion="c"+index++;
    	cancion.setId(idCancion);
    	getPeliculaById(idPelicula).addCancion(cancion);
    }
    @Override
    public void updateCancionPelicula(String idPelicula,Cancion cancion) {
    	getPeliculaById(idPelicula).updateCancion(cancion);
    }
    @Override
    public void deleteCancionPelicula(String idPelicula, String idCancion) {
    	getPeliculaById(idPelicula).deleteCancion(getCancionById(idCancion));
    }

	@Override
	public Collection<Video> getAllPeliculaVideos() {
		Collection<Video> videos = new HashSet<>();
		for (Pelicula p : getAllPeliculas()) {
			videos.addAll(p.getVideos());
		}
		return videos;
	}

	@Override
	public Collection<Video> getPeliculaVideosById(String idPelicula) {
		return getPeliculaById(idPelicula).getVideos();
	}

	@Override
	public Collection<Video> getPeliculaVideosByName(String title) {
		Collection<Video> res = new HashSet<>();
		for (Pelicula p : getPeliculasByTitle(title)) {
			res.addAll(p.getVideos());
		}
		return res;
	}

	@Override
	public Video getVideoById(String id) {
		Video res = null;
		for (Video i : getAllPeliculaVideos()) {
			if (i.getId().equals(id)) {
				res = i;
				break;
			}
		}
		return res;
	}

	@Override
	public Collection<Producto> getAllPeliculasProductos() {
		Collection<Producto> productos = new HashSet<>();
		for (Pelicula p : getAllPeliculas()) {
			productos.addAll(p.getProductos());
		}
		return productos;
	}

	@Override
	public Collection<Producto> getPeliculaProductosById(String idPelicula) {
		return getPeliculaById(idPelicula).getProductos();
	}

	@Override
	public Collection<Producto> getPeliculaProductosByName(String title) {
		Collection<Producto> res = new HashSet<>();
		for (Pelicula p : getPeliculasByTitle(title)) {
			res.addAll(p.getProductos());
		}
		return res;
	}

	@Override
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
	@Override
	public Collection<Cancion> getAllPeliculasCanciones(){
		Collection<Cancion> canciones=new HashSet<>();
		for(Pelicula p :getAllPeliculas()) {
			canciones.addAll(p.getCanciones());
		}
		return canciones;
	}
	@Override
	public Collection<Cancion>getPeliculasCancionesById(String idPelicula){
		return getPeliculaById(idPelicula).getCanciones();
	}

	@Override
	public Collection<Cancion> getPeliculasCancionesByName(String title) {
		Collection<Cancion> res = new HashSet<>();
		for (Pelicula p : getPeliculasByTitle(title)) {
			res.addAll(p.getCanciones());
		}
		return res;
	}
	@Override
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

