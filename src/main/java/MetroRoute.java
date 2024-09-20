public class MetroRoute {
    private String routeId;
    private String routeShortName;
    private String routeLongName;
    private String routeColor;

    public MetroRoute(String routeId, String routeShortName, String routeLongName, String routeColor) {
        this.routeId = routeId;
        this.routeShortName = routeShortName;
        this.routeLongName = routeLongName;
        this.routeColor = routeColor;
    }

    // Getters and Setters
    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }
    public String getRouteShortName() { return routeShortName; }
    public void setRouteShortName(String routeShortName) { this.routeShortName = routeShortName; }
    public String getRouteLongName() { return routeLongName; }
    public void setRouteLongName(String routeLongName) { this.routeLongName = routeLongName; }
    public String getRouteColor() { return routeColor; }
    public void setRouteColor(String routeColor) { this.routeColor = routeColor; }

    @Override
    public String toString() {
        return "MetroRoute{routeId='" + routeId + "', shortName='" + routeShortName + "', longName='" + routeLongName + "', color='" + routeColor + "'}";
    }
}
