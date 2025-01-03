package client;

import ocsf.client.AbstractClient;

public class LibraryClient extends AbstractClient {

    // Constructor to initialize the client with the server's host and port
    public LibraryClient(String host, int port) {
        super(host, port);
    }

    // Method to handle messages received from the server
    @Override
    protected void handleMessageFromServer(Object msg) {
        // Print the message from the server
        System.out.println("Message from server: " + msg);
    }

    // Main method to test the client
    public static void main(String[] args) {
        try {
            // Create an instance of LibraryClient and connect to the server
            LibraryClient client = new LibraryClient("localhost", 5555); // Host: localhost, Port: 12345
            client.openConnection(); // Open the connection to the server
            System.out.println("Connected to server.");

            // Test sending a message to the server
            client.sendToServer("Hello, server!");
        } catch (Exception e) {
            e.printStackTrace(); // Print any connection errors
        }
    }
}

