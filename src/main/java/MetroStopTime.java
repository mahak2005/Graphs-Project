public class MetroStopTime {
    private String tripId;
    private String arrivalTime;
    private String departureTime;
    private String stopId;
    private int stopSequence;
    private double shapeDistTraveled;

    public MetroStopTime(String tripId, String arrivalTime, String departureTime, String stopId, int stopSequence, double shapeDistTraveled) {
        this.tripId = tripId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stopId = stopId;
        this.stopSequence = stopSequence;
        this.shapeDistTraveled = shapeDistTraveled;
    }

    // Getters and Setters
    public String getTripId() { return tripId; }
    public void setTripId(String tripId) { this.tripId = tripId; }
    public String getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
    public String getDepartureTime() { return departureTime; }
    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
    public String getStopId() { return stopId; }
    public void setStopId(String stopId) { this.stopId = stopId; }
    public int getStopSequence() { return stopSequence; }
    public void setStopSequence(int stopSequence) { this.stopSequence = stopSequence; }
    public double getShapeDistTraveled() { return shapeDistTraveled; }
    public void setShapeDistTraveled(double shapeDistTraveled) { this.shapeDistTraveled = shapeDistTraveled; }

    @Override
    public String toString() {
        return "MetroStopTime{tripId='" + tripId + "', arrivalTime='" + arrivalTime + "', departureTime='" + departureTime + "', stopId='" + stopId + "', stopSequence=" + stopSequence + ", distance=" + shapeDistTraveled + "}";
    }
}
//public class MetroStopTime {
//    private String tripId;
//    private String arrivalTime; // "HH:mm:ss"
//    private String departureTime; // "HH:mm:ss"
//    private String stopId;
//    private int stopSequence;
//    private double shapeDistTraveled;
//
//    // Getters and Setters
//    public String getTripId() { return tripId; }
//    public void setTripId(String tripId) { this.tripId = tripId; }
//    public String getArrivalTime() { return arrivalTime; }
//    public void setArrivalTime(String arrivalTime) { this.arrivalTime = arrivalTime; }
//    public String getDepartureTime() { return departureTime; }
//    public void setDepartureTime(String departureTime) { this.departureTime = departureTime; }
//    public String getStopId() { return stopId; }
//    public void setStopId(String stopId) { this.stopId = stopId; }
//    public int getStopSequence() { return stopSequence; }
//    public void setStopSequence(int stopSequence) { this.stopSequence = stopSequence; }
//    public double getShapeDistTraveled() { return shapeDistTraveled; }
//    public void setShapeDistTraveled(double shapeDistTraveled) { this.shapeDistTraveled = shapeDistTraveled; }
//}
