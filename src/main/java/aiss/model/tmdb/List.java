package aiss.model.tmdb;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "iso_639_1", "id", "page", "iso_3166_1", "total_results", "object_ids", "revenue", "total_pages",
		"name", "public", "comments", "sort_by", "description", "backdrop_path", "results", "average_rating", "runtime",
		"created_by", "poster_path" })
public class List {

	@JsonProperty("iso_639_1")
	private String iso6391;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("page")
	private Integer page;
	@JsonProperty("iso_3166_1")
	private String iso31661;
	@JsonProperty("total_results")
	private Integer totalResults;
	@JsonProperty("object_ids")
	private java.util.List<Object> objectIds = null;
	@JsonProperty("revenue")
	private Integer revenue;
	@JsonProperty("total_pages")
	private Integer totalPages;
	@JsonProperty("name")
	private String name;
	@JsonProperty("public")
	private Boolean _public;
	@JsonProperty("comments")
	private java.util.List<Object> comments = null;
	@JsonProperty("sort_by")
	private String sortBy;
	@JsonProperty("description")
	private String description;
	@JsonProperty("backdrop_path")
	private Object backdropPath;
	@JsonProperty("results")
	private java.util.List<Object> results = null;
	@JsonProperty("average_rating")
	private Integer averageRating;
	@JsonProperty("runtime")
	private Integer runtime;
	@JsonProperty("created_by")
	private CreatedBy createdBy;
	@JsonProperty("poster_path")
	private Object posterPath;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("iso_639_1")
	public String getIso6391() {
		return iso6391;
	}

	@JsonProperty("iso_639_1")
	public void setIso6391(String iso6391) {
		this.iso6391 = iso6391;
	}

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("page")
	public Integer getPage() {
		return page;
	}

	@JsonProperty("page")
	public void setPage(Integer page) {
		this.page = page;
	}

	@JsonProperty("iso_3166_1")
	public String getIso31661() {
		return iso31661;
	}

	@JsonProperty("iso_3166_1")
	public void setIso31661(String iso31661) {
		this.iso31661 = iso31661;
	}

	@JsonProperty("total_results")
	public Integer getTotalResults() {
		return totalResults;
	}

	@JsonProperty("total_results")
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}

	@JsonProperty("object_ids")
	public java.util.List<Object> getObjectIds() {
		return objectIds;
	}

	@JsonProperty("object_ids")
	public void setObjectIds(java.util.List<Object> objectIds) {
		this.objectIds = objectIds;
	}

	@JsonProperty("revenue")
	public Integer getRevenue() {
		return revenue;
	}

	@JsonProperty("revenue")
	public void setRevenue(Integer revenue) {
		this.revenue = revenue;
	}

	@JsonProperty("total_pages")
	public Integer getTotalPages() {
		return totalPages;
	}

	@JsonProperty("total_pages")
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("public")
	public Boolean getPublic() {
		return _public;
	}

	@JsonProperty("public")
	public void setPublic(Boolean _public) {
		this._public = _public;
	}

	@JsonProperty("comments")
	public java.util.List<Object> getComments() {
		return comments;
	}

	@JsonProperty("comments")
	public void setComments(java.util.List<Object> comments) {
		this.comments = comments;
	}

	@JsonProperty("sort_by")
	public String getSortBy() {
		return sortBy;
	}

	@JsonProperty("sort_by")
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("backdrop_path")
	public Object getBackdropPath() {
		return backdropPath;
	}

	@JsonProperty("backdrop_path")
	public void setBackdropPath(Object backdropPath) {
		this.backdropPath = backdropPath;
	}

	@JsonProperty("results")
	public java.util.List<Object> getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(java.util.List<Object> results) {
		this.results = results;
	}

	@JsonProperty("average_rating")
	public Integer getAverageRating() {
		return averageRating;
	}

	@JsonProperty("average_rating")
	public void setAverageRating(Integer averageRating) {
		this.averageRating = averageRating;
	}

	@JsonProperty("runtime")
	public Integer getRuntime() {
		return runtime;
	}

	@JsonProperty("runtime")
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	@JsonProperty("created_by")
	public CreatedBy getCreatedBy() {
		return createdBy;
	}

	@JsonProperty("created_by")
	public void setCreatedBy(CreatedBy createdBy) {
		this.createdBy = createdBy;
	}

	@JsonProperty("poster_path")
	public Object getPosterPath() {
		return posterPath;
	}

	@JsonProperty("poster_path")
	public void setPosterPath(Object posterPath) {
		this.posterPath = posterPath;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
