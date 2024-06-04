package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<Category> subcategories;
    private List<Product> products;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        this.subcategories = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Category> subcategories) {
        this.subcategories = subcategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addSubcategory(Category subcategory) {
    	subcategory.setId(this.subcategories.size() + 1);
        this.subcategories.add(subcategory);
    }
    
    public void addSubcategory(Category subcategory, int id) {
    	subcategory.setId(id);
        this.subcategories.add(subcategory);
    }

    public void addProduct(Product product) {
    	product.setId(this.products.size() + 1);
        this.products.add(product);
    }
    
    public void addProduct(Product product, int id) {
    	product.setId(id);
        this.products.add(product);
    }

	public Product getProductById(int productId) {
		for (Product product : products) {
	        if (product.getId() == id) {
	            return product;
	        }
	    }
	    return null;
	}
	
	public void deleteCategoryById(Integer id) {
		subcategories.remove(id);
	}
	
	public void deleteProductById(Integer id) {
		products.remove(id);
	}
}
