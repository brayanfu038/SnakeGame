package view;


import javax.swing.*;

import tools.FileManagerReader;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

class MenuPanel extends JPanel {
    private JTextField nameField;
    private GameFrame gameFrame;
    FileManagerReader reader;

    public MenuPanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        
        try {
            Image backgroundImage = ImageIO.read(new File("img//Panel.png"));
            Image scaledImage = backgroundImage.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
            setLayout(new BorderLayout());
            setOpaque(false);

            JLabel backgroundImageLabel = new JLabel(new ImageIcon(scaledImage));
            add(backgroundImageLabel);
            backgroundImageLabel.setLayout(new GridLayout(5, 1));

            JLabel titleLabel = new JLabel("¡Bienvenido al Juego!");
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            backgroundImageLabel.add(titleLabel);

            JPanel inputPanel = new JPanel();
            inputPanel.setOpaque(false);
            JLabel nameLabel = new JLabel("Ingrese su nombre: ");
            nameField = new JTextField(15);
            inputPanel.add(nameLabel);
            inputPanel.add(nameField);
            backgroundImageLabel.add(inputPanel);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setOpaque(false);
            JButton startButton = new JButton("Iniciar Juego");
            startButton.addActionListener(e -> {
                try {
                    startGame();
                } catch (InterruptedException | IOException e1) {
                    e1.printStackTrace();
                }
            });
            JButton scoresButton = new JButton("Ver Historial de Puntajes");
            scoresButton.addActionListener(e -> showScoresHistory());
            buttonPanel.add(startButton);
            buttonPanel.add(scoresButton);
            backgroundImageLabel.add(buttonPanel);

            // Añade JComboBox con diferentes niveles
            String[] niveles = {"Bajo", "Medio", "Alto"};
            JComboBox<String> nivelesComboBox = new JComboBox<>(niveles);
            buttonPanel.add(nivelesComboBox);
            backgroundImageLabel.add(buttonPanel);
            nivelesComboBox.addActionListener(e -> {
                String nivelSeleccionado = (String) nivelesComboBox.getSelectedItem();
                // Realiza acciones basadas en el nivel seleccionado
                switch (nivelSeleccionado) {
                    case "Bajo":
					try {
						reader = new FileManagerReader("resources//","lvlFacil");
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
                        // Acciones para el nivel bajo
                    	
                        System.out.println("Nivel seleccionado: Bajo");
                        break;
                    case "Medio":
                        // Acciones para el nivel medio
                        System.out.println("Nivel seleccionado: Medio");
                        break;
                    case "Alto":
                        // Acciones para el nivel alto
                        System.out.println("Nivel seleccionado: Alto");
                        break;
                    default:
                        break;
                }
            });

            JPanel developerPanel = new JPanel();
            developerPanel.setOpaque(false);
            developerPanel.setLayout(new GridLayout(7, 1));
            developerPanel.add(new JLabel("Información del Desarrollador:"));
            developerPanel.add(new JLabel("Nombre: Brayan Daniel Fuquene"));
            developerPanel.add(new JLabel("Cod Estudiante: 202114796"));
            developerPanel.add(new JLabel("Facultad: Ingeniería De Sistemas"));
            developerPanel.add(new JLabel("UPTC"));
            developerPanel.add(new JLabel("Año: 2023"));
            developerPanel.add(new JLabel("Curso: Programación "));
            backgroundImageLabel.add(developerPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startGame() throws InterruptedException, IOException {
        String playerName = nameField.getText();
        gameFrame.startGame(playerName);
    }

    private void showScoresHistory() {
        JOptionPane.showMessageDialog(null, "Historial de puntajes...");
    }
}
