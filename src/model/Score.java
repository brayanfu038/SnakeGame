package model;

import view.GamePanel;

public  class Score extends Thread{
	GamePanel panel;
	
	public Score(GamePanel panel) {
		// TODO Auto-generated constructor stub
		this.panel = panel;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (panel.isRunning()) {
			this.checkApple();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public synchronized void checkApple() {
		if( (panel.x[0] == panel.appleX ) && (panel.y[0] == panel.appleY) ) {
			panel.apple.interrupt();
			panel.bodyParts++;
			panel.applesEaten++;
			
		}	
	}		
}