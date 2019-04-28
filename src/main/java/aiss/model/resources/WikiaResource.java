package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.wiki.Wiki;

public class WikiaResource {
	
	private static final String URL_WIKI =  "https://es.wikipedia.org/w/api.php?action=parse&format=json&page=";
	private static final String URL_FIN =  "&prop=wikitext";
	
	public Wiki getWiki(String query) throws UnsupportedEncodingException {
		ClientResource cr = null;
		Wiki m = null;
		try {
			cr = new ClientResource(URL_WIKI+query+URL_FIN);
			m = cr.get(Wiki.class);
		}catch (ResourceException e) {
			System.err.println("Error al querer obtener la información: " + cr.getResponse().getStatus());
		}
		return m;
	}
	
}
