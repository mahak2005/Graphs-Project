public class MetroStop {
    private String stopId;
    private String stopName;
    private double latitude;
    private double longitude;
    private double distance;

    // Constructor
    public MetroStop(String stopId, String stopName, double latitude, double longitude) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.latitude = latitude;
        this.longitude = longitude;

    }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    // Getters and Setters
    public String getStopId() { return stopId; }
    public void setStopId(String stopId) { this.stopId = stopId; }
    public String getStopName() { return stopName; }
    public void setStopName(String stopName) { this.stopName = stopName; }
    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }
    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    @Override
    public String toString() {
        return "MetroStop{id='" + stopId + "', name='" + stopName + "', latitude=" + latitude + ", longitude=" + longitude + "}";
    }



}
