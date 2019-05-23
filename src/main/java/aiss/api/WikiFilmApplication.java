package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resource.CancionesResource;
import aiss.api.resource.PeliculasResource;
import aiss.api.resource.ProductosResource;
import aiss.api.resource.VideoResource;


public class WikiFilmApplication extends Application{
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public WikiFilmApplication() {
		singletons.add(CancionesResource.getInstance());
		singletons.add(PeliculasResource.getInstance());
		singletons.add(ProductosResource.getInstance());
		singletons.add(VideoResource.getInstance());
		
	}
	
	public Set<Class<?>> getClasees(){
		return classes;
	}
	
	public Set<Object> getSingletons(){
		return singletons;
	}
}
