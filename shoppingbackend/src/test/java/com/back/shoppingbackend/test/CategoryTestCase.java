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
			System.out.println("------------Inside Init()------------");
			context = new AnnotationConfigApplicationContext();
			context.scan("com.back.shoppingbackend");
			System.out.println("------------Inside categorytestCase before referesh------------");
			//System.out.println("value of :" + context);
			context.refresh();
			System.out.println("------------Inside categorytestCase after refresh------------");
			categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		}
		
		/*@Test
		public void testAddCategory(){
			System.out.println("------------Inside testAddCategory ");
			category = new Category();
			category.setName("Television");
			category.setDescription("This is a description of television");
			category.setImageURL("CAT_1.png");
			System.out.println("------------Inside TEST-------------------- ");
			assertEquals("Successfully added a category inside the table! ", true, categoryDAO.add(category));
			
			
			
		}*/
		
		@Test
		public void getCategory(){
			category = categoryDAO.getId(5);
			assertEquals("Successfully fetched a single category from the table! ", "Television" , category.getName());
		}
		
		
		
}
