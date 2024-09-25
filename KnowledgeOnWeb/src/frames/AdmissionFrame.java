package frames;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AdmissionFrame implements ActionListener {
//	hauteur des inputs
	private final int INPUT_HEIGHT=40;
//	debut des inputs fields
	private final int INPUT_START_X=280;
//	longueur des inputs
	private final int INPUT_WIDTH=400;
//	longueur du label
	private final int LABEL_WIDTH=300;
	
	JFrame frame = new JFrame("Formlaire d'inscription");
	
	JLabel inscriptionPourLabel = new JLabel("Inscription pour");
	
	JLabel programmeNiveauEtudeLabel = new JLabel("Programme Niveau d'Etude");
	JTextField programmeNiveauEtudeField = new JTextField();
	
	JLabel ecoleLabel = new JLabel("Ecole");
	JTextField ecoleField = new JTextField();
	
	JLabel detailsPersonnel = new JLabel("Details du personnel");
	
	JLabel nomLabel = new JLabel("Nom");
	JTextField nomField = new JTextField();
	
	JLabel prenomLabel  = new JLabel("Prenom");
	JTextField prenomField = new JTextField();
	
	JLabel adresseLabel = new JLabel("Adresse");
	JTextField adresseField = new JTextField();
	
	JLabel citeLabel = new JLabel("Cite");
	JTextField citeField = new JTextField();
	
	JLabel etatLabel = new JLabel("Etat");
	JTextField etatField = new JTextField();
	
	JLabel codePostalLabel = new JLabel("Code postal");
	JTextField codePostalField = new JTextField();
	
	JLabel paysLabel = new JLabel("Pays");
	JTextField paysField = new JTextField();
	
	JLabel telephoneDomicileLabel = new JLabel("Telephone(domicile)");
	JLabel codePaysDomicileLabel = new JLabel("Code pays");
	JTextField codePaysDomicileField = new JTextField();
	JLabel indicatifRegionalDomicileLabel = new JLabel("Indicatif regional");
	JTextField indicatifRegionalDomicileField = new JTextField();
	JLabel numeroTelephoneDomicileLabel = new JLabel("Code pays");
	JTextField telephoneDomicileField = new JTextField();
	
	JLabel telephoneBureauLabel = new JLabel("Telephone(Bureau)");
	JLabel codePaysBureauLabel = new JLabel("Code pays");
	JTextField codePaysBureauField = new JTextField();
	JLabel indicatifRegionalBureauLabel = new JLabel("Indicatif regional");
	JTextField indicatifRegionalBureauField = new JTextField();
	JLabel numeroTelephoneBureauLabel = new JLabel("Code pays");
	JTextField telephoneBureauField = new JTextField();
	
	JLabel adresseEmailLabel = new JLabel("Adresse E-mail :");
	JTextField adresseEmailField = new JTextField();
	
	JLabel sexeLabel = new JLabel("Pays");
//	TODO: radio boutton: Feminin ou Masculin
	ButtonGroup sexeButtonGroup = new ButtonGroup();
	JRadioButton femininRadioButton = new JRadioButton("Feminin");
	JRadioButton masculinRadioButton = new JRadioButton("Masculin");
	
	JLabel dateNaissanceLabel = new JLabel("Date de naissance");
//	TODO: mois | jour | annee
	JLabel moisLabel = new JLabel("Mois");
	JTextField moisField = new JTextField();
	JLabel jourLabel = new JLabel("Jour");
	JTextField jourField = new JTextField();
	JLabel anneeLabel = new JLabel("Annee");
	JTextField anneeField = new JTextField();
	
	
	
	
	public AdmissionFrame() {
		inscriptionPourLabel.setBounds(20, 20, LABEL_WIDTH, INPUT_HEIGHT);
		inscriptionPourLabel.setFont(new Font(null, Font.BOLD, 25));
		
		programmeNiveauEtudeLabel.setBounds(20, 70, LABEL_WIDTH, INPUT_HEIGHT);
		programmeNiveauEtudeField.setBounds(INPUT_START_X, 70, INPUT_WIDTH, INPUT_HEIGHT);
		
		ecoleLabel.setBounds(20, 120, LABEL_WIDTH, INPUT_HEIGHT);
		ecoleField.setBounds(INPUT_START_X, 120, INPUT_WIDTH, INPUT_HEIGHT);
		
		detailsPersonnel.setBounds(20, 180, INPUT_WIDTH, INPUT_HEIGHT);
		detailsPersonnel.setFont(new Font(null, Font.BOLD, 25));
		
		nomLabel.setBounds(20, 220, LABEL_WIDTH, INPUT_HEIGHT);
		nomField.setBounds(INPUT_START_X, 220, INPUT_WIDTH, INPUT_HEIGHT);
		
		prenomLabel.setBounds(20, 270, LABEL_WIDTH, INPUT_HEIGHT);
		prenomField.setBounds(INPUT_START_X, 270, INPUT_WIDTH, INPUT_HEIGHT);
		
		adresseLabel.setBounds(20, 320, LABEL_WIDTH, INPUT_HEIGHT);
		adresseField.setBounds(INPUT_START_X, 320, INPUT_WIDTH, INPUT_HEIGHT);
		
		citeLabel.setBounds(20, 370, LABEL_WIDTH, INPUT_HEIGHT);
		citeField.setBounds(INPUT_START_X, 370, INPUT_WIDTH, INPUT_HEIGHT);
		
		etatLabel.setBounds(20, 420, LABEL_WIDTH, INPUT_HEIGHT);
		etatField.setBounds(INPUT_START_X, 420, INPUT_WIDTH, INPUT_HEIGHT);
		
		codePostalLabel.setBounds(20, 470, LABEL_WIDTH, INPUT_HEIGHT);
		codePostalField.setBounds(INPUT_START_X, 470, INPUT_WIDTH, INPUT_HEIGHT);
		
		paysLabel.setBounds(20, 520, LABEL_WIDTH, INPUT_HEIGHT);
		paysField.setBounds(INPUT_START_X, 520, INPUT_WIDTH, INPUT_HEIGHT);
		
		
		
		frame.add(inscriptionPourLabel);
		frame.add(programmeNiveauEtudeLabel);
		frame.add(programmeNiveauEtudeField);
		frame.add(ecoleLabel);
		frame.add(ecoleField);
		frame.add(detailsPersonnel);
		frame.add(nomLabel);
		frame.add(nomField);
		frame.add(prenomLabel);
		frame.add(prenomField);
		frame.add(adresseLabel);
		frame.add(adresseField);
		frame.add(citeLabel);
		frame.add(citeField);
		frame.add(etatLabel);
		frame.add(etatField);
		frame.add(codePostalLabel);
		frame.add(codePostalField);
		frame.add(paysLabel);
		frame.add(paysField);
		
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 800);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
