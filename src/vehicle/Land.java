package vehicle;

public abstract class Land extends Vehicle {
    protected int wheels;
    protected String roadType;
    public Land(String model, int distance, int maxPassengers, int maxSpeed,int wheels, String roadType) {
        super(model, distance, maxPassengers, maxSpeed);
        this.wheels = wheels;
        this.roadType = roadType;
    }
}
