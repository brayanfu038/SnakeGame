package model;

import view.GamePanel;

public class ManagerBarriers extends Thread {
	int countBarriers = 4;
	GamePanel panel;
	public int timeObstacle;
	
	public ManagerBarriers(GamePanel panel) {
		this.panel = panel;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		this.createBarriers();
		while (panel.running) {
			this.addPosition();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void createBarriers() {
		for (int i = 0; i < countBarriers; i++) {
			this.panel.barriers.add(new Barrier(panel));
		}
	}

	public void addPosition() {
		for (int i = 0; i < panel.barriers.size(); i++) {
			this.panel.barriers.get(i).addPosition();
		}
	}

}