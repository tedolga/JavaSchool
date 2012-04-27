package four.gui.frames;

import javax.swing.*;
import java.awt.*;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class JFlightFrame extends JFrame {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;

    public JFlightFrame() {
        super();
        frameInit();
    }

    @Override
    protected void frameInit() {
        super.frameInit();
        setTitle("Flights");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));
        searchPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        JLabel toLabel = new JLabel("To: ");
        searchPanel.add(toLabel, c);
        JTextField toField = new JTextField();
        toField.setColumns(20);
        c.gridx = 1;
        searchPanel.add(toField, c);
        JLabel fromLabel = new JLabel("From: ");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        searchPanel.add(fromLabel, c);
        JTextField fromField = new JTextField();
        fromField.setColumns(20);
        c.gridx = 1;
        searchPanel.add(fromField, c);

        JLabel whenLabel = new JLabel("When: ");
        JPanel resultsPanel = new JPanel();
        resultsPanel.setBorder(BorderFactory.createTitledBorder("Results"));
        mainPanel.add(searchPanel);
        mainPanel.add(resultsPanel);
        add(mainPanel);
    }
}
