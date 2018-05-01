package com.back.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.back.shoppingbackend.dao.ProductDAO;
import com.back.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context ;
	private static ProductDAO productDAO;

	private Product product;

	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.back.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	/*@Test
	public void testCRUDProduct(){
		product = new Product();
		product.setName("oppo selfie s3");
		product.setBrand("oppo");
		product.setDescription("This is some description of oppo mobile phones!");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplied(3);
		assertEquals("Successfully added a product inside the table! ", true, productDAO.add(product));

		//reading & updating
		product = productDAO.get(2);
		product.setName("Samsung Galaxy s7");
		assertEquals("Something went wrong while updating the existing record ",true, productDAO.update(product));

		//Deactivating using delete method
		assertEquals("Something went wrong while updating the existing record ",true, productDAO.delete(product));

		//list
		assertEquals("Something went wrong while updating the existing record ",4, productDAO.list().size());


	}*/
	
	
	/*@Test
	public void testListActiveProducts(){
		assertEquals("Something went wrong while fetching the list of products! ", 3 ,productDAO.listActiveProducts().size());
	}
	*/
	/*@Test
	public void testListActiveProductsByCategory(){
		assertEquals("Something went wrong while fetching the list of products! ", 2 ,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products! ", 1 ,productDAO.listActiveProductsByCategory(1).size());
	}*/
	
	@Test
	public void testGetLatestActiveProduct(){
		assertEquals("Something went wrong while fetching the list of products! ", 3 ,productDAO.getLatestActiveProducts(3).size());
	}
}
