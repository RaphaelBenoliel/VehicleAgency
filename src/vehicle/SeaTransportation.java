package vehicle;

public abstract class SeaTransportation extends Vehicle{

    protected boolean withWindDirection;
    protected String countryFlag;

    public SeaTransportation(String model, int distance, int maxPassengers, int maxSpeed, boolean withWindDirection,
                             String countryFlag){
        super(model, distance, maxPassengers, maxSpeed);
        this.withWindDirection = withWindDirection;
        this.countryFlag = countryFlag;



    }


}
