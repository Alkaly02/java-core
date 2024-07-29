package models;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
//	JFrame is GUI window to add components to
	public MyFrame(){
		this.setTitle("Image trester");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(420, 420);
		this.setVisible(true);
		
		ImageIcon image = new ImageIcon("image.png");
		this.setIconImage(image.getImage());
		this.getContentPane().setBackground(new Color(123,50,255));
	}
}
