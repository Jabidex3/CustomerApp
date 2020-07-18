package com.jabid.cls;

import java.util.Scanner;


/***
 * Customer Application
 * @author Jabid Methun
 *
 */

public class MainClass {

	public static void main(String[] args) {
		CustomerDAOClass cdc = new CustomerDAOClass();
		ProductDAOClass pdc = new ProductDAOClass();
		OrdersDAOClass odc = new OrdersDAOClass();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the Customer App!");
		while(true) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("What would you like to do/see? Enter one of the following options:");
			System.out.println("1 - See all Customers and Products ordered by them");
			System.out.println("2 - Update an existing product quantity");
			System.out.println("3 - Delete all orders for a specific product for a particular customer");
			System.out.println("4 - Quit");
			System.out.println("--------------------------------------------------------------------");
			try {
				int choice = Integer.parseInt(scan.nextLine());
				if(choice == 1) {
					//(1)Print all Customers along with all of their Products that they ordered
					System.out.println("Printing out all customers and the products they ordered:");
					for(String s: cdc.getAllProductsOrdered()) {
						System.out.println(s);
					}
					
					System.out.println();
					System.out.println();
				}
				else if(choice==2){
					//(2)Update quantity for a particular Product
					System.out.println("Updating Quantity for a particular product:");
					System.out.println("Product List and Details:");
					//print out all products and details
					for(Product p: pdc.getAllProductsInfo()) {
						System.out.println(p);
					}
					System.out.println();
					
					System.out.println("What is the product code of the product you wish to update?");
					int product_code_choice = Integer.parseInt(scan.nextLine());
					System.out.println("What is the new quantity value?");
					int product_quantity_new = Integer.parseInt(scan.nextLine());
					
					//prior to update quantity
					System.out.println("Pre-Update Values:");
					System.out.println(pdc.getProductInfo(product_code_choice));
					System.out.println();
					
					//updating quantity of desired product
					boolean success = pdc.updateQuantityOfProduct(product_code_choice, product_quantity_new);
					if(success) {
						System.out.println("Quantity updated Successfully ");
					}
					else {
						System.out.println("Error");
					}
					System.out.println();
					
					//post-update quantity
					System.out.println("Post-Update Values:");
					System.out.println(pdc.getProductInfo(product_code_choice));
					
					
					System.out.println();
					System.out.println();
				}
				else if(choice==3){
					//(3) Delete all the orders placed for a product by a particular Customer
					System.out.println("Delete all the orders placed for a product by a particular Customer:");
					
					//all orders before delete
					System.out.println("All current order details:");
					for(Orders od: odc.getAllOrders()) {
						System.out.println(od);
					}
					System.out.println();
					
					System.out.println("What is the customer number?");
					int custNum = Integer.parseInt(scan.nextLine());
					System.out.println("What is the product code of the product?");
					int prodNum = Integer.parseInt(scan.nextLine());
					
					//delete
					odc.deleteOrder(custNum, prodNum);
					System.out.println();
					
					//post-delete orders list
					System.out.println("Post delete order details:");
					for(Orders od: odc.getAllOrders()) {
						System.out.println(od);
					}
				}
				else if(choice==4){
					scan.close();
					System.out.println("Thank you for using Customer App! Goodbye!");
					break;
				}
				else {
					System.out.println("Invalid Input. Try Again");
					System.out.println();
				}
			}
			catch(Exception e){
				System.out.println("Invalid Input. Try Again");
				System.out.println();
			}
			
			
		}
		
		
		
		
		//print out all customers
//		for(Customer c: cdc.getAllCustomers()) {
//			System.out.println(c);
//		}
		
		//print out all products
//		for(Product p: pdc.getAllProductsInfo()) {
//			System.out.println(p);
//		}
		
	}

}
