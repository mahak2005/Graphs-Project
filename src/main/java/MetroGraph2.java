import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class MetroGraph2 {
    private Map<String, MetroStop> stops; // Nodes
    private Map<String, Map<String, Double>> adjacencyList; // Edges with weights

    public MetroGraph2() {
        stops = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    // Add a node (stop) to the graph
    public void addStop(MetroStop stop) {
        stops.put(stop.getStopId(), stop);
        adjacencyList.putIfAbsent(stop.getStopId(), new HashMap<>());
    }

    // Add an edge (connection) between two stops with a weight
    public void addEdge(String fromStopId, String toStopId, double weight) {
        adjacencyList.get(fromStopId).put(toStopId, weight);
    }

    // Getters
    public MetroStop getStop(String stopId) {
        return stops.get(stopId);
    }

    public Map<String, Double> getNeighbors(String stopId) {
        return adjacencyList.get(stopId);
    }

    public Set<String> getAllStops() {
        return stops.keySet();
    }
}
