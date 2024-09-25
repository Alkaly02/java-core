package server;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	private static DataInputStream dataInputStream;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(6666);
//		recuperation du socket client
		System.out.println("Serveur en attente de connexion");
		Socket clientSocket = ss.accept();
		
		dataInputStream = new DataInputStream(clientSocket.getInputStream());
		
		receiveFile("alkaly3.png");
		
		clientSocket.close();
		ss.close();
	}
	
	private static void receiveFile(String newFileName) throws Exception {
		File file = new File(newFileName);
		FileOutputStream fos = new FileOutputStream(file);
//		recuperer la taille du fichier envoyee par le client
		long sendedFileSize = dataInputStream.readLong();
		
		int bytes;
		byte[] buffer = new byte[8*1024];
		
		while(sendedFileSize>0 && (bytes = dataInputStream.read(buffer, 0, (int)Math.min(buffer.length, sendedFileSize))) != -1) {
			fos.write(buffer, 0, bytes);
		}
		fos.close();
		System.out.println("Ehhhhh voila un autre Alkaly :) !!!");
		
	}

}
