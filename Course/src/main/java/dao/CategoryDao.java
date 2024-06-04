package dao;

import java.util.List;
import model.Category;
import model.Product;

public interface CategoryDao {
	public void create(Category c);
    List<Category> findAll();
    Category findById(Integer id);
    List<Product> findProductsByName(String name);
	public void update(Category category);
	public void deleteById(Integer id);
	public int lastKey();
}

