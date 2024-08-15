package main;

import java.io.*;

public class MainActivity {

	public static void main(String[] args) {
//		Objectif : Lire le contenu d'un fichier ligne par ligne en utilisant FileReader et
//		BufferedReader.
		int i;
		File exampleFile = new File("example.txt");
		
		try {
			FileReader fileReader = new FileReader(exampleFile);
			while((i = fileReader.read()) != -1) {
				char c = (char)i;
				System.out.println(c);
			}
			fileReader.close();
		}catch(IOException ie) {
			System.out.println(exampleFile + " n'existe pas");
			ie.printStackTrace();
		}
		
//		Amelioration de l'efficacite de lecture avec BufferedReader
		String line;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(exampleFile));
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		}catch(IOException ie) {
			System.out.println(exampleFile + " n'existe pas");
			ie.printStackTrace();
		}

	}

}
