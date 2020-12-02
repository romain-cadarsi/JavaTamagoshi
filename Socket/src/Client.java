import java.net.*;
import java.io.*;


public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    

    public Client() {

	}

	public void startConnection(String ip, int port) throws UnknownHostException, IOException {
        this.clientSocket = new Socket(ip, port);
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        this.out.println(msg);
        String resp = this.in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException {
    	Client client = new Client();
    	client.startConnection("127.0.0.1", 1235);
    	System.out.println(client.sendMessage(Utilisateur.saisieClavier()));
    	
    }
}
