package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainActivity {
	public static void main(String[] args) {
		ImageIcon image = new ImageIcon("code.jpeg");
//		JLabel is u GUI component to display area for a string of text, an image, or both
		JLabel label = new JLabel();
		label.setText("Bro, do you even code?");
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.add(label);
	}
}
