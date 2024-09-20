import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvParser {

    // Method to parse Routes CSV
    public static Map<String, MetroRoute> parseRoutes(BufferedReader reader) throws IOException {
        Map<String, MetroRoute> routes = new HashMap<>();
        try (CSVReader csvReader = new CSVReader(reader)) {
            String[] line;
            // Skip the header line
            csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                // Check if the line has the correct number of columns
                if (line.length < 4) {
                    System.err.println("Warning: Skipping line with insufficient columns: " + String.join(",", line));
                    continue;
                }
                // Parse the columns
                String routeId = line[0];
                String routeShortName = line[1];
                String routeLongName = line[2];
                String routeColor = line[3];

                // Create and store the MetroRoute object
                MetroRoute route = new MetroRoute(routeId, routeShortName, routeLongName, routeColor);
                routes.put(routeId, route);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return routes;
    }

    // Method to parse Stops CSV
    public static Map<String, MetroStop> parseStops(BufferedReader reader) throws IOException {
        Map<String, MetroStop> stops = new HashMap<>();
        try (CSVReader csvReader = new CSVReader(reader)) {
            String[] line;
            // Skip the header line
            csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                // Check if the line has the correct number of columns
                if (line.length < 4) {
                    System.err.println("Warning: Skipping line with insufficient columns: " + String.join(",", line));
                    continue;
                }
                // Parse the columns
                String stopId = line[0];
                String stopName = line[1];
                double stopLat = Double.parseDouble(line[2]);
                double stopLon = Double.parseDouble(line[3]);

                // Create and store the MetroStop object
                MetroStop stop = new MetroStop(stopId, stopName, stopLat, stopLon);
                stops.put(stopId, stop);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return stops;
    }

    // Method to parse Trips CSV
    public static Map<String, MetroTrip> parseTrips(BufferedReader reader) throws IOException {
        Map<String, MetroTrip> trips = new HashMap<>();
        try (CSVReader csvReader = new CSVReader(reader)) {
            String[] line;
            // Skip the header line
            csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                // Check if the line has the correct number of columns
                if (line.length < 4) {
                    System.err.println("Warning: Skipping line with insufficient columns: " + String.join(",", line));
                    continue;
                }
                // Parse the columns
                String routeId = line[0];
                String serviceId = line[1];
                String tripId = line[2];
                String shapeId = line[3];

                // Create and store the MetroTrip object
                MetroTrip trip = new MetroTrip(routeId, serviceId, tripId, shapeId);
                trips.put(tripId, trip);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return trips;
    }

    // Method to parse Stop Times CSV
    public static Map<String, MetroStopTime> parseStopTimes(BufferedReader reader) throws IOException {
        Map<String, MetroStopTime> stopTimes = new HashMap<>();
        try (CSVReader csvReader = new CSVReader(reader)) {
            String[] line;
            // Skip the header line
            csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                // Check if the line has the correct number of columns
                if (line.length < 6) {
                    System.err.println("Warning: Skipping line with insufficient columns: " + String.join(",", line));
                    continue;
                }
                // Parse the columns
                String tripId = line[0];
                String arrivalTime = line[1];
                String departureTime = line[2];
                String stopId = line[3];
                int stopSequence = Integer.parseInt(line[4]);
                double shapeDistTraveled = Double.parseDouble(line[5]);

                // Create and store the MetroStopTime object
                MetroStopTime stopTime = new MetroStopTime(tripId, arrivalTime, departureTime, stopId, stopSequence, shapeDistTraveled);
                stopTimes.put(tripId + "_" + stopSequence, stopTime);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return stopTimes;
    }

    // Method to parse Shapes CSV
    public static Map<String, MetroShape> parseShapes(BufferedReader reader) throws IOException {
        Map<String, MetroShape> shapes = new HashMap<>();
        try (CSVReader csvReader = new CSVReader(reader)) {
            String[] line;
            // Skip the header line
            csvReader.readNext();
            while ((line = csvReader.readNext()) != null) {
                // Check if the line has the correct number of columns
                if (line.length < 5) {
                    System.err.println("Warning: Skipping line with insufficient columns: " + String.join(",", line));
                    continue;
                }
                // Parse the columns
                String shapeId = line[0];
                double shapePtLat = Double.parseDouble(line[1]);
                double shapePtLon = Double.parseDouble(line[2]);
                int shapePtSequence = Integer.parseInt(line[3]);
                double shapeDistTraveled = Double.parseDouble(line[4]);

                // Create and store the MetroShape object
                MetroShape shape = new MetroShape(shapeId, shapePtLat, shapePtLon, shapePtSequence, shapeDistTraveled);
                shapes.put(shapeId + "_" + shapePtSequence, shape);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return shapes;
    }
}
