//not in use !!
//package vehicle;
//
//import java.util.Objects;
//
///**
// * The LandTransportation class represents a vehicle that can move on land.
// */
//public  class LandTransportation extends Vehicle implements ILandTransportation {
//    protected int wheels;
//    protected String roadType;
//
//    /**
//     * Constructs a new LandTransportation with the given model, maximum number of passengers, maximum speed,
//     * number of wheels, and road type.
//     * @param model the model of the vehicle
//     * @param maxPassengers the maximum number of passengers the vehicle can carry
//     * @param maxSpeed the maximum speed of the vehicle
//     * @param wheels the number of wheels the vehicle has
//     * @param roadType the type of road the vehicle can move on
//     */
//    public LandTransportation(String model, int maxPassengers, int maxSpeed, int wheels, String roadType) {
//        super(model, maxPassengers, maxSpeed);
//        this.wheels = wheels;
//        this.roadType = roadType;
//    }
//    public int getWheels() { return wheels; }
//
//    public String getRoadType() { return roadType; }
//
//    public void setWheels(int wheels) { this.wheels = wheels; }
//
//    public void setRoadType(String roadType) { this.roadType = roadType; }
//
//    /**
//     * Returns a string representation of this LandTransportation object.
//     * @return a string representation of this LandTransportation object
//     */
//    @Override
//    public String toString() {
//        return super.toString() + " It has " + wheels + " wheels, can move on " + roadType + ".";
//    }
//
//    /**
//     * Determines whether two LandTransportation objects are equal by comparing all data members.
//     * @param o the object to compare to this object
//     * @return true if the objects are equal, false otherwise
//     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//
//        LandTransportation that = (LandTransportation) o;
//
//        if (wheels != that.wheels) return false;
//        return Objects.equals(roadType, that.roadType);
//    }
//}// End of LandTransportation class
