
package aiss.SoundCloud;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "id",
    "created_at",
    "user_id",
    "duration",
    "sharing",
    "tag_list",
    "permalink",
    "track_count",
    "streamable",
    "downloadable",
    "embeddable_by",
    "purchase_url",
    "label_id",
    "type",
    "playlist_type",
    "ean",
    "description",
    "genre",
    "release",
    "purchase_title",
    "label_name",
    "title",
    "release_year",
    "release_month",
    "release_day",
    "license",
    "uri",
    "permalink_url",
    "artwork_url",
    "user",
    "tracks"
})
public class Playlists {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("duration")
    private Integer duration;
    @JsonProperty("sharing")
    private String sharing;
    @JsonProperty("tag_list")
    private String tagList;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("track_count")
    private Integer trackCount;
    @JsonProperty("streamable")
    private Boolean streamable;
    @JsonProperty("downloadable")
    private Boolean downloadable;
    @JsonProperty("embeddable_by")
    private String embeddableBy;
    @JsonProperty("purchase_url")
    private Object purchaseUrl;
    @JsonProperty("label_id")
    private Object labelId;
    @JsonProperty("type")
    private String type;
    @JsonProperty("playlist_type")
    private String playlistType;
    @JsonProperty("ean")
    private String ean;
    @JsonProperty("description")
    private String description;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("release")
    private String release;
    @JsonProperty("purchase_title")
    private Object purchaseTitle;
    @JsonProperty("label_name")
    private String labelName;
    @JsonProperty("title")
    private String title;
    @JsonProperty("release_year")
    private Object releaseYear;
    @JsonProperty("release_month")
    private Object releaseMonth;
    @JsonProperty("release_day")
    private Object releaseDay;
    @JsonProperty("license")
    private String license;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("permalink_url")
    private String permalinkUrl;
    @JsonProperty("artwork_url")
    private String artworkUrl;
    @JsonProperty("user")
    private User user;
    @JsonProperty("tracks")
    private List<Track> tracks = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Playlists() {
    }

