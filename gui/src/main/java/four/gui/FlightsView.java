package four.gui;

import four.gui.frames.JFlightFrame;

import javax.swing.*;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class FlightsView {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFlightFrame flightFrame = new JFlightFrame();
                flightFrame.setLocationRelativeTo(null);
                flightFrame.setVisible(true);
            }
        });

    }
}
