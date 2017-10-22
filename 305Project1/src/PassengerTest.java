import static org.junit.Assert.*;

import org.junit.Test;
/**
 * A class for unit testing the Passenger class
 * @author Avinash Sharma
 *
 */
public class PassengerTest {

	/**
	 * Test an invalid destination (outside grid boundaries)
	 */
	@Test
	public void testInvalidDest() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 10000.0);
		assertFalse(pass1.isValidDest(grid, 20, 1));
	}
	
	/**
	 * Test a valid destination (within grid boundaries)
	 */
	@Test
	public void testValidDest() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 10000.0);
		assertTrue(pass1.isValidDest(grid, 19, 1));
	}
	
	/**
	 * Test the Passenger's entered destination and check if the destination coordinates are correct
	 */
	@Test
	public void testEnterDestination() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 10000.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);

		pass1.enterDestination(grid, 4, 1);
		
		assertEquals("Passenger XCoordDest is: ", pass1.getXCoordDest(), 4);
		assertEquals("Passenger YCoordDest is: ", pass1.getYCoordDest(), 1);
	}

	/**
	 * Test the Passenger's entered rating and if the driver's rating is updated
	 */
	@Test
	public void testEnterRating() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 10000.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);
		Driver driver1 = new Driver("D1", 0.0, "Sedan", true, 3.0, 1);
		driver1.setXCoordStart(10);
		driver1.setYCoordStart(10);
				
		pass1.enterRating(driver1, 4.5);
		assertEquals(driver1.getRating(), 3.75, 0.0);
		
	}

}
