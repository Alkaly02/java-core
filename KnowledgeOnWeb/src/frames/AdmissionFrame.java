package frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

enum StatutCitoyennete {
    CITOYEN_US("Citoyen U.S"),
    RESIDENT_PERMANENT("Resident permanent"),
    PAS_CITOYEN_US("N'est pas citoyen U.S"),
    REFUS_ETAT("Refus de l'Etat");

    private final String displayName;

    StatutCitoyennete(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

public class AdmissionFrame implements ActionListener {

    private final int INPUT_HEIGHT = 40;
    private final int INPUT_WIDTH = 400;

    JFrame frame = new JFrame("Formulaire d'inscription");
    JPanel panel = new JPanel();
    JButton cancelButton = new JButton("Annuler");
    JButton continuButton = new JButton("Continuer");

    // Map to store form data
    private Map<String, String> admissionData = new HashMap<>();

    // TextFields and ComboBoxes for retrieving data
    private Map<String, JTextField> textFields = new HashMap<>();
    private Map<String, JComboBox<String>> comboBoxes = new HashMap<>();
    private JComboBox<StatutCitoyennete> citoyenneteComboBox;

    public AdmissionFrame() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        addSectionSeparator(panel, "Formulaire d'inscription");

        // JComboBox for "Inscription pour"
        addLabeledComboBox(panel, "Inscription pour :", new String[] { "Deuxième cycle", "Troisième cycle" },
                "inscription");

        // JComboBox for Programme Niveau d'Étude
        addLabeledComboBox(panel, "Programme Niveau d'Étude :",
                new String[] {
                        "Aéronautique-Astronautique", "Sciences de la terre", "Physique appliquée",
                        "Biochimie", "Éducation", "BioSciences", "Humanités et Sciences",
                        "Ingénierie et Science appliquée", "Architecture", "Droit",
                        "École d'infirmerie", "Journalisme"
                }, "programme");

        // TextFields for various personal details
        addLabeledTextField(panel, "Ecole :", "ecole");
        addSectionSeparator(panel, "Détails personnels");
        addLabeledTextField(panel, "Nom :", "nom");
        addLabeledTextField(panel, "Prenom :", "prenom");
        addLabeledTextField(panel, "Adresse :", "adresse");
        addLabeledTextField(panel, "Cité :", "cite");
        addLabeledTextField(panel, "État :", "etat");
        addLabeledTextField(panel, "Code postal :", "codePostal");
        addLabeledTextField(panel, "Pays :", "pays");

        addSectionSeparator(panel, "Téléphone (Domicile)");
        addLabeledTextField(panel, "Code pays :", "codePaysDomicile");
        addLabeledTextField(panel, "Indicatif régional :", "indicatifDomicile");
        addLabeledTextField(panel, "Numéro de téléphone :", "numeroDomicile");

        addSectionSeparator(panel, "Téléphone (Bureau)");
        addLabeledTextField(panel, "Code pays :", "codePaysBureau");
        addLabeledTextField(panel, "Indicatif régional :", "indicatifBureau");
        addLabeledTextField(panel, "Numéro de téléphone :", "numeroBureau");

        addLabeledTextField(panel, "Adresse email :", "email");

        addLabeledComponent(panel, "Sexe :", createSexePanel());

        addSectionSeparator(panel, "Date de naissance");
        addMoisJourAnneeRow(panel);

        addLabeledComponent(panel, "Citoyenneté :", createCitoyenneteComboBox());

        // Buttons for actions
        ArrayList<JButton> buttons = new ArrayList<>();
        buttons.add(cancelButton);
        buttons.add(continuButton);
        addButtonsRow(panel, buttons);

        JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scrollPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addLabeledComponent(JPanel panel, String labelText, JComponent component) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, INPUT_HEIGHT));
        rowPanel.add(label);
        rowPanel.add(component);
        panel.add(rowPanel);
    }

    private JPanel createSexePanel() {
        JPanel sexePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton maleButton = new JRadioButton("Masculin");
        JRadioButton femaleButton = new JRadioButton("Féminin");
        sexePanel.add(maleButton);
        sexePanel.add(femaleButton);
        return sexePanel;
    }

    private JComboBox<StatutCitoyennete> createCitoyenneteComboBox() {
        citoyenneteComboBox = new JComboBox<>(StatutCitoyennete.values());
        citoyenneteComboBox.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        citoyenneteComboBox.setMaximumSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        return citoyenneteComboBox;
    }

    private void addLabeledTextField(JPanel panel, String labelText, String fieldKey) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, INPUT_HEIGHT));
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        rowPanel.add(label);
        rowPanel.add(textField);
        panel.add(rowPanel);
        textFields.put(fieldKey, textField); // Save reference to the text field
    }

    private void addLabeledComboBox(JPanel panel, String labelText, String[] options, String fieldKey) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, INPUT_HEIGHT));
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        rowPanel.add(label);
        rowPanel.add(comboBox);
        panel.add(rowPanel);
        comboBoxes.put(fieldKey, comboBox); // Save reference to the combo box
    }

    private void addMoisJourAnneeRow(JPanel panel) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel moisLabel = new JLabel("Mois :");
        moisLabel.setPreferredSize(new Dimension(50, INPUT_HEIGHT));
        JTextField moisField = new JTextField();
        moisField.setPreferredSize(new Dimension(60, INPUT_HEIGHT));

        JLabel jourLabel = new JLabel("Jour :");
        jourLabel.setPreferredSize(new Dimension(50, INPUT_HEIGHT));
        JTextField jourField = new JTextField();
        jourField.setPreferredSize(new Dimension(60, INPUT_HEIGHT));

        JLabel anneeLabel = new JLabel("Année :");
        anneeLabel.setPreferredSize(new Dimension(50, INPUT_HEIGHT));
        JTextField anneeField = new JTextField();
        anneeField.setPreferredSize(new Dimension(80, INPUT_HEIGHT));

        rowPanel.add(moisLabel);
        rowPanel.add(moisField);
        rowPanel.add(jourLabel);
        rowPanel.add(jourField);
        rowPanel.add(anneeLabel);
        rowPanel.add(anneeField);

        panel.add(rowPanel);

        // Store date fields in textFields map
        textFields.put("mois", moisField);
        textFields.put("jour", jourField);
        textFields.put("annee", anneeField);
    }

    private void addButtonsRow(JPanel panel, ArrayList<JButton> buttons) {
        addSectionSeparator(panel, null);
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        for (JButton button : buttons) {
            button.setPreferredSize(new Dimension(150, 40));
            button.addActionListener(this);
            rowPanel.add(button);
        }
        panel.add(rowPanel);
    }

    private void addSectionSeparator(JPanel panel, String title) {
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        JLabel sectionLabel = new JLabel(title);
        sectionLabel.setFont(new Font(null, Font.BOLD, 25));
        sectionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(sectionLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            // Vider tous les inputs
            for (JTextField textField : textFields.values()) {
                textField.setText("");
            }
        }
        if (e.getSource() == continuButton) {
            // Recuperer les donnees des champs
            boolean isValid = validateFields();
            if (isValid) {
                admissionData.clear();
                // On stoque les donnees TextField sous format key:value grace au HashMap
                for (Map.Entry<String, JTextField> entry : textFields.entrySet()) {
                    admissionData.put(entry.getKey(), entry.getValue().getText());
                }

                // On stoque les donnees ComboBox sous format key:value grace au HashMap
                for (Map.Entry<String, JComboBox<String>> entry : comboBoxes.entrySet()) {
                    admissionData.put(entry.getKey(), entry.getValue().getSelectedItem().toString());
                }

                // Store citoyenneteComboBox value
                admissionData.put("citoyennete", citoyenneteComboBox.getSelectedItem().toString());

                System.out.println("Form data collected successfully:");
                admissionData.forEach((key, value) -> System.out.println(key + ": " + value));

                // Mette le code ici pour aller ves le frame admission
            }
        }
    }

    // Fonction pour validations des champs
    private boolean validateFields() {
        StringBuilder errorMessage = new StringBuilder();

        for (Map.Entry<String, JTextField> entry : textFields.entrySet()) {
            String value = entry.getValue().getText();
            if (value == null || value.trim().isEmpty()) {
                errorMessage.append("Le champ ").append(entry.getKey()).append(" est obligatoire.\n");
            }
        }

        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(frame, errorMessage.toString(), "Erreur de validation",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}