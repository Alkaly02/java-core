package main;

import java.io.*;

class CopyImageWithBuffer{
	public static long executionDuration;
	public static void copy() throws IOException {
		InputStream imageStream = new FileInputStream("image.png");
		BufferedInputStream bufferdInputImage = new BufferedInputStream(imageStream);
		BufferedOutputStream bufferdOutputImage = new BufferedOutputStream(new FileOutputStream("copie_image.png"));
		
		int i;
		while((i = bufferdInputImage.read()) != -1) {
			bufferdOutputImage.write(i);
		}
		bufferdInputImage.close();
		bufferdOutputImage.close();
		System.out.println("La copie avec le flux tamponné prend: " + System.currentTimeMillis());
		executionDuration = System.currentTimeMillis();
	}
}

class SimpleCopyImage{
	public static long executionDuration;
	public static void copy() throws IOException {
		FileInputStream fileInput = new FileInputStream("image.png");
		FileOutputStream fileOutput = new FileOutputStream("copie_2_image.png");
		
		int i;
		while((i = fileInput.read()) != -1) {
			fileOutput.write(i);
		}
		fileInput.close();
		fileOutput.close();
		System.out.println("La copie avec le flux tamponné prend: " + System.currentTimeMillis());
		executionDuration = System.currentTimeMillis();
		
	}
}

public class MainActivity {
//Objectif : Utiliser des flux tamponnés pour améliorer les performances de lecture et
//	d'écriture.
	public static void main(String[] args) {
		try {
			CopyImageWithBuffer.copy();
		}catch(IOException ie) {
			System.out.println("Une erreur est survenue lors de la copie avec un flux tamponné");
		}
		try {
			SimpleCopyImage.copy();
		}catch(IOException ie) {
			System.out.println("Une erreur est survenue lors de la copie simple");
		}
		
		System.out.print(CopyImageWithBuffer.executionDuration < SimpleCopyImage.executionDuration);
	}

}
