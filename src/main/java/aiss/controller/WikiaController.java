package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sweble.wikitext.engine.EngineException;
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
import org.sweble.wikitext.parser.parser.LinkTargetException;
import aiss.model.wiki.TextConverter;
import aiss.model.wiki.Wiki;
import aiss.model.resources.WikiaResources;

public class WikiaController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(WikiaController.class.getName());
	
	public WikiaController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		RequestDispatcher rd = null;
		
		// Search for info in WikiPedia
		log.log(Level.FINE, "Buscando información del actor " + name);
		WikiaResources wiki = new WikiaResources();
		Wiki wikiResults = wiki.getWiki(name);
		String s = "";
		
		try {
			s = run(wikiResults.getParse().getWikitext().getT(), wikiResults.getParse().getTitle(), true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		try {
//			s = convertWikiText(wikiResults.getParse().getTitle(),wikiResults.getParse().getWikitext().getT(),175);
//			s = s.replaceAll("//", "");
//			s = s.replaceAll("-", " ");
//		} catch (LinkTargetException e) {
//			e.printStackTrace();
//		} catch (EngineException e) {
//			e.printStackTrace();
//		}
		
		if (wikiResults.getParse()!=null){
	
			rd = request.getRequestDispatcher("/wikiView.jsp");
			request.setAttribute("s", s);
			request.setAttribute("wiki", wikiResults);
			
		}else if(wikiResults.getParse()== null){
			log.log(Level.SEVERE,"WikiTexto object: "+ s);
			rd = request.getRequestDispatcher("/wikiViewError.jsp");
		}else {
			log.log(Level.SEVERE,"WikiTexto object: "+ s);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

//	public String convertWikiText(String title, String wikiText, int maxLineLength) throws LinkTargetException, EngineException {
//	    // Set-up a simple wiki configuration
//	    WikiConfig config = DefaultConfigEnWp.generate();
//	    // Instantiate a compiler for wiki pages
//	    WtEngineImpl engine = new WtEngineImpl(config);
//	    // Retrieve a page
//	    PageTitle pageTitle = PageTitle.make(config, title);
//	    PageId pageId = new PageId(pageTitle, -1);
//	    // Compile the retrieved page
//	    EngProcessedPage cp = engine.postprocess(pageId, wikiText, null);
//	    TextConverter p = new TextConverter(config, maxLineLength);
//	    return (String)p.go(cp.getPage());
//	}
	
	static String run(String wikitext, String fileTitle, boolean renderHtml) throws Exception
	{
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
		
		if (renderHtml)
		{
			String ourHtml = HtmlRenderer.print(new MyRendererCallback(), config, pageTitle, cp.getPage());
			
//			String template = IOUtils.toString(App.class.getResourceAsStream("/render-template.html"), "UTF8");
//			
//			String html = template;
//			html = html.replace("{$TITLE}", StringUtils.escHtml(pageTitle.getDenormalizedFullTitle()));
//			html = html.replace("{$CONTENT}", ourHtml);
//			
			return ourHtml;
		}
		else
		{
			TextConverter p = new TextConverter(config, wrapCol);
			return (String) p.go(cp.getPage());
		}
	}
	
	private static final class MyRendererCallback
	implements
		HtmlRendererCallback
	{
		protected static final String LOCAL_URL = "";
		
		@Override
		public boolean resourceExists(PageTitle target)
		{
			// TODO: Add proper check
			return false;
		}
		
		@Override
		public MediaInfo getMediaInfo(String title, int width, int height) throws Exception
		{
			// TODO: Return proper media info
			return null;
		}
		
		@Override
		public String makeUrl(PageTitle target)
		{
			String page = UrlEncoding.WIKI.encode(target.getNormalizedFullTitle());
			String f = target.getFragment();
			String url = page;
			if (f != null && !f.isEmpty())
				url = page + "#" + UrlEncoding.WIKI.encode(f);
			return LOCAL_URL + "/" + url;
		}
		
		@Override
		public String makeUrl(WtUrl target)
		{
			if (target.getProtocol() == "")
				return target.getPath();
			return target.getProtocol() + ":" + target.getPath();
		}
		
		@Override
		public String makeUrlMissingTarget(String path)
		{
			return LOCAL_URL + "?title=" + path + "&amp;action=edit&amp;redlink=1";
			
		}
	}
	
}
