import presentation.MainGUI;
import presentation.*;
import bll.model.DeliveryService;
import controller.ControllerClient;
import controller.ControllerMain;
public class App {
	public static void main(String[] args) {
		DeliveryService delivery = new DeliveryService();
		MainGUI mainWindow = new MainGUI(delivery);
		mainWindow.setVisible(true);
		
		new ControllerMain(mainWindow, delivery);
		
		
	     
	}
}
