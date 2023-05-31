
package Graphics;
import vehicle.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class AllVehicles {

    private ImageIcon imageVehicle;

    private JFrame frame;


    //constructor
    public AllVehicles() {

        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns
        frame.getContentPane().setBackground(Color.darkGray);


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
                int delay = new Random().nextInt(6) + 5;
                try{
                    Thread.sleep(delay * 1000);
                    new Loading("Charging");
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                if (!TestManager.isVehicleInTest(vehicle)) {
                    int result = JOptionPane.showConfirmDialog(frame, "Do you want to buy this vehicle?", "Confirmation",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "You are successfully bought this vehicle", "Congratulations", JOptionPane.INFORMATION_MESSAGE);

                        update(vehicle);
                        frame.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You can't buy this vehicle because it is already in test\n", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        return panel;
    }

    public void update(Vehicle vehicle) {
        Thread t = new Thread(() -> {
            try {
                synchronized (frameCars.vehicleList) {
                    Random rand = new Random();
                    int randomNum;
                    randomNum = 3000 + rand.nextInt((8000 - 3000) + 1);
                    Loading loading = new Loading("Updating Database...");
                    frameCars.vehicleList.remove(vehicle);
                    Thread.sleep(randomNum);
                    loading.setText("Update Done!");
                    Thread.sleep(700);
                    loading.terminate();
                }
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        });
        t.start();
    }
//
//    public void update() {
//        Thread t = new Thread(() -> {
//            try {
//                synchronized (frameCars.vehicleList) {
//                    Random rand = new Random();
//                    int randomNum;
//                    randomNum = 3000 + rand.nextInt((10000 - 5000) + 1);
//                    Loading loading = new Loading("Charging Database");
//                    Thread.sleep(randomNum);
//                    Thread.sleep(700);
//                    loading.terminate();
//                }
//            } catch (InterruptedException e) {
//                JOptionPane.showMessageDialog(null, "Error");
//            }
//        });
//        t.start();
//    }
}


