package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BuyingDialog extends JDialog {

    private int result = -1;

    public BuyingDialog(Frame window, JPanel panel) {
        super(window, "Buying a vehicle", true);
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
                result = JOptionPane.OK_OPTION;
                int x = e.getX();
                int y = e.getY();
                for (int i = 0; i < panel.getComponentCount(); i++) {
                    if (x >= panel.getComponent(i).getX() && x <= panel.getComponent(i).getX() + panel.getComponent(i).getWidth() &&
                            y >= panel.getComponent(i).getY() && y <= panel.getComponent(i).getY() + panel.getComponent(i).getHeight()) {
                        System.out.println("Vehicle " + i + " clicked");
                        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this Vehicle?", "Exit", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            panel.remove(i);
                            panel.repaint();
                            panel.revalidate();
                            JOptionPane.showMessageDialog(null, "Vehicle bought successfully.");
                            result = JOptionPane.CANCEL_OPTION;
                            setVisible(false);

                        } else {
                            JOptionPane.showMessageDialog(null, "Vehicle not bought.");
                        }
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

    public void showDialog() {
        setSize(1000, 800);
        setMinimumSize(new Dimension(1000, 800));
        setLocation(250, 80);
        setVisible(true);
    }
}
