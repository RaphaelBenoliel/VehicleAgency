/*
Sarah Khalifa : 342513066
Rudy Haddad : 336351481
 */
package Graphics;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//import my packages
import vehicle.*;

public class frameCars extends JFrame implements ActionListener {

    //data members
    static ArrayList<Vehicle> vehicleList; //np modifier (only for package gui)
    public static void main(String[] args) {

        //create new array list
        //create new object
        vehicleList = new ArrayList<Vehicle>();
        frameCars frame = new frameCars();

    }

    //data members

    //all Buttons
    private final JButton buttonJeep = new JButton();
    private final JButton buttonFrigate = new JButton();
    private final JButton buttonGamePlane = new JButton();
    private final JButton buttonSpyPlane = new JButton();
    private final JButton buttonBicycle = new JButton();
    private final JButton buttonCruise = new JButton();
    private final JButton buttonAmphibious = new JButton();
    private final JButton buttonElectricBicycle = new JButton();
    private final JButton buttonHybridPlane = new JButton();
    private final JButton buttonShowAllVehicle = new JButton();


    //constructor
    public frameCars() {
        super("Car Agency");
        this.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 5));
        getContentPane().add(panel);
        //all images icons
        ImageIcon iconJeep = new ImageIcon("src/ImgSource/jeep3.png");
        ImageIcon iconFrigate = new ImageIcon("src/ImgSource/frigate.png");
        ImageIcon iconGamePlane = new ImageIcon("images/Icons/gamePlane.png");
        ImageIcon iconSpyPlane = new ImageIcon("images/Icons/spyPlane.png");
        ImageIcon iconBicycle = new ImageIcon("images/Icons/bicycle.png");
        ImageIcon iconCruise = new ImageIcon("images/Icons/cruiseShip.png");
        ImageIcon iconAmphibious = new ImageIcon("images/Icons/amphibious.png");
        ImageIcon iconElectricBicycle = new ImageIcon("images/Icons/electricBicycle.png");
        ImageIcon iconHybridPlane = new ImageIcon("images/Icons/hybridPlane.png");
        ImageIcon iconMenu = new ImageIcon("images/Icons/menu.png");
        //all labels buttons
        JLabel labelJeep = new JLabel("Jeep");
        JLabel labelFrigate = new JLabel("Frigate");
        JLabel labelGamePlane = new JLabel("Game Plane");
        JLabel labelSpyPlane = new JLabel("Spy Plane");
        JLabel labelBicycle = new JLabel("Bicycle");
        JLabel labelCruise = new JLabel("Cruise");
        JLabel labelAmphibious = new JLabel("Amphibious");
        JLabel labelElectricBicycle = new JLabel("Electric Bicycle");
        JLabel labelHybridPlane = new JLabel("Hybrid Plane");
        JLabel labelMenu = new JLabel("Show All Vehicles");



        //add all panels
        panel.add(newPanel(iconJeep, labelJeep, buttonJeep));
        panel.add(newPanel(iconFrigate, labelFrigate, buttonFrigate));
        panel.add(newPanel(iconGamePlane, labelGamePlane, buttonGamePlane));
        panel.add(newPanel(iconSpyPlane, labelSpyPlane, buttonSpyPlane));
        panel.add(newPanel(iconBicycle, labelBicycle, buttonBicycle));
        panel.add(newPanel(iconCruise, labelCruise, buttonCruise));
        panel.add(newPanel(iconAmphibious, labelAmphibious, buttonAmphibious));
        panel.add(newPanel(iconElectricBicycle, labelElectricBicycle, buttonElectricBicycle));
        panel.add(newPanel(iconHybridPlane, labelHybridPlane, buttonHybridPlane));
        panel.add(newPanel(iconMenu, labelMenu, buttonShowAllVehicle));

        //action listeners
        buttonShowAllVehicle.addActionListener(this);
        buttonJeep.addActionListener(this);
        buttonFrigate.addActionListener(this);
        buttonGamePlane.addActionListener(this);
        buttonSpyPlane.addActionListener(this);
        buttonBicycle.addActionListener(this);
        buttonCruise.addActionListener(this);
        buttonAmphibious.addActionListener(this);
        buttonElectricBicycle.addActionListener(this);
        buttonHybridPlane.addActionListener(this);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setVisible(true);
    }

    public JPanel newPanel(ImageIcon icon, JLabel label, JButton button){
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        button.setIcon(icon);
        button.setPreferredSize(new Dimension(500, 500));
        label.setForeground(Color.WHITE);
        panel.add(button);
        panel.add(label);
        return panel;
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonShowAllVehicle) {
            // Open new frame for menu
            this.dispose(); // Close current frame
            OnlySeeAllVehicle onlySeeAllVehicle = new OnlySeeAllVehicle();
            MenuFrame menuFrame = new MenuFrame();
        }
        if (e.getSource() == buttonJeep) {
            // Open new frame for menu
            FrameForEachVehicleDetails detailsForJeep = new FrameForEachVehicleDetails("Jeep");
            this.dispose(); // Close current frame
        }
        if (e.getSource() == buttonFrigate) {
            // Open new frame for menu
            FrameForEachVehicleDetails detailsForFrigate = new FrameForEachVehicleDetails("Frigate");
            this.dispose(); // Close current frame
        }
        if (e.getSource() == buttonGamePlane) {
            // Open new frame for menu
            FrameForEachVehicleDetails detailsForGamePlane = new FrameForEachVehicleDetails("GamePlane");
            this.dispose(); // Close current frame
        }
        if (e.getSource() == buttonSpyPlane) {
            // Open new frame for menu
            FrameForEachVehicleDetails detailsForSpyPlane = new FrameForEachVehicleDetails("SpyPlane");
            this.dispose(); // Close current frame
        }
        if (e.getSource() == buttonBicycle) {
            // Open new frame for menu
            FrameForEachVehicleDetails detailsForBicycle = new FrameForEachVehicleDetails("Bicycle");
            this.dispose(); // Close current frame
        }
        if (e.getSource() == buttonCruise) {
            // Open new frame for menu
            FrameForEachVehicleDetails detailsForCruise = new FrameForEachVehicleDetails("CruiseShip");
            this.dispose(); // Close current frame
        }
        if (e.getSource() == buttonAmphibious) {
            // Open new frame for menu
            FrameForEachVehicleDetails detailsForAmphibious = new FrameForEachVehicleDetails("Amphibious");
            this.dispose(); // Close current frame
        }
        if (e.getSource() == buttonElectricBicycle) {
            // Open new frame for menu
            FrameForEachVehicleDetails detailsForElectricBicycle = new FrameForEachVehicleDetails("ElectricBicycle");
            this.dispose(); // Close current frame
        }
        if (e.getSource() == buttonHybridPlane) {
            // Open new frame for menu
            FrameForEachVehicleDetails detailsForHybridPlane = new FrameForEachVehicleDetails("HybridPlane");
            this.dispose(); // Close current frame
        }

    }
}


