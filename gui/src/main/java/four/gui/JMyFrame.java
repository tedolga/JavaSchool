package four.gui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class JMyFrame extends JFrame {

    private static final int FRAME_WIDHT = 500;
    private static final int FRAME_HEIGHT = 400;

    public JMyFrame(String title) throws HeadlessException {
        super(title);
        frameInit();
    }

    @Override
    public void frameInit() {
        super.frameInit();
        setSize(FRAME_WIDHT, FRAME_HEIGHT);
    }

}
