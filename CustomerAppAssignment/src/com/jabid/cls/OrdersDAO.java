package com.jabid.cls;

import java.util.List;

public interface OrdersDAO {
	public List<Orders> getAllOrders();
	public void deleteOrder(int customer_number, int product_code);
}
