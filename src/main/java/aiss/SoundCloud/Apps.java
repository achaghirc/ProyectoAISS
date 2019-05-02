
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
"kind",
"name",
"uri",
"permalink_url",
"external_url",
"creator"
})
public class Apps {

@JsonProperty("id")
private Integer id;
@JsonProperty("kind")
private String kind;
@JsonProperty("name")
private String name;
@JsonProperty("uri")
private String uri;
@JsonProperty("permalink_url")
private String permalinkUrl;
@JsonProperty("external_url")
private String externalUrl;
@JsonProperty("creator")
private String creator;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Apps() {
}

/**
* 
* @param id
* @param permalinkUrl
* @param name
* @param externalUrl
* @param uri
* @param kind
* @param creator
*/
public Apps(Integer id, String kind, String name, String uri, String permalinkUrl, String externalUrl, String creator) {
super();
this.id = id;
this.kind = kind;
this.name = name;
this.uri = uri;
this.permalinkUrl = permalinkUrl;
this.externalUrl = externalUrl;
this.creator = creator;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("kind")
public String getKind() {
return kind;
}

@JsonProperty("kind")
public void setKind(String kind) {
this.kind = kind;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
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

@JsonProperty("external_url")
public String getExternalUrl() {
return externalUrl;
}

@JsonProperty("external_url")
public void setExternalUrl(String externalUrl) {
this.externalUrl = externalUrl;
}

@JsonProperty("creator")
public String getCreator() {
return creator;
}

@JsonProperty("creator")
public void setCreator(String creator) {
this.creator = creator;
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
