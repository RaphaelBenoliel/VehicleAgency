//not in use !!
// package vehicle;
//
//import java.util.Objects;
///**
// * Represents a type of vehicle that is designed for air transportation.
// * Inherits from the abstract Vehicle class and adds a field for use information.
// */
//public abstract class AirTransportation extends Vehicle{
//    protected String useInfo;
//    /**
//     * Constructs a new AirTransportation object with the specified model, maximum passengers, maximum speed,
//     * and use information.
//     * @param model the model of the air transportation vehicle
//     * @param maxPassengers the maximum number of passengers the vehicle can carry
//     * @param maxSpeed the maximum speed of the vehicle in mph
//     * @param useInfo the intended use of the vehicle
//     */
//    public AirTransportation(String model, int maxPassengers, int maxSpeed, String useInfo) {
//        super(model, maxPassengers, maxSpeed);
//        this.useInfo = useInfo;
//    }
//
//    public String getUseInfo() { return useInfo; }
//    public void setUseInfo(String useInfo) { this.useInfo = useInfo; }
//    /**
//     * toString method for AirTransportation objects.
//     * @return a string representation of the AirTransportation object
//     */
//    @Override
//    public String toString(){
//        return super.toString() + " It is used for " + useInfo + ".";
//    }
//    /**
//     * Determines whether two AirTransportation objects are equal by comparing all data members.
//     * @param o the object to compare to this object
//     * @return true if the objects are equal, false otherwise
//     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        AirTransportation that = (AirTransportation) o;
//        return Objects.equals(useInfo, that.useInfo);
//    }
//}// End of AirTransportation class
