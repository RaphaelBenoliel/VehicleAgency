package vehicle;

import java.util.Objects;

public abstract class SeaTransportation extends Vehicle{
    protected boolean withWindDirection;
    protected String countryFlag;
    public SeaTransportation(String model, int maxPassengers, int maxSpeed, boolean withWindDirection,
                             String countryFlag){
        super(model, maxPassengers, maxSpeed);
        this.withWindDirection = withWindDirection;
        this.countryFlag = countryFlag;
    }
    public boolean isWithWindDirection() { return withWindDirection; }

    public String getCountryFlag() { return countryFlag; }

    public void setWithWindDirection(boolean withWindDirection) { this.withWindDirection = withWindDirection; }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SeaTransportation that = (SeaTransportation) o;

        if (withWindDirection != that.withWindDirection) return false;
        return Objects.equals(countryFlag, that.countryFlag);
    }
    @Override
    public String toString() {
        String result =  super.toString() + " Under " + countryFlag + " flag, ";
        result += withWindDirection ? "with" : "against";
        return result + " the wind.";
    }
}// End of SeaTransportation class
