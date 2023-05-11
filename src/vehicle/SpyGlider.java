package vehicle;

import javax.swing.*;
import java.util.Objects;

/**
 * The SpyGlider class represents a military Aerial vehicle, non-motorized for military use and have an energy score.
 */
public class SpyGlider extends Vehicle implements IAirTransportation,noMotorized{
    private String powerSource;
    private EnergyScore energyScore;
    private String useInfo;
    /**
     * Constructs a SpyGlider object with the given model, maximum number of passengers, maximum speed,
     * and energy score. all data members is by default.
     * @param PowerSource the source of power of the SpyGlider
     */
    public SpyGlider(String PowerSource, ImageIcon image)
    {
        super("privileged", 1, 50, image);
        this.useInfo = "military";
        setPowerSource(PowerSource);
        setEnergyScore(EnergyScore.C);
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
        return powerSource;
    }

    @Override
    public EnergyScore getEnergyScore() {
        return energyScore;
    }

    /**
     * toString method to represent a SpyGlider object.
     * @return a string representation of the SpyGlider object
     */
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + ": " + super.toString() + " It is used for " + useInfo
                + "." + " It's source power is " + getPowerSource()
                + " and has a energy score of " + getEnergyScore() + ".";
    }

    /**
     * Compares this SpyGlider to the specified object. The result is true if and only if the argument is not null
     * @param o the object to compare to this one
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SpyGlider spyGlider = (SpyGlider) o;
        if (!Objects.equals(powerSource, spyGlider.powerSource))
            return false;
        return energyScore == spyGlider.energyScore;
    }

    @Override
    public String getUseInfo() {
        return this.useInfo;
    }

    @Override
    public void setUseInfo(String useInfo) {
        this.useInfo = useInfo;
    }
}// End of SpyGlider class
