package ie.gmit.dip;

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerSetup implements User {

	private ChatFrame serverChatFrame;
	private InputStream input;
	private OutputStream output;
	private Socket socket;
	private ServerSocket serverSocket;

	public ServerSetup() {
		serverChatFrame = new ChatFrame(this, "ChatServer", "ChatClient", false);
	}

	public void run() throws IOException {
		serverSocket = new ServerSocket(5000);
		System.out.println("SERVER:- Started listening to 5000");

		serverChatFrame.setActive(false);
		System.out.println("SERVER:- Waiting for client");
		socket = serverSocket.accept();

		input = socket.getInputStream();
		output = socket.getOutputStream();

		System.out.println("SERVER:- Connected to ChatClient!");
		serverChatFrame.resetChat();
		serverChatFrame.setActive(true);
	}

	@Override
	public void sendMessage() throws IOException {
		Scanner sc = new Scanner(System.in);
		String send = serverChatFrame.getMessage();
		if (send != null && !send.equals("")) {
			output.write(send.getBytes());
			serverChatFrame.addMessage("YOU", send);
			System.out.println("SERVER:- Message sent to client: " + send);
		} while (!output.equals("/q")) {
			System.exit(0);
		} 
	}

	@Override
	public int receiveMessage() throws IOException {
		byte request[] = new byte[1000];
		int status = input.read(request);
		String received = new String(request).trim();
		if (received != null && !received.equals("")) {
			serverChatFrame.addMessage("CLIENT", received);
			System.out.println("SERVER:- Received message from client: " + received);
		}
		return status;
	}

	public void reset() throws IOException {
		serverChatFrame.setActive(false);
		serverSocket.close();
		this.run();
	}
}
