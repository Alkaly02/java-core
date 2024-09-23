package main;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Client {
	private static DataOutputStream dataOutputStream;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost", 8888);
		
		dataOutputStream = new DataOutputStream(socket.getOutputStream());
		
		sendFile("message.txt");
		
		dataOutputStream.close();
		socket.close();
	}
	
	private static void sendFile(String path) throws Exception {
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		
		dataOutputStream.writeLong(file.length());
		
		int bytes;
		byte[] buffer = new byte[4*1024];
		
		while( (bytes = fis.read(buffer)) != -1) {
			dataOutputStream.write(buffer, 0, bytes);
			dataOutputStream.flush();
		}
		fis.close();
	}

}
