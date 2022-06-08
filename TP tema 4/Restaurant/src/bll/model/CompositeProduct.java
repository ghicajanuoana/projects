package bll.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositeProduct extends MenuItem implements Serializable{
	
	private List<MenuItem> lista;
	
	public CompositeProduct(String title) {
		super(title);
		lista = new ArrayList<>();
	}
	/*
	public CompositeProduct(List<MenuItem> lista) {
        this.lista = lista;
    }
    */
	
	@Override
	public String getRating() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCalories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProtein() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSodium() {
		// TODO Auto-generated method stub
		return null;
	}

	 @Override
	public String computePrice() {
		 String price = null;
	    for (MenuItem menuItem : lista) {
	         price += menuItem.computePrice();
	    }
	    
	    return price;
	}
	
	 @Override
	    public int hashCode() {
	        return Objects.hash(getTitle(), lista);
	    }

	@Override
	public List<MenuItem> getMenuItems() {
		// TODO Auto-generated method stub
		return lista;
	}
	
	

}
