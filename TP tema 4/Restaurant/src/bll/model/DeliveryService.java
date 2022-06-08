package bll.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import javax.swing.JTable;

import dataaccess.FileWriter;
import dataaccess.Serializator;
import presentation.AngajatView;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {
	private Observer observer = new AngajatView();
	HashMap<Order, List<BaseProduct>> orderMap;
	 public List<MenuItem> menu;
	 public List<BaseProduct> productList;
	 public List<Order> orderList;
	 Serializator serial = new Serializator();
	public DeliveryService() {
		 try {
			//menu = (ArrayList<MenuItem>) Serializator.readFile("file.txt");
			//orderMap = (HashMap<Order, List<BaseProduct>>) Serializator.readFile("order.txt"); //deserialize
			//orderList = new ArrayList();
			
			productList =(List<BaseProduct>) FileWriter.readDataLineByLine("C:/Users/ghica/OneDrive/Desktop/TP tema 4/Restaurant/products.csv");
			//orderList = (List<Order>) FileWriter.readDataLineByLineOrder("C:/Users/ghica/OneDrive/Desktop/TP tema 4/Restaurant/order.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public List<BaseProduct> getProducts(){
		return productList;
	}

	@Override
	public HashMap<Order, List<BaseProduct>> getMapOrder() {
		// TODO Auto-generated method stub
		return orderMap;
	}
	

	@Override
	public void addMenuItem(MenuItem product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMenuItem(MenuItem product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editMenuItem(MenuItem product, BaseProduct base) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JTable viewMenuTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepareOrder(String nameProduct, float priceOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTable viewOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String prepareBill(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProducts() {
		// TODO Auto-generated method stub
		FileWriter file= new FileWriter();
        List<BaseProduct> product= null;
        try {
            product = FileWriter.readDataLineByLine("C:/Users/ghica/OneDrive/Desktop/TP tema 4/Restaurant/products.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        List<BaseProduct> product1 = new ArrayList<>();
        for(BaseProduct baseproduct : product)
        {
            product1.add(baseproduct);
        }
        
        product1.sort(new Comparator<BaseProduct>() {
			@Override
			public int compare(BaseProduct b1, BaseProduct b2) {
				// TODO Auto-generated method stub
				 return b1.getTitle().compareTo(b2.getTitle());
			}
        });
        this.productList=product1;
        try {
            Serializator.writeToFile("C:/Users/ghica/OneDrive/Desktop/TP tema 4/Restaurant/products.csv",product1);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void addBaseProduct(BaseProduct base) {
		// TODO Auto-generated method stub
		assert base !=null;
        this.productList.add(base);
        try {
            Serializator.writeToFile("C:/Users/ghica/OneDrive/Desktop/TP tema 4/Restaurant/products.csv",productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
	}

	@Override
	public void setBaseProduct(List<BaseProduct> list) {
		// TODO Auto-generated method stub
		assert list!=null;
        this.productList=list;
        try {
        	Serializator.writeToFile("C:/Users/ghica/OneDrive/Desktop/TP tema 4/Restaurant/products.csv",productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteBaseProduct(BaseProduct base) {
		// TODO Auto-generated method stub
		assert base !=null;
        this.productList.remove(base);
        try {
        	Serializator.writeToFile("C:/Users/ghica/OneDrive/Desktop/TP tema 4/Restaurant/products.csv",productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orderList;
	}

	public void addOrder(Order order) {
		assert  order != null;
        orderList.add(order);
        try {
            Serializator.writeToFile("C:/Users/ghica/OneDrive/Desktop/TP tema 4/Restaurant/order.txt",orderList);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void notificationOrder(Order order) {
		// TODO Auto-generated method stub
		observer.update(this, order);
	}

	@Override
	public String addMenu(MenuItem m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setMenu(List<MenuItem> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteMenu(MenuItem base) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editMenu(MenuItem product, String newTitle, int newPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTable viewMenu() {
		// TODO Auto-generated method stub
		assert balanced(); 
        assert (((BaseProduct) menu).getMenuItems().size() > 0); 
        int nrOfRows = ((BaseProduct) menu).getMenuItems().size();
        String[][] rowData = new String[nrOfRows][3];
        String[] columnNames = {"Title", "Price"};
        for (int i = 0; i < nrOfRows; i++) {
            rowData[i][0] = ((BaseProduct) menu).getMenuItems().get(i).getTitle();
            rowData[i][1] = ((BaseProduct) menu).getMenuItems().get(i).computePrice();
            
        }
        JTable tableMenu = new JTable(rowData, columnNames);
        assert balanced(); 
        return tableMenu;
		
	}
	
	
	public boolean balanced() {
	    for (int i = 0; i < ((BaseProduct) menu).getMenuItems().size(); i++) {
	         if (((BaseProduct) menu).getMenuItems().get(i) == null) return false;
	     }
	     
	    return true;
	}
	
	
}
