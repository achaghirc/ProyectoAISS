
package aiss.SoundCloud;

import java.util.HashMap;
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
    "commentable",
    "state",
    "original_content_size",
    "sharing",
    "tag_list",
    "permalink",
    "streamable",
    "embeddable_by",
    "downloadable",
    "purchase_url",
    "label_id",
    "purchase_title",
    "genre",
    "title",
    "description",
    "label_name",
    "release",
    "track_type",
    "key_signature",
    "isrc",
    "video_url",
    "bpm",
    "release_year",
    "release_month",
    "release_day",
    "original_format",
    "license",
    "uri",
    "user",
    "permalink_url",
    "artwork_url",
    "waveform_url",
    "stream_url",
    "playback_count",
    "download_count",
    "favoritings_count",
    "comment_count",
    "attachments_uri",
    "download_url"
})
public class Track {

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
    @JsonProperty("commentable")
    private Boolean commentable;
    @JsonProperty("state")
    private String state;
    @JsonProperty("original_content_size")
    private Integer originalContentSize;
    @JsonProperty("sharing")
    private String sharing;
    @JsonProperty("tag_list")
    private String tagList;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("streamable")
    private Boolean streamable;
    @JsonProperty("embeddable_by")
    private String embeddableBy;
    @JsonProperty("downloadable")
    private Boolean downloadable;
    @JsonProperty("purchase_url")
    private Object purchaseUrl;
    @JsonProperty("label_id")
    private Object labelId;
    @JsonProperty("purchase_title")
    private Object purchaseTitle;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("label_name")
    private String labelName;
    @JsonProperty("release")
    private String release;
    @JsonProperty("track_type")
    private String trackType;
    @JsonProperty("key_signature")
    private String keySignature;
    @JsonProperty("isrc")
    private String isrc;
    @JsonProperty("video_url")
    private Object videoUrl;
    @JsonProperty("bpm")
    private Object bpm;
    @JsonProperty("release_year")
    private Object releaseYear;
    @JsonProperty("release_month")
    private Object releaseMonth;
    @JsonProperty("release_day")
    private Object releaseDay;
    @JsonProperty("original_format")
    private String originalFormat;
    @JsonProperty("license")
    private String license;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("user")
    private User_ user;
    @JsonProperty("permalink_url")
    private String permalinkUrl;
    @JsonProperty("artwork_url")
    private String artworkUrl;
    @JsonProperty("waveform_url")
    private String waveformUrl;
    @JsonProperty("stream_url")
    private String streamUrl;
    @JsonProperty("playback_count")
    private Integer playbackCount;
    @JsonProperty("download_count")
    private Integer downloadCount;
    @JsonProperty("favoritings_count")
    private Integer favoritingsCount;
    @JsonProperty("comment_count")
    private Integer commentCount;
    @JsonProperty("attachments_uri")
    private String attachmentsUri;
    @JsonProperty("download_url")
    private String downloadUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Track() {
    }

