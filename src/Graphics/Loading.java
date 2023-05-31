package Graphics;

import jdk.swing.interop.LightweightFrameWrapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
public class Loading extends JFrame {

    JLabel label = new JLabel("Loading...");

    public Loading(String update) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                run2(update);
            }
        });
    }

    public void terminate() {
        this.dispose();
    }

    public void updateUI() {
        this.repaint();
        this.revalidate();
    }

    public void setText(String update) {
        label.setText(update);
        this.repaint();
    }

    public void run2(String update) {
        label = new JLabel(update);
        JPanel bgPanel = new JPanel();
        label.setBounds(new Rectangle(20, 20, 40, 40));
        this.setResizable(false);
        bgPanel.add(label);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dispose();
            }
        });
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.add(bgPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
