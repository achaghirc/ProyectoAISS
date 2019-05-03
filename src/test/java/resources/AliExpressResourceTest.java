package resources;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.aliexpress.AliExpress;
import aiss.model.aliexpress.Product;
import aiss.model.resources.AliExpressResource;

public class AliExpressResourceTest {

	static AliExpressResource AR=new AliExpressResource();
	static AliExpress a1,a2;
	@Test
	public void testGetProducts() throws UnsupportedEncodingException {
		a1=AR.getProducts("batman");
		a2=AR.getProducts("El Padrino");
		assertNotNull("No se ha podido realizar la busqueda",a1);
		assertNotNull("No se ha podido realizar la busqueda",a2);
		for(Product p:a1.getResult().getProducts()) {
			System.out.println("id del producto"+p+":"+p.getProductId());
			System.out.println("Url del producto"+p+":"+p.getProductUrl());
		}
		
		
	}

}
