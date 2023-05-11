package vehicle;

import javax.swing.*;
import java.util.Objects;
/**
 * The Bicycle class represents a bicycle.
 * A bicycle is a vehicle that implements ILandTransportation and noMotorized.
 */
public class Bicycle extends Vehicle implements ILandTransportation, noMotorized {

    private int wheels;
    private String roadType;
    private String powerSource;
    private EnergyScore energyScore;

    /**
     * Constructs a new Bicycle object.
     * @param model a String representing the model of the bicycle.
     * @param maxPassengers an integer representing the maximum number of passengers the bicycle can carry.
     * @param maxSpeed an integer representing the maximum speed of the bicycle in kilometers per hour.
     * @param roadType a String representing the type of road the bicycle can move on.
     * @param image a byte array representing the image of the bicycle.
     */
    public Bicycle(String model, int maxPassengers, int maxSpeed, String roadType, ImageIcon image){
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

    /**
     * A toString method to represent the Bicycle object.
     * @return a string representation of the Bicycle object.
     */
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + ": " + super.toString()
                + " It has " + wheels + " wheels, can move on " + roadType + "."
                + " It's source power is " + getPowerSource()
                + " and has a energy score of " + getEnergyScore() + ".";
    }

    /**
     * Compares this object to another object.
     * @param o the object to compare to this one
     * @return true if the objects are equal, false otherwise
     */
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
}
