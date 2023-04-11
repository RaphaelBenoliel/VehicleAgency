package vehicle;

public interface Motorized {
    /**
     * This interface is used to define the methods that are used in the Motorized class
     * @param fuelConsumption
     * @param engineLife
     */
    public void setAverageFuelConsumption(float fuelConsumption);
    public float getAverageFuelConsumption();

    public void setAverageEngineLife(int engineLife);
    public int getAverageEngineLife();
}
