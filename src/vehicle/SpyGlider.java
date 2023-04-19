package vehicle;

import java.util.Objects;

/**
 * The SpyGlider class represents a military Aerial vehicle, non-motorized for military use and have an energy score.
 */
public class SpyGlider extends AirTransportation implements noMotorized{
    private String powerSource;
    private EnergyScore energyScore;
    /**
     * Constructs a SpyGlider object with the given model, maximum number of passengers, maximum speed,
     * and energy score. all data members is by default.
     * @param PowerSource the source of power of the SpyGlider
     */
    public SpyGlider(String PowerSource)
    {
        super("privileged", 1, 50, "Military");
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

    @Override
    public String toString(){
        return this.getClass().getSimpleName() +": "+
                super.toString() +
                " It's source power is " + getPowerSource() +
                " and has a energy score of " + getEnergyScore() + ".";
    }
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
}// End of SpyGlider class
