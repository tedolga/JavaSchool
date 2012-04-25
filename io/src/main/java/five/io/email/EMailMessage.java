package five.io.email;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class EMailMessage {
    private String senderHost;
    private String senderAddress;
    private String recipientAddress;
    private String message;


    public EMailMessage(String senderHost, String senderAddress, String recipientAddress, String message) {
        this.senderHost = senderHost;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.message = message;
    }

    public String formatMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("HELO ");
        builder.append(senderHost);
        builder.append("\n");
        builder.append("MAIL FROM: ");
        builder.append(senderAddress);
        builder.append("\n");
        builder.append("RCPT TO:");
        builder.append(recipientAddress);
        builder.append("\n");
        builder.append("DATA");
        builder.append("\n");
        builder.append(message);
        builder.append("\n");
        builder.append(".\nQUIT\n");
        return builder.toString();
    }
}
