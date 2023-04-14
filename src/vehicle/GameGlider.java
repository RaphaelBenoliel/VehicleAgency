package vehicle;

import java.util.Objects;

public class GameGlider extends AirTransportation implements noMotorized{
    private String powerSource;
    private EnergyScore energyScore;
    public GameGlider( ) {
        super("Toy", 0, 10, "civilian");
        setPowerSource("manually");
        setEnergyScore(EnergyScore.A);
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
    public String getName(){
        return "GameGlider";
    }
    public String toString(){
        return getName() +": "+ super.toString() + " It's source power is " + getPowerSource() +
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
}
