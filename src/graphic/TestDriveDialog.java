package graphic;

import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The TestDriveDialog class represents a dialog for test-driving a vehicle.
 */
public class TestDriveDialog extends JDialog {

    private int result = -1;
    private int index = -1;

    public TestDriveDialog(Frame window, JPanel panel) {
        super(window, "Test Drive a vehicle", true);

        add(panel);
        JButton buttonExit = new JButton("Return to Menu");
        buttonExit.addActionListener(e -> {
            result = JOptionPane.CANCEL_OPTION;
            setVisible(false);
        });
        this.add(buttonExit, BorderLayout.SOUTH);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                index = -1;
                result = JOptionPane.OK_OPTION;
                int x = e.getX();
                int y = e.getY();
                for (int i = 0; i < panel.getComponentCount(); i++) {
                    // check if the mouse click is inside the bounds of the vehicle image.
                    if (x >= panel.getComponent(i).getX() && x <= panel.getComponent(i).getX() + panel.getComponent(i).getWidth() &&
                            y >= panel.getComponent(i).getY() && y <= panel.getComponent(i).getY() + panel.getComponent(i).getHeight()) {
                        System.out.println("Vehicle " + i + " clicked");
                        int option = JOptionPane.showConfirmDialog(null, "Do you want to take this Vehicle to a test drive?", "Exit", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            index = i;
                            setVisible(false);
                        }
                        else index = -1;
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public int getIndex() {
        return index;
    }
    public void showDialog() {
        setSize(1000,800);
        setMinimumSize(new Dimension(1000, 800));
        setLocation(250, 80);
        setVisible(true);
    }
}
