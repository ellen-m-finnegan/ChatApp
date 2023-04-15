package ie.gmit.dip;

import java.io.IOException;

public class ChatClient {

	public static void main(String[] args) throws IOException {
		ClientSetup client = new ClientSetup();
		client.run();

		while (true) {
			int status = client.receiveMessage();
			if (status == -1) {
				System.exit(0);
			} 
		}
	}
}