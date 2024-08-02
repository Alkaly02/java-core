package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MainActivity {
	public static void main(String[] args) {
		MyFrame frame2 = new MyFrame();
		ImageIcon image = new ImageIcon("code.jpeg");
		Border border = BorderFactory.createLineBorder(Color.green, 3);
//		JLabel is u GUI component to display area for a string of text, an image, or both
		JLabel label = new JLabel();
		label.setText("Bro, do you even code?");
		label.setIcon(image);
		label.setBackground(Color.BLACK);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setForeground(new Color(255,255,255));
		label.setFont(new Font("MV Boli", Font.PLAIN, 25));
		label.setBackground(Color.black);
		label.setOpaque(true);
		label.setBorder(border);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setBounds(0, 0, 500, 1000);
//		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 1100);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.add(label);
		System.out.print(Math.ceil(5.3));
	}
}
