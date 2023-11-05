package model;

import java.util.Random;

import view.GamePanel;

public class Caminante extends Thread {
	
	GamePanel panel;
	Random random;
	public boolean estado;
	public  int speed;
	public  int velocity; 
	public Caminante(GamePanel panel) {
		this.panel = panel;
		random = new Random();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (estado) {
			panel.move();
			panel.checkCollisions();
			panel.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			estado = panel.isRunning();
		}
	}
	
	public int  tasaDeAumento() {
	 	velocity -= speed;
	 	return velocity;
	}
}