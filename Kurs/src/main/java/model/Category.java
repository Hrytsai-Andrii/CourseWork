package model;

import java.util.HashMap;

public class Category implements Istance{
	private String name;
	private HashMap<String, Istance> list;
	
	Category(String name){
		this.name = name.trim().toLowerCase();
		this.list = new HashMap<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean add(Istance i) {
		if (!list.containsKey(i.getName().trim().toLowerCase())){
			list.put(i.getName(), i);
			return true;
		}else {
			return false;
		}
	}
	
	public void delete(String name) {
		if (list.containsKey(name.trim().toLowerCase())) {
			list.remove(name);
		}
	}
	public void edit(String name) {
		this.name = name;
	}
}
