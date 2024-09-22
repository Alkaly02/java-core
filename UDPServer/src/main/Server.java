package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DatagramSocket socket = new DatagramSocket(8765);
		byte[] receiveMessage = new byte[1024];
		
		while(true) {
			DatagramPacket packet = new DatagramPacket(receiveMessage, receiveMessage.length);
			socket.receive(packet);
			String message = new String(packet.getData(), 0, packet.getLength());
			System.out.println("Message recu :" + message);
			
			InetAddress address = packet.getAddress();
			int port = packet.getPort();
			
			byte[] messageRecu = "Votre message est bien recu".getBytes();
			DatagramPacket accuseReception = new DatagramPacket(messageRecu, messageRecu.length, address, port);
			socket.send(accuseReception);
		}
//		socket.close();
	}

}
