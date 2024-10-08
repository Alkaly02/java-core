package models;

import java.io.*;
//Learning File Handling
//Trying to understand streams
public class FIleHandler {
	public static void handle() {
		File starting = new File(System.getProperty("user.dir"));
		try {
			File sourceFile = new File(starting, "/src/models/readable.txt");
			File destinationFile = new File(starting,"/src/models/destination.txt");
			
			FileReader fileReader = new FileReader(sourceFile);
			FileWriter fileWriter = new FileWriter(destinationFile);
			
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			String line;
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
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
