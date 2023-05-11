package vehicle;

import javax.swing.*;
import java.util.Objects;

/**
 * The GameGlider class represents a toy Aerial vehicle, non-motorized for civil use and have an energy score.
 */
public class GameGlider extends Vehicle implements IAirTransportation, noMotorized {
    private String powerSource;
    private EnergyScore energyScore;
    private String useInfo;

    /**
     * Constructs a GameGlider object with the given model, maximum number of passengers, maximum speed,
     * and energy score. all data members is by default.
     */
    public GameGlider(ImageIcon image ) {
        super("Toy", 0, 10, image);
        setUseInfo("civilian");
        setPowerSource("manually");
        setEnergyScore(EnergyScore.A);
    }

    @Override
    public String getUseInfo() {
        return this.useInfo;
    }

    @Override
    public void setUseInfo(String useInfo) {
        this.useInfo = useInfo;
    }
    @Override
    public void setPowerSource(String powerSource) { this.powerSource = powerSource; }

    @Override
    public void setEnergyScore(EnergyScore score) { this.energyScore = score; }

    @Override
    public String getPowerSource() { return powerSource; }

    @Override
    public EnergyScore getEnergyScore() { return energyScore; }

    /**
     * toString method to represent a GameGlider object.
     * @return a string representation of the GameGlider object.
     */
    @Override
    public String toString(){
        return this.getClass().getSimpleName() +": "+ super.toString() + " It is used for " + useInfo + "."
                + " It's source power is " + getPowerSource()
                + " and has a energy score of " + getEnergyScore() + ".";
    }

    /**
     * Determines whether two GameGlider objects are equal by comparing all data members.
     * @param o the object to compare to this object
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GameGlider that = (GameGlider) o;
        if (!Objects.equals(powerSource, that.powerSource)) return false;
        return energyScore == that.energyScore;
    }

}// End of GameGlider class
