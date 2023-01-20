package TestSuits;

import org.junit.*;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Production.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

public class TripDeciderTest {
    static List<Vehicle> vehicleList;
    static List<Trip2> trip2List;
    static List<Trip_decider> trip_deciderList;
    List<RequestTrip> requestTripList;
    @BeforeClass
    public static void setUpVehicles() {
        System.out.println("Setting up vehicles");
        vehicleList = new LinkedList<>();
        // add 10 vehicles in for loop
        vehicleList.add(new Vehicle("SEDAN", 50, 30, 5, 26));
        vehicleList.add(new Vehicle("SEVEN_SEATER", 7, 10, 30, 2));
        vehicleList.add(new Vehicle("MOTOR_BIKE", 1, 10, 30, 2));
        for (int i = 0; i < 10; i++) {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
            vehicleList.add(new Vehicle(generatedString,
                    Math.abs(new Random().nextInt(100)+0),Math.abs(new Random().nextInt(100)+0),
                    Math.abs(new Random().nextInt(100)+0),Math.abs(new Random().nextInt(100)+0)));
        }
    }
    @BeforeClass
    public static void setUpTrips() {
        System.out.println("Setting up trips");
        trip2List = new LinkedList<>();
        // add 10 trips in for loop
        trip2List.add(new Trip2(1, 2, 3, 4,"akib"));
        trip2List.add(new Trip2(2, 3, 4, 5,"Sakib"));
        trip2List.add(new Trip2(3, 4, -5, 6,"Rakib"));
        for (int i = 0; i < 10; i++) {
            trip2List.add(new Trip2(Math.abs(new Random().nextInt(100)+0),Math.abs(new Random().nextInt(100)+0),
                    Math.abs(new Random().nextInt(100)+0),Math.abs(new Random().nextInt(100)+0),"user" + i));
        }
    }
    @BeforeClass
    public static void setUpTrip_deciders() {
        System.out.println("Setting up  drivers");
        trip_deciderList = new LinkedList<>();
        // add 10 trips in for loop
        trip_deciderList.add(new Trip_decider("akib"));
        trip_deciderList.add(new Trip_decider("Sakib"));
        trip_deciderList.add(new Trip_decider( "Rakib"));
    }


    @Test
    public void TripDeciderTestTRUE() throws Exception {
        boolean actual= trip_deciderList.get(0).canTakeTrip(vehicleList.get(0),trip2List.get(0));
        assertTrue(actual);
    }
    @Test
    public void TripDeciderTestFALSE() throws Exception {
        boolean actual= trip_deciderList.get(0).canTakeTrip(vehicleList.get(1),trip2List.get(0));
        assertFalse(actual);
    }
    @Test
    public void testExpectedException() {

        Exception thrown = assertThrows(Exception.class, () -> {
            trip_deciderList.get(2).canTakeTrip(vehicleList.get(0),trip2List.get(2));
        });

        assertEquals("Invalid number for passenger", thrown.getMessage());
    }
}
