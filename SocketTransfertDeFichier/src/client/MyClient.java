package client;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class MyClient {
	private static DataOutputStream dataOutputStream;

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 7777);
		
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		sendFile("alkaly.txt");
		
		socket.close();
	
	}
	
	private static void sendFile(String path) throws Exception {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		
		int bytes = 0;
		byte[] buffer = new byte[4 * 1024];
		
		dataOutputStream.writeLong(file.length());
		
		while((bytes = fis.read(buffer)) != -1) {
			dataOutputStream.write(buffer, 0, bytes);
			dataOutputStream.flush();
		}
		fis.close();
	}
}
