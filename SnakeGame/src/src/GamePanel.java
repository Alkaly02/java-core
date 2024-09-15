package src;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
	
	static final int SCREENWIDTH = 600;
	static final int SCREENHEIGHT = 600;
	static final int UNITSIZE = 25;
	static final int GAMEUNIT = (SCREENWIDTH * SCREENHEIGHT) / UNITSIZE;
	
	GamePanel(){
		
	}
	public void startGame() {
		
	}
	public void paintComponent(Graphics g) {
		
	}
	public void draw(Graphics g) {
		
	}
	public void move() {
		
	}
	public void checkApple() {
		
	}
	public void checkCollision() {
		
	}
	public void gameOver(Graphics g) {
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}
}
