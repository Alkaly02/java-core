package models;

import java.io.*;
import java.util.ArrayList;

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
    
    public void saveStudents() {
    	ArrayList<Student> students = Student.getAllStudents();
    	students.add(this);
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))){
    		for(Student student: students) {
    			oos.writeObject(student);
    		}
    	}catch(IOException ie) {
    		System.out.println("Une erreur est survenue lors de l'enregistrement de l'etudiant");
    	}
    }
    
    public static ArrayList<Student> getAllStudents(){
    	File file = new File("students.dat");
    	if(!file.exists()) {
    		System.out.println("Ce fichier n'existe pas");
    		return new ArrayList<Student>();
    	}
    	ArrayList<Student> deserializesStudents = new ArrayList<Student>();
    	Student deserializesStudent;
    	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
    		while(true) {
    			try {
    				deserializesStudent = (Student)ois.readObject();
    				deserializesStudents.add(deserializesStudent);
    			}catch(ClassNotFoundException | EOFException ie) {
    				break;
    			}
        	}
    	}catch(IOException ie) {
    		System.out.println("Une erreur est survenue lors de l'enregistrement de l'etudiant");
    	}
    	return deserializesStudents;
    }
}
