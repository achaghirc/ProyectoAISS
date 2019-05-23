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
import aiss.model.tmdb.Video;

@Path("/Video")
public class VideoResource extends PeliculasResource {

	private int index = 0;
	
	
	
	// Video
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
	public void addVideoPelicula(String idPelicula, Video video) {
		String idVideo = "v" + index++;
		video.setId(idVideo);
		getPeliculaById(idPelicula).addVideo(video);
	}

	@PUT
	@Consumes("application/json")
	public void updateVideoPelicula(String idPelicula, Video video) {
		getPeliculaById(idPelicula).updateVideo(video);

	}

	@DELETE
	// ??????
	public void deleteVideo(String idPelicula, String idVideo) {
		getPeliculaById(idPelicula).deleteVideo(getVideoById(idVideo));

	}

	@GET
	@Produces("application/json")
	public Collection<Video> getPeliculaVideosById(String idPelicula) {
		return getPeliculaById(idPelicula).getVideos();
	}

	@GET
	@Produces("application/json")
	public Collection<Video> getPeliculaVideosByName(String title) {
		Collection<Video> res = new HashSet<>();
		for (Pelicula p : getPeliculasByTitle(title)) {
			res.addAll(p.getVideos());
		}
		return res;
	}

	@GET
	@Produces("application/json")
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

}
