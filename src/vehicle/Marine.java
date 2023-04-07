package vehicle;

public abstract class Marine extends Vehicle{

    protected boolean withWindDirection;
    protected String countryFlag;

    public Marine(String model, int distance, int maxPassengers, int maxSpeed, boolean withWindDirection,
                  String countryFlag){
        super(model, distance, maxPassengers, maxSpeed);
        this.withWindDirection = withWindDirection;
        this.countryFlag = countryFlag;



    }


}
