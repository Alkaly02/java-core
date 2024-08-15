package main;

import java.io.*;

public class MainActivity {
//	Objectif : Copier le contenu d'un fichier source vers un fichier de destination en utilisant
//	FileInputStream et FileOutputStream.
	public static void main(String[] args) throws IOException {
		int i;
		FileInputStream fileInput = new FileInputStream("source.txt");
		FileOutputStream fileOutput = new FileOutputStream("destionation.txt");
		
		while((i = fileInput.read()) != -1) {
			fileOutput.write(i);
		}
		
		fileInput.close();
		fileOutput.close();
		System.out.println("Copy done!!");

	}

}
