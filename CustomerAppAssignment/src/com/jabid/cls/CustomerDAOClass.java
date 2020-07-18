package com.jabid.cls;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAOClass implements CustomerDAO {

	private List<Customer> allCustomers;
	private List<String> customerAndProductDetails;
	public CustomerDAOClass() {
		allCustomers = new ArrayList<>();
		customerAndProductDetails = new ArrayList<String>();
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		Connection conn = Connector.getConnection(); 
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from customer");
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomer_number(rs.getInt("customer_number"));
				c.setCustomer_name(rs.getString("customer_name"));
				c.setAddress(rs.getString("address"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				allCustomers.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allCustomers;
	}

	@Override
	//Print all Customers along with their Products that they ordered
	public List<String> getAllProductsOrdered() {
		Connection conn = Connector.getConnection(); 
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select customer.customer_number, customer.customer_name, product.product_name, orders.order_quantity, orders.total_price from customer\r\n" + 
					"inner join orders\r\n" + 
					"on customer.customer_number = orders.customer_number\r\n" + 
					"inner join product\r\n" + 
					"on product.product_code = orders.product_code");
			
			String[] tableHeaders = {"Customer_Number", "Customer_Name", "Product_Name", "Order_Quantity", "Total_Price"};
			int j=0;
			while(rs.next()) {
				String s ="";
				s+= tableHeaders[j] +": "+ rs.getInt(1) +" "+ tableHeaders[j+1] +": "+ rs.getString(2) +" "+ tableHeaders[j+2] +": "+ rs.getString(3)+" "+tableHeaders[j+3]+": "+rs.getInt(4)+" "+ tableHeaders[j+4]+": $"+rs.getFloat(5);
				customerAndProductDetails.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customerAndProductDetails;
		
	}

}
