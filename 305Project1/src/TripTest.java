import static org.junit.Assert.*;

import org.junit.Test;
/**
 * A class for unit testing the Trip class
 * @author Avinash
 *
 */
public class TripTest {

	/**
	 * Test the distance from the Driver to the Passenger 
	 */
	@Test
	public void testDistanceFromDriverToPass() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 20.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);
		Driver driver1 = new Driver("D1", 0.0, "Sedan", true, 3.0, 1);
		driver1.setXCoordStart(10);
		driver1.setYCoordStart(10);
				
		pass1.enterDestination(grid, 7, 1);
		
		Trip trip1 = new Trip(2.0, driver1, pass1);
		
		driver1.setTrip(trip1);
		assertEquals(12.728, trip1.distanceFromDriverToPass(), 0.1);
	}

	/**
	 * Test the distance from the Passenger to their destination
	 */
	@Test
	public void testDistanceFromPassToDest() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 20.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);
		Driver driver1 = new Driver("D1", 0.0, "Sedan", true, 3.0, 1);
		driver1.setXCoordStart(10);
		driver1.setYCoordStart(10);
				
		pass1.enterDestination(grid, 7, 1);
		
		Trip trip1 = new Trip(2.0, driver1, pass1);
		
		driver1.setTrip(trip1);
		assertEquals(6, trip1.distanceFromPassToDest(), 0.0);
	}

	/**
	 * Test the ETA of a trip
	 */
	@Test
	public void testEstimatedTimeArrival() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 20.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);
		Driver driver1 = new Driver("D1", 0.0, "Sedan", true, 3.0, 1);
		driver1.setXCoordStart(10);
		driver1.setYCoordStart(10);
				
		pass1.enterDestination(grid, 7, 1);
		
		Trip trip1 = new Trip(1.0, driver1, pass1);
		
		driver1.setTrip(trip1);
		assertEquals(12.728, trip1.estimatedTimeArrival(), 0.1);
	}

	/**
	 * Test the calculated fare of the trip
	 */
	@Test
	public void testCalculateFare() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 20.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);
		Driver driver1 = new Driver("D1", 0.0, "Sedan", true, 3.0, 1);
		driver1.setXCoordStart(10);
		driver1.setYCoordStart(10);
				
		pass1.enterDestination(grid, 7, 1);
		
		Trip trip1 = new Trip(1.0, driver1, pass1);
		
		driver1.setTrip(trip1);
		assertEquals(6, trip1.calculateFare(), 0.0);
	}

}
