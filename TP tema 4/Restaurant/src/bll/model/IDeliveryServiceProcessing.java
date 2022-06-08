package bll.model;

import java.util.*;

import javax.swing.JTable;

public interface IDeliveryServiceProcessing {
	//client
	HashMap <Order, List<BaseProduct>> getMapOrder();
	List<BaseProduct> getProducts();
	void setProducts();
	void addBaseProduct(BaseProduct base);
	void setBaseProduct(List<BaseProduct> list);
	void deleteBaseProduct(BaseProduct base);
	
	
	String addMenu(MenuItem m);
	String setMenu(List<MenuItem> list);
	String deleteMenu(MenuItem base);
    String editMenu(MenuItem product, String newTitle, int newPrice);
    JTable viewMenu();
	
	
	
	List<Order> getOrders();
	void addOrder(Order order);
	void notificationOrder(Order order);
	//void addMapOrder(Order order, List<BaseProduct> base);
	
	void addMenuItem(MenuItem product);
	void deleteMenuItem(MenuItem product);
	void editMenuItem(MenuItem product, BaseProduct base);
	JTable viewMenuTable();
	
	
	
	String prepareOrder(String nameProduct,float priceOrder);
	JTable viewOrder();
	String prepareBill(Order order);
}
