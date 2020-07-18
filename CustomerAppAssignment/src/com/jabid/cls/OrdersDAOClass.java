package com.jabid.cls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAOClass implements OrdersDAO{
	private List<Orders>allOrders;
	
	public OrdersDAOClass() {
		allOrders = new ArrayList<>();
	}
	
	@Override
	public void deleteOrder(int customer_number, int product_code) {
		// TODO Auto-generated method stub
		Connection conn = Connector.getConnection();
		String query = "Delete from orders where customer_number=? and product_code=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,customer_number);
			ps.setInt(2,product_code);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(allOrders.size()>0) {
			allOrders.clear();
		}
	}

	@Override
	public List<Orders> getAllOrders() {
		Connection conn = Connector.getConnection();
		
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from orders");
			while(rs.next()) {
				Orders od = new Orders();
				od.setOrder_number(rs.getInt(1));
				od.setCustomer_number(rs.getInt(2));
				od.setProduct_code(rs.getInt(3));
				od.setTotal_price(rs.getFloat(4));
				od.setOrder_quantity(rs.getInt(5));
				allOrders.add(od);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allOrders;
	}
	 
}
