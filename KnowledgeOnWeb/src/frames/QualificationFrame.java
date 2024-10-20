package frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QualificationFrame implements ActionListener {

    private final int INPUT_HEIGHT = 40;
    private final int INPUT_WIDTH = 400;

    JFrame frame = new JFrame("Qualification");
    JPanel panel = new JPanel();
    JPanel leftPanel = new JPanel();  // Partie gauche
    JPanel rightPanel = new JPanel(); // Partie droite
    JButton sendButton = new JButton("Envoyer");

    // Store admission data and qualification data
    private Map<String, String> admissionData;
    private Map<String, JTextField> qualificationFields = new HashMap<>();

    public QualificationFrame(Map<String, String> admissionData) {
        this.admissionData = admissionData;

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Partie gauche
        leftPanel.setLayout(new GridLayout(5, 2, 10, 10));
        addLabeledTextField(leftPanel, "Programme Niveau d'Étude");
        addLabeledTextField(leftPanel, "Ecole");
        addLabeledTextField(leftPanel, "Nombre maximal de points");
        addLabeledTextField(leftPanel, "Date de test");
        addLabeledTextField(leftPanel, "Point TOEFL");

        // Partie droite
        rightPanel.setLayout(new GridLayout(3, 2, 10, 10));
        addLabeledTextField(rightPanel, "Catégorie");
        addLabeledTextField(rightPanel, "Université");
        addLabeledTextField(rightPanel, "Points(%)");

        // Ajouter les deux panels au frame
        panel.add(leftPanel);
        panel.add(Box.createRigidArea(new Dimension(20, 0))); // Espacement entre les deux parties
        panel.add(rightPanel);

        // Créer un panel pour le bouton
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        sendButton.setPreferredSize(new Dimension(150, 40));
        sendButton.addActionListener(this);
        buttonPanel.add(sendButton);

        // Utiliser BorderLayout pour ajouter le panel des champs en haut et le bouton en bas
        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER); // Champs de saisie au centre
        frame.add(buttonPanel, BorderLayout.SOUTH); // Bouton en bas

        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane, BorderLayout.CENTER);

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

        // Store the text field with the corresponding label text
        qualificationFields.put(labelText, textField);

        rowPanel.add(label);
        rowPanel.add(textField);
        panel.add(rowPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendButton) {
            if (validateFields()) {
                // Collect qualifications data
                Map<String, String> qualificationData = new HashMap<>();
                for (Map.Entry<String, JTextField> entry : qualificationFields.entrySet()) {
                    qualificationData.put(entry.getKey(), entry.getValue().getText());
                }

                // Merge the admissionData with qualificationData
                Map<String, String> allData = new HashMap<>(admissionData);
                allData.putAll(qualificationData);

                // Print or process all the collected data
                System.out.println("All form data:");
                allData.forEach((key, value) -> System.out.println(key + ": " + value));

                // Save the data to a file
                saveAllDataToFile(allData);
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill all fields before submitting!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Validate the qualification form fields
    private boolean validateFields() {
        for (Map.Entry<String, JTextField> entry : qualificationFields.entrySet()) {
            if (entry.getValue().getText().trim().isEmpty()) {
                return false;  // If any field is empty, validation fails
            }
        }
        return true;  // If all fields are filled, validation passes
    }

    // Save all data into a file
    private void saveAllDataToFile(Map<String, String> allData) {
        // File file = new File("admission.dat");
        ArrayList<Map<String, String>> data = new ArrayList<Map<String, String>>();
        data.add(allData);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("admission.dat"))) {
            for (Map<String, String> mapLine : data) {
                oos.writeObject(mapLine);
            }
            JOptionPane.showMessageDialog(frame, "Data saved successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            new HomeFrame();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to save data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
