package vehicle;

public class Frigate extends SeaTransportation implements Motorized {
    private int averageFuelConsumption;
    private int averageEngineLife;
    public String getName(){ return "Frigate"; }
    public Frigate(String model, int maxPassengers, int maxSpeed, boolean withWindDirection) {
        super(model, maxPassengers, maxSpeed, withWindDirection, "Israel");
        setAverageEngineLife(4);
        setAverageFuelConsumption(500);
    }
    @Override
    public void setAverageFuelConsumption(int fuelConsumption) {
        averageFuelConsumption = fuelConsumption;
    }
    @Override
    public int getAverageFuelConsumption() {
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
       return getName() +": "+ super.toString() + " Engine: " + getAverageFuelConsumption() + "L, lifetime of " +
               getAverageEngineLife() + " years.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Frigate frigate = (Frigate) o;
        if (Float.compare(frigate.averageFuelConsumption, averageFuelConsumption) != 0) return false;
        return averageEngineLife == frigate.averageEngineLife;
    }
}

