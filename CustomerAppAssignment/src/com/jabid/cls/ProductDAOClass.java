package com.jabid.cls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOClass implements ProductDAO{
	
	private List<Product>allProducts;
	
	public ProductDAOClass() {
		allProducts = new ArrayList<>();
	}

	@Override
	public Product getProductInfo(int product_code) {
		Connection conn = Connector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from product where product_code=?");
			ps.setInt(1, product_code);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product p = new Product();
				p.setProduct_code(rs.getInt(1));
				p.setProduct_name(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				p.setQuantity(rs.getInt(4));
				return p;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Product> getAllProductsInfo() {
		Connection conn = Connector.getConnection();
		
		Statement st;
		try {
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from product");
			while(rs.next()) {
				Product p = new Product();
				p.setProduct_code(rs.getInt(1));
				p.setProduct_name(rs.getString(2));
				p.setPrice(rs.getFloat(3));
				p.setQuantity(rs.getInt(4));
				allProducts.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allProducts;
		
	}
	

	@Override
	public boolean updateQuantityOfProduct(int product_code, int updatedQuantity) {
		Connection conn = Connector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Update product set quantity=? where product_code=?");
			ps.setInt(1, updatedQuantity);
			ps.setInt(2, product_code);
			ps.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
