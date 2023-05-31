/*
Sarah Khalifa : 342513066
Rudy Haddad : 336351481
 */
package Graphics;


import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class FrameForEachVehicleDetails extends JFrame implements ActionListener {

    //data members
    private JTextField modelNameField;

    private JTextField sourceOfEnergyField;
    private String modelName;
    private JTextField maxSpeedField;
    private JTextField AverageFuelConsumptionField;
    private JTextField AverageLifeTimeField;

    private ImageIcon image1, image2, image3;

    private JRadioButton radio1, radio2, radio3, validateButton;
    JLabel imageLabel;
    String vehicleType;
    private JComboBox<Integer> comboBoxPassengers, comboBoxWheels,comboBoxFuel, comboBoxLifeTime, comboBoxSpeed ;
    private JComboBox<String> comboBoxKindOfLand, comboBoxFlag;


    private JButton confirmButton;


    String path;

    //constructor
    public FrameForEachVehicleDetails (String vehicleType) {
        this.vehicleType = vehicleType;
        setTitle(vehicleType + " Details"); //title frame
        setSize(1000, 10000); //size frame
        setLocationRelativeTo(null); //center the frame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true); //show frame

        //images
        image1 = new ImageIcon("images/" + vehicleType + "Images/" + vehicleType + "1.jpg");
        image2 = new ImageIcon("images/" + vehicleType + "Images/" + vehicleType + "2.jpg");
        image3 = new ImageIcon("images/" + vehicleType + "Images/" + vehicleType + "3.jpg");

        //take image from imageIcon
        Image image1 = this.image1.getImage();
        Image image2 = this.image2.getImage();
        Image image3 = this.image3.getImage();

        //resize the image
        Image newImage1 = image1.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        Image newImage2 = image2.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        Image newImage3 = image3.getScaledInstance(800, 600, Image.SCALE_SMOOTH);

        //put back the image to imageIcon
        this.image1 = new ImageIcon(newImage1);
        this.image2 = new ImageIcon(newImage2);
        this.image3 = new ImageIcon(newImage3);

        //create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        getContentPane().add(panel);
        panel.setBackground(Color.DARK_GRAY);


//
//        //Radio Buttons for images
//        ButtonGroup group = new ButtonGroup();
//        radio1 = new JRadioButton(vehicleType + "1", true);
//        group.add(radio1);
//        radio1.addActionListener( this);
//        radio2 = new JRadioButton(vehicleType + "2");
//        group.add(radio2);
//        radio2.addActionListener( this);
//        radio3 = new JRadioButton(vehicleType + "3");
//        group.add(radio3);
//        radio3.addActionListener( this);
//
//        panel.add(radio1);
//        panel.add(radio2);
//        panel.add(radio3);

        //image label
        imageLabel = new JLabel();
        panel.add(imageLabel);
        imageLabel.setPreferredSize(new Dimension(400,250));

        confirmButton = new JButton("Confirm All");
        confirmButton.addActionListener(this);
        panel.add(confirmButton);


        switch (vehicleType) {
            case "Jeep": {

                //add text fields for model
                panel.add(panelModel());
                //combobox for max speed
                panel.add(panelMaxSpeed(1000));
                //combobox for fuel consumption
                panel.add(panelMaxFuel(100));
                //combobox for lifetime
                panel.add(panelLifeTime(100));
                break;
            }
            case "Frigate": {
                //add text fields for model
                panel.add(panelModel());
                //combobox MaxSpeed
                panel.add(panelMaxSpeed(1000));
                //combo box for Maximum passengers
                panel.add(panelMaxPassenger(50000));
                break;
            }
            case "GamePlane": {
                //no button needed for him
                break;
            }
            case "SpyPlane": {
                panel.add(panelSourceOfEnergy());
                break;
            }
            case "Bicycle": {
                panel.add(panelModel());
                panel.add(panelKindOfLand());
                break;
            }
            case "CruiseShip": {
                //add text fields for model
                panel.add(panelModel());
                //combobox MaxPassenger
                panel.add((panelMaxPassenger(10000)));
                //combobox MaxSpeed
                panel.add(panelMaxSpeed(1000));
                //combobox Flag
                panel.add(panelFlag());

                break;
            }
            case "Amphibious", "HybridPlane": {
                imageLabel.setPreferredSize(new Dimension(400, 200));
                //add text fields for model
                panel.add(panelModel());
                //combobox MaxSpeed
                panel.add(panelMaxSpeed(1000));
                //combobox number of wheels
                panel.add(panelNumberOfWheels());
                //combobox MaxFuel
                panel.add(panelMaxFuel(100));
                //combobox lifetime
                panel.add(panelLifeTime(100));
                //combobox max number of passenger
                panel.add(panelMaxPassenger(1000));

                break;
            }

            case "ElectricBicycle": {
                //add text fields for model
                panel.add(panelModel());
                //combobox MaxSpeed
                panel.add(panelMaxSpeed(1000));
                //combobox lifetime
                panel.add(panelLifeTime(100));
                break;
            }
        }
    }


    public JPanel panelModel(){
        JPanel panelModel = new JPanel();
        modelNameField = new JTextField("Enter Model Name", 25);
        panelModel.add(modelNameField);
        modelNameField.addActionListener(this);
//        validateButton = new JRadioButton("Confirm");
//        panelModel.add(validateButton);
//        validateButton.addActionListener(this);
        return panelModel;

    }

    public JPanel panelMaxSpeed(int limit){
        JPanel panelMaxSpeed = new JPanel();
        JLabel maxSpeedLabel = new JLabel("Enter Max Speed");
        panelMaxSpeed.add(maxSpeedLabel);
        comboBoxSpeed = new JComboBox<Integer>();
        for (int i = 5; i <= limit; i += 5) {
            comboBoxSpeed.addItem(i-1);
        }
        panelMaxSpeed.add(comboBoxSpeed);
        return panelMaxSpeed;
    }

    public JPanel panelMaxFuel(int limit){
        JPanel panelMaxFuel = new JPanel();
        JLabel maxFuelLabel = new JLabel("Enter Max Fuel");
        panelMaxFuel.add(maxFuelLabel);
        comboBoxFuel = new JComboBox<Integer>();
        for (int i = 1; i <= limit; i++) {
            comboBoxFuel.addItem(i);
        }
        panelMaxFuel.add(comboBoxFuel);
        return panelMaxFuel;
    }

    public JPanel panelLifeTime(int limit){
        JPanel panelLifeTime = new JPanel();
        JLabel lifeTimeLabel = new JLabel("Enter Life Time");
        panelLifeTime.add(lifeTimeLabel);
        comboBoxLifeTime = new JComboBox<Integer>();
        for (int i = 1; i <= limit; i++) {
            comboBoxLifeTime.addItem(i);
        }
        panelLifeTime.add(comboBoxLifeTime);
        return panelLifeTime;
    }

    public JPanel panelMaxPassenger(int limit){
        JPanel panelMaxPassenger = new JPanel();
        JLabel MaxPassengerLabel = new JLabel("Enter Max passenger");
        panelMaxPassenger.add(MaxPassengerLabel);
        comboBoxPassengers = new JComboBox<Integer>();
        for (int i = 1; i <= limit; i++) {
            comboBoxPassengers.addItem(i);
        }
        panelMaxPassenger.add(comboBoxPassengers);
        return panelMaxPassenger;
    }

    public JPanel panelSourceOfEnergy(){
        JPanel panelSourceOfEnergy = new JPanel();
        sourceOfEnergyField = new JTextField("Enter Source of Energy", 25);
        panelSourceOfEnergy.add(sourceOfEnergyField);
        sourceOfEnergyField.addActionListener(this);
//        validateButton = new JRadioButton("Confirm");
//        panelSourceOfEnergy.add(validateButton);
//        validateButton.addActionListener(this);
        return panelSourceOfEnergy;
    }

    public JPanel panelKindOfLand(){
        JPanel panelKindOfLand = new JPanel();
        JLabel labelKindOfLand = new JLabel("Choose Kind of Land");
        panelKindOfLand.add(labelKindOfLand);
        comboBoxKindOfLand = new JComboBox<String>();
        comboBoxKindOfLand.addItem("Paved");
        comboBoxKindOfLand.addItem("Dirt");
        panelKindOfLand.add(comboBoxKindOfLand);
        return panelKindOfLand;
    }

    public JPanel panelFlag(){
        JPanel PanelFlag = new JPanel();
        JLabel labelFlag = new JLabel("Choose Flag");
        PanelFlag.add(labelFlag);
        comboBoxFlag = new JComboBox<String>();
        comboBoxFlag.addItem("Israel");
        comboBoxFlag.addItem("United States");
        comboBoxFlag.addItem("Greece");
        comboBoxFlag.addItem("Germany");
        comboBoxFlag.addItem("Somalia");
        comboBoxFlag.addItem("Jolly Roger");
        PanelFlag.add(comboBoxFlag);
        return PanelFlag;
    }

    public JPanel panelNumberOfWheels(){
        JPanel panelNumberOfWheels = new JPanel();
        JLabel labelNumberOfWheels = new JLabel("Choose Number Of Wheels");
        panelNumberOfWheels.add(labelNumberOfWheels);
        comboBoxWheels = new JComboBox<Integer>();
        for (int i = 1; i <= 20; i++) {
            comboBoxWheels.addItem(i);
        }
        panelNumberOfWheels.add(comboBoxWheels);
        return panelNumberOfWheels;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == radio1){
            imageLabel.setIcon(image1);
            path = "images/" + vehicleType + "Images/" + vehicleType + "1.jpg";
        }
        if (source == radio2){
            imageLabel.setIcon(image2);
            path = "images/" + vehicleType + "Images/" + vehicleType + "2.jpg";
        }
        if (source == radio3){
            imageLabel.setIcon(image3);
            path = "images/" + vehicleType + "Images/" + vehicleType + "3.jpg";
        }
//        if (source == validateButton){
//            modelName = modelNameField.getText();
//        }
        if (source == comboBoxSpeed){
            double selectValue = (double) comboBoxSpeed.getSelectedItem();
        }
        if(source == confirmButton){
            switch (vehicleType) {
                case "Jeep": {
                    ImageIcon img = getImageFromUser();
                    if (img == null) {
                        img = new ImageIcon("src/ImgSource/jeep3.png");
                        img = new ImageIcon(img.getImage().getScaledInstance(180, 170, Image.SCALE_DEFAULT));
                    }
                    update(new Jeep(modelNameField.getText(), (Integer) comboBoxSpeed.getSelectedItem(), (Integer) comboBoxFuel.getSelectedItem(), (Integer) comboBoxLifeTime.getSelectedItem(), img));
                    break;
                }
                case "Frigate": {
                    ImageIcon img = getImageFromUser();
                    if (img == null) {
                        img = new ImageIcon("src/ImgSource/frigate.png");
                        img = new ImageIcon(img.getImage().getScaledInstance(180, 170, Image.SCALE_DEFAULT));
                    }
                    update(new Frigate(modelNameField.getText(), (Integer) comboBoxPassengers.getSelectedItem(),(Integer) comboBoxSpeed.getSelectedItem(),true, img));
                    break;
                }
//                case "GamePlane": {
//                    update((new GamePlane(path)));
//                    break;
//                }
//                case "SpyPlane": {
//                    update(new SpyPlane(sourceOfEnergyField.getText(),path));
//                    break;
//                }
//                case "Bicycle": {
//                    if (comboBoxKindOfLand.getSelectedItem() == "Paved")
//                        update(new Bicycle(modelNameField.getText(), LandVehicle.kindOfLand.paved,path));
//                    else
//                        update(new Bicycle(modelNameField.getText(), LandVehicle.kindOfLand.dirt,path));
//                    break;
//                }
//                case "CruiseShip": {
//                    update(new CruiseShip(modelNameField.getText(), (Integer) comboBoxPassengers.getSelectedItem(),(Double)comboBoxSpeed.getSelectedItem(), (String) comboBoxFlag.getSelectedItem() , path));
//                    break;
//                }
//                case "Amphibious", "HybridPlane": {
//                    if (vehicleType == "Amphibious")
//                        update(new Amphibious(modelNameField.getText(), (Double) comboBoxSpeed.getSelectedItem(), (Integer) comboBoxWheels.getSelectedItem(), (Double) comboBoxFuel.getSelectedItem(), (Double) comboBoxLifeTime.getSelectedItem(),(Integer) comboBoxPassengers.getSelectedItem(), path));
//                    else
//                        update(new HybridPlane(modelNameField.getText(), (Double) comboBoxSpeed.getSelectedItem(), (Integer) comboBoxWheels.getSelectedItem(), (Double) comboBoxFuel.getSelectedItem(), (Double) comboBoxLifeTime.getSelectedItem(),(Integer) comboBoxPassengers.getSelectedItem(), path));
//                    break;
//                }
//                case "ElectricBicycle": {
//                    update(new ElectricBicycle(modelNameField.getText(), (Double) comboBoxSpeed.getSelectedItem(), (Double) comboBoxLifeTime.getSelectedItem(), path));
//                    break;
//                }

            }

            // essaie du bouton confirm

            this.dispose();
            frameCars frameCars = new frameCars();


        }


    }

    public void update(Vehicle vehicle) {
        Thread t = new Thread(() -> {
            try {
                synchronized (frameCars.vehicleList) {
                    Random rand = new Random();
                    int randomNum;
                    randomNum = 3000 + rand.nextInt((8000 - 3000) + 1);
                    Loading loading = new Loading("Updating Database...");
                    frameCars.vehicleList.add(vehicle);
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

    private ImageIcon getImageFromUser() {
        ImageIcon imageIcon = null;
        JFileChooser fileChooser = new JFileChooser();
        String[] button = {"Set by default", "Upload an image"};
        int option = JOptionPane.showOptionDialog(this, "Select Your option please",
                "Set the image for the vehicle", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,
                null,button, button[0]);
        if (option == 1 ) {
            int result = fileChooser.showOpenDialog(this);
            do {
                if (result == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(this,
                            "You must select an image file", "Select Image", JOptionPane.ERROR_MESSAGE);
                    result = fileChooser.showOpenDialog(this);
                }
            } while (result == JFileChooser.CANCEL_OPTION);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    imageIcon = new ImageIcon(Files.readAllBytes(selectedFile.toPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (imageIcon != null) {
                imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(180, 170, Image.SCALE_DEFAULT));
            }
        }
        if(imageIcon == null) JOptionPane.showMessageDialog(this, "The image will be setting by default");
        return imageIcon;
    }
}




