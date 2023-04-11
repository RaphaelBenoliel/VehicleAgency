package vehicle;

public class Jeep extends LandTransportation implements Motorized,Commercial {
    private float averageFuelConsumption;
    private int averageEngineLife;
    private licenseType licenseType;
    public String getName(){
        return "Jeep";
    }
    public Jeep(String model, int maxSpeed) {
        super(model, 5, maxSpeed, 4, "off-road");
        setLicenseType(vehicle.licenseType.MINI);
    }

    @Override
    public void setLicenseType(vehicle.licenseType type) {
        licenseType = type;
    }

    @Override
    public vehicle.licenseType getLicenseType() {
        return licenseType;
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
}
