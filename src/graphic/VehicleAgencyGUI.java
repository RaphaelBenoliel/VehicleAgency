package graphic;

import vehicle.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class VehicleAgencyGUI extends JFrame implements ActionListener,MouseListener {

    private Vehicle[] agency;
    private Popup popup;
    JPanel vehiclePanel;
    JPanel mainPanel ;
    static int serialNum = 0;
    public VehicleAgencyGUI() {
        initMainPanel();
    }

    private void initMainPanel()  {
        // Initialize vehicle agency
        mainPanel = new JPanel();
        vehiclePanel = new JPanel();
        do {
            Vehicle tmp = createVehicle();
            if (tmp != null)
                this.agency = addVehicle(agency, tmp);
            if (agency == null) {
                JOptionPane.showMessageDialog(null, "Vehicle agency is Empty! You must to" +
                        " add at least one vehicle to continue.", "Vehicle Agency", JOptionPane.ERROR_MESSAGE);
            }
        } while (agency == null || JOptionPane.showConfirmDialog(null, "Would you like to" +
                " add another vehicle?", "Vehicle Agency", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);

        //Create the main panel and add it to the frame
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.LINE_AXIS));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        // Add the components to the main panel
        JLabel titleLabel = new JLabel("Welcome to Vehicle Agency");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(titleLabel);
        mainPanel.add(vehiclePanel);
        mainPanel.add(optionPanel);
        add(mainPanel);

        //Mouse pressed event for vehicle panel
        mainPanel.addMouseListener(this);

        // Add the vehicles panel
        initVehiclePanel(vehiclePanel);

        JButton addVehicleButton = new JButton("Add New Vehicle");
        addVehicleButton.addActionListener(this);
        optionPanel.add(addVehicleButton, BorderLayout.SOUTH);

        JButton buyVehicleButton = new JButton("Buy a Vehicle");
        buyVehicleButton.addActionListener(this);
        optionPanel.add(buyVehicleButton);

        JButton testDriveButton = new JButton("Test Drive a Vehicle");
        testDriveButton.addActionListener(this);
        optionPanel.add(testDriveButton, BorderLayout.SOUTH);

        JButton resetKilometerButton = new JButton("Reset Distance Traveled");
        resetKilometerButton.addActionListener(this);
        optionPanel.add(resetKilometerButton, BorderLayout.SOUTH);

        JButton changeFlagsButton = new JButton("Change Flags");
        changeFlagsButton.addActionListener(this);
        optionPanel.add(changeFlagsButton, BorderLayout.SOUTH);

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        optionPanel.add(exitButton, BorderLayout.SOUTH);

        // Set the properties of the frame
        setTitle("Vehicle Agency");
        setSize(1000, 800);
        setMinimumSize(new Dimension(1000, 800));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initVehiclePanel(JPanel vehiclePanel) {

        vehiclePanel.setLayout(new GridLayout(4, 4));
        for (Vehicle vehicle : agency) {
            ImageIcon vehicleImg = new ImageIcon(vehicle.getImage());
            JLabel vehicleLabel = new JLabel(new ImageIcon(vehicleImg.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT)));
            serialNum++;
            vehicleLabel.setName("L: " + serialNum);
            vehiclePanel.add(vehicleLabel);
        }
        vehiclePanel.revalidate();
    }
    private JPanel setPanelFromAgency() {
        JPanel newPanel = new JPanel();
        newPanel.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < vehiclePanel.getComponentCount(); i++) {
            ImageIcon vehicleImg = new ImageIcon(agency[i].getImage());
            JLabel vehicleLabel = new JLabel(new ImageIcon(vehicleImg.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT)));
            newPanel.add(vehicleLabel);
