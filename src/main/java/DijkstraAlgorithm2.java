
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class DijkstraAlgorithm2 {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Map<String, Double> dijkstra(MetroGraph graph, String startStopId, Map<String, MetroStopTime> stopTimes) {
        // Initialize distance map and priority queue
        Map<String, Double> distances = new HashMap<>();
        PriorityQueue<StopDistance> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(StopDistance::getDistance));
        Set<String> visited = new HashSet<>();

        // Set initial distances to infinity and the start node to zero
        for (String stopId : graph.getAllStops()) {
            distances.put(stopId, Double.MAX_VALUE);
            DijkstraAlgorithm.previousStops.put(stopId, null);
        }
        distances.put(startStopId, 0.0);
        priorityQueue.add(new StopDistance(startStopId, 0.0));

        while (!priorityQueue.isEmpty()) {
            StopDistance current = priorityQueue.poll();
            String currentStopId = current.getStopId();

            if (visited.contains(currentStopId)) continue;
            visited.add(currentStopId);

            // Process each neighbor
            for (Map.Entry<String, Double> entry : graph.getNeighbors(currentStopId).entrySet()) {
                String neighborStopId = entry.getKey();
                double travelTime = entry.getValue(); // Edge weight: time to travel between stops

                // Compute edge weight (travelTime + stopTime at the current stop)
                double edgeWeight = travelTime + getStopTime(stopTimes, currentStopId);
                double newDist = distances.get(currentStopId) + edgeWeight;

                if (newDist < distances.get(neighborStopId)) {
                    distances.put(neighborStopId, newDist);
                    DijkstraAlgorithm.previousStops.put(neighborStopId, currentStopId);
                    priorityQueue.add(new StopDistance(neighborStopId, newDist));
                }
            }
        }

        return distances;
    }

    private double getStopTime(Map<String, MetroStopTime> stopTimes, String stopId) {
        double totalStopTime = 0.0;
        for (MetroStopTime stopTimeData : stopTimes.values()) {
            if (stopTimeData.getStopId().equals(stopId)) {
                try {
                    LocalTime arrival = LocalTime.parse(stopTimeData.getArrivalTime(), TIME_FORMATTER);
                    LocalTime departure = LocalTime.parse(stopTimeData.getDepartureTime(), TIME_FORMATTER);
                    Duration duration = Duration.between(arrival, departure);
                    totalStopTime += duration.toMinutes(); // Convert duration to minutes
                } catch (DateTimeParseException e) {
                    System.err.println("Error parsing time for stop ID " + stopId + ": " + e.getMessage());
                }
            }
        }
        return totalStopTime;
    }

//    public List<String> getPath(String endStopId) {
//        List<String> path = new LinkedList<>();
//        String step = endStopId;
//
//        while (step != null) {
//            path.add(step);
//            step = DijkstraAlgorithm.previousStops.get(step);
//        }
//
//        Collections.reverse(path);
//        return path;
//    }
//public List<String> getPath(String endStopId) {
//    List<String> path = new LinkedList<>();
//    Set<String> visitedStops = new HashSet<>();  // Track visited stops to prevent cycles
//    String step = endStopId;
//
//    while (step != null) {
//        if (visitedStops.contains(step)) {
//            System.err.println("Cycle detected at stop: " + step);
//            break;  // Stop if a cycle is detected
//        }
//
//        visitedStops.add(step);
//        path.add(step);
//        step = DijkstraAlgorithm.previousStops.get(step);
//    }
//
//    Collections.reverse(path);
//    return path;
//}
public List<String> getPath(String endStopId) {
    Deque<String> path = new ArrayDeque<>();
    String step = endStopId;

    while (step != null) {
        path.addFirst(step);  // Add elements at the front instead of reversing later
        step = DijkstraAlgorithm.previousStops.get(step);
    }

    return new ArrayList<>(path);  // Convert to List if needed
}



    // Helper class to store stop and distance
    public static class StopDistance {
        private String stopId;
        private double distance;

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


