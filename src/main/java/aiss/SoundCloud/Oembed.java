
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
"version",
"type",
"provider_name",
"provider_url",
"height",
"width",
"title",
"description",
"html"
})
public class Oembed {

@JsonProperty("version")
private Double version;
@JsonProperty("type")
private String type;
@JsonProperty("provider_name")
private String providerName;
@JsonProperty("provider_url")
private String providerUrl;
@JsonProperty("height")
private Integer height;
@JsonProperty("width")
private String width;
@JsonProperty("title")
private String title;
@JsonProperty("description")
private String description;
@JsonProperty("html")
private String html;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public Oembed() {
}

/**
* 
* @param title
* @param providerUrl
* @param height
* @param providerName
* @param description
* @param width
* @param html
* @param type
* @param version
*/
public Oembed(Double version, String type, String providerName, String providerUrl, Integer height, String width, String title, String description, String html) {
super();
this.version = version;
this.type = type;
this.providerName = providerName;
this.providerUrl = providerUrl;
this.height = height;
this.width = width;
this.title = title;
this.description = description;
this.html = html;
}

@JsonProperty("version")
public Double getVersion() {
return version;
}

@JsonProperty("version")
public void setVersion(Double version) {
this.version = version;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonProperty("provider_name")
public String getProviderName() {
return providerName;
}

@JsonProperty("provider_name")
public void setProviderName(String providerName) {
this.providerName = providerName;
}

@JsonProperty("provider_url")
public String getProviderUrl() {
return providerUrl;
}

@JsonProperty("provider_url")
public void setProviderUrl(String providerUrl) {
this.providerUrl = providerUrl;
}

@JsonProperty("height")
public Integer getHeight() {
return height;
}

@JsonProperty("height")
public void setHeight(Integer height) {
this.height = height;
}

@JsonProperty("width")
public String getWidth() {
return width;
}

@JsonProperty("width")
public void setWidth(String width) {
this.width = width;
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

@JsonProperty("html")
public String getHtml() {
return html;
}

@JsonProperty("html")
public void setHtml(String html) {
this.html = html;
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
