package ie.gmit.dip;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientSetup implements User {
	private OutputStream output;
	private InputStream input;
	private ChatFrame clientChatFrame;

	public ClientSetup() {
		clientChatFrame = new ChatFrame(this, "ClientSetup", "ServerSetup", true);
	}

	public void run() throws IOException {
		Socket socket = new Socket("127.0.0.1", 5000);
		System.out.println("CLIENT:- Connected to ServerSetup!");

		input = socket.getInputStream();
		output = socket.getOutputStream();
	}

	public void sendMessage() throws IOException {
		Scanner sc = new Scanner(System.in);
		String send = clientChatFrame.getMessage();
		if (send != null && !send.equals("")) {
			output.write(send.getBytes());
			clientChatFrame.addMessage("YOU", send);
			System.out.println("CLIENT:- Message sent to ServerSetup: " + send);
		}
		 while (!output.equals("/q")) {
			System.exit(0);
		} 
	}

	@Override
	public int receiveMessage() throws IOException {
		byte[] response = new byte[1000];
		int status = input.read(response);
		String received = new String(response).trim();

		if (received != null && !received.equals("")) {
			clientChatFrame.addMessage("SERVER", received);
			System.out.println("CLIENT:- Received message from server: " + received);
		}
		return status;
	}


}
