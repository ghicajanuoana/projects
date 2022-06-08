package dataaccess;
import bll.model.BaseProduct;
import bll.model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWriter {

	//public String file = "products.csv";
    //private  String Regex = "[,]";
	
	
	public static  List<BaseProduct> readDataLineByLine(String filename) throws IOException
	{ List<BaseProduct> baseList = new ArrayList<>();
	  Pattern pattern = Pattern.compile("[,]");
		try { 
    			
			    List<String> allLines= (List<String>) Files.lines(Path.of(filename)).collect(Collectors.toList());
    			allLines.remove(0); //pentru a nu aparea exceptia concurrentModificationException
    			for (String line : allLines) {
    				String[] arr = line.split(String.valueOf(pattern));
    		          BaseProduct produs = new BaseProduct(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);

    		           baseList.add(produs);
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
		return baseList;
		
	}
	/*
	public static  List<Order> readDataLineByLineOrder(String filename) throws IOException
	{ List<Order> orderList = new ArrayList<>();
	  Pattern pattern = Pattern.compile("[,]");
		try { 
    			
			    List<String> allLinesOrder= (List<String>) Files.lines(Path.of(filename)).collect(Collectors.toList());
    			allLinesOrder.remove(0); //pentru a nu aparea exceptia concurrentModificationException
    			for (String line : allLinesOrder) {
    				String[] arr = line.split(String.valueOf(pattern));
    				Order order = new Order(Integer.parseInt(arr[0]), 
    						                 Integer.parseInt(arr[1]), 
    						                 arr[2], 
    						                 Double.parseDouble(arr[3]));

    		           orderList.add(order);
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
		return orderList;
		
	}
	*/
	
  /*  
    	public static void main(String[] args) {
    		try {
    			List<String> allLines = Files.readAllLines(Paths.get("C:/Users/ghica/OneDrive/Desktop/TP tema 4/Restaurant/products.csv"));
    			for (String line : allLines) {
    				System.out.println(line);
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    */
    }

