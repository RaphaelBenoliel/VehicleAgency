package vehicle;
public abstract class Vehicle {
    protected String model;
    protected int distance;
    protected int maxPassengers;
    protected int maxSpeed;
    public abstract void move(int distance);
    public Vehicle(String model, int distance, int maxPassengers, int maxSpeed) {
        this.model = model;
        this.distance = distance;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
    }





}
