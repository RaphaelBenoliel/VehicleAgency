package vehicle;

import java.util.Objects;

public class SpyGlider extends AirTransportation implements noMotorized{
    private String powerSource;
    private EnergyScore energyScore;
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
    public String getName(){
        return "SpyGlider";
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

        SpyGlider spyGlider = (SpyGlider) o;

        if (!Objects.equals(powerSource, spyGlider.powerSource))
            return false;
        return energyScore == spyGlider.energyScore;
    }

}
