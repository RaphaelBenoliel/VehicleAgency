package vehicle;

import java.util.Objects;

public class SpyGlider extends AirTransportation implements noMotorized{
    private String powerSource;
    private PowerRating powerRating;
    public SpyGlider(String PowerSource)
    {
        super("privileged", 1, 50, "Military");
        setPowerSource(PowerSource);
        setPowerRating(PowerRating.C);
    }

    @Override
    public void setPowerSource(String powerSource) {
        this.powerSource = powerSource;
    }

    @Override
    public void setPowerRating(PowerRating rating) {
        this.powerRating = rating;
    }

    @Override
    public String getPowerSource() {
        return powerSource;
    }

    @Override
    public PowerRating getPowerRating() {
        return powerRating;
    }
    public String getName(){
        return "SpyGlider";
    }
    public String toString(){
        return getName() +": "+ super.toString() + " It is powered by " + getPowerSource() + " and has a power rating of "
                + getPowerRating() + ".";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SpyGlider spyGlider = (SpyGlider) o;

        if (!Objects.equals(powerSource, spyGlider.powerSource))
            return false;
        return powerRating == spyGlider.powerRating;
    }

}
