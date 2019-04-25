
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
"permalink",
"username",
"uri",
"permalink_url",
"avatar_url",
"country",
"full_name",
"city",
"description",
"discogs_name",
"myspace_name",
"website",
"website_title",
"online",
"track_count",
"playlist_count",
"followers_count",
"followings_count",
"public_favorites_count",
"plan",
"private_tracks_count",
"private_playlists_count",
"primary_email_confirmed"
})
public class Me {

@JsonProperty("id")
private Integer id;
@JsonProperty("permalink")
private String permalink;
@JsonProperty("username")
private String username;
@JsonProperty("uri")
private String uri;
@JsonProperty("permalink_url")
private String permalinkUrl;
@JsonProperty("avatar_url")
private String avatarUrl;
@JsonProperty("country")
private String country;
@JsonProperty("full_name")
private String fullName;
@JsonProperty("city")
private String city;
@JsonProperty("description")
private String description;
@JsonProperty("discogs_name")
private Object discogsName;
@JsonProperty("myspace_name")
private Object myspaceName;
@JsonProperty("website")
private String website;
@JsonProperty("website_title")
private String websiteTitle;
@JsonProperty("online")
private Boolean online;
@JsonProperty("track_count")
private Integer trackCount;
@JsonProperty("playlist_count")
private Integer playlistCount;
@JsonProperty("followers_count")
private Integer followersCount;
@JsonProperty("followings_count")
private Integer followingsCount;
@JsonProperty("public_favorites_count")
private Integer publicFavoritesCount;
@JsonProperty("plan")
private String plan;
@JsonProperty("private_tracks_count")
private Integer privateTracksCount;
@JsonProperty("private_playlists_count")
private Integer privatePlaylistsCount;
@JsonProperty("primary_email_confirmed")
private Boolean primaryEmailConfirmed;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Me() {
}

/**
* 
* @param websiteTitle
* @param primaryEmailConfirmed
* @param publicFavoritesCount
* @param followingsCount
* @param playlistCount
* @param website
* @param privatePlaylistsCount
* @param uri
* @param privateTracksCount
* @param online
* @param country
* @param city
* @param id
* @param username
* @param discogsName
* @param permalinkUrl
* @param plan
* @param permalink
* @param description
* @param avatarUrl
* @param followersCount
* @param fullName
* @param trackCount
* @param myspaceName
*/
public Me(Integer id, String permalink, String username, String uri, String permalinkUrl, String avatarUrl, String country, String fullName, String city, String description, Object discogsName, Object myspaceName, String website, String websiteTitle, Boolean online, Integer trackCount, Integer playlistCount, Integer followersCount, Integer followingsCount, Integer publicFavoritesCount, String plan, Integer privateTracksCount, Integer privatePlaylistsCount, Boolean primaryEmailConfirmed) {
super();
this.id = id;
this.permalink = permalink;
this.username = username;
this.uri = uri;
this.permalinkUrl = permalinkUrl;
this.avatarUrl = avatarUrl;
this.country = country;
this.fullName = fullName;
this.city = city;
this.description = description;
this.discogsName = discogsName;
this.myspaceName = myspaceName;
this.website = website;
this.websiteTitle = websiteTitle;
this.online = online;
this.trackCount = trackCount;
this.playlistCount = playlistCount;
this.followersCount = followersCount;
this.followingsCount = followingsCount;
this.publicFavoritesCount = publicFavoritesCount;
this.plan = plan;
this.privateTracksCount = privateTracksCount;
this.privatePlaylistsCount = privatePlaylistsCount;
this.primaryEmailConfirmed = primaryEmailConfirmed;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("permalink")
public String getPermalink() {
return permalink;
}

@JsonProperty("permalink")
public void setPermalink(String permalink) {
this.permalink = permalink;
}

@JsonProperty("username")
public String getUsername() {
return username;
}

@JsonProperty("username")
public void setUsername(String username) {
this.username = username;
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

@JsonProperty("avatar_url")
public String getAvatarUrl() {
return avatarUrl;
}

@JsonProperty("avatar_url")
public void setAvatarUrl(String avatarUrl) {
this.avatarUrl = avatarUrl;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("full_name")
public String getFullName() {
return fullName;
}

@JsonProperty("full_name")
public void setFullName(String fullName) {
this.fullName = fullName;
}

@JsonProperty("city")
public String getCity() {
return city;
}

@JsonProperty("city")
public void setCity(String city) {
this.city = city;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("discogs_name")
public Object getDiscogsName() {
return discogsName;
}

@JsonProperty("discogs_name")
public void setDiscogsName(Object discogsName) {
this.discogsName = discogsName;
}

@JsonProperty("myspace_name")
public Object getMyspaceName() {
return myspaceName;
}

@JsonProperty("myspace_name")
public void setMyspaceName(Object myspaceName) {
this.myspaceName = myspaceName;
}

@JsonProperty("website")
public String getWebsite() {
return website;
}

@JsonProperty("website")
public void setWebsite(String website) {
this.website = website;
}

@JsonProperty("website_title")
public String getWebsiteTitle() {
return websiteTitle;
}

@JsonProperty("website_title")
public void setWebsiteTitle(String websiteTitle) {
this.websiteTitle = websiteTitle;
}

@JsonProperty("online")
public Boolean getOnline() {
return online;
}

@JsonProperty("online")
public void setOnline(Boolean online) {
this.online = online;
}

@JsonProperty("track_count")
public Integer getTrackCount() {
return trackCount;
}

@JsonProperty("track_count")
public void setTrackCount(Integer trackCount) {
this.trackCount = trackCount;
}

@JsonProperty("playlist_count")
public Integer getPlaylistCount() {
return playlistCount;
}

@JsonProperty("playlist_count")
public void setPlaylistCount(Integer playlistCount) {
this.playlistCount = playlistCount;
}

@JsonProperty("followers_count")
public Integer getFollowersCount() {
return followersCount;
}

@JsonProperty("followers_count")
public void setFollowersCount(Integer followersCount) {
this.followersCount = followersCount;
}

@JsonProperty("followings_count")
public Integer getFollowingsCount() {
return followingsCount;
}

@JsonProperty("followings_count")
public void setFollowingsCount(Integer followingsCount) {
this.followingsCount = followingsCount;
}

@JsonProperty("public_favorites_count")
public Integer getPublicFavoritesCount() {
return publicFavoritesCount;
}

@JsonProperty("public_favorites_count")
public void setPublicFavoritesCount(Integer publicFavoritesCount) {
this.publicFavoritesCount = publicFavoritesCount;
}

@JsonProperty("plan")
public String getPlan() {
return plan;
}

@JsonProperty("plan")
public void setPlan(String plan) {
this.plan = plan;
}

@JsonProperty("private_tracks_count")
public Integer getPrivateTracksCount() {
return privateTracksCount;
}

@JsonProperty("private_tracks_count")
public void setPrivateTracksCount(Integer privateTracksCount) {
this.privateTracksCount = privateTracksCount;
}

@JsonProperty("private_playlists_count")
public Integer getPrivatePlaylistsCount() {
return privatePlaylistsCount;
}

@JsonProperty("private_playlists_count")
public void setPrivatePlaylistsCount(Integer privatePlaylistsCount) {
this.privatePlaylistsCount = privatePlaylistsCount;
}

@JsonProperty("primary_email_confirmed")
public Boolean getPrimaryEmailConfirmed() {
return primaryEmailConfirmed;
}

@JsonProperty("primary_email_confirmed")
public void setPrimaryEmailConfirmed(Boolean primaryEmailConfirmed) {
this.primaryEmailConfirmed = primaryEmailConfirmed;
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
