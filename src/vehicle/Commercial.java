package vehicle;
/**
 * The Commercial interface is used to indicate that a class represents a commercial vehicle.
 * Classes that implement this interface should provide methods to get and set the license type of the vehicle.
 */
enum licenseType{
    MINI, LIMIT, UNLIMITED
}
public interface Commercial {
    /**
     * Sets the license type of the commercial vehicle.
     * @param type the license type to set
     */
    public void setLicenseType(licenseType type);
    /**
     * Gets the license type of the commercial vehicle.
     * @return the license type of the vehicle
     */
    public licenseType getLicenseType();

}
