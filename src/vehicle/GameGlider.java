package vehicle;

import java.util.Objects;

/**
 * The GameGlider class represents a toy Aerial vehicle, non-motorized for civil use and have an energy score.
 */
public class GameGlider extends AirTransportation implements noMotorized{
    private String powerSource;
    private EnergyScore energyScore;
    /**
     * Constructs a GameGlider object with the given model, maximum number of passengers, maximum speed,
     * and energy score. all data members is by default.
     */
    public GameGlider( ) {
        super("Toy", 0, 10, "civilian");
        setPowerSource("manually");
        setEnergyScore(EnergyScore.A);
    }
    @Override
    public void setPowerSource(String powerSource) { this.powerSource = powerSource; }

    @Override
    public void setEnergyScore(EnergyScore score) { this.energyScore = score; }

    @Override
    public String getPowerSource() { return powerSource; }

    @Override
    public EnergyScore getEnergyScore() { return energyScore; }

    @Override
    public String toString(){
        return this.getClass().getSimpleName() +": "+ super.toString() + " It's source power is " + getPowerSource() +
                " and has a energy score of " + getEnergyScore() + ".";
    }
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
