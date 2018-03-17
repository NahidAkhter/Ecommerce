package com.back.shoppingbackend.dao;

import java.util.List;
import com.back.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	Category getId(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
}
