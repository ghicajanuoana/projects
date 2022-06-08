package main.java.Main;

import main.java.controller.VizitatorController;
import main.java.view.VizitatorView;

public class App {
	public static void main( String[] args )
    {
        VizitatorView vizitatorView=new VizitatorView();
        VizitatorController vizitatorController=new VizitatorController(vizitatorView);
    }
}
