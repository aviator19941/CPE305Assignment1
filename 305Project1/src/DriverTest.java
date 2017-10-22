import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.*;
import org.junit.Test;
/**
 * A class for Unit Testing the Driver class
 * @author Avinash Sharma
 *
 */
public class DriverTest {

	/**
	 * Test if the correct driver is placed at the front of the PriorityQueue
	 */
	@Test
	public void testAddDriverToQueue() {
		Grid grid = new Grid(300);
		
		Passenger pass1 = new Passenger("P1", 10000.0);
		Passenger pass2 = new Passenger("P2", 10000.0);
		grid.generateRandomPassenger(pass1);
		grid.generateRandomPassenger(pass2);
		
		Driver driver1 = new Driver("D1", 0.0, "Sedan", true, 3.0, 1);
		Driver driver2 = new Driver("D2", 0.0, "UberX", true, 4.0, 1);
		grid.generateRandomDriver(driver1);
		grid.generateRandomDriver(driver2);
		
		grid.addPassengers();
		grid.addDrivers();
		ArrayList<Passenger> passengersList = grid.getPassengers();
		ArrayList<Driver> driversList = grid.getDrivers();
		
		pass1.enterDestination(grid, 4, 1);
		
		Trip trip1 = new Trip(2.0, driver1, pass1);
		Trip trip2 = new Trip(2.0, driver2, pass1);
		
		driver1.setTrip(trip1);
		driver2.setTrip(trip2);
		
		PriorityQueue<Driver> pQueue = new PriorityQueue<Driver>();
		
		driver1.addDriverToQueue(pQueue, driver1);
		driver2.addDriverToQueue(pQueue, driver2);
		
		if (trip1.distanceFromDriverToPass() < trip2.distanceFromDriverToPass()) {
			assertEquals("Top of priority queue: ", pQueue.peek(), driver1);

		}
		else {
			assertEquals("Top of priority queue: ", pQueue.peek(), driver2);

		}
		
	}

}
