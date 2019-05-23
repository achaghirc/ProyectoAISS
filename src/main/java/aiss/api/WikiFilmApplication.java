package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.model.resources.AliExpressResource;

public class WikiFilmApplication extends Application{
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public WikiFilmApplication() {
	
	}
}
