package vehicle;
/**
 * The IAirTransportation interface represents an air transportation vehicle.
 */
public interface IAirTransportation {
    /**
     * Gets the use info of the air transportation vehicle.
     * @return a string representing the use info of the air transportation vehicle
     */
    public String getUseInfo();

    /**
     * Sets the use info of the air transportation vehicle.
     * @param useInfo a string representing the use info of the air transportation vehicle
     */
    public void setUseInfo(String useInfo);
}
