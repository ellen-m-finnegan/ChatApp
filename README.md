ChatApp
<br />
A Chat App made in Java for Network Technologies module of H.Dip in Soft. Dev. that allows communication between a Server and Client.
Description:
•	ChatClient: Allows messages to be received
•	ChatFrame: Creates the chat boxes for ChatClient and ChatServer with text box, chat window, and send button. 
•	ChatServer: Allows messages to be received
•	ClientSetup: Sets up the Client
•	ServerSetup: Sets up the Server
•	User: Sends and receives messages
How to run?
Open two different terminals/command-prompt windows and then from project directory:
1.	cd bin (On both windows)
2.	java ChatServer (On one window)
3.	java ChatClient (On another window)
4.	/q to quit application (On either window)

You can now type messages to and from the Client and Server and press "Send" to send the message.
Notes:
•	Server should be started before running the Client.
•	Since it is a TCP type connection, communication will happen only when both Server and Client are up and running and a connection is established between them.
•	The Server also tells the activity status of the client i.e. when the Client is running and connection is established, the Server ChatFrame displays "Active Now" under the "Client" heading.
•	On closing the Client, the "Active Now" text goes away and the chat clears out. Now the Server is waiting for a new Client.
•	On closing the Server, the Client closes automatically.
