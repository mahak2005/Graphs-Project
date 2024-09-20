//import java.util.HashMap;
//import java.util.Map;
//
//public class MetroGraph {
//    private final Map<String, MetroStop> stops;
//    private final Map<String, Map<String, Double>> adjacencyList;
//
//    public MetroGraph() {
//        stops = new HashMap<>();
//        adjacencyList = new HashMap<>();
//    }
//
//    // Add a stop to the graph
//    public void addStop(String id, String name, double latitude, double longitude) {
//        stops.put(id, new MetroStop(id, name, latitude, longitude));
//        adjacencyList.put(id, new HashMap<>()); // Initialize adjacency list for the stop
//    }
//
//    // Add an edge between two stops with a weight (e.g., travel time)
//    public void addEdge(String fromStopId, String toStopId, double weight) {
//        if (adjacencyList.containsKey(fromStopId) && adjacencyList.containsKey(toStopId)) {
//            adjacencyList.get(fromStopId).put(toStopId, weight);
//            adjacencyList.get(toStopId).put(fromStopId, weight); // For undirected graph
//        }
//    }
//
//    // Check if a stop exists in the graph
//    public boolean containsStop(String stopId) {
//        return stops.containsKey(stopId);
//    }
//
//    // Get all stops
//    public Iterable<String> getAllStops() {
//        return stops.keySet();
//    }
//
//    // Get neighbors and weights for a given stop
//    public Map<String, Double> getNeighbors(String stopId) {
//        return adjacencyList.getOrDefault(stopId, new HashMap<>());
//    }
//
//    // Get stop details
//    public MetroStop getStops(String stopId) {
//        return stops.get(stopId);
//    }
//}
import java.util.HashMap;
import java.util.Map;

public class MetroGraph {
    private final Map<String, MetroStop> stops;
    private final Map<String, Map<String, Double>> adjacencyList;

    public MetroGraph() {
        stops = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    // Add a stop to the graph
    public void addStop(String id, String name, double latitude, double longitude) {
        stops.put(id, new MetroStop(id, name, latitude, longitude));
        adjacencyList.put(id, new HashMap<>()); // Initialize adjacency list for the stop
    }

    // Add an edge between two stops with a weight (e.g., travel time)
    public void addEdge(String fromStopId, String toStopId, double weight) {
        if (adjacencyList.containsKey(fromStopId) && adjacencyList.containsKey(toStopId)) {
            adjacencyList.get(fromStopId).put(toStopId, weight);
            adjacencyList.get(toStopId).put(fromStopId, weight); // For undirected graph
        }
    }

    // Set or update the distance between two stops
    public void setDistance(String fromStopId, String toStopId, double distance) {
        if (adjacencyList.containsKey(fromStopId) && adjacencyList.containsKey(toStopId)) {
            adjacencyList.get(fromStopId).put(toStopId, distance);
            adjacencyList.get(toStopId).put(fromStopId, distance); // For undirected graph
        } else {
            System.out.println("One or both stops do not exist in the graph.");
        }
    }

    // Check if a stop exists in the graph
    public boolean containsStop(String stopId) {
        return stops.containsKey(stopId);
    }

    // Get all stops
    public Iterable<String> getAllStops() {
        return stops.keySet();
    }

    // Get neighbors and weights for a given stop
    public Map<String, Double> getNeighbors(String stopId) {
        return adjacencyList.getOrDefault(stopId, new HashMap<>());
    }

    // Get stop details
    public MetroStop getStop(String stopId) {
        return stops.get(stopId);
    }
}
