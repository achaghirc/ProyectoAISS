package aiss.model.resources;

import java.io.UnsupportedEncodingException;


import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.aliexpress.AliExpress;

public class AliExpressResource {

	private static final Logger log = Logger.getLogger(AliExpressResource.class.getName());

	private static final String APIKEY = "33503";

	public AliExpress getProducts(String param) throws UnsupportedEncodingException {
		String query = URLEncoder.encode(param, "UTF-8");
		String uri = "http://gw.api.alibaba.com/openapi/param2/2/portals.open/api.listPromotionProduct/" + APIKEY
				+ "?fields=productUrl,imageUrl,originalPrice,localPrice,productTitle&localCurrency=EUR&keywords=" + query;
		ClientResource cr = new ClientResource(uri);
		AliExpress sr = cr.get(AliExpress.class);
		return sr;

	}
}