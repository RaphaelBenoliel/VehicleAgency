package vehicle;

import javax.swing.*;
import java.util.Objects;
/**
 * Represents a type of vehicle that is designed for sea transportation.
 * Inherits from the abstract Vehicle class and adds fields for average fuel consumption and average engine life.
 * Implements the ISeaTransportation, Motorized, and Commercial interfaces.
 */
public class CruiseShip extends Vehicle implements ISeaTransportation,Motorized,Commercial{
    private int averageFuelConsumption;
    private int averageEngineLife;
    private boolean withWindDirection;
    private String countryFlag;
    private licenseType licenseType;

    /**
     * Constructs a new CruiseShip object.
     * @param model a String representing the model of the cruise ship.
     * @param maxPassengers an integer representing the maximum number of passengers the cruise ship can carry.
     * @param maxSpeed an integer representing the maximum speed of the cruise ship in kilometers per hour.
     * @param countryFlag a String representing the country flag of the cruise ship.
     * @param image a byte array representing the image of the cruise ship.
     */
    public CruiseShip(String model, int maxPassengers, int maxSpeed, String countryFlag, ImageIcon image){
        super(model, maxPassengers, maxSpeed, image);
        this.countryFlag = countryFlag;
        this.withWindDirection = true;
        this.licenseType = vehicle.licenseType.UNLIMITED;
    }
    /**
     * Returns A toString method to represent the CruiseShip object.
     * @return a String representation of this CruiseShip object.
     */
    @Override
    public String toString(){
        String result =  this.getClass().getSimpleName() +": " + super.toString() + " Under " + countryFlag + " flag, ";
        result += withWindDirection ? "with" : "against";
        return result + " the wind."
                + " It has a " + getLicenseType() + " license."
                + " Engine: " + getAverageFuelConsumption() + "L, "
                + "lifetime of " + getAverageEngineLife() + " years.";
    }

    /**
     * Returns a boolean value indicating whether the given object is equal to this CruiseShip object.
     * @param o an Object.
     * @return true if the given object is equal to this CruiseShip object, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CruiseShip that = (CruiseShip) o;
        if (averageFuelConsumption != that.averageFuelConsumption) return false;
        if (averageEngineLife != that.averageEngineLife) return false;
        if (withWindDirection != that.withWindDirection) return false;
        if (!Objects.equals(countryFlag, that.countryFlag)) return false;
        return licenseType == that.licenseType;
    }
    @Override
    public void setLicenseType(licenseType type) {
        this.licenseType = type;
    }

    @Override
    public licenseType getLicenseType() {
        return this.licenseType;
    }

    @Override
    public void setWithWindDirection(boolean withWindDirection) {
        this.withWindDirection = withWindDirection;
    }
    @Override
    public boolean isWithWindDirection() {
        return this.withWindDirection;
    }

    @Override
    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }
    @Override
    public String getCountryFlag() {
        return this.countryFlag;
    }

    @Override
    public void setAverageFuelConsumption(int fuelConsumption) {
        this.averageFuelConsumption = fuelConsumption;
    }

    @Override
    public int getAverageFuelConsumption() {
        return this.averageFuelConsumption;
    }

    @Override
    public void setAverageEngineLife(int engineLife) {
        this.averageEngineLife = engineLife;
    }

    @Override
    public int getAverageEngineLife() {
        return this.averageEngineLife;
    }


}
