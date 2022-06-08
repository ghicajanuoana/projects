package main.java.controller;
import main.java.model.*;
import main.java.view.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class VizitatorController {
	VizitatorView vizitatorView;

    public VizitatorController(VizitatorView v){
        this.vizitatorView=v;
        
        vizitatorView.loginListener(new LoginButtonListener());
        
/*
        vizitatorView.getLogInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Utilizator user=null;
                    for (Utilizator utilizator : PersistentaUtilizator.getInstance().getListaUtilizatori()) {
                        if (vizitatorView.getUsername().equals(utilizator.getUsername()) && vizitatorView.getPassword().equals(utilizator.getPassword()) && vizitatorView.getRolesField().getText().equals(utilizator.getRole()) && utilizator.getRole().equals("administrator")) {
                            user=new Utilizator(utilizator.getId(),utilizator.getUsername(),utilizator.getPassword(),utilizator.getRole());
                            AdministratorView administratorView = new AdministratorView();
                            AdministratorController administratorController=new AdministratorController(administratorView);
                            break;
                        } else if(vizitatorView.getUsername().equals(utilizator.getUsername()) && vizitatorView.getPassword().equals(utilizator.getPassword()) && vizitatorView.getRolesField().getText().equals(utilizator.getRole()) && utilizator.getRole().equals("angajat"))
                        {
                            user=new Utilizator(utilizator.getId(),utilizator.getUsername(),utilizator.getPassword(),utilizator.getRole());
                            AngajatView angajatView = new AngajatView();
                            AngajatController angajatController = new AngajatController(angajatView);

                            break;
                        }
                    }
                    if(user==null){
                        throw new Exception("Utilizator inexistent");
                    }
                    //vizitatorView.dispose();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
*/
        vizitatorView.getCautaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Planta>lista=new ArrayList<>();
                    for (Planta planta : PersistentaPlanta.getInstance().getListaPlante()) {
                        if (vizitatorView.getCautaField().getText().equals(planta.getNume())){
                            lista.add(planta);
                        }
                    }
                    if(vizitatorView.getCautaField().getText().equals("")){
                        throw new Exception("Introduceti un nume");
                    }
                    if(lista.size()==0){
                        throw new Exception("Nu exista plante cu acest nume");
                    }

                    vizitatorView.setTabelPlante(lista);
                    vizitatorView.getCautaField().setText("");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        vizitatorView.getFiltreazaSpecieButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Planta>lista=new ArrayList<>();
                    for (Planta planta : PersistentaPlanta.getInstance().getListaPlante()) {
                        if (vizitatorView.getSpecieField().getText().equals(planta.getSpecie())){
                            lista.add(planta);
                        }
                    }
                    if(vizitatorView.getSpecieField().getText().equals("")){
                        throw new Exception("Introduceti o specie");
                    }
                    if(lista.size()==0){
                        throw new Exception("Nu exista plante cu aceasta specie");
                    }

                    vizitatorView.setTabelPlante(lista);
                    vizitatorView.getSpecieField().setText("");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }

        });

        vizitatorView.getFiltreazaAlimentatieButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Planta>lista=new ArrayList<>();
                    for (Planta animal : PersistentaPlanta.getInstance().getListaPlante()) {
                        if (vizitatorView.getTipField().getText().equals(animal.getTip())){
                            lista.add(animal);
                        }
                    }
                    if(vizitatorView.getTipField().getText().equals("")){
                        throw new Exception("Introduceti un tip");
                    }
                    if(lista.size()==0){
                        throw new Exception("Nu exista plante de acest tip");
                    }

                    vizitatorView.setTabelPlante(lista);
                    vizitatorView.getTipField().setText("");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        vizitatorView.getFiltreazaHabitatButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Planta>lista=new ArrayList<>();
                    for (Planta planta : PersistentaPlanta.getInstance().getListaPlante()) {
                        if (vizitatorView.getZonaField().getText().equals(planta.getZona())){
                            lista.add(planta);
                        }
                    }
                    if(vizitatorView.getZonaField().getText().equals("")){
                        throw new Exception("Introduceti o zona");
                    }
                    if(lista.size()==0){
                        throw new Exception("Nu exista plante din aceasta zona");
                    }

                    vizitatorView.setTabelPlante(lista);
                    vizitatorView.getZonaField().setText("");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        vizitatorView.getShowButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Planta> lista = new ArrayList<>(PersistentaPlanta.getInstance().getListaPlante());
                    if(lista.size()==0){
                        throw new Exception("Nu exista plante");
                    }

                    vizitatorView.setTabelPlante(lista);

                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
/*
        vizitatorView.getLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AngajatView angajat = new AngajatView();
                //AngajatController c = new AngajatController(angajat);
            	VizitatorView v = new VizitatorView();
            	UserLogin login = new UserLogin(v);
            	
            	
            }
        });
        */
        vizitatorView.getRomana().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Locale locale=new Locale("ro","RO");
                vizitatorView.onLocaleChange(locale);
            }
        });

        vizitatorView.getEngleza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Locale locale=new Locale("en","US");
                vizitatorView.onLocaleChange(locale);
            }
        });

        vizitatorView.getFranceza().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Locale locale=new Locale("fr","FR");
                vizitatorView.onLocaleChange(locale);
            }
        });
    }
    public class LoginButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//VizitatorView v = new VizitatorView();
			UserLogin angajatlogin = new UserLogin();
		}
		
	}
}
