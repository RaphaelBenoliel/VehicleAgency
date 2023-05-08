//not in use !!
//package vehicle;
//
//import java.util.Objects;
//
///**
// * The SeaTransportation class represents a vehicle that can move on water.
// */
//public class SeaTransportation extends Vehicle implements ISeaTransportation {
//    protected boolean withWindDirection;
//    protected String countryFlag;
//    /**
//     * Constructs a new SeaTransportation with the given model, maximum number of passengers, maximum speed,
//     * wind direction, and country flag.
//     * @param model the model of the vehicle
//     * @param maxPassengers the maximum number of passengers the vehicle can carry
//     * @param maxSpeed the maximum speed of the vehicle
//     * @param withWindDirection the wind direction of the vehicle
//     * @param countryFlag the country flag of the vehicle
//     */
//    public SeaTransportation(String model, int maxPassengers, int maxSpeed, boolean withWindDirection,
//                             String countryFlag){
//        super(model, maxPassengers, maxSpeed);
//        this.withWindDirection = withWindDirection;
//        this.countryFlag = countryFlag;
//    }
//    public boolean isWithWindDirection() { return withWindDirection; }
//
//    public String getCountryFlag() { return countryFlag; }
//
//    public void setWithWindDirection(boolean withWindDirection) { this.withWindDirection = withWindDirection; }
//
//    public void setCountryFlag(String countryFlag) {
//        this.countryFlag = countryFlag;
//    }
//
//    /**
//     * Determines whether two SeaTransportation objects are equal by comparing all data members.
//     * @param o the object to compare to this object
//     * @return true if the objects are equal, false otherwise
//     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        SeaTransportation that = (SeaTransportation) o;
//
//        if (withWindDirection != that.withWindDirection) return false;
//        return Objects.equals(countryFlag, that.countryFlag);
//    }
//
//    /**
//     * Returns a string representation of this SeaTransportation object.
//     * @return a string representation of this SeaTransportation object
//     */
//    @Override
//    public String toString() {
//        String result =  super.toString() + " Under " + countryFlag + " flag, ";
//        result += withWindDirection ? "with" : "against";
//        return result + " the wind.";
//    }
//}// End of SeaTransportation class
