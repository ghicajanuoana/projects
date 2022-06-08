package bll.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class MenuItem implements Serializable{
	 
	 public String title;

     public MenuItem(String title) {
        this.title = title;
     }

     public String getTitle() {
        return title;
     }
     public void setTitle(String title) {
    	 this.title=title;
     }
	 public abstract String getRating();
	 public abstract String getCalories();
	 public abstract String getProtein();
	 public abstract String getFat();
	 public abstract String getSodium();
	 public abstract String computePrice();
	
	 
	 public void addNewProduct(MenuItem m) {
	        throw new UnsupportedOperationException();
	 }

	 public void removeProduct(MenuItem m) {
	        throw new UnsupportedOperationException();
	 }

	 public abstract List<MenuItem> getMenuItems();
	 

}
