package vehicle;

public abstract class LandTransportation extends Vehicle {
    protected int wheels;
    protected String roadType;
    public LandTransportation(String model, int distance, int maxPassengers, int maxSpeed, int wheels, String roadType) {
        super(model, distance, maxPassengers, maxSpeed);
        this.wheels = wheels;
        this.roadType = roadType;
    }
}
