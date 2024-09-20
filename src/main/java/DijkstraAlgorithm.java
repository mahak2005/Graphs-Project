import java.util.*;

public class DijkstraAlgorithm {

    public static Map<String, String> previousStops = new HashMap<>();

    public Map<String, Double> dijkstra(MetroGraph graph, String startStopId) {
        // Priority queue to select the stop with the smallest distance
        PriorityQueue<StopDistance> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(StopDistance::getDistance));
        Map<String, Double> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();

        // Initialize distances and priority queue
        for (String stopId : graph.getAllStops()) {
            distances.put(stopId, Double.MAX_VALUE);
            previousStops.put(stopId, null);
        }
        distances.put(startStopId, 0.0);
        priorityQueue.add(new StopDistance(startStopId, 0.0));

        while (!priorityQueue.isEmpty()) {
            StopDistance currentStopDistance = priorityQueue.poll();
            String currentStopId = currentStopDistance.getStopId();

            if (visited.contains(currentStopId)) continue;
            visited.add(currentStopId);

            for (Map.Entry<String, Double> neighborEntry : graph.getNeighbors(currentStopId).entrySet()) {
                String neighborStopId = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double newDist = distances.get(currentStopId) + weight;

                if (newDist < distances.get(neighborStopId)) {
                    distances.put(neighborStopId, newDist);
                    previousStops.put(neighborStopId, currentStopId);
                    priorityQueue.add(new StopDistance(neighborStopId, newDist));
                }
            }
        }
        return distances;
    }

    public List<String> getPath(String endStopId, Map<String, String> previousStops) {
        List<String> path = new ArrayList<>();
        for (String at = endStopId; at != null; at = previousStops.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    // Inner class to represent a stop and its distance
    private static class StopDistance {
        private final String stopId;
        private final double distance;

        public StopDistance(String stopId, double distance) {
            this.stopId = stopId;
            this.distance = distance;
        }

        public String getStopId() {
            return stopId;
        }

        public double getDistance() {
            return distance;
        }
    }
}
