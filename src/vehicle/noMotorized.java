package vehicle;
/**
 * The noMotorized interface represents a vehicle that does not have a motor.
 * It provides methods for setting and getting the power source and energy score
 * of the vehicle.
 */
enum EnergyScore {
    A, B, C
}
public interface noMotorized {

    /**
     * Sets the power source of the vehicle.
     * @param powerSource a String representing the type of power source used by the vehicle
     */
    public void setPowerSource(String powerSource);

    /**
     * Sets the energy score of the vehicle.
     * @param score an EnergyScore enumeration value representing the energy efficiency rating of the vehicle
     */
    public void setEnergyScore(EnergyScore score);

    /**
     * Returns the power source of the vehicle.
     * @return a String representing the type of power source used by the vehicle
     */
    public String getPowerSource();

    /**
     * Returns the energy score of the vehicle.
     * @return an EnergyScore enumeration value representing the energy efficiency rating of the vehicle
     */
    public EnergyScore getEnergyScore();
}
