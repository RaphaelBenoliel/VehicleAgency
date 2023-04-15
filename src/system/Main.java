package system;

import vehicle.*;

import java.util.Scanner;
enum option {
    BuyVehicle, TestVehicle, Reset_ALL_KM, ChangingFlag, Exit
}
public class Main {

    public static void main(String[] args) {

        Vehicle[] Agency = null;
        for(int i=0; i<5; i++){
            Agency = addVehicle(Agency);
        }
        for (Vehicle vehicle : Agency) {
            System.out.println(vehicle);
        }

    }
    public static Vehicle[] addVehicle(Vehicle[] Agency){
        Vehicle vehicle = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a vehicle type:");
        System.out.println("1. Jeep");
        System.out.println("2. Frigate");
        System.out.println("3. Spy glider");
        System.out.println("4. Game glider");

        int type = scanner.nextInt();
        scanner.nextLine(); // consume the new line character

        switch(type){
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
        }
        if(Agency == null) {
            Agency = new Vehicle[1];
            Agency[0] = vehicle;
        }
        else {
            Vehicle[] temp = new Vehicle[Agency.length + 1];
            for(int i=0; i<Agency.length; i++)
                temp[i] = Agency[i];
            temp[Agency.length] = vehicle;
            Agency = temp;
        }
        return Agency;
    }
}