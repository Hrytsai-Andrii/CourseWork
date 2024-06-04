package database;

import dao.CategoryDao;
import model.Category;
import model.Product;

public class TestDataBase {
	public static void create(CategoryDao cd) {
		Category electronics = new Category(1, "Electronics");
        cd.create( electronics);

        Category homeAppliances = new Category(2, "Home Appliances");
        cd.create(homeAppliances);
	}
}
