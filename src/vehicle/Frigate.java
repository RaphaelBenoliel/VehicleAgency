package vehicle;

import javax.swing.*;

/**
 * The Frigate class represents a frigate vessel.
 * It extends the Vehicle class and implements the ISeaTransportation and Motorized interface.
 */
public class Frigate extends Vehicle implements ISeaTransportation, Motorized {
    private int averageFuelConsumption;
    private int averageEngineLife;
    private boolean withWindDirection;
    private String countryFlag;
    /**
     * Constructs a new Frigate object.
     * @param model a String representing the model of the frigate.
     * @param maxPassengers an integer representing the maximum number of passengers the frigate can carry.
     * @param maxSpeed an integer representing the maximum speed of the frigate in kilometers per hour.
     * @param withWindDirection a boolean representing whether the frigate can move with the wind or against it.
     */
    public Frigate(String model, int maxPassengers, int maxSpeed, boolean withWindDirection, ImageIcon image) {
        super(model, maxPassengers, maxSpeed, image);
        setWithWindDirection(withWindDirection);
        setCountryFlag("Israel");
        setAverageEngineLife(4);
        setAverageFuelConsumption(500);
    }

    @Override
    public boolean isWithWindDirection() {
        return withWindDirection;
    }

    @Override
    public String getCountryFlag() {
        return countryFlag;
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
    public void setAverageFuelConsumption(int fuelConsumption) { averageFuelConsumption = fuelConsumption; }
    @Override
    public int getAverageFuelConsumption() { return averageFuelConsumption; }

    @Override
    public void setAverageEngineLife(int engineLife) { averageEngineLife = engineLife; }

    @Override
    public int getAverageEngineLife() { return averageEngineLife; }


    /**
     * toString method for Frigate objects.
     * @return a string representation of the Frigate object
     */
    @Override
    public String toString(){
        String result =  this.getClass().getSimpleName() +": " +super.toString() + " Under " + countryFlag + " flag, ";
        result += withWindDirection ? "with" : "against";
        return result + " the wind."
                + " Engine: " + getAverageFuelConsumption() + "L, "
                + "lifetime of " + getAverageEngineLife() + " years.";
    }
    /**
     * Determines whether two Frigate objects are equal by comparing all data members.
     * @param o the object to compare to this object
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Frigate frigate = (Frigate) o;
        if (Float.compare(frigate.averageFuelConsumption, averageFuelConsumption) != 0) return false;
        return averageEngineLife == frigate.averageEngineLife;
    }

}// End of Frigate class

