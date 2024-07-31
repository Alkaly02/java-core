package main;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MainActivity {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 800);
		
		JPanel panel = new JPanel(new GridLayout(6,2,0,0));
		
		JLabel nomLabel = new JLabel("Nom");
		JTextField nomTextField = new JTextField();
		nomTextField.setBorder(new LineBorder(Color.BLACK,1));
		
		panel.add(nomLabel);
		panel.add(nomTextField);
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
