
package aiss.model.aliexpress;

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
    "productTitle",
    "productId",
    "originalPrice",
    "imageUrl",
    "productUrl",
    "localPrice"
})
public class Product {

    @JsonProperty("productTitle")
    private String productTitle;
    @JsonProperty("productId")
    private Integer productId;
    @JsonProperty("originalPrice")
    private String originalPrice;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("productUrl")
    private String productUrl;
    @JsonProperty("localPrice")
    private String localPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("productTitle")
    public String getProductTitle() {
        return productTitle;
    }

    @JsonProperty("productTitle")
    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    @JsonProperty("productId")
    public Integer getProductId() {
        return productId;
    }

    @JsonProperty("productId")
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @JsonProperty("originalPrice")
    public String getOriginalPrice() {
        return originalPrice;
    }

    @JsonProperty("originalPrice")
    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("productUrl")
    public String getProductUrl() {
        return productUrl;
    }

    @JsonProperty("productUrl")
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    @JsonProperty("localPrice")
    public String getLocalPrice() {
        return localPrice;
    }

    @JsonProperty("localPrice")
    public void setLocalPrice(String localPrice) {
        this.localPrice = localPrice;
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
