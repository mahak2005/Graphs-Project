import java.util.Map;
import java.util.HashMap;

public class EdgeWeightCalculator {

    public static double calculateTravelTime(String arrivalTime1, String departureTime2) {
        // Assuming time format is "HH:mm:ss"
        long arrivalMillis = parseTimeToMillis(arrivalTime1);
        long departureMillis = parseTimeToMillis(departureTime2);
        return (departureMillis - arrivalMillis) / 1000.0 / 60.0; // Convert to minutes
    }

    public static long parseTimeToMillis(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return (hours * 3600 + minutes * 60 + seconds) * 1000;
    }

    public static double calculateStopTime(String arrivalTime, String departureTime) {
        long arrivalMillis = parseTimeToMillis(arrivalTime);
        long departureMillis = parseTimeToMillis(departureTime);
        return (departureMillis - arrivalMillis) / 1000.0 / 60.0; // Convert to minutes
    }

    public static double getEdgeWeight(Map<String, MetroStopTime> stopTimes, String fromStopId, String toStopId) {
        // Assuming you have sorted stopTimes by tripId and stop_sequence
        for (MetroStopTime stopTime : stopTimes.values()) {
            if (stopTime.getStopId().equals(fromStopId)) {
                String arrivalTime = stopTime.getArrivalTime();
                String departureTime = stopTime.getDepartureTime();
                // Find the next stop in the sequence
                MetroStopTime nextStopTime = findNextStopTime(stopTimes, stopTime.getTripId(), stopTime.getStopSequence());
                if (nextStopTime != null && nextStopTime.getStopId().equals(toStopId)) {
                    double travelTime = calculateTravelTime(arrivalTime, nextStopTime.getArrivalTime());
                    double stopTimeAtFromStop = calculateStopTime(arrivalTime, departureTime);
                    return travelTime + stopTimeAtFromStop;
                }
            }
        }
        return Double.MAX_VALUE; // No path found
    }

    private static MetroStopTime findNextStopTime(Map<String, MetroStopTime> stopTimes, String tripId, int currentStopSequence) {
        for (MetroStopTime stopTime : stopTimes.values()) {
            if (stopTime.getTripId().equals(tripId) && stopTime.getStopSequence() == currentStopSequence + 1) {
                return stopTime;
            }
        }
        return null;
    }
}
