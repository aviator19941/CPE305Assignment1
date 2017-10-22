import java.util.*;
/**
 * A class to handle the trips between Passengers and Drivers
 * @author Avinash Sharma
 *
 */
public class Trip {
	private double rate;
	private Driver driver;
	private Passenger pass;
	
	/**
	 * Constructs a Trip with the specified rate, current Driver, and current Passenger
	 * @param rate specified rate from text file
	 * @param driver the current Driver
	 * @param pass the current Passenger
	 */
	public Trip(double rate, Driver driver, Passenger pass) {
		this.rate = rate;
		this.driver = driver;
		this.pass = pass;
	}
	
	/**
	 * Gets the rate of the trip
	 * @return the rate of the trip
	 */
	public double getRate() {
		return rate;
	}
	
	/**
	 * Gets the current driver of the trip
	 * @return the current driver of the trip
	 */
	public Driver getDriver() {
		return driver;
	}
	
	/**
	 * Gets the current passenger of the trip
	 * @return the current passenger of the trip
	 */
	public Passenger getPassenger() {
		return pass;
	}
	
	/**
	 * Calculates the distance from the Driver to the Passenger
	 * @return the distance from the Driver to the Passenger
	 */
	public double distanceFromDriverToPass() {
		int xDiff = Math.abs(driver.getXCoordStart() - pass.getXCoordStart());
		int yDiff = Math.abs(driver.getYCoordStart() - pass.getYCoordStart());
		return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
	}
	
	/**
	 * Calculates the distance from the Passenger to their destination
	 * @return the distance from the Passenger to their destination
	 */
	public double distanceFromPassToDest() {
		int xDiff = Math.abs(pass.getXCoordDest() - pass.getXCoordStart());
		int yDiff = Math.abs(pass.getYCoordDest() - pass.getYCoordStart());
		return Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));
	}
	
	/**
	 * Gets the ETA of the Driver to the Passenger with each unit of 
	 * distance specified as 1 minute
	 * @return the ETA of the Driver to reach the Passenger
	 */
	public double estimatedTimeArrival() {
		return this.distanceFromDriverToPass() * 1;
	}
	
	/**
	 * Calculates the fare of the ride by multiplying the distance from the Passenger
	 * to their destination by the specified rate
	 * @return the fare of the ride
	 */
	public double calculateFare() {
		return this.distanceFromPassToDest() * rate;
	}
	
}
