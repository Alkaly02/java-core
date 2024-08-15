package main;

import java.io.*;
import java.util.Scanner;

public class MainActivity {

	public static void main(String[] args) throws IOException {
		System.out.println("Veuillez saisir un texte");
		Scanner scn = new Scanner(System.in);
		String textSaisi = scn.nextLine();
		scn.close();
		

		File textFile = new File("texte.txt");
		if(textFile.exists()) {
			textFile.delete();
		}
		FileWriter fileWriter = new FileWriter(textFile);
		fileWriter.write(textSaisi);
		fileWriter.close();
		System.out.println("Ficher creer");

	}

}
