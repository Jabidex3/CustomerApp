package com.jabid.cls;

public class Product {
	private int product_code;
    private String product_name;
    private float price;
    private int quantity;
    
    public Product() {
    	
    }
    
	public Product(int product_code, String product_name, float price, int quantity) {
		super();
		this.product_code = product_code;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProduct_code() {
		return product_code;
	}

	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [product_code=" + product_code + ", product_name=" + product_name + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
    
    
}
