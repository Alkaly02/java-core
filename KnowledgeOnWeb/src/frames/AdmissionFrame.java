package frames;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

enum STATUTCITOYEN {
    CITOYEN_US("Citoyen U.S"),
    RESIDENT_PERMANENT("Resident permanent"),
    PAS_CITOYEN_US("N'est pas citoyen U.S"),
    REFUS_ETAT("Refus de l'Etat");

    private String displayName;

    // Constructeur pour l'énumération
    STATUTCITOYEN(String displayName) {
        this.displayName = displayName;
    }

    // Méthode pour obtenir le nom affiché
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
};

public class AdmissionFrame implements ActionListener {
    // Constantes pour la taille des champs et labels
    private final int INPUT_HEIGHT = 40;
    private final int INPUT_START_X = 280;
    private final int INPUT_WIDTH = 400;
    private final int LABEL_WIDTH = 300;

    JFrame frame = new JFrame("Formulaire d'inscription");
    JPanel panel = new JPanel();
    JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    public AdmissionFrame() {
        // Définir le layout du panel en null pour utiliser des positions absolues
        panel.setLayout(null);
        
        // Définir la taille préférée du panel pour permettre le scroll
        panel.setPreferredSize(new Dimension(700, 1200));

        // Création des composants
        JLabel inscriptionPourLabel = new JLabel("Inscription pour");
        inscriptionPourLabel.setBounds(20, 20, LABEL_WIDTH, INPUT_HEIGHT);
        inscriptionPourLabel.setFont(new Font(null, Font.BOLD, 25));
        
        JLabel programmeNiveauEtudeLabel = new JLabel("Programme Niveau d'Etude");
        programmeNiveauEtudeLabel.setBounds(20, 70, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField programmeNiveauEtudeField = new JTextField();
        programmeNiveauEtudeField.setBounds(INPUT_START_X, 70, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel ecoleLabel = new JLabel("Ecole");
        ecoleLabel.setBounds(20, 120, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField ecoleField = new JTextField();
        ecoleField.setBounds(INPUT_START_X, 120, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel detailsPersonnel = new JLabel("Details du personnel");
        detailsPersonnel.setBounds(20, 180, INPUT_WIDTH, INPUT_HEIGHT);
        detailsPersonnel.setFont(new Font(null, Font.BOLD, 25));
        
        JLabel nomLabel = new JLabel("Nom");
        nomLabel.setBounds(20, 220, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField nomField = new JTextField();
        nomField.setBounds(INPUT_START_X, 220, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel prenomLabel = new JLabel("Prenom");
        prenomLabel.setBounds(20, 270, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField prenomField = new JTextField();
        prenomField.setBounds(INPUT_START_X, 270, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel adresseLabel = new JLabel("Adresse");
        adresseLabel.setBounds(20, 320, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField adresseField = new JTextField();
        adresseField.setBounds(INPUT_START_X, 320, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel citeLabel = new JLabel("Cite");
        citeLabel.setBounds(20, 370, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField citeField = new JTextField();
        citeField.setBounds(INPUT_START_X, 370, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel etatLabel = new JLabel("Etat");
        etatLabel.setBounds(20, 420, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField etatField = new JTextField();
        etatField.setBounds(INPUT_START_X, 420, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel codePostalLabel = new JLabel("Code postal");
        codePostalLabel.setBounds(20, 470, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField codePostalField = new JTextField();
        codePostalField.setBounds(INPUT_START_X, 470, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel paysLabel = new JLabel("Pays");
        paysLabel.setBounds(20, 520, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField paysField = new JTextField();
        paysField.setBounds(INPUT_START_X, 520, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel telephoneDomicileLabel = new JLabel("Telephone(domicile)");
        telephoneDomicileLabel.setBounds(20, 580, INPUT_WIDTH, INPUT_HEIGHT);
        telephoneDomicileLabel.setFont(new Font(null, Font.BOLD, 25));
        JLabel codePaysDomicileLabel = new JLabel("Code pays");
        codePaysDomicileLabel.setBounds(20, 640, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField codePaysDomicileField = new JTextField();
        codePaysDomicileField.setBounds(INPUT_START_X, 640, INPUT_WIDTH, INPUT_HEIGHT);
        JLabel indicatifRegionalDomicileLabel = new JLabel("Indicatif regional");
        indicatifRegionalDomicileLabel.setBounds(20, 690, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField indicatifRegionalDomicileField = new JTextField();
        indicatifRegionalDomicileField.setBounds(INPUT_START_X, 690, INPUT_WIDTH, INPUT_HEIGHT);
        JLabel numeroTelephoneDomicileLabel = new JLabel("Numero telephone");
        numeroTelephoneDomicileLabel.setBounds(20, 740, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField numeroTelephoneDomicileField = new JTextField();
        numeroTelephoneDomicileField.setBounds(INPUT_START_X, 740, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel telephoneBureauLabel = new JLabel("Telephone(Bureau)");
        telephoneBureauLabel.setBounds(20, 790, INPUT_WIDTH, INPUT_HEIGHT);
        telephoneBureauLabel.setFont(new Font(null, Font.BOLD, 25));
        JLabel codePaysBureauLabel = new JLabel("Code pays");
        codePaysBureauLabel.setBounds(20, 840, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField codePaysBureauField = new JTextField();
        codePaysBureauField.setBounds(INPUT_START_X, 840, INPUT_WIDTH, INPUT_HEIGHT);
        JLabel indicatifRegionalBureauLabel = new JLabel("Indicatif regional");
        indicatifRegionalBureauLabel.setBounds(20, 890, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField indicatifRegionalBureauField = new JTextField();
        indicatifRegionalBureauField.setBounds(INPUT_START_X, 890, INPUT_WIDTH, INPUT_HEIGHT);
        JLabel numeroTelephoneBureauLabel = new JLabel("Numero telephone");
        numeroTelephoneBureauLabel.setBounds(20, 940, LABEL_WIDTH, INPUT_HEIGHT);
        JTextField numeroTelephoneBureauField = new JTextField();
        numeroTelephoneBureauField.setBounds(INPUT_START_X, 940, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel emailLabel = new JLabel("Adresse email");
        emailLabel.setBounds(20, 990, INPUT_WIDTH, INPUT_HEIGHT);
        JTextField emailTextField = new JTextField();
        emailTextField.setBounds(INPUT_START_X, 990, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel sexeLabel = new JLabel("Sexe");
        sexeLabel.setBounds(20, 1040, INPUT_WIDTH, INPUT_HEIGHT);
        JRadioButton maleButton = new JRadioButton("Masculin");
        maleButton.setBounds(INPUT_START_X, 1040, 100, INPUT_HEIGHT);
        JRadioButton femaleButton = new JRadioButton("Féminin");
        femaleButton.setBounds(INPUT_START_X + 100, 1040, INPUT_WIDTH, INPUT_HEIGHT);
        
        JLabel dateNaissanceLabel = new JLabel("Date de naissance");
        dateNaissanceLabel.setBounds(20, 1090, INPUT_WIDTH, INPUT_HEIGHT);
        dateNaissanceLabel.setFont(new Font(null, Font.BOLD, 25));
        JLabel moisLabel = new JLabel("Mois");
        moisLabel.setBounds(20, 1140, INPUT_WIDTH, INPUT_HEIGHT);
        JTextField moisTextField = new JTextField();
        moisTextField.setBounds(60, 1140, 60, INPUT_HEIGHT);
        JLabel jourLabel = new JLabel("Jour");
        jourLabel.setBounds(200, 1140, INPUT_WIDTH, INPUT_HEIGHT);
        JTextField jourTextField = new JTextField();
        jourTextField.setBounds(250, 1140, 60, INPUT_HEIGHT);
        JLabel anneeLabel = new JLabel("Annee");
        anneeLabel.setBounds(350, 1140, INPUT_WIDTH, INPUT_HEIGHT);
        JTextField anneeTextField = new JTextField();
        anneeTextField.setBounds(400, 1140, 60, INPUT_HEIGHT);
        
        JComboBox<STATUTCITOYEN> citoyenneteComboBox = new JComboBox<>(STATUTCITOYEN.values());
        citoyenneteComboBox.setBounds(20, 1190, INPUT_WIDTH, INPUT_HEIGHT);


        // Ajouter tous les composants au panneau (panel)
        panel.add(inscriptionPourLabel);
        panel.add(programmeNiveauEtudeLabel);
        panel.add(programmeNiveauEtudeField);
        panel.add(ecoleLabel);
        panel.add(ecoleField);
        panel.add(detailsPersonnel);
        panel.add(nomLabel);
        panel.add(nomField);
        panel.add(prenomLabel);
        panel.add(prenomField);
        panel.add(adresseLabel);
        panel.add(adresseField);
        panel.add(citeLabel);
        panel.add(citeField);
        panel.add(etatLabel);
        panel.add(etatField);
        panel.add(codePostalLabel);
        panel.add(codePostalField);
        panel.add(paysLabel);
        panel.add(paysField);
        panel.add(telephoneDomicileLabel);
        panel.add(codePaysDomicileLabel);
        panel.add(codePaysDomicileField);
        panel.add(indicatifRegionalDomicileLabel);
        panel.add(indicatifRegionalDomicileField);
        panel.add(numeroTelephoneDomicileLabel);
        panel.add(numeroTelephoneDomicileField);
        panel.add(telephoneBureauLabel);
        panel.add(codePaysBureauLabel);
        panel.add(codePaysBureauField);
        panel.add(indicatifRegionalBureauLabel);
        panel.add(indicatifRegionalBureauField);
        panel.add(numeroTelephoneBureauLabel);
        panel.add(numeroTelephoneBureauField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(sexeLabel);
        panel.add(maleButton);
        panel.add(femaleButton);
        panel.add(dateNaissanceLabel);
        panel.add(moisLabel);
        panel.add(moisTextField);
        panel.add(jourLabel);
        panel.add(jourTextField);
        panel.add(anneeLabel);
        panel.add(anneeTextField);
        panel.add(citoyenneteComboBox);
        

        // Ajouter le JScrollPane au cadre (frame)
        frame.add(scrollPane);

        // Configurer le cadre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 900);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
