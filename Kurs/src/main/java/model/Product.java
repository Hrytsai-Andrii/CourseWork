package model;
import java.sql.*;

public class Product implements Istance{
	private String name;
	private String characteristic;
	private double price;
	
	Product(String n, String c, double price){
		this.name = n.trim().toLowerCase();
		this.characteristic = n;
		if(price <= 0)
			throw new IllegalArgumentException();
		this.price = price;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getCharacteristic() {
		return this.characteristic;
	}
	
	public double getPrice() {
		return this.price;
	}

}
