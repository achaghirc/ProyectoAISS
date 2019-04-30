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
import org.sweble.wikitext.engine.utils.DefaultConfigEnWp;
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
			s = convertWikiText(wikiResults.getParse().getTitle(),wikiResults.getParse().getWikitext().getT(),185);
		} catch (LinkTargetException e) {
			e.printStackTrace();
		} catch (EngineException e) {
			e.printStackTrace();
		}
		
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
	
	public String convertWikiText(String title, String wikiText, int maxLineLength) throws LinkTargetException, EngineException {
	    // Set-up a simple wiki configuration
	    WikiConfig config = DefaultConfigEnWp.generate();
	    // Instantiate a compiler for wiki pages
	    WtEngineImpl engine = new WtEngineImpl(config);
	    // Retrieve a page
	    PageTitle pageTitle = PageTitle.make(config, title);
	    PageId pageId = new PageId(pageTitle, -1);
	    // Compile the retrieved page
	    EngProcessedPage cp = engine.postprocess(pageId, wikiText, null);
	    TextConverter p = new TextConverter(config, maxLineLength);
	    return (String)p.go(cp.getPage());
	}
	
}
