package five.io.email;

import five.io.file.IOUtils;

import java.io.*;
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
        System.setProperty("mail.smtp.starttls.enable", "true");
        MailClient mailClient = new MailClient("smtp.yandex.ru", 25);
        EMailMessage eMailMessage = new EMailMessage("smtp.yandex.ru", "tedolga@yandex.ru", "tedolga@yandex.ru", "Hello");
        mailClient.sendMessage(eMailMessage);
    }

    public void sendMessage(EMailMessage mailMessage) throws IOException {
        Socket socket = null;
        PrintWriter writer = null;
        try {
            socket = new Socket(host, port);
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            writer = new PrintWriter(outputStream);
            writer.write(mailMessage.formatMessage());
            writer.flush();
            ByteArrayOutputStream response = IOUtils.readFully(inputStream);
            System.out.println("response = " + new String(response.toByteArray()));
        } finally {
            IOUtils.closeSafely(writer);
            if (socket != null) {
                socket.close();
            }
        }
    }
}
