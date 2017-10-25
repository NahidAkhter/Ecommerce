package com.back.shoppingbackend.dao;

import java.util.List;

import com.back.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category getId(int id);
}
