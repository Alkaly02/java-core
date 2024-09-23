package main;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static DataInputStream dataInputStream;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(8888);
		
		Socket clientSocket = ss.accept();
		dataInputStream = new DataInputStream(clientSocket.getInputStream());
		
		receiveFile("copieFichier2.txt");
		
		clientSocket.close();
		ss.close();
	}
	
	private static void receiveFile(String newFileName) throws Exception {
		File file = new File(newFileName);
		FileOutputStream fos = new FileOutputStream(file);
		
		long receivedFIleSize = dataInputStream.readLong();
		int bytes;
		byte[] buffer = new byte[4*1024];
		
		while(receivedFIleSize > 0 && 
		(bytes = dataInputStream.read(buffer, 0, (int)Math.min(buffer.length, receivedFIleSize))) != -1) {
			fos.write(buffer, 0, bytes);
		}
		fos.close();
		System.out.println("Fichier recu");
	}

}
