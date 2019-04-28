package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import org.junit.Test;

import aiss.model.resources.WikiaResources;
import aiss.model.wiki.Wiki;

public class WikiResourceTest {
	static Wiki wiki;
	static WikiaResources sr = new WikiaResources();
	
	@Test
	public void testGetWiki() throws UnsupportedEncodingException {
		wiki = sr.getWiki("Johnny Depp");
		
		//Show results
		System.out.println(wiki);
		System.out.println(wiki.getParse());
		System.out.println(wiki.getParse().getWikitext());
		System.out.println(wiki.getParse().getWikitext().getT());
		
	}
	
}
