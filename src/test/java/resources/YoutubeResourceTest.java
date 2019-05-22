package resources;


import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.resources.YoutubeResource;
import aiss.model.youtube.CommentResponse;
import aiss.model.youtube.Item;
import aiss.model.youtube.Snippet;
import aiss.model.youtube.Snippet_;
import aiss.model.youtube.TopLevelComment;
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
	
/*	@Test
	public void testPostVideo() throws UnsupportedEncodingException {
		YoutubeResource ytr = new YoutubeResource();
		CommentResponse comentario = new CommentResponse();
		Snippet snp = new Snippet();
        TopLevelComment tlc = new TopLevelComment();
        Snippet_ snp_ = new Snippet_();
    
        snp_.setTextOriginal("Hola todo funciona");
       
        tlc.setSnippet_(snp_);
        
        snp.setTopLevelComment(tlc);       
      
        snp.setVideoId("v01");        
        snp.setIsPublic(true);
        comentario.setSnippet(snp);
        
		c = ytr.insertComment(comentario);
		
		assertNotNull("El comentario no ha sido introducido", c);
		
		System.out.println("El comentario introducido ha sido "+c.getSnippet().getTopLevelComment().getSnippet_().getTextOriginal());
	}*/

}