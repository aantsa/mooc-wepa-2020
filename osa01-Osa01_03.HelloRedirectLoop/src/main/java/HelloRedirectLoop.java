
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HelloRedirectLoop {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
        // waiting for the request
        Socket socket = server.accept();
            
        //read the request
        Scanner reader = new Scanner(socket.getInputStream());      
        String next = reader.nextLine();
        
        if(next.contains("/quit")){
            break;
        }
        //writing the answer
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println("HTTP/1.1 302 Found");
        writer.println("Location: http://localhost:8080/");
        
        writer.flush();

        reader.close();
        writer.close();
        socket.close();
        server.close();
        
       }
    }
}
