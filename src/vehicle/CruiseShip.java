package vehicle;

import java.util.Objects;

public class CruiseShip extends Vehicle implements ISeaTransportation,Motorized,Commercial{
    private int averageFuelConsumption;
    private int averageEngineLife;
    private boolean withWindDirection;
    private String countryFlag;
    private licenseType licenseType;

    public CruiseShip(String model, int maxPassengers, int maxSpeed, String countryFlag, byte[] image){
        super(model, maxPassengers, maxSpeed, image);
        this.countryFlag = countryFlag;
        this.withWindDirection = true;
        this.licenseType = vehicle.licenseType.UNLIMITED;
    }

    @Override
    public String toString(){
        String result =  this.getClass().getSimpleName() +": " + super.toString() + " Under " + countryFlag + " flag, ";
        result += withWindDirection ? "with" : "against";
        return result + " the wind."
                + " It has a " + getLicenseType() + " license."
                + " Engine: " + getAverageFuelConsumption() + "L, "
                + "lifetime of " + getAverageEngineLife() + " years.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CruiseShip that = (CruiseShip) o;
        if (averageFuelConsumption != that.averageFuelConsumption) return false;
        if (averageEngineLife != that.averageEngineLife) return false;
        if (withWindDirection != that.withWindDirection) return false;
        if (!Objects.equals(countryFlag, that.countryFlag)) return false;
        return licenseType == that.licenseType;
    }
    @Override
    public void setLicenseType(licenseType type) {
        this.licenseType = type;
    }

    @Override
    public licenseType getLicenseType() {
        return this.licenseType;
    }

    @Override
    public void setWithWindDirection(boolean withWindDirection) {
        this.withWindDirection = withWindDirection;
    }
    @Override
    public boolean isWithWindDirection() {
        return this.withWindDirection;
    }

    @Override
    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }
    @Override
    public String getCountryFlag() {
        return this.countryFlag;
    }

    @Override
    public void setAverageFuelConsumption(int fuelConsumption) {
        this.averageFuelConsumption = fuelConsumption;
    }

    @Override
    public int getAverageFuelConsumption() {
        return this.averageFuelConsumption;
    }

    @Override
    public void setAverageEngineLife(int engineLife) {
        this.averageEngineLife = engineLife;
    }

    @Override
    public int getAverageEngineLife() {
        return this.averageEngineLife;
    }


}
