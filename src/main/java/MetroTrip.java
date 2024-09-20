public class MetroTrip {
    private String routeId;
    private String serviceId;
    private String tripId;
    private String shapeId;

    public MetroTrip(String routeId, String serviceId, String tripId, String shapeId) {
        this.routeId = routeId;
        this.serviceId = serviceId;
        this.tripId = tripId;
        this.shapeId = shapeId;
    }

    // Getters and Setters
    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }
    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) { this.serviceId = serviceId; }
    public String getTripId() { return tripId; }
    public void setTripId(String tripId) { this.tripId = tripId; }
    public String getShapeId() { return shapeId; }
    public void setShapeId(String shapeId) { this.shapeId = shapeId; }

    @Override
    public String toString() {
        return "MetroTrip{routeId='" + routeId + "', serviceId='" + serviceId + "', tripId='" + tripId + "', shapeId='" + shapeId + "'}";
    }
}
