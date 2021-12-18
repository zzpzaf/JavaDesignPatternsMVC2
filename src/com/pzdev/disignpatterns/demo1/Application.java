package com.pzdev.disignpatterns.demo1;

import javax.swing.SwingUtilities;

import com.pzdev.disignpatterns.demo1.controller.Controller;
import com.pzdev.disignpatterns.demo1.model.Model;
import com.pzdev.disignpatterns.demo1.view.View;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				runApp();
			}
		});
	}
	
	private static void runApp() {
		// TODO Auto-generated method stub
		
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view); 
		
		view.setLoginListener(controller);
		
		view.showWindow();
		
	}

}
