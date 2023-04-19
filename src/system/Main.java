package system;
import vehicle.*;

import java.util.Scanner;
/**
 * Main class for the vehicle agency.
 */
public class Main {

    public static void main(String[] args) {
        Vehicle[] Agency =  initAgency();//initialize the agency
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("============== Welcome to the vehicle agency! ==============");
            System.out.println("Please choose an option:");
            System.out.println("1. Buy a vehicle");
            System.out.println("2. Test drive a vehicle");
            System.out.println("3. Reset distance traveled for all vehicles");
            System.out.println("4. Change flag for all vessels");
            System.out.println("5. Exit");
            System.out.println("Please enter your option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("=================== Buy A Vehicle Menu ===================");
                    if (Agency != null && Agency.length == 0) {
                        System.out.println("There are no vehicles in the agency.");
                        break;
                    }
                    Agency = buyVehicle(Agency);
                }
                case 2 -> {
                    System.out.println("=================== Test A Vehicle ===================");
                    testDrive(Agency);
                }
                case 3 -> {
                    System.out.println("=============== Reset All Vehicle Kilometer ===============");
                    if (Agency != null)
                        resetAllVehicleKilometer(Agency);
                }
                case 4 -> {
                    System.out.println("=================== Changing Vessels Flags ===================");
                    changeVesselsFlags(Agency);
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Please choose again.");
            }
        }
    }// End of method main

    /**
     * method to initialize the agency.
     * @return the agency array.
     */
    private static Vehicle[] initAgency() {
        Vehicle[] agency = null;
        Vehicle temp;
        System.out.println("initializing agency...");
        String inputAns = "y";
        while(inputAns.equals("y")) {
            temp = createVehicle();
            if (temp == null) System.out.println("Invalid vehicle type. Please try again.");
            else agency = addVehicle(agency, temp);
            System.out.println("Would you like to add another vehicle? [y/n]");
            Scanner scanner = new Scanner(System.in);
            inputAns = scanner.next();
        }
        return agency;
    }

    /**
     * method to change all vessels flags to a new flag entered by the user.
     * @param agency the agency array.
     */
    public static void changeVesselsFlags(Vehicle[] agency) {
        System.out.println("Please enter the new flag:");
        Scanner scanner = new Scanner(System.in);
        String newFlag = scanner.next();
        if (agency != null) {
            for (Vehicle vehicle : agency) {
                if (vehicle instanceof SeaTransportation) {
                    ((SeaTransportation) vehicle).setCountryFlag(newFlag);
                }
            }
            System.out.println("All vessels flags has been changed successfully.");
        }
    }
    /**
     * method to test drive a vehicle.
     * @param agency the agency array.
     */
    public static void testDrive(Vehicle[] agency) {
        System.out.println("Which vehicle would you like to test drive?");
        printAgency(agency);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your option [1-" + agency.length + "]: ");
        int option = scanner.nextInt();
        if(option > 0 && option <= agency.length) {
            System.out.println("The selected vehicle is:\n" + agency[option - 1]);
            System.out.println("Please enter the distance of the test drive:");
            int distance = scanner.nextInt();
            agency[option - 1].move(distance);
            System.out.println("\nThe test drive is completed. The distance traveled is " +
                    agency[option - 1].getDistanceTraveled()+ " Kilometer.\n\n");

        }
        else {
            System.out.println("Invalid option. Please try again.");
        }
    }

    /**
     * method to reset all vehicle kilometer to 0.
     * @param agency the agency array.
     */
    public static void resetAllVehicleKilometer(Vehicle[] agency) {
        for (Vehicle vehicle : agency) {
            vehicle.setDistanceTraveled(0);
        }
        System.out.println("\nAll vehicle kilometer has been reset successfully.\n\n");
    }

    /**
     * method to create a new vehicle object according to the user's choice.
     * @return the new vehicle object or null if the user entered an invalid vehicle type.
     */
    public static Vehicle createVehicle() {
        Vehicle vehicle = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a vehicle type:");
        System.out.println("1. Jeep");
        System.out.println("2. Frigate");
        System.out.println("3. Spy glider");
        System.out.println("4. Game glider");
        System.out.print("Please enter your option: ");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume the new line character
        switch (type) {
            case 1 -> {
                System.out.println("Please enter the model of the Jeep:");
                String model = scanner.nextLine();
                System.out.println("Please enter the maximum speed:");
                int maxSpeed = scanner.nextInt();
                System.out.println("Please enter the Fuel Consumption:");
                int fuelConsumption = scanner.nextInt();
                System.out.println("Please enter the engine life years:");
                int engineLife = scanner.nextInt();
                scanner.nextLine(); // consume the new line character
                vehicle = new Jeep(model, maxSpeed, fuelConsumption, engineLife);
            }
            case 2 -> {
                System.out.println("Please enter the model of the Frigate:");
                String model = scanner.nextLine();
                System.out.println("Please enter the maximum number of passengers:");
                int maxPassengers = scanner.nextInt();
                System.out.println("Please enter the maximum speed:");
                int maxSpeed = scanner.nextInt();
                do {
                    System.out.println("Please enter the wind direction:");
                    System.out.println("1 - with the wind");
                    System.out.println("2 - against the wind");
                    System.out.println("Please enter your option:");
                    int windDirection = scanner.nextInt();
                    if (windDirection == 1) {
                        vehicle = new Frigate(model, maxPassengers, maxSpeed, true);
                    } else if (windDirection == 2) {
                        vehicle = new Frigate(model, maxPassengers, maxSpeed, false);
                    } else {
                        System.out.println("Invalid option. Please choose again.");
                    }
                } while (vehicle == null);
            }
            case 3 -> {
                System.out.println("Please enter the power source of the Spy glider:");
                String powerSource = scanner.nextLine();
                vehicle = new SpyGlider(powerSource);
            }
            case 4 -> vehicle = new GameGlider();
            default -> System.out.println("Invalid option. Please choose again.");
        }
        return vehicle;
    }

    /**
     * method to add a vehicle to the agency array when creating a vehicle .
     * @param agency the agency array
     * @param vehicle the vehicle to add
     * @return the agency array with the added vehicle
     */
    public static Vehicle[] addVehicle(Vehicle[] agency, Vehicle vehicle) {
        if (agency == null) {
            agency = new Vehicle[1];
            agency[0] = vehicle;
        }
        else {
            Vehicle[] temp = new Vehicle[agency.length + 1];
            System.arraycopy(agency, 0, temp, 0, agency.length);
            temp[temp.length - 1] = vehicle;
            agency = temp;
        }
        return agency;
    }
    /**
     * method to removes a vehicle from the agency array when purchase a vehicle .
     * @param agency the agency array
     * @param index the index of the vehicle to remove
     * @return the agency array without the removed vehicle
     */
    public static Vehicle[] removeVehicle(Vehicle[] agency, int index) {
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
    /**
     * method to buy a vehicle from the agency.
     * @param agency the agency array
     * @return the agency array without the purchased vehicle
     */
    private static Vehicle[] buyVehicle(Vehicle[] agency) {
        System.out.println("In order to buy a vehicle, you must fill-in the vehicle details " +
                "exactly as in the following list:\n");
        printAgency(agency);
        // creating a temporary vehicle to compare with the agency vehicles
        Vehicle vehicle = createVehicle();

        if (vehicle == null) System.out.println("Invalid vehicle type. Please try again.");
        else {
            System.out.println("Please enter the vehicle distance traveled:");
            int distance = new Scanner(System.in).nextInt();
            vehicle.setDistanceTraveled(distance);
            for (int i = 0; i < agency.length; i++) {
                if (agency[i].equals(vehicle)) {
                    System.out.println("\n\nVehicle found in the agency!\n");
                    // removing the vehicle from the agency.
                    agency = removeVehicle(agency, i);
                    System.out.println("Vehicle successfully purchased!\n");
                    return agency;
                }
            }
            System.out.println("\nVehicle not found in our agency! Please try another.\n");
        }
        return agency;
    }
    /**
     * method to print the agency vehicles.
     * @param agency the agency array
     */
    private static void printAgency(Vehicle[] agency) {
        for (int i = 0; i < agency.length; i++) {
            System.out.println(i + 1 + ". " + agency[i]);
        }
    }
}// End of class Main