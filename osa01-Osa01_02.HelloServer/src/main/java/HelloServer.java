

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Scanner;

public class HelloServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Syötä osoite: ");
        
        while (true) {
        // odotetaan pyyntöä
        Socket socket = server.accept();
            
        // luetaan pyyntö
        Scanner reader = new Scanner(socket.getInputStream());      
        String next = reader.nextLine();
        
        if(next.contains("/quit")){
            break;
        }
       
        // kirjoitetaan vastaus
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println("HTTP/1.1 200 OK");
        writer.println("");
        
        
        try (Scanner scanner = new Scanner(Paths.get("index.html"))) {
             while (scanner.hasNextLine()) {
                 System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {

        }
        writer.flush();
        // vapautetaan resurssit
        reader.close();
        writer.close();
        socket.close();
        server.close();
        }
    }
}
