package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
		
	}

	@Override
	@Transactional
	public Category get(int id) {

		try {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public boolean addCategory(Category category) {
		
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Override
	@Transactional
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteCategory(Category category) {
		
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}

}
