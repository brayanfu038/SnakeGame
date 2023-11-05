package view;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GameFrame extends JFrame {
	
	private MenuPanel menuPanel;
    private GamePanel gamePanel;
	
	public GameFrame() throws InterruptedException, IOException { 
		this.add((menuPanel=new MenuPanel(this)));
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		}
	 public void startGame(String playerName) throws InterruptedException, IOException {
	        if (!playerName.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "¡Hola, " + playerName + "! Juego iniciado.");

	            gamePanel = new GamePanel();
	            getContentPane().remove(menuPanel);
	            getContentPane().add(gamePanel);
	            revalidate();
	        } else {
	            JOptionPane.showMessageDialog(null, "Por favor ingrese su nombre.");
	        }
	    }
	
	public static void main(String[] args) throws InterruptedException, IOException {
		new GameFrame();
	}
}
