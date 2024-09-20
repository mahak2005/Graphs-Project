import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvParserTest {

    public static void main(String[] args) {
        try {
            // Access files from the resources directory
            InputStream routesStream = CsvParserTest.class.getClassLoader().getResourceAsStream("route.csv");
            InputStream stopsStream = CsvParserTest.class.getClassLoader().getResourceAsStream("stop.csv");
            InputStream tripsStream = CsvParserTest.class.getClassLoader().getResourceAsStream("trip.csv");
            InputStream stopTimesStream = CsvParserTest.class.getClassLoader().getResourceAsStream("stop_time.csv");
            InputStream shapesStream = CsvParserTest.class.getClassLoader().getResourceAsStream("shape.csv");

            if (routesStream == null || stopsStream == null || tripsStream == null || stopTimesStream == null || shapesStream == null) {
                throw new IllegalArgumentException("One or more resource files are missing.");
            }

            // Parse CSV files using InputStream
            Map<String, MetroRoute> routes = CsvParser.parseRoutes(new BufferedReader(new InputStreamReader(routesStream)));
            Map<String, MetroStop> stops = CsvParser.parseStops(new BufferedReader(new InputStreamReader(stopsStream)));
            Map<String, MetroTrip> trips = CsvParser.parseTrips(new BufferedReader(new InputStreamReader(tripsStream)));
            Map<String, MetroStopTime> stopTimes = CsvParser.parseStopTimes(new BufferedReader(new InputStreamReader(stopTimesStream)));
            Map<String, MetroShape> shapes = CsvParser.parseShapes(new BufferedReader(new InputStreamReader(shapesStream)));

            // Print results to verify the data
//            System.out.println("Routes:");
//            routes.forEach((id, route) -> System.out.println(id + ": " + route));

            System.out.println("\nStops:");
            stops.forEach((id, stop) -> System.out.println(id + ": " + stop));
//
//            System.out.println("\nTrips:");
//            trips.forEach((id, trip) -> System.out.println(id + ": " + trip));

//            System.out.println("\nStop Times:");
//            stopTimes.forEach((id, stopTime) -> System.out.println(id + ": " + stopTime));

//            System.out.println("\nShapes:");
//            shapes.forEach((id, shape) -> System.out.println(id + ": " + shape));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
