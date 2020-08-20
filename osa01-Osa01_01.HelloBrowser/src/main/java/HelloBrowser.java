
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HelloBrowser {

    public static void main(String[] args) throws Exception {
        System.out.println("Where to?");
        Scanner input = new Scanner(System.in);
        String address = input.nextLine();
        int gate = 80;
        
        //Create connection
        Socket socket = new Socket(address, gate);
        
        //Send message to the server
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println("GET / HTTP/1.1");
        writer.println("Host: " + address);
        writer.println();
        writer.flush();
        
        // Read the answer from the server
        Scanner reader = new Scanner(socket.getInputStream());
        while (reader.hasNextLine()){
            System.out.println(reader.nextLine());
        }
        
    }
}
