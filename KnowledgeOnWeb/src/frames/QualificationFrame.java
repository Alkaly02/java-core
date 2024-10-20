package frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QualificationFrame implements ActionListener {

    private final int INPUT_HEIGHT = 40;
    private final int INPUT_WIDTH = 400;

    JFrame frame = new JFrame("Qualification");
    JPanel panel = new JPanel();
    JPanel leftPanel = new JPanel();  // Partie gauche
    JPanel rightPanel = new JPanel(); // Partie droite

    public QualificationFrame() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Partie gauche
        leftPanel.setLayout(new GridLayout(5, 2, 10, 10));
        addLabeledTextField(leftPanel, "Programme Niveau d'Étude :");
        addLabeledTextField(leftPanel, "Ecole :");
        addLabeledTextField(leftPanel, "Nombre maximal de points :");
        addLabeledTextField(leftPanel, "Date de test :");
        addLabeledTextField(leftPanel, "Point TOEFL :");

        // Partie droite
        rightPanel.setLayout(new GridLayout(3, 2, 10, 10));
        addLabeledTextField(rightPanel, "Catégorie :");
        addLabeledTextField(rightPanel, "Université :");
        addLabeledTextField(rightPanel, "Points(%) :");

        // Ajouter les deux panels au frame
        panel.add(leftPanel);
        panel.add(Box.createRigidArea(new Dimension(20, 0))); // Espacement entre les deux parties
        panel.add(rightPanel);

        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addLabeledTextField(JPanel panel, String labelText) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, INPUT_HEIGHT));
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, INPUT_HEIGHT));
        rowPanel.add(label);
        rowPanel.add(textField);
        panel.add(rowPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new QualificationFrame();
    }
}
