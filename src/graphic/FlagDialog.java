package graphic;

import javax.swing.*;

public class FlagDialog extends JDialog {

    public FlagDialog(JFrame window, JPanel panel) {
        super(window, "Flag a vehicle", true);

        add(panel);
        JButton buttonExit = new JButton("Return to Menu");
        buttonExit.addActionListener(e -> {
            setVisible(false);
        });
        this.add(buttonExit);
    }
}
