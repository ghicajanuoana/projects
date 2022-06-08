package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bll.model.DeliveryService;

import javax.swing.*;

public class MainGUI extends JFrame{
	JPanel panel = new JPanel();
	ClientGUI clientgui;
	AdministratorView admingui;
	JButton btnClient = new JButton("Client");
	JButton btnAdmin = new JButton("Login");
	DeliveryService delivery;
	public MainGUI(DeliveryService d ) {
		this.delivery=d;
		this.setSize(500, 400);  
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true); 
        
        this.add(panel);
        
		this.clientgui=clientgui;
		btnClient.setBounds(50,100,80,30);
        btnClient.setBackground(Color.green);
	    panel.add(btnClient);
	    
	    this.admingui=admingui;
	    btnAdmin.setBounds(80,80,100,70);
        btnAdmin.setBackground(Color.green);
	    panel.add(btnAdmin);
	    
	   // btnClient.addActionListener(clientButton);
	    
	}
	
	public void clientListener(ActionListener clientButton) {
        this.btnClient.addActionListener(clientButton);
    }
	public void adminListener(ActionListener adminButton) {
        this.btnAdmin.addActionListener(adminButton);
    }
	
	
}
