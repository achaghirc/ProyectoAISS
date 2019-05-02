
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
    "id",
    "created_at",
    "user_id",
    "duration",
    "commentable",
    "state",
    "sharing",
    "tag_list",
    "permalink",
    "description",
    "streamable",
    "downloadable",
    "genre",
    "release",
    "purchase_url",
    "label_id",
    "label_name",
    "isrc",
    "video_url",
    "track_type",
    "key_signature",
    "bpm",
    "title",
    "release_year",
    "release_month",
    "release_day",
    "original_format",
    "original_content_size",
    "license",
    "uri",
    "permalink_url",
    "artwork_url",
    "waveform_url",
    "user",
    "stream_url",
    "download_url",
    "playback_count",
    "download_count",
    "favoritings_count",
    "comment_count",
    "attachments_uri"
})
public class Users {

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
    @JsonProperty("sharing")
    private String sharing;
    @JsonProperty("tag_list")
    private String tagList;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("streamable")
    private Boolean streamable;
    @JsonProperty("downloadable")
    private Boolean downloadable;
    @JsonProperty("genre")
    private Object genre;
    @JsonProperty("release")
    private Object release;
    @JsonProperty("purchase_url")
    private Object purchaseUrl;
    @JsonProperty("label_id")
    private Object labelId;
    @JsonProperty("label_name")
    private Object labelName;
    @JsonProperty("isrc")
    private Object isrc;
    @JsonProperty("video_url")
    private Object videoUrl;
    @JsonProperty("track_type")
    private String trackType;
    @JsonProperty("key_signature")
    private Object keySignature;
    @JsonProperty("bpm")
    private Object bpm;
    @JsonProperty("title")
    private String title;
    @JsonProperty("release_year")
    private Object releaseYear;
    @JsonProperty("release_month")
    private Object releaseMonth;
    @JsonProperty("release_day")
    private Object releaseDay;
    @JsonProperty("original_format")
    private String originalFormat;
    @JsonProperty("original_content_size")
    private Integer originalContentSize;
    @JsonProperty("license")
    private String license;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("permalink_url")
    private String permalinkUrl;
    @JsonProperty("artwork_url")
    private Object artworkUrl;
    @JsonProperty("waveform_url")
    private String waveformUrl;
    @JsonProperty("user")
    private User user;
    @JsonProperty("stream_url")
    private String streamUrl;
    @JsonProperty("download_url")
    private String downloadUrl;
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
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Users() {
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
     * @param downloadable
     * @param labelId
     * @param releaseYear
     * @param id
     * @param title
     * @param permalinkUrl
     * @param sharing
     * @param description
     * @param createdAt
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
     * @param labelName
     * @param user
     * @param release
     */
    public Users(Integer id, String createdAt, Integer userId, Integer duration, Boolean commentable, String state, String sharing, String tagList, String permalink, Object description, Boolean streamable, Boolean downloadable, Object genre, Object release, Object purchaseUrl, Object labelId, Object labelName, Object isrc, Object videoUrl, String trackType, Object keySignature, Object bpm, String title, Object releaseYear, Object releaseMonth, Object releaseDay, String originalFormat, Integer originalContentSize, String license, String uri, String permalinkUrl, Object artworkUrl, String waveformUrl, User user, String streamUrl, String downloadUrl, Integer playbackCount, Integer downloadCount, Integer favoritingsCount, Integer commentCount, String attachmentsUri) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.duration = duration;
        this.commentable = commentable;
        this.state = state;
        this.sharing = sharing;
        this.tagList = tagList;
        this.permalink = permalink;
        this.description = description;
        this.streamable = streamable;
        this.downloadable = downloadable;
        this.genre = genre;
        this.release = release;
        this.purchaseUrl = purchaseUrl;
        this.labelId = labelId;
        this.labelName = labelName;
        this.isrc = isrc;
        this.videoUrl = videoUrl;
        this.trackType = trackType;
        this.keySignature = keySignature;
        this.bpm = bpm;
        this.title = title;
        this.releaseYear = releaseYear;
        this.releaseMonth = releaseMonth;
        this.releaseDay = releaseDay;
        this.originalFormat = originalFormat;
        this.originalContentSize = originalContentSize;
        this.license = license;
        this.uri = uri;
        this.permalinkUrl = permalinkUrl;
        this.artworkUrl = artworkUrl;
        this.waveformUrl = waveformUrl;
        this.user = user;
        this.streamUrl = streamUrl;
        this.downloadUrl = downloadUrl;
        this.playbackCount = playbackCount;
        this.downloadCount = downloadCount;
        this.favoritingsCount = favoritingsCount;
        this.commentCount = commentCount;
        this.attachmentsUri = attachmentsUri;
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

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
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

    @JsonProperty("genre")
    public Object getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(Object genre) {
        this.genre = genre;
    }

    @JsonProperty("release")
    public Object getRelease() {
        return release;
    }

    @JsonProperty("release")
    public void setRelease(Object release) {
        this.release = release;
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

    @JsonProperty("label_name")
    public Object getLabelName() {
        return labelName;
    }

    @JsonProperty("label_name")
    public void setLabelName(Object labelName) {
        this.labelName = labelName;
    }

    @JsonProperty("isrc")
    public Object getIsrc() {
        return isrc;
    }

    @JsonProperty("isrc")
    public void setIsrc(Object isrc) {
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

    @JsonProperty("track_type")
    public String getTrackType() {
        return trackType;
    }

    @JsonProperty("track_type")
    public void setTrackType(String trackType) {
        this.trackType = trackType;
    }

    @JsonProperty("key_signature")
    public Object getKeySignature() {
        return keySignature;
    }

    @JsonProperty("key_signature")
    public void setKeySignature(Object keySignature) {
        this.keySignature = keySignature;
    }

    @JsonProperty("bpm")
    public Object getBpm() {
        return bpm;
    }

    @JsonProperty("bpm")
    public void setBpm(Object bpm) {
        this.bpm = bpm;
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

    @JsonProperty("original_format")
    public String getOriginalFormat() {
        return originalFormat;
    }

    @JsonProperty("original_format")
    public void setOriginalFormat(String originalFormat) {
        this.originalFormat = originalFormat;
    }

    @JsonProperty("original_content_size")
    public Integer getOriginalContentSize() {
        return originalContentSize;
    }

    @JsonProperty("original_content_size")
    public void setOriginalContentSize(Integer originalContentSize) {
        this.originalContentSize = originalContentSize;
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
    public Object getArtworkUrl() {
        return artworkUrl;
    }

    @JsonProperty("artwork_url")
    public void setArtworkUrl(Object artworkUrl) {
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

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("stream_url")
    public String getStreamUrl() {
        return streamUrl;
    }

    @JsonProperty("stream_url")
    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    @JsonProperty("download_url")
    public String getDownloadUrl() {
        return downloadUrl;
    }

    @JsonProperty("download_url")
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

