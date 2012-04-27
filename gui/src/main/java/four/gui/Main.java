package four.gui;

import four.gui.frames.JCounterFrame;

import javax.swing.*;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JCounterFrame counterFrame = new JCounterFrame();
                counterFrame.setLocationRelativeTo(null);
                counterFrame.setVisible(true);
            }
        });

    }
}
