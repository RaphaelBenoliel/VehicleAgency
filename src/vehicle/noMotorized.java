package vehicle;

enum PowerRating{
    A, B, C
}

public interface noMotorized {
    public void setPowerSource(String powerSource);
    public void setPowerRating(PowerRating rating);
    public String getPowerSource();
    public PowerRating getPowerRating();

}
