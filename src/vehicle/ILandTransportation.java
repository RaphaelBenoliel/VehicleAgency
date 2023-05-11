package vehicle;
/**
 * The ILandTransportation interface represents a land transportation vehicle.
 */
public interface ILandTransportation {
    public int getWheels() ;

    public String getRoadType() ;

    public void setWheels(int wheels);

    public void setRoadType(String roadType);
}
