package system;

import vehicle.*;

import java.util.Scanner;

public class Main {
    private enum Option {
        BuyVehicle, TestVehicle, Reset_ALL_KM, ChangingFlag, Exit
    }
    public static void main(String[] args) {

        Vehicle[] Agency = null;
        Vehicle temp = null;
        for (int i = 0; i < 5; i++) {
           temp = createVehicle(Agency);
           if (temp == null){
               System.out.println("Invalid vehicle type. Please try again.");
               i--;
               continue;
           }
           else{
               Agency = addVehicle(Agency, temp);
           }
        }
        for (Vehicle vehicle : Agency) {
            System.out.println(vehicle);
        }
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please choose an option:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Buy a vehicle");
            System.out.println("3. Test drive a vehicle");
            System.out.println("4. Reset distance traveled for all vehicles");
            System.out.println("5. Change flag for all vessels");
            System.out.println("6. Exit");

            Option option = scanner.nextInt() == 1 ? Option.BuyVehicle :
                    scanner.nextInt() == 2 ? Option.TestVehicle :
                            scanner.nextInt() == 3 ? Option.Reset_ALL_KM :
                                    scanner.nextInt() == 4 ? Option.ChangingFlag :
                                            Option.Exit;
            switch (option) {
                case BuyVehicle:
                    System.out.println("BuyVehicle");


                    break;
                case TestVehicle:
                    System.out.println("TestVehicle");
                    break;
                case Reset_ALL_KM:
                    System.out.println("Reset_ALL_KM");
                    break;
                case ChangingFlag:
                    System.out.println("ChangingFlag");
                    break;
                case Exit:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

    }
    public static Vehicle[] addVehicle(Vehicle[] Agency, Vehicle vehicle) {
        if (Agency == null) {
            Agency = new Vehicle[1];
            Agency[0] = vehicle;
        }
        else
        {
            Vehicle[] temp = new Vehicle[Agency.length + 1];
            for (int i = 0; i < Agency.length; i++) {
                temp[i] = Agency[i];
            }
            temp[temp.length - 1] = vehicle;
            Agency = temp;
        }
        return Agency;
    }
    public static Vehicle createVehicle(Vehicle[] Agency) {
        Vehicle vehicle = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a vehicle type:");
        System.out.println("1. Jeep");
        System.out.println("2. Frigate");
        System.out.println("3. Spy glider");
        System.out.println("4. Game glider");

        int type = scanner.nextInt();
        scanner.nextLine(); // consume the new line character


        switch (type) {
            case 1:
                System.out.println("Please enter the model of the Jeep:");
                String model = scanner.nextLine();
                System.out.println("Please enter the maximum number of passengers:");
                int maxPassengers = scanner.nextInt();
                System.out.println("Please enter the maximum speed:");
                int maxSpeed = scanner.nextInt();
                System.out.println("Please enter the number of wheels:");
                int wheels = scanner.nextInt();
                scanner.nextLine(); // consume the new line character
                vehicle = new Jeep(model, maxPassengers, maxSpeed, wheels);
                break;
            case 2:
                System.out.println("Please enter the model of the Frigate:");
                model = scanner.nextLine();
                System.out.println("Please enter the maximum number of passengers:");
                maxPassengers = scanner.nextInt();
                System.out.println("Please enter the maximum speed:");
                maxSpeed = scanner.nextInt();
//                System.out.println("Please enter the wind direction:");
//                boolean withWindDirection = scanner.nextBoolean();
                vehicle = new Frigate(model, maxPassengers, maxSpeed, true);
                break;
            case 3:
                System.out.println("Please enter the power source of the Spy glider:");
                String powerSource = scanner.nextLine();
                vehicle = new SpyGlider(powerSource);
                break;
            case 4:
                vehicle = new GameGlider();
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
        return vehicle;
    }
    public static void buyVehicle (Vehicle[]Agency){
            for (Vehicle vehicle : Agency)
                System.out.println(vehicle);


    }
}