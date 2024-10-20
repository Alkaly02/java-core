package frames;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    public AdmissionFrame() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        addSectionSeparator(panel, "Formulaire d'inscription");

        // Remplacer "Inscription pour" par un JComboBox
        addLabeledComboBox(panel, "Inscription pour :", new String[]{"Deuxième cycle", "Troisième cycle"}, INPUT_WIDTH, INPUT_HEIGHT);
        
        // Ajouter le champ Programme Niveau d'Étude (JComboBox)
        addLabeledComboBox(panel, "Programme Niveau d'Étude :", 
            new String[]{
                "Aéronautique-Astronautique", "Sciences de la terre", "Physique appliquée",
                "Biochimie", "Éducation", "BioSciences", "Humanités et Sciences",
                "Ingénierie et Science appliquée", "Architecture", "Droit",
                "École d'infirmerie", "Journalisme"
            }, INPUT_WIDTH, INPUT_HEIGHT);

        addLabeledTextField(panel, "Ecole :", INPUT_WIDTH, INPUT_HEIGHT);

        addSectionSeparator(panel, "Details du personnel");

        addLabeledTextField(panel, "Nom :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "Prenom :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "Adresse :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "Cité :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "État :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "Code postal :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "Pays :", INPUT_WIDTH, INPUT_HEIGHT);

        addSectionSeparator(panel, "Téléphone (Domicile)");

        addLabeledTextField(panel, "Code pays :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "Indicatif régional :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "Numéro de téléphone :", INPUT_WIDTH, INPUT_HEIGHT);

        addSectionSeparator(panel, "Téléphone (Bureau)");

        addLabeledTextField(panel, "Code pays :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "Indicatif régional :", INPUT_WIDTH, INPUT_HEIGHT);
        addLabeledTextField(panel, "Numéro de téléphone :", INPUT_WIDTH, INPUT_HEIGHT);

        addLabeledTextField(panel, "Adresse email :", INPUT_WIDTH, INPUT_HEIGHT);

        addLabeledComponent(panel, "Sexe :", createSexePanel());

        addSectionSeparator(panel, "Date de naissance");

        // Ajouter les champs Mois, Jour, et Année sur la même ligne
        addMoisJourAnneeRow(panel);

        addLabeledComponent(panel, "Citoyenneté :", createCitoyenneteComboBox());
        
        // Ajout des buttons
        ArrayList<JButton> buttons = new ArrayList<JButton>();
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

    private JPanel createSexePanel() {
        JPanel sexePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JRadioButton maleButton = new JRadioButton("Masculin");
        JRadioButton femaleButton = new JRadioButton("Féminin");
        sexePanel.add(maleButton);
        sexePanel.add(femaleButton);
        return sexePanel;
    }

    private JComboBox<StatutCitoyennete> createCitoyenneteComboBox() {
        JComboBox<StatutCitoyennete> citoyenneteComboBox = new JComboBox<>(StatutCitoyennete.values());
        citoyenneteComboBox.setPreferredSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        citoyenneteComboBox.setMaximumSize(new Dimension(INPUT_WIDTH, INPUT_HEIGHT));
        return citoyenneteComboBox;
    }

    private void addLabeledTextField(JPanel panel, String labelText, int width, int height) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, height));
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        rowPanel.add(label);
        rowPanel.add(textField);
        panel.add(rowPanel);
    }

    private void addLabeledComponent(JPanel panel, String labelText, JComponent component) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, INPUT_HEIGHT));
        rowPanel.add(label);
        rowPanel.add(component);
        panel.add(rowPanel);
    }

    // Nouvelle méthode pour ajouter un JComboBox
    private void addLabeledComboBox(JPanel panel, String labelText, String[] options, int width, int height) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(150, height));
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setPreferredSize(new Dimension(width, height));
        rowPanel.add(label);
        rowPanel.add(comboBox);
        panel.add(rowPanel);
    }

    // Méthode pour ajouter Mois, Jour et Année sur la même ligne
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
        System.out.println("actionPerformed");
        if (e.getSource() == cancelButton) {
        }
        if (e.getSource() == continuButton) {
            frame.dispose();
            new QualificationFrame();
        }
    }
}
