package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {

		category = new Category();
		// category.setId(2);
		category.setName("Laptop");
		category.setImageUrl("url is there");
		category.setDescription("Laptop category is there");
		category.setActive(true);

		assertEquals("Successfully added the category in the database", true, categoryDAO.addCategory(category));

		category = new Category();
		// category.setId(2);
		category.setName("Television");
		category.setImageUrl("url is there");
		category.setDescription("Household category is there");
		category.setActive(true);

		assertEquals("Successfully added the category in the database", true, categoryDAO.addCategory(category));
		
		category = new Category();
		// category.setId(2);
		category.setName("Mobile");
		category.setImageUrl("url is there");
		category.setDescription("Mobile category is there");
		category.setActive(true);

		assertEquals("Successfully added the category in the database", true, categoryDAO.addCategory(category));
	}
////
//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.get(1);
//
//		assertEquals("Successfully get the category from the database", "Television", category.getName());
//	}
//
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(1);
//		category.setName("Television");
//		assertEquals("Successfully update the category in the database", true, categoryDAO.updateCategory(category));
//	}
//
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(1);
//		assertEquals("Successfully update the category in the database", true, categoryDAO.deleteCategory(category));
//	}
//
//	@Test
//	public void testlistCategory() {
//		assertEquals("Successfully update the category in the database", 1, categoryDAO.list().size());
//	}

	

}
