package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import org.junit.Test;
import aiss.Wiki.Wiki;
import aiss.model.resources.WikiaResources;

public class WikiResourceTest {
	static Wiki wiki;
	static WikiaResources sr = new WikiaResources();
	
	@Test
	public void testGetWiki() throws UnsupportedEncodingException {
		wiki = sr.getWiki("Michael Papajohn");
		
		//Show results
		System.out.println(wiki.getParse());
		System.out.println(wiki.getParse().getWikitext());
		System.out.println(wiki.getParse().getWikitext().getT());
		
	}
	
}
