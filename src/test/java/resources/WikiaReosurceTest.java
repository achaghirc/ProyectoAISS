package resources;

import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.sweble.wikitext.engine.PageId;
import org.sweble.wikitext.engine.PageTitle;
import org.sweble.wikitext.engine.WtEngineImpl;
import org.sweble.wikitext.engine.config.WikiConfig;
import org.sweble.wikitext.engine.nodes.EngProcessedPage;
import org.sweble.wikitext.engine.output.HtmlRenderer;
import org.sweble.wikitext.engine.output.HtmlRendererCallback;
import org.sweble.wikitext.engine.output.MediaInfo;
import org.sweble.wikitext.engine.utils.DefaultConfigEnWp;
import org.sweble.wikitext.engine.utils.UrlEncoding;
import org.sweble.wikitext.parser.nodes.WtUrl;
import aiss.model.wiki.TextConverter;
import aiss.model.wiki.Wiki;
import aiss.model.resources.WikiaResources;

public class WikiaReosurceTest {
	static Wiki wiki;
	static WikiaResources sr = new WikiaResources();
	
	@Test
	public void testGetWiki() throws UnsupportedEncodingException {
		
		wiki = sr.getWiki("Tobey Maguire");
		
		//Show results
		String s = "";
		
		try {
			s = run(wiki.getParse().getWikitext().getT(), wiki.getParse().getTitle(), true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println(s);
	}
	
	static String run(String wikitext, String fileTitle, boolean renderHtml) throws Exception {
		// Set-up a simple wiki configuration
		WikiConfig config = DefaultConfigEnWp.generate();
		
		final int wrapCol = 80;
		
		// Instantiate a compiler for wiki pages
		WtEngineImpl engine = new WtEngineImpl(config);
		
		// Retrieve a page
		PageTitle pageTitle = PageTitle.make(config, fileTitle);
		
		PageId pageId = new PageId(pageTitle, -1);
		
		// Compile the retrieved page
		EngProcessedPage cp = engine.postprocess(pageId, wikitext, null);
		
		if (renderHtml){
			return HtmlRenderer.print(new MyRendererCallback(), config, pageTitle, cp.getPage());
		}else{
			TextConverter p = new TextConverter(config, wrapCol);
			return (String) p.go(cp.getPage());
		}
	}
	
	private static final class MyRendererCallback implements HtmlRendererCallback {
		protected static final String LOCAL_URL = "";
		
		@Override
		public boolean resourceExists(PageTitle target) {
			return false;
		}
		
		@Override
		public MediaInfo getMediaInfo(String title, int width, int height) throws Exception {
			return null;
		}
		
		@Override
		public String makeUrl(PageTitle target) {
			String page = UrlEncoding.WIKI.encode(target.getNormalizedFullTitle());
			String f = target.getFragment();
			String url = page;
			if (f != null && !f.isEmpty())
				url = page + "#" + UrlEncoding.WIKI.encode(f);
			return LOCAL_URL + "/" + url;
		}
		
		@Override
		public String makeUrl(WtUrl target) {
			if (target.getProtocol() == "")
				return target.getPath();
			return target.getProtocol() + ":" + target.getPath();
		}
		
		@Override
		public String makeUrlMissingTarget(String path) {
			return "https://es.wikipedia.org/wiki/" + path;
			
		}
	}
	
}