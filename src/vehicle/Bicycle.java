package vehicle;

import java.util.Objects;

public class Bicycle extends Vehicle implements ILandTransportation, noMotorized {

    private int wheels;
    private String roadType;
    private String powerSource;
    private EnergyScore energyScore;


    public Bicycle(String model, int maxPassengers, int maxSpeed, String roadType, byte[] image){
        super(model, maxPassengers, maxSpeed, image);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Bicycle bicycle = (Bicycle) o;
        if (wheels != bicycle.wheels) return false;
        if (!Objects.equals(roadType, bicycle.roadType)) return false;
        if (!Objects.equals(powerSource, bicycle.powerSource)) return false;
        return energyScore == bicycle.energyScore;
    }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() + ": " + super.toString()
                + " It has " + wheels + " wheels, can move on " + roadType + "."
                + " It's source power is " + getPowerSource()
                + " and has a energy score of " + getEnergyScore() + ".";
    }
}
