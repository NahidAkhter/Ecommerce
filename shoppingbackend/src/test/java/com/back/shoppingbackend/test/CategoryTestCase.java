package com.back.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.back.shoppingbackend.dao.CategoryDAO;
import com.back.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	@Autowired
	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.back.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*@Test
	public void testAddCategory(){
		category = new Category();
		category.setName("laptop");
		category.setDescription("This is a description of television");
		category.setImageURL("CAT_4.png");
		assertEquals("Successfully added a category inside the table! ", true, categoryDAO.add(category));
	}*/

	/*@Test
		public void getCategory(){
			category = categoryDAO.getId(1);
			assertEquals("Successfully fetched a single category from the table! ", "mobile" , category.getName());
		}*/

	/*	@Test
	public void testUpdateCategory(){
		category = categoryDAO.getId(1);
		category.setDescription("This is for mobile description");
		assertEquals("Successfully fetched a single category from the table! ",true, categoryDAO.update(category));
	}*/

	/*@Test
	public void testDeleteCategory(){

		category = categoryDAO.getId(3);
		assertEquals("Successfully deleted a single category from the table! ",true, categoryDAO.delete(category));
	}
	 */

	/*@Test
	public void testListCategory(){
		assertEquals("Successfully List all category from the table! ",3, categoryDAO.list().size());
	}*/

	
	@Test
	public void testCRUDCategory(){
		
		category = new Category();
		category.setName("laptop");
		category.setDescription("This is a description of laptop");
		category.setImageURL("CAT_1.png");
		assertEquals("Successfully added a category inside the table! ", true, categoryDAO.add(category));
		
		
		category = new Category();
		category.setName("Television");
		category.setDescription("This is a description of television");
		category.setImageURL("CAT_2.png");
		assertEquals("Successfully added a category inside the table! ", true, categoryDAO.add(category));
		
		
		//fetching & updating
		category = categoryDAO.getId(2);
		category.setName("TV");
		assertEquals("Successfully fetched a single category from the table! ",true, categoryDAO.update(category));
		
		//Deactivating using delete method
		assertEquals("Successfully deleted a single category from the table! ",true, categoryDAO.delete(category));
	
		//fetching the list
		assertEquals("Successfully List all category from the table! ",1, categoryDAO.list().size());
		
		
	}
	
	
	
	
	
	
}
