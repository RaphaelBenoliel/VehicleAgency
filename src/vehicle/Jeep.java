package vehicle;

public class Jeep extends LandTransportation implements Motorized,Commercial {

    private int averageFuelConsumption;
    private int averageEngineLife;
    private licenseType licenseType;
    public String getName(){
        return "Jeep";
    }
    public Jeep(String model, int maxSpeed, int fuelConsumption, int engineLife) {
        super(model, 5, maxSpeed, 4, "off-road");
        setLicenseType(vehicle.licenseType.MINI);
        setAverageFuelConsumption(fuelConsumption);
        setAverageEngineLife(engineLife);
    }

    @Override
    public void setLicenseType(vehicle.licenseType type) {
        licenseType = type;
    }

    @Override
    public vehicle.licenseType getLicenseType() { return licenseType; }
    @Override
    public void setAverageFuelConsumption(int fuelConsumption) { averageFuelConsumption = fuelConsumption; }
    @Override
    public float getAverageFuelConsumption() { return averageFuelConsumption; }
    @Override
    public void setAverageEngineLife(int engineLife) { averageEngineLife = engineLife; }
    @Override
    public int getAverageEngineLife() { return averageEngineLife; }
    public String toString(){
        return getName() +": "+ super.toString() + " It has a " + getLicenseType() + " license." + " Engine: " +
                getAverageFuelConsumption() + "L, lifetime of " + getAverageEngineLife() + " years.";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Jeep jeep = (Jeep) o;
        if (Float.compare(jeep.averageFuelConsumption, averageFuelConsumption) != 0) return false;
        if (averageEngineLife != jeep.averageEngineLife) return false;
        return licenseType == jeep.licenseType;
    }
}
