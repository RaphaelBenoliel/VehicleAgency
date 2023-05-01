package vehicle;

import java.util.Objects;
/**
 * The Vehicle class represents a generic vehicle.
 */
public abstract class Vehicle {
    protected String model;
    protected int distanceTraveled;
    protected int maxPassengers;
    protected int maxSpeed;
    /**
     * Constructs a new Vehicle with the given model, maximum number of passengers, and maximum speed.
     * @param model the model of the vehicle
     * @param maxPassengers the maximum number of passengers the vehicle can carry
     * @param maxSpeed the maximum speed of the vehicle
     */
    public Vehicle(String model, int maxPassengers, int maxSpeed) {
        this.model = model;
        this.distanceTraveled = 0;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
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

    /**
     * Returns a string representation of the vehicle, including its model, distance traveled, maximum speed,
     * and maximum number of passengers.
     * @return a string representation of the vehicle
     */
    @Override
    public String toString() {
        return "Model: " + this.model + ", Traveled: " + this.distanceTraveled + "KM, Max Speed of " + this.maxSpeed +
                "Mph, can carry max of " + this.maxPassengers + " people.";
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
}// End of Vehicle class
