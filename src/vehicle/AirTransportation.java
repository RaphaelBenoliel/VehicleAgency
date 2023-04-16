package vehicle;

import java.util.Objects;

public abstract class AirTransportation extends Vehicle{
    protected String useInfo;
    public AirTransportation(String model, int maxPassengers, int maxSpeed, String useInfo) {
        super(model, maxPassengers, maxSpeed);
        this.useInfo = useInfo;
    }

    public String getUseInfo() { return useInfo; }

    public void setUseInfo(String useInfo) { this.useInfo = useInfo; }
    public String toString(){
        return super.toString() + " It is used for " + useInfo + ".";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AirTransportation that = (AirTransportation) o;
        return Objects.equals(useInfo, that.useInfo);
    }
}
