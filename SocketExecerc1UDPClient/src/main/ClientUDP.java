package main;

import java.io.IOException;
import java.net.DatagramPacket;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP{
	private static int PORT = 8765;
	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("localhost");
		
		byte[] message1 = "Ceci est mon premier message".getBytes();
		byte[] message2 = "Ceci est mon deuxieme message".getBytes();
		
//		Envoie du packet 1
		sendPacket(message1, socket, address, PORT);
//		recevoir le message de bien recu
		String receivedMessage1 = getReceivedMessage(message1);
		System.out.println(receivedMessage1);
		
//		Envoie du packet 2
		sendPacket(message2, socket, address, PORT);
//		recevoir le message de bien recu
		String receivedMessage2 = getReceivedMessage(message1);
		System.out.println(receivedMessage2);
		
		socket.close();
	}
	
	public static void sendPacket(byte[] message, DatagramSocket socket, InetAddress address, int PORT) throws IOException {
		DatagramPacket packet = new DatagramPacket(message, message.length, address, PORT);
		socket.send(packet);
	}
	
	public static String getReceivedMessage(byte[] message) {
		DatagramPacket receivedPacket = new DatagramPacket(message, message.length);
		String receivedMessage = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
		return receivedMessage;
	}
}
//public class ClientUDP {
//
//	public static void main(String[] args) throws Exception {
//		DatagramSocket socket = new DatagramSocket();
//		InetAddress adress = InetAddress.getByName("localhost");
//		
//		byte[] message1 = "Salut, cv?".getBytes();
//		byte[] message2 = "J'espere que tu vas bien! Akay".getBytes();
//		
//		DatagramPacket packet1 = new DatagramPacket(message1, message1.length, adress, 8765);
//		socket.send(packet1);
//		packet1 = new DatagramPacket(message1, message1.length);
//		socket.receive(packet1);
//		String receive1 = new String(packet1.getData(), 0, packet1.getLength());
//		System.out.println("receive1: " + receive1);
//		
//		DatagramPacket packet2 = new DatagramPacket(message2, message2.length, adress, 8765);
//		socket.send(packet2);
//		packet2 = new DatagramPacket(message2, message2.length);
//		socket.receive(packet2);
//		String receive2 = new String(packet2.getData(), 0, packet2.getLength());
//		System.out.println("receive2: " + receive2);
//		
//		socket.close();
//	}
//
