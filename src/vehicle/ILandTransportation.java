package vehicle;
/**
 * The ILandTransportation interface represents a land transportation vehicle.
 */
public interface ILandTransportation {

    /**
     * Gets the number of wheels of the land transportation vehicle.
     * @return an integer representing the number of wheels of the land transportation vehicle
     */
    public int getWheels() ;
    /**
     * Gets the road type of the land transportation vehicle.
     * @return a string representing the road type of the land transportation vehicle
     */
    public String getRoadType() ;
    /**
     * Sets the number of wheels of the land transportation vehicle.
     * @param wheels an integer representing the number of wheels of the land transportation vehicle
     */
    public void setWheels(int wheels);

    /**
     * Sets the road type of the land transportation vehicle.
     * @param roadType a string representing the road type of the land transportation vehicle
     */
    public void setRoadType(String roadType);
}
