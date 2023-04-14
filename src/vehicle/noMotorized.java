package vehicle;

enum EnergyScore {
    A, B, C
}

public interface noMotorized {
    public void setPowerSource(String powerSource);
    public void setEnergyScore(EnergyScore score);
    public String getPowerSource();
    public EnergyScore getEnergyScore();
}
