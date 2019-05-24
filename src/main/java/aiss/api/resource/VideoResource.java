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

import aiss.api.classes.Pelicula;
import aiss.api.classes.Video;
import aiss.model.repository.WikifilmRepository;
import aiss.model.repository.WikifilmRepositoryImpl;

@Path("/Videos")
public class VideoResource extends PeliculasResource {

	private int index = 0;
	public static VideoResource instance = null;
	
	WikifilmRepository repository;
	
	public VideoResource() {
		repository = WikifilmRepositoryImpl.getInstance();
	}
	
	public static VideoResource getInstance() {
		if (instance == null) {
			instance = new VideoResource();
		}
		return instance;
	}

	// Video
	
	//No usar en swagger
	@GET
	@Produces("application/json")
	public Collection<Video> getAllPeliculaVideos() {
		Collection<Video> videos = new HashSet<>();
		for (Pelicula p : getAllPeliculas()) {
			videos.addAll(p.getVideos());
		}
		return videos;
	}

	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/idPelicula/{idPelicula}")
	public void addVideoPelicula(@PathParam("idPelicula") String idPelicula, Video video) {
		String idVideo = "v" + index++;
		video.setId(idVideo);
		getPeliculaById(idPelicula).addVideo(video);
	}

	
	//No
	@PUT
	@Consumes("application/json")
	public void updateVideoPelicula(@PathParam("idPelicula") String idPelicula, Video video) {
		getPeliculaById(idPelicula).updateVideo(video);

	}

	@DELETE
	@Path("/idPelicula/{idPelicula}/idVideo/{idVideo}")
	public void deleteVideo(@PathParam("idPelicula")String idPelicula,@PathParam("idVideo") String idVideo) {
		getPeliculaById(idPelicula).deleteVideo(getVideoById(idVideo));

	}

//	@GET
//	@Produces("application/json")
//	public Collection<Video> getPeliculaVideosById(@PathParam("idPelicula") String idPelicula) {
//		return getPeliculaById(idPelicula).getVideos();
//	}

	@GET
	@Produces("application/json")
	@Path("/tituloPelicula/{titlePelicula}")
	public Collection<Video> getPeliculaVideosByName(@PathParam("titlePelicula")String title) {
		Collection<Video> res = new HashSet<>();
		for (Pelicula p : getPeliculasByTitle(title)) {
			res.addAll(p.getVideos());
		}
		return res;
	}

	@GET
	@Produces("application/json")
	@Path("/idVideo/{idVideo}")
	public Video getVideoById(@PathParam("idVideo")String id) {
		Video res = null;
		for (Video i : getAllPeliculaVideos()) {
			if (i.getId().equals(id)) {
				res = i;
				break;
			}
		}
		return res;
	}

}