    /**
     * 
     * @param genre
     * @param purchaseUrl
     * @param type
     * @param downloadable
     * @param kind
     * @param labelId
     * @param releaseYear
     * @param id
     * @param title
     * @param permalinkUrl
     * @param sharing
     * @param purchaseTitle
     * @param createdAt
     * @param description
     * @param userId
     * @param streamable
     * @param license
     * @param trackCount
     * @param artworkUrl
     * @param playlistType
     * @param tracks
     * @param uri
     * @param ean
     * @param duration
     * @param releaseMonth
     * @param permalink
     * @param releaseDay
     * @param embeddableBy
     * @param tagList
     * @param labelName
     * @param user
     * @param release
     */
    public Playlists(String kind, Integer id, String createdAt, Integer userId, Integer duration, String sharing, String tagList, String permalink, Integer trackCount, Boolean streamable, Boolean downloadable, String embeddableBy, Object purchaseUrl, Object labelId, String type, String playlistType, String ean, String description, String genre, String release, Object purchaseTitle, String labelName, String title, Object releaseYear, Object releaseMonth, Object releaseDay, String license, String uri, String permalinkUrl, String artworkUrl, User user, List<Track> tracks) {
        super();
        this.kind = kind;
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.duration = duration;
        this.sharing = sharing;
        this.tagList = tagList;
        this.permalink = permalink;
        this.trackCount = trackCount;
        this.streamable = streamable;
        this.downloadable = downloadable;
        this.embeddableBy = embeddableBy;
        this.purchaseUrl = purchaseUrl;
        this.labelId = labelId;
        this.type = type;
        this.playlistType = playlistType;
        this.ean = ean;
        this.description = description;
        this.genre = genre;
        this.release = release;
        this.purchaseTitle = purchaseTitle;
        this.labelName = labelName;
        this.title = title;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDay = releaseDay;
        this.license = license;
        this.uri = uri;
        this.permalinkUrl = permalinkUrl;
        this.artworkUrl = artworkUrl;
        this.user = user;
        this.tracks = tracks;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("duration")
    public Integer getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @JsonProperty("sharing")
    public String getSharing() {
        return sharing;
    }

    @JsonProperty("sharing")
    public void setSharing(String sharing) {
        this.sharing = sharing;
    }

    @JsonProperty("tag_list")
    public String getTagList() {
        return tagList;
    }

    @JsonProperty("tag_list")
    public void setTagList(String tagList) {
        this.tagList = tagList;
    }

    @JsonProperty("permalink")
    public String getPermalink() {
        return permalink;
    }

    @JsonProperty("permalink")
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    @JsonProperty("track_count")
    public Integer getTrackCount() {
        return trackCount;
    }

    @JsonProperty("track_count")
    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    @JsonProperty("streamable")
    public Boolean getStreamable() {
        return streamable;
    }

    @JsonProperty("streamable")
    public void setStreamable(Boolean streamable) {
        this.streamable = streamable;
    }

    @JsonProperty("downloadable")
    public Boolean getDownloadable() {
        return downloadable;
    }

    @JsonProperty("downloadable")
    public void setDownloadable(Boolean downloadable) {
        this.downloadable = downloadable;
    }

    @JsonProperty("embeddable_by")
    public String getEmbeddableBy() {
        return embeddableBy;
    }

    @JsonProperty("embeddable_by")
    public void setEmbeddableBy(String embeddableBy) {
        this.embeddableBy = embeddableBy;
    }

    @JsonProperty("purchase_url")
    public Object getPurchaseUrl() {
        return purchaseUrl;
    }

    @JsonProperty("purchase_url")
    public void setPurchaseUrl(Object purchaseUrl) {
        this.purchaseUrl = purchaseUrl;
    }

    @JsonProperty("label_id")
    public Object getLabelId() {
        return labelId;
    }

    @JsonProperty("label_id")
    public void setLabelId(Object labelId) {
        this.labelId = labelId;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("playlist_type")
    public String getPlaylistType() {
        return playlistType;
    }

    @JsonProperty("playlist_type")
    public void setPlaylistType(String playlistType) {
        this.playlistType = playlistType;
    }

    @JsonProperty("ean")
    public String getEan() {
        return ean;
    }

    @JsonProperty("ean")
    public void setEan(String ean) {
        this.ean = ean;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonProperty("release")
    public String getRelease() {
        return release;
    }

    @JsonProperty("release")
    public void setRelease(String release) {
        this.release = release;
    }

    @JsonProperty("purchase_title")
    public Object getPurchaseTitle() {
        return purchaseTitle;
    }

    @JsonProperty("purchase_title")
    public void setPurchaseTitle(Object purchaseTitle) {
        this.purchaseTitle = purchaseTitle;
    }

    @JsonProperty("label_name")
    public String getLabelName() {
        return labelName;
    }

    @JsonProperty("label_name")
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("release_year")
    public Object getReleaseYear() {
        return releaseYear;
    }

    @JsonProperty("release_year")
    public void setReleaseYear(Object releaseYear) {
        this.releaseYear = releaseYear;
    }

    @JsonProperty("release_month")
    public Object getReleaseMonth() {
        return releaseMonth;
    }

    @JsonProperty("release_month")
    public void setReleaseMonth(Object releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    @JsonProperty("release_day")
    public Object getReleaseDay() {
        return releaseDay;
    }

    @JsonProperty("release_day")
    public void setReleaseDay(Object releaseDay) {
        this.releaseDay = releaseDay;
    }

    @JsonProperty("license")
    public String getLicense() {
        return license;
    }

    @JsonProperty("license")
    public void setLicense(String license) {
        this.license = license;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("permalink_url")
    public String getPermalinkUrl() {
        return permalinkUrl;
    }

    @JsonProperty("permalink_url")
    public void setPermalinkUrl(String permalinkUrl) {
        this.permalinkUrl = permalinkUrl;
    }

    @JsonProperty("artwork_url")
    public String getArtworkUrl() {
        return artworkUrl;
    }

    @JsonProperty("artwork_url")
    public void setArtworkUrl(String artworkUrl) {
        this.artworkUrl = artworkUrl;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("tracks")
    public List<Track> getTracks() {
        return tracks;
    }

    @JsonProperty("tracks")
    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
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

