package main.java.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import main.java.model.Planta;
import main.java.model.Utilizator;
import main.java.model.PersistentaPlanta;
import main.java.model.PersistentaUtilizator;
import main.java.view.AdministratorView;
import main.java.view.AngajatView;

public class AdministratorController {
	AdministratorView administratorView;
	
	
	public AdministratorController(AdministratorView a) {
		// TODO Auto-generated constructor stub
		this.administratorView=a;

		administratorView.romanaListener(new RomanaBtnListener());
		administratorView.englezaListener(new EnglezaBtnListener());
		administratorView.francezaListener(new FrancezaBtnListener());
		
		administratorView.getAdauga().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
                    Utilizator user=new Utilizator(administratorView.getUserID().getText(),administratorView.getUserName().getText(),administratorView.getUserPass().getText(),administratorView.getRole().getText());
                    PersistentaUtilizator.getInstance().insertUser(user);
                    administratorView.setTabel(PersistentaUtilizator.getInstance().getLista());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
			}
		});
		administratorView.getShow().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Utilizator> lista = new ArrayList<>(PersistentaUtilizator.getInstance().getLista());
                    if(lista.size()==0){
                        throw new Exception("Nu exista utilizatori");
                    }

                    administratorView.setTabel(lista);

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
		administratorView.getDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Utilizator planta= administratorView.getUser();
                    if(planta==null){
                        throw new Exception("Nu s-a selectat user");
                    }

                    PersistentaUtilizator.getInstance().stergereUtilizator(planta);
                    administratorView.setTabel(PersistentaUtilizator.getInstance().getLista());

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
		
	}
	public class RomanaBtnListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Locale locale=new Locale("ro","RO");
	            administratorView.changeText(locale);
			}
			
		}
		public class EnglezaBtnListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Locale locale=new Locale("en","EN");
	            administratorView.changeText(locale);
			}
			
		}
		public class FrancezaBtnListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Locale locale=new Locale("fr","FR");
	            administratorView.changeText(locale);
			}
			
		}
}
