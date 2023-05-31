
package Graphics;

import vehicle.*;

public class TestManager {
    private static Vehicle vehicleInTest = null;

    public static synchronized boolean isVehicleInTest(Vehicle vehicle) {
        return vehicleInTest != null && vehicleInTest.equals(vehicle);
    }

    public static synchronized void startTest(Vehicle vehicle, double distance) {
        if (isVehicleInTest(vehicle)) {
            throw new IllegalStateException("A test is already in progress for this vehicle.");
        }

        vehicleInTest = vehicle;
        Thread testThread = new Thread(() -> {
            try {
                vehicle.startTest(distance);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                synchronized (TestManager.class) {
                    vehicleInTest = null;
                }
            }
        });
        testThread.start();
    }

    public static synchronized boolean isAnyVehicleInTest() {
        return vehicleInTest != null;
    }

}

