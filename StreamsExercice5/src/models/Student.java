package models;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	private String prenom, nom, numero;
	private int age;
	
    public Student(String nom, String prenom, int age, String numeroEtudiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.numero = numeroEtudiant;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumeroEtudiant() {
        return this.numero;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numero = numeroEtudiant;
    }
}