    /**
     * 
     * @param genre
     * @param playbackCount
     * @param isrc
     * @param favoritingsCount
     * @param purchaseUrl
     * @param state
     * @param downloadUrl
     * @param kind
     * @param downloadable
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
     * @param trackType
     * @param streamUrl
     * @param license
     * @param commentable
     * @param waveformUrl
     * @param originalContentSize
     * @param attachmentsUri
     * @param artworkUrl
     * @param downloadCount
     * @param videoUrl
     * @param keySignature
     * @param commentCount
     * @param uri
     * @param bpm
     * @param duration
     * @param originalFormat
     * @param releaseMonth
     * @param permalink
     * @param releaseDay
     * @param tagList
     * @param embeddableBy
     * @param labelName
     * @param user
     * @param release
     */
    
    
    public Track(String kind, Integer id, String createdAt, Integer userId, Integer duration, Boolean commentable, String state, Integer originalContentSize, String sharing, String tagList, String permalink, Boolean streamable, String embeddableBy, Boolean downloadable, Object purchaseUrl, Object labelId, Object purchaseTitle, String genre, String title, String description, String labelName, String release, String trackType, String keySignature, String isrc, Object videoUrl, Object bpm, Object releaseYear, Object releaseMonth, Object releaseDay, String originalFormat, String license, String uri, User_ user, String permalinkUrl, String artworkUrl, String waveformUrl, String streamUrl, Integer playbackCount, Integer downloadCount, Integer favoritingsCount, Integer commentCount, String attachmentsUri, String downloadUrl) {
        super();
        this.kind = kind;
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.duration = duration;
        this.commentable = commentable;
        this.state = state;
        this.originalContentSize = originalContentSize;
        this.sharing = sharing;
        this.tagList = tagList;
        this.permalink = permalink;
        this.streamable = streamable;
        this.embeddableBy = embeddableBy;
        this.downloadable = downloadable;
        this.purchaseUrl = purchaseUrl;
        this.labelId = labelId;
        this.purchaseTitle = purchaseTitle;
        this.genre = genre;
        this.title = title;
        this.description = description;
        this.labelName = labelName;
        this.release = release;
        this.trackType = trackType;
        this.keySignature = keySignature;
        this.isrc = isrc;
        this.videoUrl = videoUrl;
        this.bpm = bpm;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDay = releaseDay;
        this.originalFormat = originalFormat;
        this.license = license;
        this.uri = uri;
        this.user = user;
        this.permalinkUrl = permalinkUrl;
        this.artworkUrl = artworkUrl;
        this.waveformUrl = waveformUrl;
        this.streamUrl = streamUrl;
        this.playbackCount = playbackCount;
        this.downloadCount = downloadCount;
        this.favoritingsCount = favoritingsCount;
        this.commentCount = commentCount;
        this.attachmentsUri = attachmentsUri;
        this.downloadUrl = downloadUrl;
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

    @JsonProperty("commentable")
    public Boolean getCommentable() {
        return commentable;
    }

    @JsonProperty("commentable")
    public void setCommentable(Boolean commentable) {
        this.commentable = commentable;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("original_content_size")
    public Integer getOriginalContentSize() {
        return originalContentSize;
    }

    @JsonProperty("original_content_size")
    public void setOriginalContentSize(Integer originalContentSize) {
        this.originalContentSize = originalContentSize;
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

    @JsonProperty("streamable")
    public Boolean getStreamable() {
        return streamable;
    }

    @JsonProperty("streamable")
    public void setStreamable(Boolean streamable) {
        this.streamable = streamable;
    }

    @JsonProperty("embeddable_by")
    public String getEmbeddableBy() {
        return embeddableBy;
    }

    @JsonProperty("embeddable_by")
    public void setEmbeddableBy(String embeddableBy) {
        this.embeddableBy = embeddableBy;
    }

    @JsonProperty("downloadable")
    public Boolean getDownloadable() {
        return downloadable;
    }

    @JsonProperty("downloadable")
    public void setDownloadable(Boolean downloadable) {
        this.downloadable = downloadable;
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

    @JsonProperty("purchase_title")
    public Object getPurchaseTitle() {
        return purchaseTitle;
    }

    @JsonProperty("purchase_title")
    public void setPurchaseTitle(Object purchaseTitle) {
        this.purchaseTitle = purchaseTitle;
    }

    @JsonProperty("genre")
    public String getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("label_name")
    public String getLabelName() {
        return labelName;
    }

    @JsonProperty("label_name")
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    @JsonProperty("release")
    public String getRelease() {
        return release;
    }

    @JsonProperty("release")
    public void setRelease(String release) {
        this.release = release;
    }

    @JsonProperty("track_type")
    public String getTrackType() {
        return trackType;
    }

    @JsonProperty("track_type")
    public void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    @JsonProperty("key_signature")
    public String getKeySignature() {
        return keySignature;
    }

    @JsonProperty("key_signature")
    public void setKeySignature(String keySignature) {
        this.keySignature = keySignature;
    }

    @JsonProperty("isrc")
    public String getIsrc() {
        return isrc;
    }

    @JsonProperty("isrc")
    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    @JsonProperty("video_url")
    public Object getVideoUrl() {
        return videoUrl;
    }

    @JsonProperty("video_url")
    public void setVideoUrl(Object videoUrl) {
        this.videoUrl = videoUrl;
    }

    @JsonProperty("bpm")
    public Object getBpm() {
        return bpm;
    }

    @JsonProperty("bpm")
    public void setBpm(Object bpm) {
        this.bpm = bpm;
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

    @JsonProperty("original_format")
    public String getOriginalFormat() {
        return originalFormat;
    }

    @JsonProperty("original_format")
    public void setOriginalFormat(String originalFormat) {
        this.originalFormat = originalFormat;
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

    @JsonProperty("user")
    public User_ getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User_ user) {
        this.user = user;
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

    @JsonProperty("waveform_url")
    public String getWaveformUrl() {
        return waveformUrl;
    }

    @JsonProperty("waveform_url")
    public void setWaveformUrl(String waveformUrl) {
        this.waveformUrl = waveformUrl;
    }

    @JsonProperty("stream_url")
    public String getStreamUrl() {
        return streamUrl;
    }

    @JsonProperty("stream_url")
    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    @JsonProperty("playback_count")
    public Integer getPlaybackCount() {
        return playbackCount;
    }

    @JsonProperty("playback_count")
    public void setPlaybackCount(Integer playbackCount) {
        this.playbackCount = playbackCount;
    }

    @JsonProperty("download_count")
    public Integer getDownloadCount() {
        return downloadCount;
    }

    @JsonProperty("download_count")
    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @JsonProperty("favoritings_count")
    public Integer getFavoritingsCount() {
        return favoritingsCount;
    }

    @JsonProperty("favoritings_count")
    public void setFavoritingsCount(Integer favoritingsCount) {
        this.favoritingsCount = favoritingsCount;
    }

    @JsonProperty("comment_count")
    public Integer getCommentCount() {
        return commentCount;
    }

    @JsonProperty("comment_count")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @JsonProperty("attachments_uri")
    public String getAttachmentsUri() {
        return attachmentsUri;
    }

    @JsonProperty("attachments_uri")
    public void setAttachmentsUri(String attachmentsUri) {
        this.attachmentsUri = attachmentsUri;
    }

    @JsonProperty("download_url")
    public String getDownloadUrl() {
        return downloadUrl;
    }

    @JsonProperty("download_url")
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
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

