package com.back.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.back.shoppingbackend.dao.CategoryDAO;
import com.back.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		return null;
	}

	/*
	 * Getting Single category based on id
	 * */
	@Override
	public Category getId(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {
		
		try{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch(Exception e){
			System.out.println("Catched exception");
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean update(Category category) {
		
		return false;
	}

	@Override
	public boolean delete(Category category) {
		
		return false;
	}

}
