package vehicle;

public abstract class AirTransportation extends Vehicle{
    protected String useInfo;
    public AirTransportation(String model, int distance, int maxPassengers, int maxSpeed, String useInfo) {
        super(model, distance, maxPassengers, maxSpeed);
        this.useInfo = useInfo;
    }
}
