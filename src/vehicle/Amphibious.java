package vehicle;

import javax.swing.*;
import java.util.Objects;

/**
 * The Amphibious class represents a vehicle that can move on land and sea.
 * It extends the Vehicle class and implements the ISeaTransportation and Motorized interface.
 */
public class Amphibious extends Vehicle implements ILandTransportation, ISeaTransportation, Motorized {

    private int averageFuelConsumption;
    private int averageEngineLife;
    private boolean withWindDirection;
    private String countryFlag;
    private int wheels;
    private String roadType;

    /**
     * Constructs a new Amphibious object.
     * @param model a String representing the model of the amphibious.
     * @param maxPassengers an integer representing the maximum number of passengers the amphibious can carry.
     * @param maxSpeed an integer representing the maximum speed of the amphibious in kilometers per hour.
     * @param wheels an integer representing the number of wheels the amphibious has.
     * @param withWindDirection a boolean representing whether the amphibious can move with the wind or against it.
     * @param countryFlag a String representing the country flag of the amphibious.
     * @param averageFuelConsumption an integer representing the average fuel consumption of the amphibious.
     * @param averageEngineLife an integer representing the average engine life of the amphibious.
     * @param image a byte array representing the image of the amphibious.
     */
    public Amphibious(String model, int maxPassengers, int maxSpeed, int wheels, boolean withWindDirection,
                      String countryFlag, int averageFuelConsumption, int averageEngineLife, ImageIcon image) {
        super(model, maxPassengers, maxSpeed, image);
        this.wheels = wheels;
        this.countryFlag = countryFlag;
        this.withWindDirection = withWindDirection;
        this.roadType = "road";
        this.averageFuelConsumption = averageFuelConsumption;
        this.averageEngineLife = averageEngineLife;
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
    public boolean isWithWindDirection() {
        return this.withWindDirection;
    }

    @Override
    public String getCountryFlag() {
        return this.countryFlag;
    }

    @Override
    public void setWithWindDirection(boolean withWindDirection) {
        this.withWindDirection = withWindDirection;
    }

    @Override
    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    @Override
    public void setAverageFuelConsumption(int fuelConsumption) {
        averageFuelConsumption = fuelConsumption;
    }

    @Override
    public int getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    @Override
    public void setAverageEngineLife(int engineLife) {
        averageEngineLife = engineLife;
    }

    @Override
    public int getAverageEngineLife() {
        return averageEngineLife;
    }

    /**
     * A toString method to represent the Amphibious object.
     * @return a string representation of the Amphibious object.
     */
    @Override
    public String toString() {
        String result = this.getClass().getSimpleName() + ": " + super.toString()
                + " It has " + wheels + " wheels, can move on " + roadType + "."
                + " It can also move on water," + " Under " + getCountryFlag() + " flag, ";
        result += withWindDirection ? "with" : "against";
        result += " the wind." + " Engine: " + getAverageFuelConsumption() + "L, "
                + "lifetime of " + getAverageEngineLife() + " years.";
        return result;
    }
    /**
     * A method to check if two Amphibious objects are equal.
     * @param o an object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Amphibious that = (Amphibious) o;
        if (averageFuelConsumption != that.averageFuelConsumption) return false;
        if (averageEngineLife != that.averageEngineLife) return false;
        if (withWindDirection != that.withWindDirection) return false;
        if (wheels != that.wheels) return false;
        if (!Objects.equals(countryFlag, that.countryFlag)) return false;
        return Objects.equals(roadType, that.roadType);
    }

}