//            newPanel.add(new JLabel(new ImageIcon(agency[i].getImage())));
            newPanel.getComponent(i).setName(vehiclePanel.getComponent(i).getName());
        }
        newPanel.revalidate();
        newPanel.repaint();
        return newPanel;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Add New Vehicle" -> {
                Vehicle temp = createVehicle();
                if (temp == null) JOptionPane.showMessageDialog(this, "Invalid vehicle type." +
                        " Please try again.");
                else {
                    agency = addVehicle(agency, temp);
                    JOptionPane.showMessageDialog(this, "Vehicle added successfully.");
                    ImageIcon vehicleImg = new ImageIcon(temp.getImage());
                    JLabel vehicleLabel = new JLabel(new ImageIcon(vehicleImg.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT)));
                    serialNum++;
                    vehicleLabel.setName("L: " + serialNum);
                    vehiclePanel.add(vehicleLabel);
                    vehiclePanel.revalidate();
                    vehiclePanel.repaint();
                }
            }
            case "Buy a Vehicle" -> buyVehicle();
            case "Test Drive a Vehicle" -> testDriveVehicle();
            case "Reset Distance Traveled" -> resetDistanceTraveled();
            case "Change Flags" -> changeFlags();
            case "Exit" -> exit();
        }
    }

    private void buyVehicle() {
        if(agency.length == 0){
            JOptionPane.showMessageDialog(this, "There are no vehicles to buy.");
            return;
        }
        JPanel buyPanel= setPanelFromAgency();
        BuyingDialog b = new BuyingDialog(this, buyPanel);
        b.showDialog();
        int x;
        if (buyPanel.getComponentCount() != vehiclePanel.getComponentCount()) {
            for (int i = vehiclePanel.getComponentCount() - 1; i >= 0; i--) {
                x = 0;
                for (int j = 0; j < buyPanel.getComponentCount(); j++) {
                    if (vehiclePanel.getComponent(i).getName().equals(buyPanel.getComponent(j).getName())) {
                        x++;
                    }
                }
                if (x == 0) {
                    vehiclePanel.remove(i);
                    agency = removeVehicle(agency, i);
                    System.out.println("Vehicle " + i + " removed");
                }
            }
        }
        vehiclePanel.repaint();
        vehiclePanel.revalidate();
    }
    private void testDriveVehicle() {
        if(agency.length == 0){
            JOptionPane.showMessageDialog(this, "There are no vehicles in the agency.");
            return;
        }
        JPanel testPanel = setPanelFromAgency();
        TestDriveDialog testDialog = new TestDriveDialog(this, testPanel);
        testDialog.showDialog();

        int index = testDialog.getIndex();
        if (index != -1) {
            testPanel.setVisible(true);
            int distance = Integer.parseInt(JOptionPane.showInputDialog(this, "Please enter the distance you would like to drive."));
            agency[index].move(distance);
            JOptionPane.showMessageDialog(this, "Vehicle " + agency[index].getModel() + " has been driven " + agency[index].getDistanceTraveled() + " km.");
            testPanel.setVisible(false);
        }
    }

    private void resetDistanceTraveled() {
        if(agency.length == 0){
            JOptionPane.showMessageDialog(this, "There are no vehicles in the agency.");
            return;
        }
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to reset the distance traveled of all vehicles?", "Reset Distance Traveled", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            for (Vehicle vehicle : agency) {
                vehicle.setDistanceTraveled(0);
            }
            JOptionPane.showMessageDialog(this, "Distance traveled of all vehicles has been reset.");
        }
    }
    private void changeFlags() {
        if(agency.length == 0){
            JOptionPane.showMessageDialog(this, "There are no vehicles in the agency.");
            return;
        }
        FlagDialog flagDialog = new FlagDialog(this);
        flagDialog.showDialog();
        int result = flagDialog.getResult();
        String[] flags = {"Israel", "USA", "Germany", "Italy", "Greece", "Somalia", "Pirate"};
        boolean flag = false;
        if (agency != null && result != -1) {
            for (Vehicle vehicle : agency) {
                if (vehicle instanceof ISeaTransportation) {
                    ((ISeaTransportation) vehicle).setCountryFlag(flags[result]);
                    flag = true;
                }
            }
            if(flag) JOptionPane.showMessageDialog(null, "All Flags changed successfully.");
            else JOptionPane.showMessageDialog(null, "There are no sea vehicles in the agency.");
        }
    }
    private void exit() {
        int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) System.exit(0);
    }

    private Vehicle createVehicle() {
        String[] vehicleTypes = {"Jeep", "Frigate", "Spy Glider", "Game Glider", "Amphibious", "Bicycle", "Cruise Ship"};
        String type = (String) JOptionPane.showInputDialog(this, "Select the type of vehicle to add:",
                "Add New Vehicle",JOptionPane.QUESTION_MESSAGE, null, vehicleTypes, vehicleTypes[0]);
        if (type == null) {
            JOptionPane.showMessageDialog(this, "Adding a vehicle canceled.");
            return null;
        }
        return switch (type) {
            case "Jeep" -> createJeep();
            case "Frigate" -> createFrigate();
            case "Spy Glider" -> createSpyGlider();
            case "Game Glider" -> createGameGlider();
            case "Amphibious" -> createAmphibious();
            case "Bicycle" -> createBicycle();
            case "Cruise Ship" -> createCruiseShip();
            default -> null;
        };
    }

    private Vehicle createCruiseShip() {
        String model = JOptionPane.showInputDialog(this, "Model Vehicle:");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Max Passenger:"));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Max Speed:"));
        String countryFlag = JOptionPane.showInputDialog(this, "Country Flag:");
        byte[] image = getBytes();
        return new CruiseShip(model, maxPassengers, maxSpeed, countryFlag, image);
    }

    private Vehicle createBicycle() {
        String model = JOptionPane.showInputDialog(this, "Model Vehicle:");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Max Passenger:"));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Max Speed:"));
        String roadType = JOptionPane.showInputDialog(this, "Road Type:");
        byte[] img = getBytes();
        return new Bicycle(model, maxPassengers, maxSpeed, roadType, img);
    }

    private Vehicle createGameGlider() {
        byte[] img = getBytes();
        return new GameGlider(img);
    }

    private Vehicle createSpyGlider() {
        String powerSource = JOptionPane.showInputDialog(this, "Power Source:");
        byte[] img = getBytes();
        return new SpyGlider(powerSource, img);
    }

    private Vehicle createAmphibious() {
        String model = JOptionPane.showInputDialog(this, "Model Vehicle:");
        int maxPassengers = Integer.parseInt(JOptionPane.showInputDialog(this, "Max Passenger:"));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Max Speed:"));
        int wheels = Integer.parseInt(JOptionPane.showInputDialog(this, "Wheels:"));
        // Create the wind direction panel and add the radio buttons
        boolean windDirection = isWindDirectionRadio();

        String countryFlag = JOptionPane.showInputDialog(this, "Country Flag:");
        int averageFuelConsumption = Integer.parseInt(JOptionPane.showInputDialog(this, "Average Fuel Consumption:"));
        int averageEngineLife = Integer.parseInt(JOptionPane.showInputDialog(this, "Average Engine Life:"));
        byte[] image = getBytes();
        return new Amphibious(model, maxPassengers, maxSpeed, wheels, windDirection, countryFlag,
                averageFuelConsumption, averageEngineLife, image);
    }

    private Vehicle createFrigate() {
        String model = JOptionPane.showInputDialog(this, "Model Vehicle:");
        int maxPassenger = Integer.parseInt(JOptionPane.showInputDialog(this, "Max Passenger:"));
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Max Speed:"));
        // Create the wind direction panel and add the radio buttons
        boolean windDirection = isWindDirectionRadio();

        byte[] img = getBytes();
        return new Frigate(model, maxPassenger, maxSpeed, windDirection, img);
    }

    private Jeep createJeep() {
        String model = JOptionPane.showInputDialog(this, "Model Vehicle:");
        int maxSpeed = Integer.parseInt(JOptionPane.showInputDialog(this, "Max Speed:"));
        int fuelConsumption = Integer.parseInt(JOptionPane.showInputDialog(this, "Fuel Consumption:"));
        int engineLife = Integer.parseInt(JOptionPane.showInputDialog(this, "Engine Life"));
        byte[] img = getBytes();
        return new Jeep(model, maxSpeed, fuelConsumption, engineLife, img);
    }

    private boolean isWindDirectionRadio() {
        JPanel windPanel = new JPanel();
        windPanel.setLayout(new BoxLayout(windPanel, BoxLayout.PAGE_AXIS));
        JRadioButton withWindButton = new JRadioButton("With the wind direction");
        JRadioButton againstWindButton = new JRadioButton("Against the wind direction");
        ButtonGroup windGroup = new ButtonGroup();
        windGroup.add(withWindButton);
        windGroup.add(againstWindButton);
        windPanel.add(withWindButton);
        windPanel.add(againstWindButton);
        // Show the wind direction panel and wait for user selection
        JOptionPane.showConfirmDialog(this, windPanel, "Please enter the wind direction:", JOptionPane.OK_CANCEL_OPTION);
        // Get the selected wind direction and create the Frigate object
        return withWindButton.isSelected();
    }

    private byte[] getBytes() {
        JFileChooser fileChooser = new JFileChooser();
        JOptionPane.showMessageDialog(this, "Select an image file", "Select Image", JOptionPane.INFORMATION_MESSAGE);
        int result = fileChooser.showOpenDialog(this);
        byte[] img = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                img = Files.readAllBytes(selectedFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return img;
    }

    private Vehicle[] removeVehicle(Vehicle[] agency, int index) {
        Vehicle[] temp = new Vehicle[agency.length - 1];
        int j = 0;
        for (int i = 0; i < agency.length; i++) {
            if(i != index) {
                temp[j] = agency[i];
                j++;
            }
        }
        agency = temp;
        return agency;
    }

    private Vehicle[] addVehicle(Vehicle[] agency, Vehicle vehicle) {
        if (agency == null) {
            agency = new Vehicle[1];
            agency[0] = vehicle;
        } else {
            Vehicle[] temp = new Vehicle[agency.length + 1];
            System.arraycopy(agency, 0, temp, 0, agency.length);
            temp[temp.length - 1] = vehicle;
            agency = temp;
        }
        return agency;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (int i = 0; i < vehiclePanel.getComponentCount(); i++) {
            if (x >= vehiclePanel.getComponent(i).getX() && x <= vehiclePanel.getComponent(i).getX() + vehiclePanel.getComponent(i).getWidth() &&
                    y >= vehiclePanel.getComponent(i).getY() && y <= vehiclePanel.getComponent(i).getY() + vehiclePanel.getComponent(i).getHeight()) {
                System.out.println("Vehicle " + i + " clicked");
                if(popup != null) popup.hide();
                JLabel label = new JLabel();
                label.setText(agency[i].toString());
                popup = PopupFactory.getSharedInstance().getPopup(e.getComponent(),label,e.getXOnScreen(),e.getYOnScreen());
                popup.show();
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if (popup != null) popup.hide();
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
