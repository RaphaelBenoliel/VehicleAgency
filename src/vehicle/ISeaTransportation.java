package vehicle;

/**
 * The ISeaTransportation interface represents a sea transportation vehicle.
 */
public interface ISeaTransportation {
    /**
     * Returns whether the vehicle can move with the wind or against it.
     * @return a boolean representing whether the vehicle can move with the wind or against it.
     */
    public boolean isWithWindDirection();

    /**
     * Returns the country flag of the vehicle.
     * @return a String representing the country flag of the vehicle.
     */
    public String getCountryFlag() ;

    /**
     * Sets whether the vehicle can move with the wind or against it.
     * @param withWindDirection a boolean representing whether the vehicle can move with the wind or against it.
     */
    public void setWithWindDirection(boolean withWindDirection) ;

    /**
     * Sets the country flag of the vehicle.
     * @param countryFlag a String representing the country flag of the vehicle.
     */
    public void setCountryFlag(String countryFlag);
}
