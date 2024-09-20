public class MetroShape {
    private String shapeId;
    private double latitude;
    private double longitude;
    private int sequence; // shape_pt_sequence
    private double distanceTraveled;

    // Constructor
    public MetroShape(String shapeId, double latitude, double longitude, int sequence, double distanceTraveled) {
        this.shapeId = shapeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sequence = sequence;
        this.distanceTraveled = distanceTraveled;
    }

    // Getter for shapeId
    public String getShapeId() {
        return shapeId;
    }

    // Getter for latitude
    public double getLatitude() {
        return latitude;
    }

    // Getter for longitude
    public double getLongitude() {
        return longitude;
    }

    // Getter for sequence
    public int getSequence() {
        return sequence;
    }

    // Getter for distanceTraveled
    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    @Override
    public String toString() {
        return "MetroShape{" +
                "shapeId='" + shapeId + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", sequence=" + sequence +
                ", distanceTraveled=" + distanceTraveled +
                '}';
    }
}
