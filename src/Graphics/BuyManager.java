package Graphics;

import vehicle.*;
public class BuyManager {
    private static Vehicle vehicleInBuy = null;

    public static synchronized boolean isVehicleInBuy(Vehicle vehicle) {
        return vehicleInBuy != null && vehicleInBuy.equals(vehicle);
    }

    public static synchronized void starBuy(Vehicle vehicle) {
        if (isVehicleInBuy(vehicle)) {
            throw new IllegalStateException("A buy process is already in progress for this vehicle.");
        }

        vehicleInBuy = vehicle;
        Thread buyThread = new Thread(() -> {
            synchronized (BuyManager.class) {
                vehicleInBuy = null;
            }

        });
        buyThread.start();
    }

    public static synchronized boolean isAnyVehicleInBuyProgress() {
        return vehicleInBuy != null;
    }

}
