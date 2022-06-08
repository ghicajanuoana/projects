package polinom.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import polinom.model.Polinom;
import polinom.view.View;


public class Controller implements ActionListener{
	View view;
	String[] m1;
	String[] m2;
	public Controller(View v) {
		this.view = v;
	}
	private Polinom aduna(String p1, String p2) {
    	Polinom poli1, poli2, poli3;
    	poli1 = integrareDeriv(p1);
    	poli2 = integrareDeriv(p2);
    	poli3 = poli1.addPolinom(poli2);
    	return poli3;
    }
    
    private Polinom scadere(String p1, String p2) {
    	Polinom poli1, poli2, poli3;
    	poli1 = integrareDeriv(p1);
    	poli2 = integrareDeriv(p2);
    	poli3 = poli1.scadePolinom(poli2);
    	return poli3;
    }
    
    private Polinom inmultire(String p1, String p2) {
    	Polinom poli1, poli2, poli3;
    	poli1 = integrareDeriv(p1);
    	poli2 = integrareDeriv(p2);
    	poli3 = poli1.inmultestePol(poli2);
    	return poli3;
    }
	
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        
        if(command.equals("enter1"))  {     //integrare derivare pol 1
            String string = view.txtPol1.getText();
        	Polinom polinom = this.integrareDeriv(string);
        	view.lblP1.setText("Rezultat polinom 1: " );
        	view.lblRezP1.setText("Polinom 1: " + polinom.afisarePolinom()  );
        } else if(command.equals("enter2")) {   //integrare derivare pol 2
            String string = view.txtPol2.getText();
        	Polinom poli =  this.integrareDeriv(string);
        	view.lblP2.setText("Rezultat polinom 2: " );
        	view.lblRezP2.setText( poli.afisarePolinom());
        } else if(command.equals("aduna")) {  //aduna
            String pol1 = view.txtPol1.getText();
            String pol2 = view.txtPol2.getText();
        	Polinom poli3 = this.aduna(pol1, pol2);
        	view.lblSuma.setText("Suma");
        	view.lblRezSuma.setText(poli3.afisarePolinom() );
        } else if(command.equals("scade")) {   //scade
            String pol1 = view.txtPol1.getText();
            String pol2 = view.txtPol2.getText();
        	Polinom poli3 = this.scadere(pol1, pol2);
        	view.lblScadere.setText("Scadere");
        	view.lblRezScadere.setText(poli3.afisarePolinom() );
        } else if(command.equals("inmulteste")) {  //inmultire
            String pol1 = view.txtPol1.getText();
            String pol2 = view.txtPol2.getText();
        	Polinom poli3 = this.inmultire(pol1, pol2);
        	view.lblInmultire.setText("Inmultire");
        	view.lblRezInmultire.setText(poli3.afisarePolinom() );
        } 
    }
    
    private Polinom integrareDeriv(String string) {
    	String monoame[];
    	String rezPol;
    	if(string.toLowerCase().contains("deriveaza")) {
    		string.trim().replace("deriveaza", "");   
    		String polinom = (string.contains("-")) ? string.replace("-", "+-") : string;
        	rezPol = (polinom.charAt(0) == '+') ? polinom.substring(1) : polinom;
        	monoame = rezPol.split("\\+"); 
        	Polinom poli = new Polinom(monoame);
        	poli.deriv();
        	return poli;
    	} else if(string.toLowerCase().contains("integreaza")) {
    		string.replace("integreaza", "").trim();   
    		String polinom = (string.contains("-")) ? string.replace("-", "+-") : string;
        	rezPol = (polinom.charAt(0) == '+') ? polinom.substring(1) : polinom;
        	monoame = rezPol.split("\\+"); 
        	Polinom poli = new Polinom(monoame);
        	poli.integ();
        	return poli;
    	} else {
    		String polinom = (string.contains("-")) ? string.replace("-", "+-") : string;
        	rezPol = (polinom.charAt(0) == '+') ? polinom.substring(1) : polinom;
        	monoame = rezPol.split("\\+"); 
        	Polinom poli = new Polinom(monoame);
        	return poli;
    	}
    }
    
    

}
