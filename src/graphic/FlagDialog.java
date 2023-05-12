package graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * The BuyingDialog class represents a dialog for buying a vehicle.
 */
public class FlagDialog extends JDialog {
    private int result = -1;

    /**
     * Constructs a BuyingDialog object with the given window and panel.
     * @param window the window of the parent frame (VehicleAgencyGUI).
     */
    public FlagDialog(JFrame window) {
        super(window, "Changing all vessels flags", true);

        JButton buttonExit = new JButton("Return to Menu");
        this.add(buttonExit, BorderLayout.SOUTH);
        buttonExit.addActionListener(e -> setVisible(false));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        JLabel israelFlag = new JLabel(new ImageIcon("src/imgSource/israel.png"));
        israelFlag.setName("Israel");

        JLabel usaFlag = new JLabel(new ImageIcon("src/imgSource/USA.png"));
        usaFlag.setName("USA");
        JLabel germanyFlag = new JLabel(new ImageIcon("src/imgSource/germany.png"));
        germanyFlag.setName("Germany");
        JLabel italyFlag = new JLabel(new ImageIcon("src/imgSource/italy.png"));
        italyFlag.setName("Italy");
        JLabel greeceFlag = new JLabel(new ImageIcon("src/imgSource/Greece.png"));
        greeceFlag.setName("Greece");
        JLabel somaliaFlag = new JLabel(new ImageIcon("src/imgSource/somalia.png"));
        somaliaFlag.setName("Somalia");
        JLabel pirateFlag = new JLabel(new ImageIcon("src/imgSource/pirate.png"));
        pirateFlag.setName("Pirate");
        panel.add(israelFlag);
        panel.add(usaFlag);
        panel.add(germanyFlag);
        panel.add(italyFlag);
        panel.add(greeceFlag);
        panel.add(somaliaFlag);
        panel.add(pirateFlag);
        add(panel);
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                result = -1;
                int x = e.getX();
                int y = e.getY();
                for (int i = 0; i < panel.getComponentCount(); i++) {
                    // check if the mouse click is inside the bounds of the vehicle image.
                    if (x >= panel.getComponent(i).getX() && x <= panel.getComponent(i).getX() + panel.getComponent(i).getWidth() &&
                            y >= panel.getComponent(i).getY() && y <= panel.getComponent(i).getY() + panel.getComponent(i).getHeight()) {
                        System.out.println("flag " + panel.getComponent(i).getName() + " clicked");
                        int option = JOptionPane.showConfirmDialog(null, "You choose the "+
                                panel.getComponent(i).getName()+" flag.\nAre you sure dou you want to change all vessels to this flag?", "Exit", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            setVisible(false);
                            result = i;
                        }
                        else result = -1;
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    public int getResult(){ return result; }
    public void showDialog(){
        setSize(1000,820);
        setMinimumSize(new Dimension(1000, 800));
        setLocation(250, 80);
        setVisible(true);
    }
}
