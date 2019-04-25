
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
"track_id",
"timestamp",
"body",
"uri",
"user"
})
public class Comments {

@JsonProperty("id")
private Integer id;
@JsonProperty("created_at")
private String createdAt;
@JsonProperty("user_id")
private Integer userId;
@JsonProperty("track_id")
private Integer trackId;
@JsonProperty("timestamp")
private Integer timestamp;
@JsonProperty("body")
private String body;
@JsonProperty("uri")
private String uri;
@JsonProperty("user")
private User user;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Comments() {
}

/**
* 
* @param timestamp
* @param id
* @param body
* @param trackId
* @param createdAt
* @param userId
* @param user
* @param uri
*/
public Comments(Integer id, String createdAt, Integer userId, Integer trackId, Integer timestamp, String body, String uri, User user) {
super();
this.id = id;
this.createdAt = createdAt;
this.userId = userId;
this.trackId = trackId;
this.timestamp = timestamp;
this.body = body;
this.uri = uri;
this.user = user;
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

@JsonProperty("track_id")
public Integer getTrackId() {
return trackId;
}

@JsonProperty("track_id")
public void setTrackId(Integer trackId) {
this.trackId = trackId;
}

@JsonProperty("timestamp")
public Integer getTimestamp() {
return timestamp;
}

@JsonProperty("timestamp")
public void setTimestamp(Integer timestamp) {
this.timestamp = timestamp;
}

@JsonProperty("body")
public String getBody() {
return body;
}

@JsonProperty("body")
public void setBody(String body) {
this.body = body;
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
public User getUser() {
return user;
}

@JsonProperty("user")
public void setUser(User user) {
this.user = user;
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
