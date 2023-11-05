package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;

import model.Apple;
import model.Barrier;
import model.Caminante;
import model.ManagerBarriers;
import model.Score;
import tools.FileWriterBinary;

public class GamePanel extends JPanel implements ActionListener {

	public static final int SCREEN_WIDTH = 600;
	public static final int SCREEN_HEIGHT = 600;
	public static final int UNIT_SIZE = 25;
	public static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	public static final int DELAY = 200;
	public final int x[] = new int[GAME_UNITS];
	public final int y[] = new int[GAME_UNITS];
	public int bodyParts = 5;
	public int applesEaten;
	public int appleX;
	public int appleY;
	public char direction = 'R';
	public boolean running = false;
	public Random random;
	public Apple apple;
	public Score score;
	public Caminante caminante;
	public ArrayList<Barrier> barriers;
	ManagerBarriers manager;
	private BufferedImage obstaculoImage;
	private BufferedImage resizedImage;
	private BufferedImage appleImage;

	public GamePanel() throws InterruptedException, IOException {
		// TODO Auto-generated constructor stub
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}

	public void startGame() throws InterruptedException, IOException {
		barriers = new ArrayList();
		this.readImage();
		resizedImage = new BufferedImage(UNIT_SIZE, UNIT_SIZE, BufferedImage.TYPE_INT_ARGB);
		caminante = new Caminante(this);
		apple = new Apple(this);
		score = new Score(this);
		manager = new ManagerBarriers(this);
		running = true;
		apple.start();
		score.start();
		manager.start();
		this.avanzar();
	}
	
	public void readImage() throws IOException {
		obstaculoImage = ImageIO.read(new File("img//bomba.png"));
		appleImage = ImageIO.read(new File("img//manzana.png"));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			draw(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void draw(Graphics g) throws IOException {

		if (running) {
			
			g.drawImage(appleImage, appleX, appleY, UNIT_SIZE, UNIT_SIZE, null);
			for (int i = 0; i < barriers.size(); i++) {
				g.drawImage(obstaculoImage, barriers.get(i).positionX, barriers.get(i).positionY, UNIT_SIZE, UNIT_SIZE,
						null);

			}

			for (int i = 0; i < bodyParts; i++) {
				if (i == 0) {
					g.setColor(Color.GREEN);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(new Color(45, 180, 0));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.RED);
			g.setFont(new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2,
					g.getFont().getSize());
		} else {
			gameOver(g);
		}
	}

	public void move() {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		switch (direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		default:
			break;
		}

	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void checkCollisions() {

		// checks if head collides with body
		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && (y[0] == y[i])) {
				running = false;
			}
		}
		this.checkPosition();
		for (int i = barriers.size() - 1; i >= 0; i--) {
			if (x[0] == barriers.get(i).positionX && y[0] == barriers.get(i).positionY) {
				running = false;
				break;
			}
		}

	}

	public void checkPosition() {
		if (x[0] > SCREEN_WIDTH) {
			x[0] = 0;
		}

		if (x[0] < 0) {
			x[0] = SCREEN_WIDTH;
		}
		if (y[0] > SCREEN_HEIGHT) {
			y[0] = 0;
		}
		if (y[0] < 0) {
			y[0] = SCREEN_WIDTH;
		}
	}

	public void gameOver(Graphics g) throws IOException {
		FileWriterBinary fl = new FileWriterBinary("resources//puntuacion.ser");
		g.setColor(Color.RED);
		g.setFont(new Font("Ink Free", Font.BOLD, 75));
		FontMetrics metrics = getFontMetrics(g.getFont());
		g.drawString("Game Over", (SCREEN_WIDTH - metrics.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
		fl.writeInt(this.applesEaten);
	}

	public void avanzar() {
		if (!caminante.isAlive()) {
			caminante = new Caminante(this);
			caminante.estado = true;
			caminante.start();
		}
	}

	public class MyKeyAdapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if (direction != 'R') {
					direction = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if (direction != 'L') {
					direction = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if (direction != 'D') {
					direction = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if (direction != 'U') {
					direction = 'D';
				}
				break;

			default:
				break;
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
