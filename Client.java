import java.net.*;
import java.io.*;

public class Client {

    // Inner class to handle client logic (each client runs in its own thread)
    static class ClientTask implements Runnable {
        private final int port;

        public ClientTask(int port) {
            this.port = port;
        }

        @Override
        public void run() {
            try {
                InetAddress address = InetAddress.getByName("localhost");
                Socket socket = new Socket(address, port);

                // Send message to server
                PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                toSocket.println("Hello from the client");

                // Receive response from server
                BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = fromSocket.readLine();
                System.out.println("Response from server: " + line);

                // Close resources
                fromSocket.close();
                toSocket.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int port = 8010;

        // Start multiple clients
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new ClientTask(port));
            thread.start();
        }
    }
}
