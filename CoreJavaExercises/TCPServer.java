// Q35a: TCP Server
// Run this first in one terminal: javac TCPServer.java && java TCPServer
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws Exception {
        int port = 5000;
        System.out.println("Server listening on port " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept()) {

            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter    out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String received;
            while ((received = in.readLine()) != null) {
                System.out.println("Client: " + received);
                if (received.equalsIgnoreCase("bye")) break;
                System.out.print("Server: ");
                String reply = console.readLine();
                out.println(reply);
            }
        }
        System.out.println("Server closed.");
    }
}
