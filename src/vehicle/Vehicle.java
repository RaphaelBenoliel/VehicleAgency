package vehicle;

import java.util.Objects;

public abstract class Vehicle {
    protected String model;
    protected int distanceTraveled;
    protected int maxPassengers;
    protected int maxSpeed;

    public Vehicle(String model, int maxPassengers, int maxSpeed) {
        this.model = model;
        this.distanceTraveled = 0;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
    }

    public void move(int distance) {
        this.distanceTraveled += distance;
    }

    public String getModel() {
        return this.model;
    }

    public int getDistanceTraveled() {
        return this.distanceTraveled;
    }

    public int getMaxPassengers() {
        return this.maxPassengers;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String toString() {
        return "Model: " + this.model + ", Traveled: " + this.distanceTraveled + "KM, Max Speed of " + this.maxSpeed +
                "Mph, can carry max of " + this.maxPassengers + " people.";
    }
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
}
