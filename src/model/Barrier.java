package model;

import view.GamePanel;

import java.util.Random;

public class Barrier {

	public int positionX;
	public int positionY;
	GamePanel panel;
	Random random;

	public Barrier(GamePanel panel) {
		this.panel = panel;
		random = new Random();
	}

	public void addPosition() {
		int tempX = random.nextInt((int) GamePanel.SCREEN_WIDTH / GamePanel.UNIT_SIZE) * GamePanel.UNIT_SIZE;
		int tempY = random.nextInt((int) GamePanel.SCREEN_HEIGHT / GamePanel.UNIT_SIZE) * GamePanel.UNIT_SIZE;
		if (this.checkposition(tempX, tempY)) {
			this.positionX = tempX;
			this.positionY = tempY;
		} else {
			this.addPosition();
		}
	}

	public boolean checkposition(int x, int y) {
		boolean estate = true;
		for (int i = panel.bodyParts; i > 0; i--) {
			if (panel.x[i] == x || panel.y[i] == y) {
				estate = false;
			}
		}
		return estate;
	}
}