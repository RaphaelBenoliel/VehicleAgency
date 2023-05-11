package vehicle;

import javax.swing.*;
/**
 * The Jeep class is a Land Transportation vehicle motorized for commercial use.
 */
public class Jeep extends Vehicle implements ILandTransportation,Motorized,Commercial {
    private int averageFuelConsumption;
    private int averageEngineLife;
    private licenseType licenseType;
    private int wheels;
    private String roadType;
    /**
     * Constructs a new Jeep object.
     * @param model a String representing the model of the Jeep.
     * @param maxSpeed an integer representing the maximum speed of the Jeep in kilometers per hour.
     * @param fuelConsumption an integer representing the average fuel consumption in liters per 100 kilometers.
     * @param engineLife an integer representing the average engine life in years.
     */
    public Jeep(String model, int maxSpeed, int fuelConsumption, int engineLife, ImageIcon image) {
        super(model, 5, maxSpeed, image);
        setWheels(4);
        setRoadType("off-road");
        setLicenseType(vehicle.licenseType.MINI);
        setAverageFuelConsumption(fuelConsumption);
        setAverageEngineLife(engineLife);
    }

    @Override
    public void setLicenseType(vehicle.licenseType type) { licenseType = type; }

    @Override
    public vehicle.licenseType getLicenseType() { return licenseType; }

    @Override
    public void setAverageFuelConsumption(int fuelConsumption) { averageFuelConsumption = fuelConsumption; }

    @Override
    public int getAverageFuelConsumption() { return averageFuelConsumption; }

    @Override
    public void setAverageEngineLife(int engineLife) { averageEngineLife = engineLife; }

    @Override
    public int getAverageEngineLife() { return averageEngineLife; }

    /**
     * toString method to represent a Jeep object.
     * @return a String representation of the Jeep object.
     */
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + ": " +
                super.toString() + "\n" +"It has " + wheels + " wheels, can move on " + roadType + "."
                + "\nIt has a " + getLicenseType() + " license."
                + "\nEngine: " + getAverageFuelConsumption() + "L, "
                + "lifetime of " + getAverageEngineLife() + " years.";
    }

    /**
     * Compares this Jeep object to another object for equality.
     * @param o the object to compare to this one
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Jeep jeep = (Jeep) o;
        if (Float.compare(jeep.averageFuelConsumption, averageFuelConsumption) != 0) return false;
        if (averageEngineLife != jeep.averageEngineLife) return false;
        return licenseType == jeep.licenseType;
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
}// End of Jeep class
