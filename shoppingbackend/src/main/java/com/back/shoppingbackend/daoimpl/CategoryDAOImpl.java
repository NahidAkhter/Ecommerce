package com.back.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.back.shoppingbackend.dao.CategoryDAO;
import com.back.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();
		// adding categories
		// 1
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is a description of television");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// 2
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is a description of Mobile!");
		category.setImageURL("CAT_2.png");

		// 3
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is a description of Laptop!");
		category.setImageURL("CAT_3.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		return categories;
	}

	@Override
	public Category getId(int id) {
		for(Category category : categories){
			if(category.getId() == id){
				return category;
			}
		}
		return null;
		
	}

}
