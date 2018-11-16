package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	boolean addCategory(Category category);
	boolean updateCategory(Category category);
	boolean deleteCategory(Category category);
	
	List<Category> list();
	
	Category get(int id);

}
