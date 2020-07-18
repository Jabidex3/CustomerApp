package com.jabid.cls;

public class Orders {
	private int order_number;
    private int customer_number;
    private int product_code;
    private float total_price;
    private int order_quantity;
    
    public Orders() {
    	
    }
    
	public Orders(int order_number, int customer_number, int product_code, int total_price, int order_quantity) {
		super();
		this.order_number = order_number;
		this.customer_number = customer_number;
		this.product_code = product_code;
		this.total_price = total_price;
		this.order_quantity = order_quantity;
	}
	
	public int getOrder_number() {
		return order_number;
	}
	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	public int getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}

	@Override
	public String toString() {
		return "Orders [order_number=" + order_number + ", customer_number=" + customer_number + ", product_code="
				+ product_code + ", total_price=" + total_price + ", order_quantity=" + order_quantity + "]";
	}
    
    
}
