package four.gui;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        final JMyFrame myFrame = new JMyFrame(String.format(JMyFrame.NAME_PATTERN, "0", "0", "0"));
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
}
