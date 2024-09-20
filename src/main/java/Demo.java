import java.util.*;

public class Demo {

    public static void main(String[] args) {
        MetroGraph graph = new MetroGraph();

        // Add stops
        graph.addStop("36", "Stop A", 28.6139, 77.2090);
        graph.addStop("47", "Stop B", 28.7041, 77.1025);
        graph.addStop("50", "Stop C", 28.7350, 77.1450);

        // Add edges
        graph.addEdge("36", "50", 5.0);
        graph.addEdge("50", "47", 10.0);

        // Perform Dijkstra's algorithm
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        String startStopId = "36";
        String endStopId = "47";

        Map<String, Double> distances = dijkstra.dijkstra(graph, startStopId);
        List<String> path = dijkstra.getPath(endStopId, DijkstraAlgorithm.previousStops);

        // Print the result
        if (distances.get(endStopId) != Double.MAX_VALUE) {
            System.out.println("The shortest distance from " + startStopId + " to " + endStopId + " is " + distances.get(endStopId));
            System.out.println("The path is: " + String.join(" -> ", path));
        } else {
            System.out.println("No path found between " + startStopId + " and " + endStopId);
        }
    }

}
