package dao;


import model.Category;
import model.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryCategoryDao implements CategoryDao {

    private Map<Integer, Category> categories = new HashMap<>();
    
    public void create(Category c) {
    	int id = (categories.isEmpty()) ? 1 : categories.size() + 1;
    	c.setId(id);
    	categories.put(c.getId(), c);
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categories.values());
    }

    @Override
    public Category findById(Integer id) {
        return categories.get(id);
    }

    @Override
    public List<Product> findProductsByName(String name) {
        return categories.values().stream()
                .flatMap(category -> category.getProducts().stream())
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

	@Override
	public void update(Category category) {
		categories.put(category.getId(), category);
		
	}

	@Override
	public void deleteById(Integer id) {
		categories.remove(id);
	}

	@Override
	public int lastKey() {
		return this.categories.size();
	}

}
