package main;

import java.io.*;

public class MainActivity {
	public static void main(String[] args) throws IOException {
//		FileInputStream in = null;
//		FileOutputStream out = null;
		final String currentDir = System.getProperty("user.dir");
//		
//		
//		in = new FileInputStream(currentDir + "/src/main/input.txt");
//		out = new FileOutputStream(currentDir + "/src/main/output.txt");
//		
//		int c;
//		while((c = in.read()) != -1) {
//			System.out.println(c);
//			out.write(c);
//		}
//		in.close();
//		out.close();
		FileOutputStream outputStream = new FileOutputStream("exemple.txt");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		bufferedOutputStream.write("Hello lka".getBytes());
		
		bufferedOutputStream.close();
	}
}
