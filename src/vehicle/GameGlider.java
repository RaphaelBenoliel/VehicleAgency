package vehicle;

public class GameGlider extends AirTransportation implements noMotorized{

    public GameGlider(String model, int maxPassengers, int maxSpeed, String useInfo) {
        super(model, maxPassengers, maxSpeed, useInfo);
    }
    @Override
    public void setPowerSource(String powerSource) {

    }

    @Override
    public void setPowerRating(PowerRating rating) {

    }

    @Override
    public String getPowerSource() {
        return null;
    }

    @Override
    public PowerRating getPowerRating() {
        return null;
    }
}
