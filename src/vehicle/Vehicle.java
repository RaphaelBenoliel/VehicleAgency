package vehicle;

import javax.swing.*;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The Vehicle class represents a generic vehicle.
 */
public abstract class Vehicle {
    protected String model;
    protected int distanceTraveled;
    protected int maxPassengers;
    protected int maxSpeed;
    protected ImageIcon image;
    private boolean inTest = false;

    private boolean inBuy = false;

    private static Object sharedLock = new Object(); // Verrou partagé pour la synchronisation des threads

    private static Object sharedLockB = new Object(); // Verrou partagé pour la synchronisation des threads

    private Lock lock = new ReentrantLock(); // Verrou pour la synchronisation des threads

    private Lock lockB = new ReentrantLock();
    /**
     * Constructs a new Vehicle with the given model, maximum number of passengers, and maximum speed.
     * @param model the model of the vehicle
     * @param maxPassengers the maximum number of passengers the vehicle can carry
     * @param maxSpeed the maximum speed of the vehicle
     */
    public Vehicle(String model, int maxPassengers, int maxSpeed, ImageIcon image) {
        this.model = model;
        this.distanceTraveled = 0;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
        this.image = image;
    }

    protected Vehicle() {
    }

    /**
     * Moves the vehicle by the specified distance.
     * @param distance the distance to move the vehicle in km.
     */
    public void move(int distance) { this.distanceTraveled += distance; }

    public String getModel() { return this.model; }

    public int getDistanceTraveled() { return this.distanceTraveled; }

    public int getMaxPassengers() { return this.maxPassengers; }

    public int getMaxSpeed() { return this.maxSpeed; }

    public void setModel(String model) { this.model = model; }

    public void setDistanceTraveled(int distanceTraveled) { this.distanceTraveled = distanceTraveled; }

    public void setMaxPassengers(int maxPassengers) { this.maxPassengers = maxPassengers; }

    public void setMaxSpeed(int maxSpeed) { this.maxSpeed = maxSpeed; }
    public static Object getSharedLock() {
        return sharedLock;
    }

    public static Object getSharedLockB() {return sharedLock;}
    /**
     * Returns a string representation of the vehicle, including its model, distance traveled, maximum speed,
     * and maximum number of passengers.
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        return "Model: " + this.getModel() + ", Traveled: " + this.getDistanceTraveled() + "KM, Max Speed of " + this.getMaxSpeed() +
                "Mph, can carry max of " + this.getMaxPassengers() + " people.";
    }

    /**
     * Determines whether two Vehicle objects are equal by comparing all data members.
     * @param o the object to compare to this one
     * @return true if this object is the same as the o argument; false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;
        if (distanceTraveled != vehicle.distanceTraveled) return false;
        if (maxPassengers != vehicle.maxPassengers) return false;
        if (maxSpeed != vehicle.maxSpeed) return false;
        return Objects.equals(model, vehicle.model);
    }
    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public ImageIcon getImage() {
        return image;
    }
    public synchronized void startTest(double distance) throws InterruptedException {

        synchronized (sharedLock) {

            if (isInTest()) {
                JOptionPane.showMessageDialog(null, "This vehicle is already being tested.");
                return;
            }

            inTest = true;
            // Effectuer les actions nécessaires pour le test

            // Faire dormir le thread pendant la durée du test
            long sleepTime = (long) (distance * 100);
            Thread.sleep(sleepTime);

            // Effectuer d'autres actions après le test
            synchronized (sharedLock) {
                inTest = false;
            }
        }
    }
    public synchronized boolean isInTest() {
        return inTest;
    }

    public Lock getLock() {
        return lock;
    }



    public synchronized void starBuy() throws InterruptedException {

        synchronized (sharedLockB) {

            if (isInBuy()) {
                JOptionPane.showMessageDialog(null, "This vehicle is already being buy process.");
                return;
            }

            inBuy = true;


            // Effectuer d'autres actions après le test
            synchronized (sharedLock) {
                inBuy = false;
            }
        }
    }

    public synchronized boolean isInBuy() {
        return inBuy;
    }

    public Lock getLockB() {
        return lockB;
    }
}// End of Vehicle class
