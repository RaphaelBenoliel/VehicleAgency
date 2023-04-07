package vehicle;

public abstract class Air extends Vehicle{
    protected String useInfo;
    public Air(String model, int distance, int maxPassengers, int maxSpeed, String useInfo) {
        super(model, distance, maxPassengers, maxSpeed);
        this.useInfo = useInfo;
    }
}
