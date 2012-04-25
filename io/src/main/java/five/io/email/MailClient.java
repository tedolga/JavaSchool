package five.io.email;

import java.io.IOException;
import java.net.Socket;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class MailClient {
    private String host;
    private int port;

    public MailClient(String server, int port) {
        this.host = server;
        this.port = port;
    }

    public static void main(String[] args) throws IOException {
        MailClient mailClient = new MailClient("smtp.gmail.com", 587);
        mailClient.connect();
    }

    public void connect() throws IOException {
        Socket socket = new Socket(host, port);
        System.out.println(socket.getInetAddress());
    }
}
