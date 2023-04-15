package ie.gmit.dip;

import java.io.IOException;

public class ChatServer {

	public static void main(String[] args) throws IOException {
		ServerSetup server = new ServerSetup();
		server.run();

		while (true) {
			int status = server.receiveMessage();
			if (status == -1) {
				server.reset();
			}
		}
	}
}
