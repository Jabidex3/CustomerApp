package com.jabid.cls;

public class Customer {
	private int customer_number;
    private String customer_name;
    private String address;
    private String city;
    private String country;
    
    public Customer() {
    	
    }
    
	public Customer(int customer_number, String customer_name, String address, String city, String country) {
		super();
		this.customer_number = customer_number;
		this.customer_name = customer_name;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	
	public int getCustomer_number() {
		return customer_number;
	}
	public void setCustomer_number(int customer_number) {
		this.customer_number = customer_number;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Customer [customer_number=" + customer_number + ", customer_name=" + customer_name + ", address="
				+ address + ", city=" + city + ", country=" + country + "]";
	}
    
	
    
}
