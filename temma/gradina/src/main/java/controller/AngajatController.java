package main.java.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import main.java.model.PersistentaPlanta;
import main.java.model.Planta;
import main.java.view.AngajatView;
public class AngajatController {
	 AngajatView angajatView;

	    public AngajatController(AngajatView a){
	        this.angajatView=a;

	        angajatView.getCautaButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    List<Planta>lista=new ArrayList<>();
	                    for (Planta planta : PersistentaPlanta.getInstance().getListaPlante()) {
	                        if (angajatView.getCautaField().getText().equals(planta.getNume())){
	                            lista.add(planta);
	                        }
	                    }
	                    if(angajatView.getCautaField().getText().equals("")){
	                        throw new Exception("Introduceti un nume");
	                    }
	                    if(lista.size()==0){
	                        throw new Exception("Nu exista plante cu acest nume");
	                    }

	                    angajatView.setTabelPlante(lista);
	                    angajatView.getCautaField().setText("");
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });

	        angajatView.getFiltreazaSpecieButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    List<Planta>lista=new ArrayList<>();
	                    for (Planta planta : PersistentaPlanta.getInstance().getListaPlante()) {
	                        if (angajatView.getSpecieField().getText().equals(planta.getSpecie())){
	                            lista.add(planta);
	                        }
	                    }
	                    if(angajatView.getSpecieField().getText().equals("")){
	                        throw new Exception("Introduceti o specie");
	                    }
	                    if(lista.size()==0){
	                        throw new Exception("Nu exista plante cu aceasta specie");
	                    }

	                    angajatView.setTabelPlante(lista);
	                    angajatView.getSpecieField().setText("");
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }

	        });

	        angajatView.getFiltreazaTipButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    List<Planta>lista=new ArrayList<>();
	                    for (Planta animal : PersistentaPlanta.getInstance().getListaPlante()) {
	                        if (angajatView.getTipField().getText().equals(animal.getTip())){
	                            lista.add(animal);
	                        }
	                    }
	                    if(angajatView.getTipField().getText().equals("")){
	                        throw new Exception("Introduceti un tip");
	                    }
	                    if(lista.size()==0){
	                        throw new Exception("Nu exista plante de acest tip");
	                    }

	                    angajatView.setTabelPlante(lista);
	                    angajatView.getTipField().setText("");
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });

	        angajatView.getFiltreazaHabitatButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    List<Planta>lista=new ArrayList<>();
	                    for (Planta planta : PersistentaPlanta.getInstance().getListaPlante()) {
	                        if (angajatView.getZonaField().getText().equals(planta.getZona())){
	                            lista.add(planta);
	                        }
	                    }
	                    if(angajatView.getZonaField().getText().equals("")){
	                        throw new Exception("Introduceti o zona");
	                    }
	                    if(lista.size()==0){
	                        throw new Exception("Nu exista plante din aceasta zona");
	                    }

	                    angajatView.setTabelPlante(lista);
	                    angajatView.getZonaField().setText("");
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });

	        angajatView.getShowButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    List<Planta> lista = new ArrayList<>(PersistentaPlanta.getInstance().getListaPlante());
	                    if(lista.size()==0){
	                        throw new Exception("Nu exista plante");
	                    }

	                    angajatView.setTabelPlante(lista);

	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });

	        angajatView.getAddButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try{
	                    for(Planta planta:PersistentaPlanta.getInstance().getListaPlante()){
	                        if(planta.getNume().equals(angajatView.getAddNameTextField().getText())){
	                            throw new Exception("Planta exista deja");
	                        }
	                    }
	                    Planta planta=new Planta(angajatView.getAddNameTextField().getText(),angajatView.getAddTipTextField().getText(),angajatView.getAddSpecieTextField().getText(),angajatView.getAddZonaTextField().getText());
	                    PersistentaPlanta.getInstance().salvarePlanta(planta);
	                    angajatView.setTabelPlante(PersistentaPlanta.getInstance().getListaPlante());
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });

	        angajatView.getUpdateButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try{
	                    List<Planta> lista=new ArrayList<>();

	                    for(Planta planta:PersistentaPlanta.getInstance().getListaPlante()) {
	                        if (planta.getNume().equals(angajatView.getAddNameTextField().getText())) {
	                            lista.add(planta);
	                        }
	                    }
	                    if(lista.size()==0){
	                        throw new Exception("Nu exista planta cu acest nume");
	                    }
	                    Planta plantaNoua=new Planta();
	                    Planta plantaVeche=new Planta();
	                    for(Planta planta:PersistentaPlanta.getInstance().getListaPlante()){
	                        if(planta.getNume().equals(angajatView.getAddNameTextField().getText())){
	                            plantaVeche.setNume(planta.getNume());
	                            plantaVeche.setTip(planta.getTip());
	                            plantaVeche.setSpecie(planta.getSpecie());
	                            plantaVeche.setZona(planta.getZona());


	                            planta.setSpecie(angajatView.getAddSpecieTextField().getText());
	                            planta.setZona(angajatView.getAddZonaTextField().getText());
	                            planta.setTip(angajatView.getAddTipTextField().getText());


	                            plantaNoua.setNume(planta.getNume());
	                            plantaNoua.setTip(planta.getTip());
	                            plantaNoua.setSpecie(planta.getSpecie());
	                            plantaNoua.setZona(planta.getZona());

	                        }
	                    }
	                    PersistentaPlanta.getInstance().actualizarePlanta(plantaVeche,plantaNoua);
	                    angajatView.setTabelPlante(PersistentaPlanta.getInstance().getListaPlante());

	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });

	        angajatView.getDeleteButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try{
	                    Planta planta= angajatView.getPlanta();
	                    if(planta==null){
	                        throw new Exception("Nu s-a selectat planta");
	                    }

	                    PersistentaPlanta.getInstance().stergerePlanta(planta);
	                    angajatView.setTabelPlante(PersistentaPlanta.getInstance().getListaPlante());

	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });

	       

	        angajatView.getRomana().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Locale locale=new Locale("ro","RO");
	                angajatView.onLocaleChange(locale);
	            }
	        });

	        angajatView.getEngleza().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Locale locale=new Locale("en","US");
	                angajatView.onLocaleChange(locale);
	            }
	        });

	        angajatView.getFranceza().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                Locale locale=new Locale("fr","FR");
	                angajatView.onLocaleChange(locale);
	            }
	        });
	    }
}
