package vehicle;
enum licenseType{
    MINI, LIMIT, UNLIMIT
}
public interface Commercial {
    public void setLicenseType(licenseType type);
    public licenseType getLicenseType();

}
