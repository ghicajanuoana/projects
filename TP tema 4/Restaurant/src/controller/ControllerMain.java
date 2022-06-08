package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bll.model.DeliveryService;
import presentation.*;
import presentation.MainGUI;

public class ControllerMain {
	MainGUI mainWindow;
	private DeliveryService delivery;
	public ControllerMain(MainGUI mainWindow, DeliveryService d) {
		this.mainWindow=mainWindow;
		this.delivery = d;
	    mainWindow.clientListener(new ClientButtonListener());
	    mainWindow.adminListener(new AdminButtonListener());
	    
	}
	public class ClientButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ClientGUI clientgui = new ClientGUI();
			ControllerClient c = new ControllerClient(clientgui,delivery);
		}
		
	}
	public class AdminButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//AdministratorView admingui = new AdministratorView();
			UserLogin login = new UserLogin(delivery);
		}
	}
}
