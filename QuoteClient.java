package test1;

import java.io.*;
import java.net.*;
 
/**
 * This program demonstrates how to implement a UDP client program.
 *
 *
 * @author www.codejava.net
 */
public class QuoteClient {
 
    public static void main(String[] argv) throws SocketException, UnknownHostException {
    	
    	 //
    	 // 1. Open UDP socket
    	 //
    	DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("hwlab1.scse.ntu.edu.sg"); // quote of the day server
    
		byte[] buffer = new byte[512];
			
		try {
			// 2. Send UDP Request to Server
			String message = new String("test");
			buffer = message.getBytes();
			DatagramPacket request = new DatagramPacket(buffer, buffer.length, address, 17); // QOTD port 17
			socket.send(request);
			
			// 3. Receive UDP Reply from Server
			buffer = new byte[65535];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			socket.receive(reply);
			String received = new String(reply.getData(), 0, reply.getLength());
			System.out.println(received);
			
		}catch (IOException e) {} 
		
		System.out.println("Closing Socket...");
		socket.close();
    }
}
