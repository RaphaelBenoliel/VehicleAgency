package vehicle;

public class Frigate extends AirTransportation implements Motorized {
    private float averageFuelConsumption;
    private int averageEngineLife;
    public String getName(){
        return "Frigate";
    }
    public Frigate(String model,int maxPassengers, int maxSpeed, String useInfo) {
        super(model, maxPassengers, maxSpeed, useInfo);
        setAverageEngineLife(4);
        setAverageFuelConsumption(500);
    }
    @Override
    public void setAverageFuelConsumption(float fuelConsumption) {
        averageFuelConsumption = fuelConsumption;
    }

    @Override
    public float getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    @Override
    public void setAverageEngineLife(int engineLife) {
        averageEngineLife = engineLife;
    }

    @Override
    public int getAverageEngineLife() {
        return averageEngineLife;
    }
    public String toString(){
       return getName() + super.toString() + " Engine: " + getAverageFuelConsumption() + ", lifetime of " +
               getAverageEngineLife() + " years.";
    }
}

