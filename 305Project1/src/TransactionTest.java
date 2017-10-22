import static org.junit.Assert.*;

import org.junit.Test;
/**
 * A class for unit testing the Transaction class
 * @author Avinash
 *
 */
public class TransactionTest {

	/**
	 * Test the case when Passenger's balance is invalid and they request a ride
	 */
	@Test
	public void testInvalidPassengerBalance() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 5.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);
		Driver driver1 = new Driver("D1", 0.0, "Sedan", true, 3.0, 1);
		driver1.setXCoordStart(10);
		driver1.setYCoordStart(10);
				
		pass1.enterDestination(grid, 4, 1);
		
		Trip trip1 = new Trip(2.0, driver1, pass1);
		
		driver1.setTrip(trip1);
		Transaction transaction1 = new Transaction(driver1, pass1, trip1);
		
		assertFalse(transaction1.checkPassengerBalance());
	}

	/**
	 * Test if Passenger's balance is valid for the ride
	 */
	@Test
	public void testValidPassengerBalance() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 6.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);
		Driver driver1 = new Driver("D1", 0.0, "Sedan", true, 3.0, 1);
		driver1.setXCoordStart(10);
		driver1.setYCoordStart(10);
				
		pass1.enterDestination(grid, 4, 1);
		
		Trip trip1 = new Trip(2.0, driver1, pass1);
		
		driver1.setTrip(trip1);
		Transaction transaction1 = new Transaction(driver1, pass1, trip1);
		
		assertTrue(transaction1.checkPassengerBalance());
	}

	/**
	 * Test the subtraction of the fare from the Passenger's balance
	 */
	@Test
	public void testDeductPassengerBalance() {
		Grid grid = new Grid(20);
		Passenger pass1 = new Passenger("P1", 6.0);
		pass1.setXCoordStart(1);
		pass1.setYCoordStart(1);
		Driver driver1 = new Driver("D1", 0.0, "Sedan", true, 3.0, 1);
		driver1.setXCoordStart(10);
		driver1.setYCoordStart(10);
				
		pass1.enterDestination(grid, 4, 1);
		
		Trip trip1 = new Trip(2.0, driver1, pass1);
		
		driver1.setTrip(trip1);
		Transaction transaction1 = new Transaction(driver1, pass1, trip1);
		transaction1.deductPassengerBalance();
		assertEquals(0.0, pass1.getCustBalance(), 0.0);
	}

	/**
	 * Test the subtraction of the fare from the Passenger's balance
	 */
	@Test
	public void testDeductPassengerBalance2() {
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
		Transaction transaction1 = new Transaction(driver1, pass1, trip1);
		transaction1.deductPassengerBalance();
		assertEquals(8.0, pass1.getCustBalance(), 0.0);
	}

	/**
	 * Test the addition of 75% of the fare to the Driver's balance
	 */
	@Test
	public void testAddToDriverBalance() {
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
		Transaction transaction1 = new Transaction(driver1, pass1, trip1);
		transaction1.addToDriverBalance();
		assertEquals(9.0, driver1.getBalance(), 0.0);
	}

}
