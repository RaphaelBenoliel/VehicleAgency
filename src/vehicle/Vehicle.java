package vehicle;
public abstract class Vehicle {
    protected String model;
    protected int distanceTraveled;
    protected int maxPassengers;
    protected int maxSpeed;
    public abstract void move(int distance);
    public Vehicle(String model, int distanceTraveled, int maxPassengers, int maxSpeed) {
        this.model = model;
        this.distanceTraveled = distanceTraveled;
        this.maxPassengers = maxPassengers;
        this.maxSpeed = maxSpeed;
    }
    public String getModel() {
        return model;
    }






}
