package com.jabid.cls;

import java.util.List;

public interface ProductDAO {
	 public boolean updateQuantityOfProduct(int product_code, int updatedQuantity);
	 public Product getProductInfo(int product_code);
	 public List<Product> getAllProductsInfo();
}
