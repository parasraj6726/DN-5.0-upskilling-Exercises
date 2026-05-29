// Q35b: TCP Client
// Run after TCPServer in another terminal: javac TCPClient.java && java TCPClient
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to server at " + host + ":" + port);

            PrintWriter    out     = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in      = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while (true) {
                System.out.print("Client: ");
                userInput = console.readLine();
                out.println(userInput);
                if (userInput.equalsIgnoreCase("bye")) break;
                String reply = in.readLine();
                System.out.println("Server: " + reply);
            }
        }
        System.out.println("Client disconnected.");
    }
}
