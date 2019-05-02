package aiss.model.tmdb;

public class Cancion {

	private String uri;
	private String name;
	private String id;
	private Integer duration;
	private Integer popularity;
	
	public Cancion() {
		
	}

	public Cancion(String uri, String name, String id, Integer duration, Integer popularity) {
		this.uri = uri;
		this.name = name;
		this.id = id;
		this.duration = duration;
		this.popularity = popularity;
	}

	public Cancion(String uri, String name, Integer duration, Integer popularity) {
		this.uri = uri;
		this.name = name;
		this.duration = duration;
		this.popularity = popularity;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}
	
}
