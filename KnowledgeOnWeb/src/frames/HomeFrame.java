package frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;

public class HomeFrame {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    ArrayList<Map<String, String>> data = readDataFromFile("admission.dat");


    public HomeFrame() {
        frame = new JFrame("Liste des admissions");
        frame.setLayout(new BorderLayout());

        // Créer le modèle de la table avec les colonnes spécifiées
        String[] columnNames = { "Prenom", "Nom", "Adresse", "Numero domicile", "Email", "Inscription", "Actions"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Remplir la table avec des données factices (à remplacer par des données réelles)
        for (Map<String, String> row : data) {
            System.out.println(row);
            // prenom, nom, adresse, numeroDomicile, inscription, email
            System.out.println(row.get("prenom"));
            addAdmissionRow(new Object[]{ row.get("prenom"), row.get("nom"), row.get("adresse"), row.get("numeroDomicile"), row.get("email"), row.get("inscription")});
        }
        // addAdmissionRow(new Object[]{ "Jane Doe", "Informatique", "Université B", "02/11/2024"});

        // Créer la table
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Rendre la dernière colonne (boutons) non éditable
                return column == 5;
            }
        };

        // Ajouter des boutons dans la colonne "Actions"
        addButtonsToTable();

        // Ajouter la table à un JScrollPane pour permettre le défilement
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Ajouter un bouton en bas du frame pour ouvrir le frame d'ajout d'admission
        JButton addButton = new JButton("Ajouter une admission");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir un nouveau frame pour ajouter une admission
                new AdmissionFrame();
            }
        });

        // Panel pour le bouton en bas
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(addButton);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Ajouter une nouvelle ligne d'admission
    private void addAdmissionRow(Object[] rowData) {
        tableModel.addRow(new Object[]{rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5], "Voir détails"});
    }

    // Ajouter des boutons "Voir détails" dans la table
    private void addButtonsToTable() {
        // Rendre la colonne "Actions" avec des boutons cliquables
        table.getColumn("Actions").setCellRenderer(new ButtonRenderer());
        table.getColumn("Actions").setCellEditor(new ButtonEditor(new JCheckBox(), this));
    }

    // Afficher les détails de l'admission (à personnaliser selon les besoins)
    public void showAdmissionDetails(int rowIndex) {
        String admissionDetails = "Détails de l'admission : \n"
                + "ID: " + table.getValueAt(rowIndex, 0) + "\n"
                + "Nom: " + table.getValueAt(rowIndex, 1) + "\n"
                + "Programme: " + table.getValueAt(rowIndex, 2) + "\n"
                + "Ecole: " + table.getValueAt(rowIndex, 3) + "\n"
                + "Date de test: " + table.getValueAt(rowIndex, 4);
        JOptionPane.showMessageDialog(frame, admissionDetails, "Détails de l'admission", JOptionPane.INFORMATION_MESSAGE);
    }

    private static ArrayList<Map<String, String>> readDataFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return new ArrayList<Map<String, String>>();
        }
        ArrayList<Map<String, String>> fileData = new ArrayList<Map<String, String>>();
        Map<String, String> deserializedLine;
        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(file))) {
            while(true) {
    			try {
    				deserializedLine = (Map<String, String>) ios.readObject();
    				fileData.add(deserializedLine);
    			}catch(ClassNotFoundException | EOFException ie) {
    				System.out.println("Fin du fichier");
    				break;
    			}
    		}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData;
    }
}

// Classe pour le rendu des boutons
class ButtonRenderer extends JButton implements javax.swing.table.TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

// Classe pour l'éditeur de bouton
class ButtonEditor extends DefaultCellEditor {

    private JButton button;
    private int selectedRow;

    public ButtonEditor(JCheckBox checkBox, HomeFrame parentFrame) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Appeler la méthode pour afficher les détails de l'admission
                parentFrame.showAdmissionDetails(selectedRow);
                // fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        button.setText((value == null) ? "" : value.toString());
        selectedRow = row;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
      return button.getText();
    }
}