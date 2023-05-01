package vehicle;

public interface ISeaTransportation {
    public boolean isWithWindDirection();

    public String getCountryFlag() ;

    public void setWithWindDirection(boolean withWindDirection) ;

    public void setCountryFlag(String countryFlag);
}
