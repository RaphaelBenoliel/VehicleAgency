package vehicle;

public interface Motorized {
    /**
     * This interface is used to define the methods that are used in the Motorized class
     */
    public void setAverageFuelConsumption(int fuelConsumption);
    public float getAverageFuelConsumption();

    public void setAverageEngineLife(int engineLife);
    public int getAverageEngineLife();
}
