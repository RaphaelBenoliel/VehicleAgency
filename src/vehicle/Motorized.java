package vehicle;
/**
 * The Motorized interface represents a vehicle that is powered by an engine.
 * It provides methods to set and get the average fuel consumption and average engine life of the vehicle.
 */
public interface Motorized {

    /**
     * Sets the average fuel consumption of the motorized vehicle.
     * @param fuelConsumption an integer representing the average fuel consumption in liters per 100 kilometers.
     */
    public void setAverageFuelConsumption(int fuelConsumption);

    /**
     * Returns the average fuel consumption of the motorized vehicle.
     * @return an integer representing the average fuel consumption in liters per 100 kilometers.
     */
    public int getAverageFuelConsumption();

    /**
     * Sets the average engine life of the motorized vehicle.
     * @param engineLife an integer representing the average engine life in years.
     */
    public void setAverageEngineLife(int engineLife);

    /**
     * Returns the average engine life of the motorized vehicle.
     * @return an integer representing the average engine life in years.
     */
    public int getAverageEngineLife();
}
