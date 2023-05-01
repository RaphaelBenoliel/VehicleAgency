package vehicle;

import java.util.Objects;

public class Amphibious extends Vehicle implements ILandTransportation, ISeaTransportation, Motorized{

    private final LandTransportation landTransportation;
    private final SeaTransportation seaTransportation;
    private int averageFuelConsumption;
    private int averageEngineLife;
    public Amphibious(String model,int maxPassengers, int maxSpeed,int wheels, boolean withWindDirection,
                      String countryFlag, int averageFuelConsumption, int averageEngineLife) {
        landTransportation = new LandTransportation(model, maxPassengers, maxSpeed, wheels, "road");
        seaTransportation = new SeaTransportation(model, maxPassengers, maxSpeed, withWindDirection, countryFlag);
        this.averageFuelConsumption = averageFuelConsumption;
        this.averageEngineLife = averageEngineLife;
    }
    @Override
    public int getWheels() {
        return landTransportation.getWheels();
    }

    @Override
    public String getRoadType() {
        return landTransportation.getRoadType();
    }

    @Override
    public void setWheels(int wheels) {
        landTransportation.setWheels(wheels);

    }

    @Override
    public void setRoadType(String roadType) {
        landTransportation.setRoadType(roadType);

    }

    @Override
    public boolean isWithWindDirection() {
        return seaTransportation.isWithWindDirection();
    }

    @Override
    public String getCountryFlag() {
        return seaTransportation.getCountryFlag();
    }

    @Override
    public void setWithWindDirection(boolean withWindDirection) {
        seaTransportation.setWithWindDirection(withWindDirection);
    }

    @Override
    public void setCountryFlag(String countryFlag) {
        seaTransportation.setCountryFlag(countryFlag);
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

    @Override
    public String toString() {
        return landTransportation.toString() + " It can also move on water. " + seaTransportation.toString() +
                " It has an average fuel consumption of " + averageFuelConsumption +
                " liters per 100 km and an average engine life of " + averageEngineLife + " years.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Amphibious that = (Amphibious) o;

        if (averageFuelConsumption != that.averageFuelConsumption) return false;
        if (averageEngineLife != that.averageEngineLife) return false;
        if (!Objects.equals(landTransportation, that.landTransportation))
            return false;
        return Objects.equals(seaTransportation, that.seaTransportation);
    }

}
