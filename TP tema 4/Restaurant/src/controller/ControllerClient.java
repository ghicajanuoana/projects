package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JTextField;

import bll.model.*;
import presentation.*;

public class ControllerClient {
	private ClientGUI clientgui;
	private DeliveryService delivery;
	private Utilizator user;
	private List<BaseProduct> listaProduct;
	
	public ControllerClient(ClientGUI client, DeliveryService delivery2) {
		// TODO Auto-generated constructor stub
		this.clientgui=client;
		this.delivery=delivery2;
		
		listaProduct = new ArrayList(delivery.getProducts());
		
		clientgui.searchTitleListener(new TitleActionListener());
		clientgui.searchProteinListener(new ProteinActionListener());
		clientgui.searchFatListener(new FatActionListener());
		clientgui.searchSodiumListener(new SodiumActionListener());
		clientgui.searchCaloriesListener(new CaloriesActionListener());
		clientgui.searchRatingListener(new RatingActionListener());
		clientgui.searchPriceListener(new PriceActionListener());
		clientgui.viewListener(new ViewActionListener());
		
		clientgui.addOrderListener(new OrderActionListener());
		clientgui.createOrderListener(new CreateOrderActionListener());
		
	}
	public class TitleActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			List<BaseProduct> finalLista= new ArrayList<>();

			List<BaseProduct> listBase = delivery.getProducts();
			String name = clientgui.getTitleTxt();
			List<BaseProduct> newListBase=listBase.stream().filter( s->( name.equals("") || s.getTitle().equals(name)   )  ).collect(Collectors.toList());
			
            for(BaseProduct bs : newListBase){
            	finalLista.add(bs);
                
            }

            clientgui.setTabel(finalLista);
		}
		
	}
	public class ProteinActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			List<BaseProduct> finalLista= new ArrayList<>();

			List<BaseProduct> listBase = delivery.getProducts();
			String name = clientgui.getProteinTxt();
			List<BaseProduct> newListBase=listBase.stream().filter( s->( name.equals("") || s.getProtein().equals(name)   )  ).collect(Collectors.toList());
			
            for(BaseProduct bs : newListBase){
            	finalLista.add(bs);
                
            }

            clientgui.setTabel(finalLista);
			
	}
	}
	public class FatActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			List<BaseProduct> finalLista= new ArrayList<>();

			List<BaseProduct> listBase = delivery.getProducts();
			String name = clientgui.getFatTxt();
			List<BaseProduct> newListBase=listBase.stream().filter( s->( name.equals("") || s.getFat().equals(name)   )  ).collect(Collectors.toList());
			
            for(BaseProduct bs : newListBase){
            	finalLista.add(bs);
                
            }

            clientgui.setTabel(finalLista);
		}
		
	}
	public class SodiumActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			List<BaseProduct> finalLista= new ArrayList<>();

			List<BaseProduct> listBase = delivery.getProducts();
			String name = clientgui.getSodiumTxt();
			List<BaseProduct> newListBase=listBase.stream().filter( s->( name.equals("") || s.getSodium().equals(name)   )  ).collect(Collectors.toList());
			
            for(BaseProduct bs : newListBase){
            	finalLista.add(bs);
                
            }

            clientgui.setTabel(finalLista);
		}
		
	}
	public class CaloriesActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			List<BaseProduct> finalLista= new ArrayList<>();

			List<BaseProduct> listBase = delivery.getProducts();
			String name = clientgui.getCaloriesTxt();
			List<BaseProduct> newListBase=listBase.stream().filter( s->( name.equals("") || s.getCalories().equals(name)   )  ).collect(Collectors.toList());
			
            for(BaseProduct bs : newListBase){
            	finalLista.add(bs);
                
            }

            clientgui.setTabel(finalLista);
		}
		
	}
	public class RatingActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			List<BaseProduct> finalLista= new ArrayList<>();

			List<BaseProduct> listBase = delivery.getProducts();
			String name = clientgui.getRatingTxt();
			List<BaseProduct> newListBase=listBase.stream().filter( s->( name.equals("") || s.getRating().equals(name)   )  ).collect(Collectors.toList());
			
            for(BaseProduct bs : newListBase){
            	finalLista.add(bs);
                
            }

            clientgui.setTabel(finalLista);
		}
		
	}
	public class PriceActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			List<BaseProduct> finalLista= new ArrayList<>();

			List<BaseProduct> listBase = delivery.getProducts();
			String name = clientgui.getPriceTxt();
			List<BaseProduct> newListBase=listBase.stream().filter( s->( name.equals("") || s.computePrice().equals(name)   )  ).collect(Collectors.toList());
			
            for(BaseProduct bs : newListBase){
            	finalLista.add(bs);
                
            }

            clientgui.setTabel(finalLista);
		}
		
	}
	public class ViewActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
                List<BaseProduct> lista = new ArrayList<>(delivery.getProducts());
                if(lista.size()==0){
                    throw new Exception("Nu exista produse");
                }

                clientgui.setTabel(lista);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
			
			
		}
		
	}
	
	public class CreateOrderActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			List<BaseProduct> lista= delivery.getProducts();
			String name= clientgui.getTitleTxt();
            
            List<BaseProduct> lista2 = new ArrayList<>();
            lista2= lista.stream().filter((s)->s.getTitle().equals(name)).collect(Collectors.toList());
            lista2.forEach(s->listaProduct.add(s));
            
            StringBuilder string= new StringBuilder();
            for(BaseProduct base : listaProduct)
            {
            	string.append(base.toString());
            	string.append("\n\n");
            }
            clientgui.setOrders(string.toString());
			
		}
	}
	
	
	public class OrderActionListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int idClient=0;
			String date = new String();
			double price=0;
			
			Order order=new Order(delivery.getOrders().size(),idClient, date, price);
			
            delivery.addOrder(order);
            delivery.notificationOrder(order);
            clientgui.setOrders("");
		}
	}
}
