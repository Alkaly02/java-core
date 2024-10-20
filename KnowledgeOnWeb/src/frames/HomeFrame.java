package frames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HomeFrame {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    Map<String, String> data = readDataFromFile("admissions.bat");

    public HomeFrame() {
        frame = new JFrame("Liste des admissions");
        frame.setLayout(new BorderLayout());

        // Créer le modèle de la table avec les colonnes spécifiées
        String[] columnNames = {"ID", "Nom", "Programme", "Ecole", "Date de test", "Actions"};
        tableModel = new DefaultTableModel(columnNames, 0);

        // Remplir la table avec des données factices (à remplacer par des données réelles)
        addAdmissionRow(new Object[]{"1", "John Doe", "Physique appliquée", "Université A", "01/10/2024"});
        addAdmissionRow(new Object[]{"2", "Jane Doe", "Informatique", "Université B", "02/11/2024"});

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
        tableModel.addRow(new Object[]{rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], "Voir détails"});
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

    private static Map<String, String> readDataFromFile(String fileName) {
        Map<String, String> fileData = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    fileData.put(parts[0].trim(), parts[1].trim());
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