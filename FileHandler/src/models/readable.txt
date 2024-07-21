package models;

import java.io.*;

//Learning File Handling
//Trying to understand streams
public class FIleHandler {
	public static void handle() {
		try {
			File sourceFile = new File("source.txt");
			File destinationFile = new File("destination.txt");
			
			FileReader fileReader = new FileReader(sourceFile);
			FileWriter fileWriter = new FileWriter(destinationFile);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			String line;
			while((line = bufferedReader.readLine()) != null) {
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
			
			bufferedReader.close();
			bufferedWriter.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
