import java.net.*;
import java.util.*;
import java.io.*;
import java.util.function.Consumer;
public class Server {

    public Consumer<Socket>getConsumer(){
//        return new Consumer<Socket>() {
//            @Override
//            public void accept(Socket clientSocket){
//
//            }
//        };
        return (clientSocket)->{
            try{
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(),true);
                toClient.println("Hello from the server");
                toClient.close();
                clientSocket.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        };
    }
    public static void main(String[] args){
        int port = 8010; // The port number our server will listen on
        Server server = new Server(); // Create a server object
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("Server is listening on port "+port);
            while(true){
                Socket acceptedSocket = serverSocket.accept();
                Thread thread = new Thread(()->server.getConsumer().accept(acceptedSocket));
                thread.start();
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }






}