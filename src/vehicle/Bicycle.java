package vehicle;

public class Bicycle extends Vehicle implements ILandTransportation, noMotorized {

    private int wheels;
    private String roadType;
    private String powerSource;
    private EnergyScore energyScore;

    public Bicycle(String model, int maxPassengers, int maxSpeed, String roadType){
        super(model, maxPassengers, maxSpeed);
        this.wheels = 2;
        this.roadType = roadType;
        this.powerSource = "manually";
        this.energyScore = EnergyScore.A;
    }

    @Override
    public int getWheels() {
        return this.wheels;
    }

    @Override
    public String getRoadType() {
        return this.roadType;
    }

    @Override
    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    @Override
    public void setRoadType(String roadType) {
        this.roadType = roadType;
    }

    @Override
    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    @Override
    public void setEnergyScore(EnergyScore score) {
        this.energyScore = score;
    }

    @Override
    public String getPowerSource() {
        return this.powerSource;
    }

    @Override
    public EnergyScore getEnergyScore() {
        return this.energyScore;
    }
}
