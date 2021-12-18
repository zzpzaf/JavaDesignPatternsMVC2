package com.pzdev.disignpatterns.demo1.view;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.pzdev.disignpatterns.demo1.model.Model;

public class View extends JFrame implements ActionListener{
	
	//private Model model;
	private GridBagConstraints gc = new GridBagConstraints();

	private JButton okButton;
	private JButton exitButton;
	
	private JTextField nameField;
	private JPasswordField passField;
	
	private JLabel nameLabel;
	private JLabel passwLabel;
	
	
	private LoginListener loginListener;
	
	
	public View() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super("MVC Demo");
		//this.model = model;
	}

	public void setLoginListener(LoginListener loginListener) {
		this.loginListener = loginListener;
	}
	
	
	
	public void showWindow() {
		

				
		okButton = createButton("OK");
		exitButton = createButton("Exit");
		
		nameLabel = createLabel("User Name: ");
		passwLabel = createLabel("Password: ");
		
		nameField = new JTextField(10);
		passField = new JPasswordField(10);
		
		addElementsToGrid();
		
		//addActionListenerToButton(okButton);
		okButton.addActionListener(this);
		
		// Here we instantiate a new anonymous class implementing directly 
		// the ActionListener Interface and overrides its method
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("App terminated!");
				System.exit(0);
			}
			
		});
		
	}

	
	private JLabel createLabel(String labelText) {
		JLabel label = new JLabel(labelText);
		return label;
	}
	
	
	private JButton createButton(String buttonText) {
		JButton button = new JButton(buttonText);
		return button;
	}
	
	
	private void addElementsToGrid() {
		
		
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(600, 500);

		setVisible(true);

		// nameLabel
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		gc.gridx=1;
		gc.gridy=1;
		gc.weightx=1;
		gc.weighty=1;
		gc.insets = new Insets(100, 0, 0, 10);
		gc.fill=GridBagConstraints.NONE;
		add(nameLabel, gc);
		
		// nameField
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx=2;
		gc.gridy=1;
		gc.weightx=1;
		gc.weighty=1;
		gc.insets = new Insets(100, 0, 0, 0);
		gc.fill=GridBagConstraints.NONE;
		add(nameField, gc);
		
		// passwLabel
		gc.anchor = GridBagConstraints.LINE_END;
		gc.gridx=1;
		gc.gridy=2;
		gc.weightx=1;
		gc.weighty=1;
		gc.insets = new Insets(0, 0, 0, 10);
		gc.fill=GridBagConstraints.NONE;
		add(passwLabel, gc);
		
		// passwField
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx=2;
		gc.gridy=2;
		gc.weightx=1;
		gc.weighty=1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.fill=GridBagConstraints.NONE;
		add(passField, gc);
		
		// okButton
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx=2;
		gc.gridy=3;
		gc.weightx=1;
		gc.weighty=100;
		gc.fill=GridBagConstraints.NONE;
		
		add(okButton, gc);
		

		// exitButton
		exitButton.setForeground(Color.RED);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx=2;
		gc.gridy=4;
		gc.weightx=1;
		gc.weighty=600;
		gc.fill=GridBagConstraints.NONE;
		
		add(exitButton, gc);
		
		
	}
	
	
	
	
	
//	private void addActionListenerToButton(JButton button) {
//		button.addActionListener(this);
//	}

	
	
	

	// This is the abstract method of the ActionListener Interface that should be implemented
	// https://docs.oracle.com/javase/8/docs/api/java/awt/event/ActionListener.html
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		JButton sourceButton = (JButton)e.getSource();
		
		if(sourceButton == okButton) {
			
			
			String password = new String(passField.getPassword());
			String name = nameField.getText();
			
			if (name.trim().length() == 0 || password.trim().length() == 0 ) return;
			

			//fireLoginEvent( "Use Naem: " + name + " Password: " + password );
			fireLoginEvent( new LoginFormEvent(name, password) );

		}

		
	}
	
	
	private void fireLoginEvent(LoginFormEvent event) {
	
		if(loginListener != null) {
			loginListener.loginPerformed(event);
		}
	}


}

