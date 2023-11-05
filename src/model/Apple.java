package model;

import java.util.Random;

import view.GamePanel;

public class Apple extends Thread {
	
	public GamePanel panel;
	public Random random;
	public int timeFood;
	public Apple(GamePanel panel) {
		// TODO Auto-generated constructor stub
		this.panel = panel;
		random = new Random();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (panel.running) {
			this.newApple();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
			}
			
		}
	}
			
	public void newApple() {
		int tempX = random.nextInt((int)panel.SCREEN_WIDTH/panel.UNIT_SIZE)*panel.UNIT_SIZE;
		int tempY = random.nextInt((int)panel.SCREEN_HEIGHT/panel.UNIT_SIZE)*panel.UNIT_SIZE;	
		if(this.checkposition(tempX,tempY)) {
			panel.appleX= tempX;
			panel.appleY= 	tempY;
		}else {
			this.newApple();
		}				
	}
	public boolean checkposition(int x , int y){
		boolean estate = true;
		for (int i = panel.bodyParts; i<0; i--) {
			if(panel.x[i]== x || panel.y[i] == y) {
				estate = false;
			}
		}
		return estate;
	}
	
}