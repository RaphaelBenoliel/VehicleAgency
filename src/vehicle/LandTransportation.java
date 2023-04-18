package vehicle;

import java.util.Objects;

public abstract class LandTransportation extends Vehicle {
    protected int wheels;
    protected String roadType;
    public LandTransportation(String model, int maxPassengers, int maxSpeed, int wheels, String roadType) {
        super(model, maxPassengers, maxSpeed);
        this.wheels = wheels;
        this.roadType = roadType;
    }
    public int getWheels() { return wheels; }
    public String getRoadType() { return roadType; }
    public void setWheels(int wheels) { this.wheels = wheels; }
    public void setRoadType(String roadType) { this.roadType = roadType; }
    @Override
    public String toString() {
        return super.toString() + " It has " + wheels + " wheels, can move on " + roadType + ".";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LandTransportation that = (LandTransportation) o;

        if (wheels != that.wheels) return false;
        return Objects.equals(roadType, that.roadType);
    }
}// End of LandTransportation class
