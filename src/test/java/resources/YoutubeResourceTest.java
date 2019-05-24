package resources;


import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.CommentResponse;
import aiss.model.youtube.Item;
import aiss.model.youtube.VideoSearch;

public class YoutubeResourceTest {
	
	static YoutubeResource YR=new YoutubeResource();
	
	static VideoSearch v1,v2;
	static CommentResponse c;
	

	@Test
	public void tesGetVideo1() throws UnsupportedEncodingException {
		v1=YR.getVideo("Black Panther");
		assertNotNull("La busqueda no se ha realizado",v1);
		System.out.println("id del primer elemento de la búsqueda:"+v1.getItems().get(0).getId());
	
	}
	@Test
	public void testGetVideo2() throws UnsupportedEncodingException {
		v2=YR.getVideo("El Padrino");
		assertNotNull("La busqueda no se ha realizado",v2);
		for(Item i:v2.getItems()) {
			System.out.println("id del video"+i+":"+i.getId());
		}
		System.out.println("id del primer elemento de la búsqueda:"+v2.getItems().get(0).getId());
	}

}