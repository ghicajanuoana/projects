package bll.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseProduct extends MenuItem implements Serializable{
	//private String title;
	private String rating;
    private String calories;
    private String protein;
    private String fat;
    private String sodium;
    private String price;
    
    public BaseProduct(String title,String rating, String calories, String protein, String fat, String sodium, String price) {
        super(title);
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }
    
    @Override
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
    @Override
    public String getCalories() {
        return calories;
    }
    
  
    public void setCalories(String calories) {
        this.calories = calories;
    }
    
    @Override
    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }
    
    @Override
    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }
    
    @Override
    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }
    
    @Override
    public String computePrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getTitle() {
    	return super.title;
    }
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseProduct product = (BaseProduct) o;
      
        return (rating == product.rating) &&  (calories == product.calories) && super.title.equals(product.title) && (protein == product.protein) && (fat == product.fat) && (sodium == product.sodium) && (price==product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(),rating, calories, protein, fat, sodium, price);
    }

	@Override
	public List<MenuItem> getMenuItems() {
		// TODO Auto-generated method stub
		List<MenuItem> list = new ArrayList();
        list.add(this);
        return list;
	}

	

	
    

}
