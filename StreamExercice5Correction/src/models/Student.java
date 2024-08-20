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
    	ArrayList<Student> students = this.getAllStudents();
    	students.add(this);
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))){
    		for(Student student: students) {	
    			oos.writeObject(student);
    		}
    	}catch(IOException ie) {
    		ie.printStackTrace();
    	}
    }
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> getAllStudents() {
    	File file = new File("students.dat");
    	if(!file.exists()) {
    		return new ArrayList<Student>();
    	}
    	ArrayList<Student> allSavedStudents = new ArrayList<Student>();
    	Student deserilizedStudent;
    	try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream(file))){
    		while(true) {
    			try {
    				deserilizedStudent = (Student) ios.readObject();
    				allSavedStudents.add(deserilizedStudent);
    			}catch(ClassNotFoundException | EOFException ie) {
    				System.out.println("Fin du fichier");
    				break;
    			}
    		}
    	}catch(IOException ie) {
    		ie.printStackTrace();
    	}
    	
    	return allSavedStudents;
    }
}
