package models;

import java.util.Date;

enum PHONEYPE {Domicile, Bureau};
enum SEXE {M, F};
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

class Telephone{
	private String codePays, indicatifRegional, numeroTelephone;
	private PHONEYPE type;
	
	public Telephone(String codePays, String indicatifRegional, PHONEYPE type) {
		this.codePays = codePays;
		this.indicatifRegional = indicatifRegional;
		this.type = type;
	}
	
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}
	public String getCodePays() {
		return this.codePays;
	}
	
	public void setIndicatifRegional(String indicatifRegional) {
		this.indicatifRegional = indicatifRegional;
	}
	public String getIndicatifRegional() {
		return this.indicatifRegional;
	}
	
	public void setType(PHONEYPE type) {
		this.type = type;
	}
	public PHONEYPE getType() {
		return this.type;
	}
	
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public String getNumeroTelephone() {
		return this.numeroTelephone;
	}
}

public class Etudiant {
	private String nomComplet, address, cite, etat, codePostal, pays, email;
	private Telephone telephoneDomicile, telephoneBureau;
	private SEXE sexe;
	private Date dateNaissance;
	private STATUTCITOYEN statutCitoyen;
	
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getNomComplet() {
		return this.nomComplet;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}
	
	public void setCite(String cite) {
		this.cite = cite;
	}
	public String getCite() {
		return this.cite;
	}
	
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getEtat() {
		return this.etat;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getCodePostal() {
		return this.codePostal;
	}
	
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getPays() {
		return this.pays;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	
	public void setSexe(SEXE sexe) {
		this.sexe = sexe;
	}
	public SEXE getSexe() {
		return this.sexe;
	}
	
	public void setStatutCitoyen(STATUTCITOYEN statutCitoyen) {
		this.statutCitoyen = statutCitoyen;
	}
	public STATUTCITOYEN getStatutCitoyen() {
		return this.statutCitoyen;
	}
	
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Date getDateNaissance() {
		return this.dateNaissance;
	}
	
	public void setTelephoneDomicile(Telephone telephoneDomicile) {
		this.telephoneDomicile = telephoneDomicile;
	}
	public Telephone getTelephoneDomicile() {
		return this.telephoneDomicile;
	}
	
	public void setTelephoneBureau(Telephone telephoneBureau) {
		this.telephoneBureau = telephoneBureau;
	}
	public Telephone getTelephoneBureau() {
		return this.telephoneBureau;
	}
	
}
