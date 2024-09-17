package src;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	
	static final int SCREENWIDTH = 600;
	static final int SCREENHEIGHT = 600;
	static final int UNITSIZE = 25;
	static final int GAMEUNIT = (SCREENWIDTH * SCREENHEIGHT) / UNITSIZE;
	static final int DELAY = 75;
	final int x[] = new int[GAMEUNIT];
	final int y[] =  new int[GAMEUNIT];
	int bodyParts = 6;
	int applesEaten;
	int appleX;
	int appleY;
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;
	
	GamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		for(int i=0; i<SCREENHEIGHT/UNITSIZE; i++) {
			g.drawLine(i*UNITSIZE, 0, i*UNITSIZE, SCREENHEIGHT);
			g.drawLine(0, i*UNITSIZE, SCREENWIDTH, i*UNITSIZE);
		}
		g.setColor(Color.red);
		g.fillOval(appleX, appleY, UNITSIZE, UNITSIZE);
	}
	public void newApple() {
		appleX = random.nextInt((int)(SCREENWIDTH/UNITSIZE)*UNITSIZE);
		appleY = random.nextInt((int)(SCREENHEIGHT/UNITSIZE)*UNITSIZE);
	}
	public void move() {
		for(int i=bodyParts; i>0; i--) {
			g.drawLine(i*UNITSIZE, 0, i*UNITSIZE, SCREENHEIGHT);
			g.drawLine(0, i*UNITSIZE, SCREENWIDTH, i*UNITSIZE);
		}
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
