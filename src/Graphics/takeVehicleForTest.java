package Graphics;

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;

public class takeVehicleForTest {

    JFrame frame = new JFrame("Take vehicle for test");
    private ImageIcon imageVehicle;

    private JComboBox<Double> comboBox = new JComboBox<>(){};

    private JButton OK = new JButton("OK");




    //constructor

    public takeVehicleForTest() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns
        frame.getContentPane().setBackground(Color.darkGray);

        for (Double i = (double) 0; i < 200000; i+=5) {
            comboBox.addItem(i);
        }
        comboBox.setSelectedItem("choose a distance");

        ArrayList<JLabel> labels = new ArrayList<>();
        for (Vehicle i : frameCars.vehicleList) {
            JLabel label = VehiclePanels(i);
            frame.getContentPane().add(label);
            labels.add(label);

        }
        frame.setVisible(true);
    }
    public JLabel VehiclePanels(Vehicle vehicle) {
        JLabel panel = new JLabel();
        panel.setLayout(new GridLayout(2, 1)); // 2 rows
        // Add image
        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(200, 200));

        imageVehicle = new ImageIcon(vehicle.getImage().getImage());
//        System.out.println(vehicle.getPath());

        Image image = imageVehicle.getImage(); // transform it
        image = image.getScaledInstance(250, 300, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        this.imageVehicle = new ImageIcon(image);  // transform it back
        imageLabel.setIcon(imageVehicle);
        panel.add(imageLabel);
        // Add details
        JTextArea detailsArea = new JTextArea(vehicle.toString());
        detailsArea.setEditable(false);
        panel.add(detailsArea);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                synchronized (Vehicle.getSharedLock()) {
//                    JPanel panelcomboBox = new JPanel(new GridBagLayout());
//                    JOptionPane.showMessageDialog(null, comboBox, "choose distance ", JOptionPane.QUESTION_MESSAGE);
//                    panel.add(panelcomboBox);
                    int distance = Integer.parseInt(JOptionPane.showInputDialog("Please enter the distance you would like to drive.",null));

                    if (vehicle.getDistanceTraveled() + distance < 200000) {
                        if (!TestManager.isVehicleInTest(vehicle)) {
                            try {
                                vehicle.move(distance);
                                TestManager.startTest(vehicle, distance);
                                JOptionPane.showMessageDialog(null, "The vehicle is now being tested.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                //vehicle.TravelDistance(distance);
                            } catch (IllegalStateException ex) {
                                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "This vehicle is already being tested.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "You can't travel more than 200000 km", "Error", JOptionPane.ERROR_MESSAGE);
                        frame.dispose();
                    }
                }
            }

        });
        return panel;
    }




}