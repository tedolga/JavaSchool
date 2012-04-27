package four.gui.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class JCounterFrame extends JFrame {
    public static final String NAME_PATTERN = "Minimized:%s ,Gained: %s, Lost focus: %s";
    private static final int FRAME_WIDHT = 500;
    private static final int FRAME_HEIGHT = 400;

    public JCounterFrame() throws HeadlessException {
        super();
        frameInit();
    }

    @Override
    public void frameInit() {
        super.frameInit();
        setSize(FRAME_WIDHT, FRAME_HEIGHT);
        WindowAdapter windowAdapter = new CountAdapter();
        addWindowFocusListener(windowAdapter);
        addWindowListener(windowAdapter);
    }

    private class CountAdapter extends WindowAdapter {
        int minCount = 0;
        int gainCount = 0;
        int lostCount = 0;

        /**
         * Invoked when a window is iconified.
         */
        @Override
        public void windowIconified(WindowEvent e) {
            minCount += 1;
            updateTitle();
        }

        /**
         * Invoked when the Window is set to be the focused Window, which means
         * that the Window, or one of its subcomponents, will receive keyboard
         * events.
         *
         * @since 1.4
         */
        @Override
        public void windowGainedFocus(WindowEvent e) {
            gainCount += 1;
            updateTitle();
        }

        /**
         * Invoked when the Window is no longer the focused Window, which means
         * that keyboard events will no longer be delivered to the Window or any of
         * its subcomponents.
         *
         * @since 1.4
         */
        @Override
        public void windowLostFocus(WindowEvent e) {
            lostCount += 1;
            updateTitle();
        }

        private void updateTitle() {
            JCounterFrame.this.setTitle(String.format(NAME_PATTERN, String.valueOf(minCount),
                    String.valueOf(gainCount), String.valueOf(lostCount)));
        }
    }

}


