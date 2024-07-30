package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class MainActivity {
	public static void main(String[] args) {
		// Crée une nouvelle fenêtre (JFrame)
        JFrame frame = new JFrame("Exemple de GridBagLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        JLabel headerLeftHeader = new JLabel();
        headerLeftHeader.setText("Header Left");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(headerLeftHeader, gbc);

        JLabel headerRight = new JLabel();
        headerRight.setText("Header Right");

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(headerRight, gbc);

        JLabel infoLabel = new JLabel("Billet");
        infoLabel.setText("Lorem .");
        // infoLabel.setHorizontalTextPosition(JLabel.CENTER);

        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(infoLabel, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);
        frame.add(panel);
        // Rendre le frame visible
        frame.setVisible(true);
	}
}
